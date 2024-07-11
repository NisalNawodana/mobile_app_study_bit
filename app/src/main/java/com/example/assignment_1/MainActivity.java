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

public class MainActivity extends AppCompatActivity {

    EditText emailaddress, password;
    Button signin_btn, register_btn, administrator_btn, guest_btn, viewBranches;
    DBHepler myDB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        emailaddress = findViewById(R.id.emailaddress);
        password = findViewById(R.id.password);
        signin_btn = findViewById(R.id.signin_btn);
        register_btn = findViewById(R.id.register_btn);
        administrator_btn = findViewById(R.id.administrator_btn);
        guest_btn = findViewById(R.id.guest_btn);
        viewBranches = findViewById(R.id.viewBranches);


        myDB = new DBHepler(this);

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistrationDetails.class);
                startActivity(intent);
                finish();
            }
        });

        guest_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, guestInterface.class);
                startActivity(intent);
                finish();
            }
        });

        administrator_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdminLogin.class);
                startActivity(intent);
                finish();
            }
        });

        viewBranches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, viewMap.class);
                startActivity(intent);
                finish();
            }
        });



        studentLogin();
    }

    public void studentLogin() {
        signin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studentEmail = emailaddress.getText().toString();
                String studentPassword = password.getText().toString();

                if (studentEmail.isEmpty() || studentPassword.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all detailss", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkUserPass = myDB. checkusernamePassword(studentEmail, studentPassword);
                    if (checkUserPass) {
                        Intent intent = new Intent(MainActivity.this, RegisterActivity.class); // Redirect to StudentHome or appropriate activity
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
