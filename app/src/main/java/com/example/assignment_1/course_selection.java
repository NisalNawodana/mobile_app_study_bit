package com.example.assignment_1;

import java.util.ArrayList;
import java.util.List;

public class course_selection {


    static List<String> getcourse(String course){
        List<String> courseL = new ArrayList<>();

        if(course.equals("Engineering"))
        {
            courseL.add("LKR 20,000/=");
        }
        else if(course.equals("Art"))
        {
            courseL.add("LKR 30,000/=");
        }
        else if(course.equals("Com"))
        {
            courseL.add("LKR 40,000/=");
        }
      return courseL;



    }
}
