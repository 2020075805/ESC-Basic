package com.example.escbasicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


   private ImageButton addContact;
   private ImageButton contact;
   private TextView phoneNum;
   private TextView[] dials = new TextView[10];
   private TextView star;
   private TextView sharp;
   private ImageButton message;
   private ImageButton call;
   private ImageButton backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpUI();

    }

    private void setUpUI() {
        addContact = findViewById(R.id.main_ibtn_add);
        contact = findViewById(R.id.main_ibtn__contact);
        phoneNum = findViewById(R.id.main_tv_phone);

        for (int i = 0; i < dials.length; i++) {
            dials[i] = findViewById(getResourceID("main_tv_" + i, "id", this));
        }

        star = findViewById(R.id.main_tv_star);
        sharp = findViewById((R.id.main_tv_sharp));
        message = findViewById(R.id.main_ibtn_message);
        call = findViewById(R.id.main_ibtn_call);
        backspace = findViewById((R.id.main_ibtn_backspace));


        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO:연락처추가
                Toast.makeText(MainActivity.this, "text", Toast.LENGTH_SHORT).show();
            }
        });


        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:연락처

            }
        });

        setOnClickDial(star, "*");
        setOnClickDial(sharp, "#");

        for (int i = 0; i < 10; i++) {
            setOnClickDial(dials[i], String.valueOf(i));
        }

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO:메세지
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: 전화
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(phoneNum.getText().length() > 0) {
                    phoneNum.setText(changeToDial(phoneNum.getText().subSequence(0, phoneNum.getText().length() - 1).toString()));
                }
            }
        });
    }
    private void setOnClickDial(final View view, final String input) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNum.setText(changeToDial(phoneNum.getText() + input));
            }
        });
    }


    private int getResourceID(final String resName, final String resType, final Context ctx) {
        final int ResourceID =
                ctx.getResources().getIdentifier(resName, resType, ctx.getApplicationInfo().packageName);
        if (ResourceID == 0) {
            throw new IllegalArgumentException("No resource string found with name" + resName);
        } else {
            return ResourceID;
        }
    }

    private String changeToDial(String phoneNum) {
        phoneNum = phoneNum.replace("-", "");

        if (phoneNum.length() >= 4 && phoneNum.length() <= 7)
            return phoneNum.substring(0, 3) + "-" + phoneNum.substring(3);
        else if (phoneNum.length() >= 8 && phoneNum.length() <= 11)
            return phoneNum.substring(0, 3) + "-" + phoneNum.substring(3, 7) + "-" + phoneNum.substring(7);
        else

        return phoneNum;
        //전화번호 기준0103744834
        //4글자 이상일때 3번째 숫자 다음에 - (010-3)
        //8글자 이상일때 3번째 다음이랑 7번째 다음에 - (010-3744-0)
        //12글자 이상이면 - 전부제거
        //특수문자 * # 있으면- 전부 제거



    }
}

