package com.example.hesamodin.sec06;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Confirm_registering extends AppCompatActivity implements OnClickListener {


    public Intent intent;
    Spinner education;
    public TextView tv_username,tv_name,tv_family,tv_email,tv_mobile,tv_age,tv_education;
    Button btn_confirm,btn_back;
    public String intent_user,intent_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_registering);

        intent = getIntent();

        tv_username=(TextView)findViewById(R.id.con_tv_username);
        tv_name=(TextView)findViewById(R.id.con_tv_name);
        tv_family=(TextView)findViewById(R.id.con_tv_family);
        tv_email=(TextView)findViewById(R.id.con_tv_email);
        tv_mobile=(TextView)findViewById(R.id.con_tv_mobile);
        tv_age=(TextView)findViewById(R.id.con_tv_age);
        tv_education=(TextView)findViewById(R.id.con_tv_education);

        intent_user=intent.getStringExtra("username");
        tv_username.setText("نام کاربری: " + intent_user);
        tv_name.setText("نام : " + intent.getStringExtra("name"));
        tv_family.setText("نام خانوادگی: " + intent.getStringExtra("family"));
        tv_email.setText("Email: " + intent.getStringExtra("email"));
        intent_pass=intent.getStringExtra("mobile");
        tv_mobile.setText("شماره همراه :" + intent_pass);
        tv_age.setText("سن :" + intent.getStringExtra("age"));

        tv_education.setText(intent.getStringExtra("education"));

        btn_confirm=(Button)findViewById(R.id.con_btn_register);
        btn_confirm.setOnClickListener(this);

        btn_back=(Button)findViewById(R.id.con_btn2_cancel);
        btn_back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.con_btn_register:
                AlertDialog.Builder alertbuilder = new AlertDialog.Builder(Confirm_registering.this);
                alertbuilder.setMessage("ثبت نام شما قطعی شد . به صفحه ورود به سامانه هدایت می شوید");
                alertbuilder.setIcon(R.drawable.person);
                alertbuilder.setCancelable(false);
                alertbuilder.setPositiveButton("تائید", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Confirm_registering.this, Login.class);
                                intent.putExtra("username",intent_user);
                                intent.putExtra("mobile",intent_pass);
                                startActivity(intent);

                            }
                        }).show();
                break;

            case R.id.con_btn2_cancel:
                onBackPressed();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
