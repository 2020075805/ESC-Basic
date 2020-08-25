package com.example.escbasicapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ContactActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView avatar;
    private TextView name;
    private TextView phone;
    private TextView email;
    private ImageButton prev;
    private TextView page;
    private ImageButton next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        setUpUI();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setInfo(0);
    }

    private void setUpUI() {
        toolbar = findViewById(R.id.contact_toolbar);
        avatar = findViewById(R.id.contact_iv_avatar);
        name = findViewById(R.id.contact_tv_name);
        phone = findViewById(R.id.contact_tv_phone);
        email = findViewById(R.id.contact_tv_email);
        prev = findViewById(R.id.contact_ibtn_prev);
        page = findViewById(R.id.contact_tv_page);
        next = findViewById(R.id.contact_ibtn_next);


    }

    private  void setInfo(int index) {
        name.setText(DummyDate.contacts.get(index).getName());
        phone.setText(DummyDate.contacts.get(index).getPhone());
        email.setText(DummyDate.contacts.get(index).getEmail());

        if (index == 0) {
            prev.setVisibility(View.GONE);
        } else {
            prev.setVisibility(View.VISIBLE);
        }

        if (index == DummyDate.contacts.size() - 1) {
            next.setVisibility(View.GONE);
        } else {
            next.setVisibility(View.VISIBLE);
        }

        page.setText((index + 1) + "/" + DummyDate.contacts.size());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}

