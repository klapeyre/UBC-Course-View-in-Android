package com.lapeyre.ubc_course_viewer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseManagerTest {

    Course c1;
    Course c2;
    Course c3;

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
    public void testSingleton() {
        CourseManager cm1 = CourseManager.getInstance();
        assertTrue(cm1.getCourses().size() == 0);
        cm1.addCourse(c1);
        assertTrue(cm1.getCourses().size() == 1);

        CourseManager cm2 = CourseManager.getInstance();
        assertTrue(cm2.getCourses().size() == 1);
    }

    @Test
    public void testAddOneCourse() {
        CourseManager cm1 = CourseManager.getInstance();
        cm1.addCourse(c1);
        assertTrue(cm1.getCourses().size() == 1);
        assertTrue(cm1.getCourse("ABCD", "101", "001").equals(c1));
    }

    @Test
    public void testAddDuplicate() {
        CourseManager cm1 = CourseManager.getInstance();
        cm1.addCourse(c1);
        cm1.addCourse(c1);
        assertTrue(cm1.getCourses().size() == 1);
    }

    @Test
    public void testAddSameSection() {
        CourseManager cm1 = CourseManager.getInstance();
        cm1.addCourse(c1);
        cm1.addCourse(c3);
        assertTrue(cm1.getCourses().size() == 1);
        Course getC3 = cm1.getCourse(c3);
        assertFalse(getC3.getTitle().equals("Test Course 1 - Duplicate"));
    }

    @Test
    public void testRemoveCourse() {
        CourseManager cm1 = CourseManager.getInstance();
        cm1.addCourse(c1);
        assertTrue(cm1.getCourses().size() == 1);
        assertTrue(cm1.containsCourse(c1));

        cm1.removeCourse(c1);
        assertTrue(cm1.getCourses().size() == 0);
        assertFalse(cm1.containsCourse(c1));
    }

    @Test
    public void testGetCourseByCourse() {
        Course c1Dup = new Course("Test Course 1", "ABCD", "101", "001",
                "14:00", "15:00", "Mon Wed", "1", "Lecture");

        CourseManager cm1 = CourseManager.getInstance();
        cm1.addCourse(c1);
        assertTrue(cm1.getCourses().size() == 1);
        assertTrue(cm1.containsCourse(c1));

        Course getC1 = cm1.getCourse(c1Dup);
        assertTrue(getC1.equals(c1Dup));
    }
}