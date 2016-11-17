package com.example.hesamodin.sec06;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Registering extends AppCompatActivity {

    public EditText R_edt_username, R_edt_name, R_edt_family, R_edt_email, R_edt_mobile, R_edt_age;

    Button btn_register, btn_cancel;
    int check = 0;

    public void check_fields(View view) {
        //Boolean result=false;
        EditText edt_txt = (EditText) findViewById(view.getId());
        if (edt_txt.getText().toString().equals("")) {
            check++;

            //edt_txt.setBackgroundResource(R.drawable.warningedittext);
            edt_txt.setBackground(getResources().getDrawable(R.drawable.warningedittext));
            //edt_txt.setBackgroundColor(Color.parseColor("#FF69B4"));
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registering);

        List<String> list = new ArrayList<String>();
        list.add(0, "کاردانی");
        list.add(1, "کارشناسی");
        list.add(2, "کارشناسی ارشد");
        list.add(3, "دکتری");
        final Spinner education = (Spinner) findViewById(R.id.education);
        ArrayAdapter<String> adp_education = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list);
        education.setAdapter(adp_education);

        btn_register = (Button) findViewById(R.id.btn_register);
        btn_cancel = (Button) findViewById(R.id.btn2_cancel);

        R_edt_username = (EditText) findViewById(R.id.edt_user);
        R_edt_username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // edt_username.setBackgroundColor(Color.WHITE);
                R_edt_username.setBackground(getResources().getDrawable(R.drawable.sampleedittext));
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        R_edt_name = (EditText) findViewById(R.id.edt_name);
        R_edt_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                R_edt_name.setBackground(getResources().getDrawable(R.drawable.sampleedittext));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        R_edt_family = (EditText) findViewById(R.id.edt_family);
        R_edt_family.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                R_edt_family.setBackground(getResources().getDrawable(R.drawable.sampleedittext));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        R_edt_email = (EditText) findViewById(R.id.edt_email);
        R_edt_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                R_edt_email.setBackground(getResources().getDrawable(R.drawable.sampleedittext));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        R_edt_mobile = (EditText) findViewById(R.id.edt_mobile);
        R_edt_mobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                R_edt_mobile.setBackground(getResources().getDrawable(R.drawable.sampleedittext));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        R_edt_age = (EditText) findViewById(R.id.edt_age);
        R_edt_age.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                R_edt_age.setBackground(getResources().getDrawable(R.drawable.sampleedittext));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ArrayList<EditText> myedtlist = new ArrayList<EditText>();
                LinearLayout mylayout = (LinearLayout) findViewById(R.id.activity_registering);
                LinearLayout my = (LinearLayout) mylayout.getChildAt(1);

                check = 0;
                for (int i = 0; i < my.getChildCount(); i++) {
                    if (my.getChildAt(i) instanceof EditText)
                        check_fields(my.getChildAt(i));
                }
                if (check > 0)
                    Toast.makeText(Registering.this, "فیلد های مشخص شده را تکمیل نمایید", Toast.LENGTH_SHORT).show();

                else {
                    int age =Integer.parseInt( R_edt_age.getText().toString());
                    if (100>age && age>5 ) {
                        AlertDialog.Builder alertbuilder = new AlertDialog.Builder(Registering.this);
                        alertbuilder.setMessage("به صفحه تائید اطلاعات هدایت میشوید . لطفاً  اطلاعات را بررسی و در صورت تائید ، ثبت نام خود را قطعی نمایید");
                        alertbuilder.setIcon(R.drawable.person);
                        alertbuilder.setCancelable(false);
                        alertbuilder.setPositiveButton("تائید", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Intent intent = new Intent(Registering.this, Confirm_registering.class);
                                intent.putExtra("username", R_edt_username.getText().toString());
                                intent.putExtra("name", R_edt_name.getText().toString());
                                intent.putExtra("family", R_edt_family.getText().toString());
                                intent.putExtra("email", R_edt_email.getText().toString());
                                intent.putExtra("mobile", R_edt_mobile.getText().toString());
                                intent.putExtra("age",R_edt_age.getText().toString());
                                intent.putExtra("education", education.getSelectedItem().toString());
                                startActivity(intent);

                            }
                        });
                        alertbuilder.setNegativeButton("انصراف", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
                    } else
                    {
                        R_edt_age.setBackground(getResources().getDrawable(R.drawable.warningedittext));
                        Toast.makeText(Registering.this,"سن باید عددی بین 6 تا 99 باشد",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registering.this, MainActivity.class);
                startActivity(intent);

            }
        });


    }

    @Override
    protected void onPause() {
        super.onPause();
        //finish();
    }
}
