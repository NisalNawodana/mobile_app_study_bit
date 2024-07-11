package com.example.assignment_1;

import static android.content.ContentValues.TAG;
import static com.example.assignment_1.R.id.emailaddress;
import static com.example.assignment_1.R.id.registernow_btn;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrationDetails extends AppCompatActivity {

    DBHepler myDB;
    EditText name,address,livingcity,dateofbirth,nic,gender,mobilenumber,password,emailaddress;
    Button registernow_btn, back1_btn;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration_details);

        name = (EditText) findViewById(R.id.name);
        address = (EditText) findViewById(R.id.address);
        livingcity = (EditText) findViewById(R.id.livingcity);
        dateofbirth = (EditText) findViewById(R.id.dateofbirth);
        nic = (EditText) findViewById(R.id.nic);
        mobilenumber = (EditText) findViewById(R.id.mobilenumber);
        password = (EditText) findViewById(R.id.password);
        emailaddress = (EditText) findViewById(R.id.emailaddress);

        registernow_btn = (Button) findViewById(R.id.registernow_btn);
        back1_btn = (Button) findViewById(R.id.back1_btn);
        myDB = new DBHepler (this);

        registernow_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = emailaddress.getText().toString();
                String pass = password.getText().toString();
                String  na = name.getText().toString();
                String add = address.getText().toString();
                String living = livingcity.getText().toString();
                String dateof = dateofbirth.getText().toString();
                String ni = nic.getText().toString();
                String mobile = mobilenumber.getText().toString();

                if (user.equals("")|| pass.equals("") || na.equals("") || add.equals("") || living.equals("")|| dateof.equals("") || ni.equals("") || mobile.equals(""))
                {
                    Toast.makeText(RegistrationDetails.this, "Fill all the Field", Toast.LENGTH_SHORT).show();
                }
                else
                {
                   // Toast.makeText(RegistrationDetails.this, "Fine", Toast.LENGTH_SHORT).show();
                    Boolean usercheckresult = myDB.checkusername(user);
                    if(usercheckresult ==  false)
                    {
                        Boolean regresult = myDB.insertData(user,pass);
                        if(regresult == true)
                        {
                            Toast.makeText(RegistrationDetails.this, "Registration Successful \n Varification Code Send to the Email Address.", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(RegistrationDetails.this, "Registration Failed \n Try Again.", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(RegistrationDetails.this, "User Already Exists. \n Please Sign In", Toast.LENGTH_SHORT).show();
                    }



                }




            }
        });

        back1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationDetails.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });






    }
}