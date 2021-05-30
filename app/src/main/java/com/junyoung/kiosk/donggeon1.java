package com.junyoung.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;
public class donggeon1 extends AppCompatActivity {
    TextView text1, text2;
    CheckBox chkAgree;
    RadioGroup rGroup1;
    RadioButton rhufspay, rtoss, rkakao;
    Button btnOk, pay_finish;
    ImageView imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donggeon1);

        text1= (TextView) findViewById(R.id.Text1);
        text2= (TextView) findViewById(R.id.Text2);
        chkAgree = (CheckBox)findViewById(R.id.ChkAgree);

        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        rkakao = (RadioButton) findViewById(R.id.Kakao);
        rhufspay = (RadioButton) findViewById(R.id.Hufspay);
        rtoss = (RadioButton) findViewById(R.id.Toss);

        btnOk = (Button) findViewById(R.id.BtnOk);
        pay_finish = (Button) findViewById(R.id.Pay_finish);
        imgPet = (ImageView) findViewById(R.id.ImgPet);

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chkAgree.isChecked() == true) {
                    rGroup1.setVisibility(android.view.View.VISIBLE);
                    btnOk.setVisibility(android.view.View.VISIBLE);
                    imgPet.setVisibility(android.view.View.VISIBLE);
                }
                else{
                    rGroup1.setVisibility(android.view.View.INVISIBLE);
                    btnOk.setVisibility(android.view.View.INVISIBLE);
                    imgPet.setVisibility(android.view.View.INVISIBLE);
                    pay_finish.setVisibility(android.view.View.INVISIBLE);
                }
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg){
                switch(rGroup1.getCheckedRadioButtonId()) {
                    case R.id.Toss:
                        imgPet.setImageResource(R.drawable.toss);
                        pay_finish.setVisibility(android.view.View.VISIBLE);
                        break;
                    case R.id.Kakao:
                        imgPet.setImageResource(R.drawable.kakao);
                        pay_finish.setVisibility(android.view.View.VISIBLE);
                        break;
                    case R.id.Hufspay:
                        imgPet.setImageResource(R.drawable.hufspay);
                        pay_finish.setVisibility(android.view.View.VISIBLE);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "먼저선택하시오",Toast.LENGTH_SHORT).show();
                }
            }
        });
        pay_finish.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg2) {
                Intent intent = new Intent(getApplicationContext(), donggeon2.class);
                startActivity(intent);
            }
        });
    }
}
