package com.lapeyre.ubc_course_viewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private CourseManager cm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getData(View view) {
        Intent intent = new Intent(this, DisplayCourseDataActivity.class);
        loadDataIntoManager();
        startActivity(intent);

    }

    private void loadDataIntoManager() {
        cm = CourseManager.getInstance();
        if (cm.getCourses().isEmpty()) {
            CourseParser.parseCourseData(this);
        }

    }

    
}
