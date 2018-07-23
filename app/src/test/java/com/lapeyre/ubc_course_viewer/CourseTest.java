package com.lapeyre.ubc_course_viewer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseTest {

    private Course c1;
    private Course c2;
    private Course c3;

    @Before
    public void setUp() throws Exception {
        c1 = new Course("Test Course 1", "ABCD", "101", "001",
                "14:00", "15:00", "Mon Wed", "1", "Lecture");
        c2 = new Course("Test Course 2", "EFGH", "201", "001",
                "14:00", "15:00", "Mon Wed", "1", "Lecture");
        c3 = new Course("Test Course 1 - Duplicate", "ABCD", "101", "001",
                "14:00", "15:00", "Mon Wed", "1", "Lecture");
    }

    @Test
    public void testConstructor() {
        Course testCourse = new Course("Test Course 1", "ABCD", "101", "001",
                "14:00", "15:00", "Mon Wed", "1", "Lecture");
        assertTrue(testCourse.getStart().equals("14:00"));
        assertTrue(testCourse.getEnd().equals("15:00"));
        assertTrue(testCourse.getTitle().equals("Test Course 1"));
        assertTrue(testCourse.getCode().equals("ABCD"));
        assertTrue(testCourse.getNumber().equals("101"));
        assertTrue(testCourse.getSection().equals("001"));
        assertTrue(testCourse.getDays().equals("Mon Wed"));
        assertTrue(testCourse.getTerm().equals("1"));
        assertTrue(testCourse.getActivity().equals("Lecture"));
    }

    @Test
    public void testCoursesEqual() {
        assertTrue(c1.equals(c3));
    }

    @Test
    public void testCoursesDifferent() {
        assertTrue(!c2.equals(c3));
    }
}