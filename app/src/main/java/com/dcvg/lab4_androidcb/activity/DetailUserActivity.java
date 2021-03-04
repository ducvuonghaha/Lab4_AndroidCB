package com.dcvg.lab4_androidcb.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dcvg.lab4_androidcb.R;

public class DetailUserActivity extends AppCompatActivity {

    private TextView tvFullnameUserDetail;
    private TextView tvPhoneUserDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);
        initView();

        Intent intent = getIntent();
        tvFullnameUserDetail.setText(intent.getStringExtra("fullname_user"));
        tvPhoneUserDetail.setText(intent.getStringExtra("phone_user"));
    }

    private void initView() {
        tvFullnameUserDetail = (TextView) findViewById(R.id.tvFullnameUserDetail);
        tvPhoneUserDetail = (TextView) findViewById(R.id.tvPhoneUserDetail);
    }
}