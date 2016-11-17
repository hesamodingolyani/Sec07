package com.example.hesamodin.sec06;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity {

    Button btn_exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btn_exit=(Button)findViewById(R.id.btn_exit);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertbuilder=new AlertDialog.Builder(ProfileActivity.this);
                alertbuilder.setMessage("خروج با موفقیت انجام شد");
                alertbuilder.setIcon(R.drawable.person);
                alertbuilder.setCancelable(false);

                alertbuilder.setPositiveButton("تائید", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent =new Intent(ProfileActivity.this,MainActivity.class);
                        startActivity(intent);

                    }
                }).show();
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
