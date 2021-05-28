package com.junyoung.kiosk.component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.junyoung.kiosk.R
import kotlinx.android.synthetic.main.activity_shopping_basket.*

class ShoppingBasket : AppCompatActivity() {
    private val viewModel : KioskViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_basket)
        viewModel.getData()
        //title과 간략정보를 가져오기 위한 통신
        viewModel.LiveData.observe(this,androidx.lifecycle.Observer {
            val adapter = RecyclerAdapter(viewModel.data, LayoutInflater.from(this))
            recycler_view.adapter = adapter
            recycler_view.layoutManager = LinearLayoutManager(this)
            recycler_view.adapter?.notifyDataSetChanged()
            (recycler_view.adapter as RecyclerAdapter).setData(it)

        })
    }
}

