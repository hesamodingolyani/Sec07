package com.example.hesamodin.sec06;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button btn_login, btn_cancel;
    EditText edt_username, edt_password;
    public String user_input, pass_input, user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_cancel = (Button) findViewById(R.id.btn_cancel);
        edt_username = (EditText) findViewById(R.id.edt_username);
        edt_password = (EditText) findViewById(R.id.edt_password);

            Intent intent = getIntent();
            edt_username.setText(intent.getStringExtra("username"));
            user = edt_username.getText().toString();
            pass = intent.getStringExtra("mobile");


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user_input = edt_username.getText().toString();
                pass_input = edt_password.getText().toString();
                if ((user.equalsIgnoreCase(user_input)) && (pass.equalsIgnoreCase(pass_input)))
                //if (true)
                {
                    Intent intent = new Intent(Login.this, ProfileActivity.class);
                    startActivity(intent);
                } else
                    Toast.makeText(Login.this, "نام کاربری یا کلمه عبور اشتباه است", Toast.LENGTH_LONG).show();
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);

            }
        });


    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
