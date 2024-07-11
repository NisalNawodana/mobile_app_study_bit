package com.example.assignment_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    ListView courseListView;
    DBAdmin adminDB;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        adminDB = new DBAdmin(this);

        courseListView = findViewById(R.id.course_list_view);
        loadCourseList();


    }

    private void loadCourseList() {
        Cursor res = adminDB.getAllData();
        if (res.getCount() == 0) {
            Toast.makeText(this, "No courses found", Toast.LENGTH_SHORT).show();
            return;
        }

        ArrayList<String> courseList = new ArrayList<>();
        while (res.moveToNext()) {
            String course = "Course Name: " + res.getString(0) + "\n"
                    + "Course Fee: " + res.getString(1) + "\n"
                    + "Branch: " + res.getString(2) + "\n"
                    + "Duration: " + res.getString(3) + "\n"
                    + "Published On: " + res.getString(4) + "\n"
                    + "Registration Close: " + res.getString(5) + "\n"
                    + "Starting On: " + res.getString(6);
            courseList.add(course);
        }

        CustomAdapter adapter = new CustomAdapter(this, courseList);
        courseListView.setAdapter(adapter);
    }
}
