package com.lapeyre.ubc_course_viewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class ViewCoursesActivity extends AppCompatActivity {

    private ArrayList<Course> chosenCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_courses);

        Intent i = getIntent();

        chosenCourses = (ArrayList<Course>) i.getSerializableExtra("Course List");

        displayCourses();
    }

    private void displayCourses() {
        // Implement multi-line text views
    }
}
