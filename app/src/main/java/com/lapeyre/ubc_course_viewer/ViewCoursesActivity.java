package com.lapeyre.ubc_course_viewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewCoursesActivity extends AppCompatActivity {

    private ArrayList<Course> chosenCourses;
    private SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_courses);

        Intent i = getIntent();

        chosenCourses = (ArrayList<Course>) i.getSerializableExtra("Course List");

        displayCourses();

        ((ListView)findViewById(R.id.list)).setAdapter(sa);
    }

    private void displayCourses() {
        // Implement multi-line text views
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        HashMap<String, String> item;
        for (Course course: chosenCourses) {
            item = new HashMap<String, String>();
            String l1 = course.getTitle();
            String l2 = course.getCode() + " " +  course.getNumber() + " " + course.getSection();
            String l3;
            if (course.getDays().equals("") || course.getEnd().equals("") || course.getStart().equals("")) {
                l3 = "";
            } else {
                l3 = course.getDays() + " , " + course.getStart() + " - " + course.getEnd();
            }
            item.put("line 1", l1);
            item.put("line 2", l2);
            item.put("line 3", l3);
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[] {"line 1", "line 2", "line 3"},
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c});
    }
}
