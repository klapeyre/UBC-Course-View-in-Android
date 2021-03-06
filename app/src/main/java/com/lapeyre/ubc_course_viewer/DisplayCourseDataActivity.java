package com.lapeyre.ubc_course_viewer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.io.Serializable;
import java.util.*;

public class DisplayCourseDataActivity extends AppCompatActivity {

    private CourseManager cm;
    private Spinner courseNumberSpinner;
    private Spinner courseSectionSpinner;

    private String selectedCode;
    private String selectedNumber;
    private String selectedSection;

    private ArrayList<Course> chosenCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_course_data);

        ArrayList<String> courseCodes = loadCourseCodes();
        Spinner courseCodeSpinner = (Spinner) findViewById(R.id.courseCodesSpinner);

        ArrayAdapter<String> courseCodeAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, courseCodes);
        courseCodeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        courseCodeSpinner.setAdapter(courseCodeAdapter);

        courseNumberSpinner = (Spinner) findViewById(R.id.courseNumberSpinner);
        courseSectionSpinner = (Spinner) findViewById(R.id.courseSectionSpinner);

        courseCodeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedCode =  (String) adapterView.getItemAtPosition(i);
                setupCourseNumberSpinner(selectedCode);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // do nothing
            }
        });

        courseNumberSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedNumber = (String) adapterView.getItemAtPosition(i);
                setupCourseSectionSpinner(selectedCode, selectedNumber);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // do nothing
            }
        });

        courseSectionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedSection = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // do nothing
            }
        });

        chosenCourses = new ArrayList<>();

    }

    public void addCourseToList(View view) {
        cm = CourseManager.getInstance();
        Course match = cm.getCourse(selectedCode, selectedNumber, selectedSection);
        if (match != null) {
            if (!chosenCourses.contains(match)) {
                chosenCourses.add(match);
                Toast.makeText(getApplicationContext(), "Course added successfully!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Course not found! Or you already added it.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void removeCourseFromList(View view) {
        cm = CourseManager.getInstance();
        Course match = cm.getCourse(selectedCode, selectedNumber, selectedSection);
        if (match != null) {
            if (chosenCourses.contains(match)) {
                chosenCourses.remove(match);
                Toast.makeText(getApplicationContext(), "Course removed successfully!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Course not found! Maybe you didn't add it yet.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void viewCourses(View view) {
        Intent intent = new Intent(this, ViewCoursesActivity.class);
        intent.putExtra("Course List", (Serializable) chosenCourses);
        startActivity(intent);
    }

    private void setupCourseNumberSpinner(String code) {
        ArrayList<String> courseNums = loadCourseNumbers(code);
        ArrayAdapter<String> courseNumberAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, courseNums);
        courseNumberAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        courseNumberSpinner.setAdapter(courseNumberAdapter);
    }

    private void setupCourseSectionSpinner(String code, String number) {
        ArrayList<String> courseSections = loadCourseSections(code, number);
        ArrayAdapter<String> courseSectionAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, courseSections);
        courseSectionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        courseSectionSpinner.setAdapter(courseSectionAdapter);
    }

    private ArrayList<String> loadCourseCodes() {
        ArrayList<String> codes = new ArrayList<>();
        cm = CourseManager.getInstance();
        List<Course> courses = cm.getCourses();
        for (Course c : courses) {
            if (!codes.contains(c.getCode())) {
                codes.add(c.getCode());
            }
        }
        Collections.sort(codes);
        return codes;
    }

    private ArrayList<String> loadCourseNumbers(String code) {
        ArrayList<String> nums = new ArrayList<>();
        cm = CourseManager.getInstance();
        List<Course> courses = cm.getCourses();
        for (Course c : courses) {
            if (c.getCode().equals(code)) {
                if (!nums.contains(c.getNumber())) {
                    nums.add(c.getNumber());
                }
            }
        }
        Collections.sort(nums);
        return nums;
    }

    private ArrayList<String> loadCourseSections(String code, String number) {
        ArrayList<String> sections = new ArrayList<>();
        cm = CourseManager.getInstance();
        List<Course> courses = cm.getCourses();
        for (Course c : courses) {
            if (c.getCode().equals(code) && c.getNumber().equals(number)) {
                if (!sections.contains(c.getSection())) {
                    sections.add(c.getSection());
                }
            }
        }
        Collections.sort(sections);
        return sections;
    }
}
