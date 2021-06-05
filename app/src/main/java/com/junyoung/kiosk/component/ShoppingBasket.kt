package com.junyoung.kiosk.component

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.junyoung.kiosk.R
import com.junyoung.kiosk.pay_page1
import kotlinx.android.synthetic.main.activity_shopping_basket.*

class ShoppingBasket : AppCompatActivity() {
    private val viewModel : KioskViewModel by viewModels()
    private var menuname: String? = null
    private var companyname: String? = ""
    private var menuExplain: String? = ""
    private var cost: Long? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_basket)
        menuname = intent.getStringExtra("menuname")
        companyname = intent.getStringExtra("companyname")
        menuExplain = intent.getStringExtra("menuExplain")
        cost = intent.getLongExtra("sendcost",0)
        Toast.makeText(this,""+menuname, Toast.LENGTH_LONG).show()
        //뒤로가도 장바구니 데이터는 남기고 싶어서
        val firedata = FireData(menuname.toString(), menuExplain.toString(), "", companyname, cost)

        //title과 간략정보를 가져오기 위한 통신
        if(menuname==null) {
            fetchdata()
        }else {
            viewModel.addShoppingData(firedata)
            fetchdata()
        }
        shopping_basket_btn.setOnClickListener {
            val nextIntent = Intent(this, pay_page1::class.java)
            nextIntent.putExtra("cost", cost)
            startActivity(nextIntent)
        }

    }
    fun fetchdata() {
        viewModel.LiveShoppingData.observe(this, androidx.lifecycle.Observer {
            val adapter = RecyclerAdapter(viewModel.dataShoppingData, LayoutInflater.from(this))
            recycler_view.adapter = adapter
            recycler_view.layoutManager = LinearLayoutManager(this)
            recycler_view.adapter?.notifyDataSetChanged()
            (recycler_view.adapter as RecyclerAdapter).setData(it)
        })
    }

}

