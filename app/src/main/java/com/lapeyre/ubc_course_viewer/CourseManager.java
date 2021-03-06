package com.lapeyre.ubc_course_viewer;

import java.util.*;


public class CourseManager {

    private Map<Integer, Course> courses;
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
        if (!courses.containsKey(c.hashCode())) {
            courses.put(c.hashCode(),c);
        }
    }

    public void removeCourse(Course c) {
        courses.remove(c.hashCode());
    }

    public boolean containsCourse(Course c) {
        return courses.containsKey(c.hashCode());
    }

    public Course getCourse(String code, String number, String section) {
        Course match = null;
        for (Map.Entry<Integer, Course> entry : courses.entrySet()) {
            if (entry.getValue().getCode().equals(code) &&
                    entry.getValue().getNumber().equals(number) &&
                    entry.getValue().getSection().equals(section)) {
                match =  entry.getValue();
            }
        }

        return match;
    }

    public List<Course> getCourses() {
        List<Course> cs = new ArrayList<Course>(courses.values());
        return Collections.unmodifiableList(cs);
    }


}
