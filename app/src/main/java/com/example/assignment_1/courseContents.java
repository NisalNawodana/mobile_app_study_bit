package com.example.assignment_1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class courseContents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_course_contents);

        //TextView course= (TextView) findViewById(R.id.spinner);

        Spinner spinnercourse= (Spinner) findViewById(R.id.spinner_course);

        spinnercourse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String newItem = spinnercourse.getSelectedItem().toString();
                if(newItem.equals("Engineering"))
                {
                    Toast.makeText(courseContents.this, "You Selected: \n"+ newItem, Toast.LENGTH_SHORT).show();
            }
                else
                {
                    Toast.makeText(courseContents.this, "Other", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });







    }
}