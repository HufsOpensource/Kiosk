package com.junyoung.kiosk;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;
public class pay_page1<dc_mn, all_mn, f_mn> extends AppCompatActivity {
    public static Object mContext;
    public static RadioGroup rGroup1;
    TextView text1, text2, text_cou1, text_money1, text_money2, text_money3, text_money4;
    CheckBox chkAgree, chkAgree2, rhufspay2;
    RadioGroup  rGroup2;
    RadioButton rhufspay, rtoss, rkakao;
    Button btnOk, pay_finish;
    static float all_mn,dc_mn,f_mn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent2 = getIntent();
        all_mn = intent2.getLongExtra("cost", 0); //총 금액
        dc_mn = 0; //할인가격
        f_mn = all_mn - dc_mn; //결제 금액
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay1);

//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();

        text1 = (TextView) findViewById(R.id.Order_finish);
        text2= (TextView) findViewById(R.id.Text2);
        chkAgree = (CheckBox) findViewById(R.id.ChkAgree);

        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        rkakao = (RadioButton) findViewById(R.id.Kakao);
        rhufspay = (RadioButton) findViewById(R.id.Hufspay);
        rtoss = (RadioButton) findViewById(R.id.Toss);

        btnOk = (Button) findViewById(R.id.BtnOk);
        text_cou1 = (TextView) findViewById(R.id.Text_cou1);
        chkAgree2 = (CheckBox) findViewById(R.id.ChkAgree2);
        rGroup2 = (RadioGroup) findViewById(R.id.Rgroup2);
        rhufspay2 = (CheckBox) findViewById(R.id.Hufspay2);

        text_money1 = (TextView) findViewById(R.id.Text_money1);
        text_money2 = (TextView) findViewById(R.id.Text_money2);
        text_money2.append(""+ (int)all_mn);
        text_money2.append("원");
        text_money3 = (TextView) findViewById(R.id.Text_money3);
        text_money3.append(""+ (int)dc_mn);
        text_money3.append("원");
        text_money4 = (TextView) findViewById(R.id.Text_money4);
        text_money4.append(""+ (int)f_mn);
        text_money4.append("원");
        pay_finish = (Button) findViewById(R.id.Pay_finish);
        // imgPet = (ImageView) findViewById(R.id.ImgPet);

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chkAgree.isChecked() == true) {
                    rGroup1.setVisibility(View.VISIBLE);
                    btnOk.setVisibility(View.VISIBLE);
                } else {
                    rGroup1.setVisibility(View.INVISIBLE);
                    btnOk.setVisibility(View.INVISIBLE);

                }
            }
        });


        chkAgree2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chkAgree2.isChecked() == true) {
                    rGroup2.setVisibility(View.VISIBLE);
                    rhufspay2.setVisibility(View.VISIBLE);

                } else {
                    rGroup2.setVisibility(View.INVISIBLE);
                    rhufspay2.setVisibility(View.INVISIBLE);

                }
            }
        });
        rhufspay2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (rhufspay2.isChecked() == true) {
                    dc_mn = all_mn * (float) 0.05;
                    text_money3.setText("할인 금액 :");
                    text_money3.append(""+ (int)dc_mn);
                    text_money3.append("원");
                    f_mn= all_mn-dc_mn;
                    text_money4.setText("결제 금액 :");
                    text_money4.append(""+ (int)f_mn);
                    text_money4.append("원");
                } else {
                    dc_mn=0;
                    text_money3.setText("할인 금액 :");
                    text_money3.append(""+ (int)dc_mn);
                    text_money3.append("원");
                    f_mn=all_mn;
                    text_money4.setText("결제 금액 :");
                    text_money4.append(""+ (int)f_mn);
                    text_money4.append("원");
                }
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg) {
                switch (rGroup1.getCheckedRadioButtonId()) {
                    case R.id.Toss:
                        pay_finish.setVisibility(View.VISIBLE);
                        chkAgree2.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.Kakao:
                        pay_finish.setVisibility(View.VISIBLE);
                        chkAgree2.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.Hufspay:
                        pay_finish.setVisibility(View.VISIBLE);
                        chkAgree2.setVisibility(View.VISIBLE);
                        break;
                    default:
                        chkAgree2.setVisibility(View.INVISIBLE);
                        Toast.makeText(getApplicationContext(), "먼저선택하시오", Toast.LENGTH_SHORT).show();
                }
            }
        });
        pay_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg2) {
                Intent intent = new Intent(getApplicationContext(), pay_page2.class);
                startActivity(intent);
            }
        });

    }

}

