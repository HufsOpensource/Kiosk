package com.junyoung.kiosk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.junyoung.kiosk.component.FireData;
import com.junyoung.kiosk.component.KioskViewModel;
import com.junyoung.kiosk.component.ShoppingBasket;

public class MainActivity2 extends AppCompatActivity {

    private static final String TAG = "MainActivity_ms";
    private KioskViewModel viewModel;
    private TextView tvCount, tvCost,menuName,menuExplain;
    private Button btnPlus, btnMinus, btnShoppingBasket;
    private int count=1;
    private Long cost;
    private Long sendcost;
    private String companyname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        viewModel= new ViewModelProvider(this).get(KioskViewModel.class);
        menuName = findViewById(R.id.text_menu_name);
        menuExplain = findViewById(R.id.menu_explanation);
        tvCount=findViewById(R.id.tv_count);
        tvCount.setText(count+"");
        tvCost=findViewById(R.id.tv_cost);
        btnPlus=findViewById(R.id.btnP);
        btnMinus=findViewById(R.id.btnM);
        btnShoppingBasket=findViewById(R.id.shopping_basket_btn);
        companyname = getIntent().getStringExtra("companyname");
        viewModel.getshopData();

        viewModel.getLiveData().observe(this,data->{
            //firedata의 업소명이 같으면
            //붙여넣어준다
            for(int i=0; i<data.size(); i++) {
                if(data.get(i).getCompanyname().equals(companyname)){
                    menuName.setText(data.get(0).getTitle().toString());
                    menuExplain.setText(data.get(0).getDescription().toString());
                    cost = data.get(0).getCost();
                    sendcost = cost*count;
                    tvCost.setText(cost*count+"");
                    break;
                }
            }



        });




        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: btnPlus : "+v.getClass().getName());
                count++;
                tvCount.setText(count+"");
                tvCost.setText(cost*count+"");
                sendcost = cost*count;
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count>1) {
                    count--;
                    tvCount.setText(count + "");
                    tvCost.setText(cost*count+"");
                    sendcost = cost*count;
                }
            }
        });


        btnShoppingBasket.setOnClickListener(new View.OnClickListener(){

            public void onClick(View arg) {

                Intent intent = new Intent(getApplicationContext(), ShoppingBasket.class);
                intent.putExtra("menuname", String.valueOf(menuName.getText()));
                intent.putExtra("companyname", companyname);
                intent.putExtra("menuExplain", String.valueOf(menuExplain.getText()));
                intent.putExtra("cost", sendcost);

                startActivity(intent);
            }
        });

    }
}