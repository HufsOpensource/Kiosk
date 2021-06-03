package com.junyoung.kiosk.component

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.junyoung.kiosk.R
import java.util.*

class RecyclerAdapter(
        var itemList: ArrayList<FireData>,
        val inflater: LayoutInflater

): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        val basket_title = view.findViewById<TextView>(R.id.item_title)
        val basket_description = view.findViewById<TextView>(R.id.item_description)
        val basket_cost = view.findViewById<TextView>(R.id.item_cost)
    }
    //데이터 변동사항 체크
    fun setData(newData: ArrayList<FireData>) {
        itemList = newData
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.shopping_recycleitem,parent,false))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val item = itemList[position]
        holder.basket_title.setText(item.title)
        holder.basket_description.setText(item.description)
        holder.basket_cost.setText(""+item.cost)
//        holder.linear_detail.setOnClickListener {
//            onClick.invoke(item)
//        }

    }
}

