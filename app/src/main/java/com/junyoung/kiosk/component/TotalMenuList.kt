package com.junyoung.kiosk.component

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.junyoung.kiosk.R
import kotlinx.android.synthetic.main.activity_total_menu_list.*
import java.util.ArrayList

class TotalMenuList : AppCompatActivity() {
    private val viewModel : KioskViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_total_menu_list)
        viewModel.getcompanyname()
        viewModel.LiveComponyData.observe(this, Observer {
            val adapter = RecyclerAdapter2(viewModel.dataComponyName, LayoutInflater.from(this),
                onClick = {
                    val intent = Intent(this,MenuDetail::class.java)
                    intent.putExtra("companyname",it.myname)
                    startActivity(intent)
                }
                    )
            recycler_total_view.adapter = adapter
            recycler_total_view.layoutManager = LinearLayoutManager(this)
            recycler_total_view.adapter?.notifyDataSetChanged()
            (recycler_total_view.adapter as RecyclerAdapter2).setData(it)
        })
    }
    inner class RecyclerAdapter2(
            var itemList: ArrayList<FireComponyName>,
            val inflater: LayoutInflater,
            val onClick:(a:FireComponyName) -> Unit

    ): RecyclerView.Adapter<RecyclerAdapter2.ViewHolder>(){
        inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){

            val text_compony= view.findViewById<TextView>(R.id.text_company)
            val menu_total_linear = view.findViewById<LinearLayout>(R.id.menu_total_linear)


        }
        //데이터 변동사항 체크
        fun setData(newData: ArrayList<FireComponyName>) {
            itemList = newData
            notifyDataSetChanged()
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter2.ViewHolder {
            return ViewHolder(inflater.inflate(R.layout.menu_total_list,parent,false))
        }

        override fun getItemCount(): Int {
            return itemList.size
        }

        override fun onBindViewHolder(holder: RecyclerAdapter2.ViewHolder, position: Int) {
            val item = itemList[position]
            holder.text_compony.setText(item.myname)


            holder.menu_total_linear.setOnClickListener {
                onClick.invoke(item)
            }

        }
    }

}