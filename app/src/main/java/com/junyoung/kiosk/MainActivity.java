package com.junyoung.kiosk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.junyoung.kiosk.component.Home;

public class MainActivity extends AppCompatActivity {

    private android.view.animation.Animation Animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView image_rotate = findViewById(R.id.image_rotate);
        if (image_rotate.getAnimation() == null) {
            Animation rotateAnimation = AnimationUtils.loadAnimation (getApplicationContext(), R.anim.anim_image);
            image_rotate.startAnimation(rotateAnimation);
            image_rotate.setAnimation(rotateAnimation);
        }
        Handler handler = new Handler();
        final Intent intent = new Intent(this,Home.class);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
            }
        }, 1000);

        
    }
}