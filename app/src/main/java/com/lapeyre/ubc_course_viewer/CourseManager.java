package com.lapeyre.ubc_course_viewer;

import java.util.HashMap;
import java.util.Map;


public class CourseManager {

    private Map<Course, Course> courses;
    private static CourseManager instance;

    private CourseManager() {
        courses = new HashMap<>();
    }

    public static CourseManager getInstance() {
        if (instance == null) {
            instance = new CourseManager();
            return instance;
        } else {
            return instance;
        }
    }

    public void addCourse(Course c) {
        if (!courses.containsKey(c)) {
            courses.put(c,c);
        }
    }

    public void removeCourse(Course c) {
        courses.remove(c);
    }

    public boolean containsCourse(Course c) {
        return courses.containsKey(c);
    }

    public Course getCourse(Course c) {
        return courses.get(c);
    }

    public Course getCourse(String code, String number, String section) {
        Course match = null;
        for (Map.Entry<Course, Course> entry : courses.entrySet()) {
            if (entry.getValue().getCode().equals(code) &&
                    entry.getValue().getNumber().equals(number) &&
                    entry.getValue().getSection().equals(section)) {
                match =  entry.getValue();
            }
        }

        return match;
    }

    public Map<Course, Course> getCourses() {
        return courses;
    }


}
