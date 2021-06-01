package com.junyoung.kiosk;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;


public class pay_page2 extends AppCompatActivity  {
    Random rnd;
    long mNow = System.currentTimeMillis();;
    Date mDate= new Date(mNow);
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy--MM--dd--HH:mm:ss");
    //String time1 = mFormat.format(mDate);



    TextView text11,text3,text4,text5,textday;
    Button bho,pay_finish2;
    ImageView imgPet;

    private String time2() {
        return mFormat.format(mDate);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay2);


        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        rnd = new Random();
        StringBuffer buf = new StringBuffer();
        for(int i=0;i<10;i++){
            if(rnd.nextBoolean()){
                buf.append((char)((int)(rnd.nextInt(26))+97));
            }else{
                buf.append((rnd.nextInt(10)));
            }
        }



        text11 = (TextView) findViewById(R.id.Text_order);
        imgPet = (ImageView) findViewById(R.id.ImgPet);
        switch(pay_page1.rGroup1.getCheckedRadioButtonId()) {
            case R.id.Toss:
                imgPet.setImageResource(R.drawable.toss);
                break;
            case R.id.Kakao:
                imgPet.setImageResource(R.drawable.kakao);
                break;
            case R.id.Hufspay:
                imgPet.setImageResource(R.drawable.hufspay);
                break;
            default:
                break;
        }
        pay_finish2 = (Button) findViewById(R.id.Pay_finish2);
        text3 = (TextView) findViewById(R.id.Text3);
        text4 = (TextView) findViewById(R.id.Text4);
        text5 = (TextView) findViewById(R.id.Text5);
        text5.setText(buf);
        textday = (TextView) findViewById(R.id.Textday);
        textday.setText(time2());
        bho = (Button) findViewById(R.id.Bho);


        pay_finish2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg){
                text3.setVisibility(android.view.View.VISIBLE);
                text4.setVisibility(android.view.View.VISIBLE);
                text5.setVisibility(android.view.View.VISIBLE);
                textday.setVisibility(android.view.View.VISIBLE);
                bho.setVisibility(android.view.View.VISIBLE);
            }
        });

        bho.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg) {
                Intent intent = new Intent(getApplicationContext(), pay_page1.class);
                startActivity(intent);
            }
        });

    }
}

