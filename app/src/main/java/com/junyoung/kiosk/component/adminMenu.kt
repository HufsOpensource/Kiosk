package com.junyoung.kiosk.component

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.junyoung.kiosk.R
import kotlinx.android.synthetic.main.activity_admin_menu.*
import kotlinx.android.synthetic.main.activity_make_room.*


class adminMenu:AppCompatActivity() {
    private val viewModel : KioskViewModel by viewModels()
    private var companyname: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_menu)
        companyname = intent.getStringExtra("companyname")
        save_btn.setOnClickListener {
            save()
        }
    }
    fun save() {
        val myname : String = menuName.text.toString()
        val menuinfo : String = menuInfo.text.toString()
        val howmuch : Long = howMuch.text.toString().toLong()
        val firedata = FireData(
                title = myname,
                description = menuinfo,
                cost = howmuch,
                companyname = companyname
        )
        viewModel.addData(firedata)
        val intent = Intent(this,adminMenu::class.java)
        intent.putExtra("companyname",myname)
        startActivity(intent)
    }
}