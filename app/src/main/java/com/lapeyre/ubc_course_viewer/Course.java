package com.lapeyre.ubc_course_viewer;


import java.io.Serializable;
import java.util.Objects;

public class Course implements Serializable {

    private String title;
    private String code;
    private String number;
    private String section;
    private String start;
    private String end;
    private String days;
    private String term;
    private String activity;

    public Course(String title, String code, String number, String section, String start, String end, String days,
                  String term, String activity) {
        this.title = title;
        this.code = code;
        this.number = number;
        this.section = section;
        this.start = start;
        this.end = end;
        this.days = days;
        this.term = term;
        this.activity = activity;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCode() {
        return this.code;
    }

    public String getNumber() {
        return this.number;
    }

    public String getSection() {
        return this.section;
    }

    public String getStart() {
        return this.start;
    }

    public String getEnd() {
        return this.end;
    }

    public String getDays() {
        return this.days;
    }

    public String getTerm() {
        return this.term;
    }

    public String getActivity() {
        return this.activity;
    }


    // A course is equal to another if it is the same code, number and section, in the same term.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(code, course.code) &&
                Objects.equals(number, course.number) &&
                Objects.equals(section, course.section);
    }

    @Override
    public int hashCode() {

        return Objects.hash(code, number, section);
    }
}
