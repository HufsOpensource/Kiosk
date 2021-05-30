package com.junyoung.kiosk.component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.junyoung.kiosk.R
import kotlinx.android.synthetic.main.activity_make_room.*

class MakeRoom : AppCompatActivity() {
    private val viewModel: KioskViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_room)
        btn_save.setOnClickListener {
            save()
        }
    }
    fun save() {
        val myname : String = edit_myname.text.toString()

    }
}