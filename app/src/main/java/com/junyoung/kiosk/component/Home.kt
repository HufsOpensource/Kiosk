package com.junyoung.kiosk.component

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.junyoung.kiosk.R
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*

class Home: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //장바구니 애니메이션
        val animation = AnimationUtils.loadAnimation(this, R.anim.home_highlight)
        image_home_hightlight.startAnimation(animation)
        val animationBackground = AnimationUtils.loadAnimation(this,R.anim.home_highlight_background)
        Linear_background.startAnimation(animationBackground)
        //방 생성
        btn_home_makeroom.setOnClickListener {
            startActivity(Intent(this,MakeRoom::class.java))
        }
        //장바구니 이동
        image_goshop.setOnClickListener {
            startActivity(Intent(this,ShoppingBasket::class.java))
        }

    }
}