package com.example.assignment_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdminLogin extends AppCompatActivity {

    Button login_btn, back3_btn;
    EditText adminEmailAddress,adminPassword;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_login);

        login_btn = (Button)findViewById(R.id.login_btn);
        back3_btn = findViewById(R.id.back3_btn);
        adminEmailAddress = (EditText)findViewById(R.id.adminEmailAddress);
        adminPassword= (EditText)findViewById(R.id.adminPassword);

        loginButton();
        back3Button();

        }


    public void loginButton()
    {
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredEmail = adminEmailAddress.getText().toString();
                String enteredPassword = adminPassword.getText().toString();

                if (enteredEmail.equals("temp@gmail.com") && enteredPassword.equals("1234")) {
                    Intent intent = new Intent(AdminLogin.this, Administrator_interface.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(AdminLogin.this, "Please Enter the correct details", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
    public void back3Button()
    {
    back3_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(AdminLogin.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    });
    }



    }
