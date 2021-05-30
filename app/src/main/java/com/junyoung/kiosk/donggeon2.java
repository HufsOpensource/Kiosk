package com.junyoung.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;
import android.view.View;
import android.content.Intent;


public class donggeon2 extends AppCompatActivity  {
    Random rnd;
    long mNow = System.currentTimeMillis();;
    Date mDate= new Date(mNow);
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy--MM--dd--HH:mm:ss");
    //String time1 = mFormat.format(mDate);


    TextView text3,text4,text5,textday;
    Button bho;

    private String time2() {
        return mFormat.format(mDate);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donggeon2);

        rnd = new Random();
        StringBuffer buf = new StringBuffer();
        for(int i=0;i<10;i++){
            if(rnd.nextBoolean()){
                buf.append((char)((int)(rnd.nextInt(26))+97));
            }else{
                buf.append((rnd.nextInt(10)));
            }
        }



        text3 = (TextView) findViewById(R.id.Text3);
        text4 = (TextView) findViewById(R.id.Text4);
        text5 = (TextView) findViewById(R.id.Text5);
        text5.setText(buf);
        textday = (TextView) findViewById(R.id.Textday);
        textday.setText(time2());
        bho = (Button) findViewById(R.id.Bho);


        bho.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View arg) {
            Intent intent = new Intent(getApplicationContext(), donggeon1.class);
            startActivity(intent);
        }
    });

    }
}


