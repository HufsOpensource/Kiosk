package com.junyoung.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.junyoung.kiosk.component.ShoppingBasket;

public class MainActivity2 extends AppCompatActivity {
    private static final String TAG = "MainActivity_ms";

    private TextView tvCount, tvCost;
    private Button btnPlus, btnMinus, btnShoppingBasket;
    private int count=1;
    private int cost = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvCount=findViewById(R.id.tv_count);
        tvCount.setText(count+"");
        tvCost=findViewById(R.id.tv_cost);
        tvCost.setText(cost*count+"");
        btnPlus=findViewById(R.id.btnP);
        btnMinus=findViewById(R.id.btnM);
        btnShoppingBasket=findViewById(R.id.shopping_basket_btn);


        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: btnPlus : "+v.getClass().getName());
                count++;
                tvCount.setText(count+"");
                tvCost.setText(cost*count+"");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count>1) {
                    count--;
                    tvCount.setText(count + "");
                    tvCost.setText(cost*count+"");
                }
            }
        });


        btnShoppingBasket.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg) {
                Intent intent = new Intent(getApplicationContext(), ShoppingBasket.class);
                startActivity(intent);
            }
        });

    }
}