package com.example.assignment_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class guestInterface extends AppCompatActivity {

    DBAdmin adminDB;
    Button viewCource_btn, back4_btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_guest_interface);

        adminDB = new DBAdmin(this);
        viewCource_btn = findViewById(R.id.viewCource_btn);
        back4_btn = findViewById(R.id.back4_btn);

        viewAll ();
        guestBack ();


    }

    public void viewAll (){
        viewCource_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res = adminDB.getAllData();
                if(res.getCount()==0)
                {
                    showMessage("Error", "Nothing Found");

                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext())
                {
                    buffer.append("COURSE_NAME :" +(" ")+ res.getString(0)+"\n");
                    buffer.append("COURSE_FEE :"+(" ")+ res.getString(1)+"\n");
                    buffer.append("BRANCH_NAME :"+(" ")+ res.getString(2)+"\n");
                    buffer.append("DURATION :"+(" ")+ res.getString(3)+"\n");
                    buffer.append("PUBLISHED_ON :"+(" ")+ res.getString(4)+"\n");
                    buffer.append("CLOSE_ON :"+(" ")+ res.getString(5)+"\n");
                    buffer.append("STARTING_ON :"+(" ")+ res.getString(6)+"\n\n\n\n");
                }

                showMessage("Data",buffer.toString());

            }
        });
    }

    public void showMessage(String title, String Message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this) ;
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void guestBack ()
    {
        back4_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(guestInterface.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }





}