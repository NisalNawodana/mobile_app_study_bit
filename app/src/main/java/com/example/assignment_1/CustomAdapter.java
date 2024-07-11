package com.example.assignment_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final ArrayList<String> courses;

    public CustomAdapter(Context context, ArrayList<String> courses) {
        super(context, R.layout.course_list_item, courses);
        this.context = context;
        this.courses = courses;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.course_list_item, parent, false);

        TextView courseInfo = rowView.findViewById(R.id.course_info);
        Button registerButton = rowView.findViewById(R.id.item_register_btn);

        courseInfo.setText(courses.get(position));

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Register for: " + courses.get(position), Toast.LENGTH_SHORT).show();
                // Add registration logic here
            }
        });

        return rowView;
    }
}
