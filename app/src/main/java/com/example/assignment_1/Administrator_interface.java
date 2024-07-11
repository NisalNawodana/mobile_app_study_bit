package com.example.assignment_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Administrator_interface extends AppCompatActivity {
    DBAdmin adminDB;
    EditText admincourse_name, admincourse_fee,admincourse_branch,admincourse_duration, adminpublished_on,adminregistration_close,adminstarting_on;
    Button add_btn,view_btn,update_btn,delete_btn, back2_btn;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_administrator_interface);

        adminDB = new DBAdmin(this);

        admincourse_name = (EditText)findViewById(R.id.admincourse_name);
        admincourse_fee = (EditText)findViewById(R.id.admincourse_fee);
        admincourse_branch = (EditText)findViewById(R.id.admincourse_branch);
        admincourse_duration= (EditText)findViewById(R.id.admincourse_duration);
        adminpublished_on= (EditText)findViewById(R.id.adminpublished_on);
        adminregistration_close= (EditText)findViewById(R.id.adminregistration_close);
        adminstarting_on= (EditText)findViewById(R.id.adminstarting_on);

        add_btn = (Button)findViewById(R.id.add_btn);
        view_btn = (Button)findViewById(R.id.view_btn);
        update_btn = (Button)findViewById(R.id.update_btn);
        delete_btn = (Button)findViewById(R.id.delete_btn);
        back2_btn = (Button)findViewById(R.id.back2_btn);

        AddData();
        viewAll ();

        UpdateData();
        DeleteData();
        backButton();
    }

    public void AddData(){
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               boolean isInserted =  adminDB.insertData(admincourse_name.getText().toString(),admincourse_fee.getText().toString(),
                        admincourse_branch.getText().toString(),admincourse_duration.getText().toString(),adminpublished_on.getText().toString(),
                        adminregistration_close.getText().toString(),adminstarting_on.getText().toString());

               if(isInserted ==true)

                   Toast.makeText(Administrator_interface.this, "Data inserted", Toast.LENGTH_SHORT).show();

               else

                   Toast.makeText(Administrator_interface.this, "Insert Again", Toast.LENGTH_SHORT).show();



            }
        });

    }

public void viewAll (){
        view_btn.setOnClickListener(new View.OnClickListener() {
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


public void UpdateData(){
        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isupdated  = adminDB.updateData(admincourse_name.getText().toString(),admincourse_fee.getText().toString(),admincourse_duration.getText().toString(),
                        admincourse_branch.getText().toString(),adminpublished_on.getText().toString(),adminregistration_close.getText().toString(),adminstarting_on.getText().toString());

                if(isupdated==true)
                {
                    Toast.makeText(Administrator_interface.this, "Data is Updated", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Administrator_interface.this, "Data is Not Updated", Toast.LENGTH_SHORT).show();
                }
            }
        });

}


public void DeleteData(){
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deleteRows = adminDB.deleteData(admincourse_name.getText().toString());
                if(deleteRows >0)
                {
                    Toast.makeText(Administrator_interface.this, "Deleted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Administrator_interface.this, "Not Deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });
}

public void backButton()
{
    back2_btn.setOnClickListener(new View.OnClickListener()
    {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Administrator_interface.this, AdminLogin.class);
            startActivity(intent);
            }
    });
}
}



