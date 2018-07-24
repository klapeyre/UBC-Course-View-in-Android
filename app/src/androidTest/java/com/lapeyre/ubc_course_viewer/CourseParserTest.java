package com.lapeyre.ubc_course_viewer;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;



@RunWith(AndroidJUnit4.class)
public class CourseParserTest {

    private Course c1;
    private Course c2;
    private Course c3;
    private Course fakeCourse;
    private Course c4;

    private String courseName = "BIOL 200 Fundamentals of Cell Biology";
    private String courseCode = "BIOL";
    private String courseNumber = "200";
    private String sec1 = "T53";
    private String sec2 = "T54";
    private String sec3 = "T55";
    private String start = "14:00";
    private String end = "15:00";
    private String day = "Wed";
    private String term = "1";
    private String activity = "Tutorial";

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.lapeyre.ubc_course_viewer", appContext.getPackageName());
    }

    @Test
    public void loadTestData() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        CourseParser.parseCourseData(appContext);

        // CourseManager should now have the whole data set. Run all tests so data only needs to load once.
        // Having trouble getting separate data to load for tests, so for now test data is built from known examples in dataset
        CourseManager cm = CourseManager.getInstance();
        assertTrue(cm.getCourses().size() != 0);

        c1 = new Course(courseName, courseCode, courseNumber, sec1, start, end,
                day, term, activity);
        c2 = new Course(courseName, courseCode, courseNumber, sec2, start, end,
                day, term, activity);
        c3 = new Course(courseName, courseCode, courseNumber, sec3, "15:00", "16:00",
                day, term, activity);
        fakeCourse = new Course("Test course", "Test code", "Test number", "Test section",
                "Test start", "Test end", "Test day", "Test term", "Test activity");
        c4 = new Course("VANT 140D Content and Language Enrichment Tutorials - CONTENT LANG TUT", "", "", "",
                "12:00", "14:00", "Fri", "2", "Tutorial");


        assertTrue(cm.containsCourse(c1));
        assertTrue(cm.containsCourse(c2));
        assertTrue(cm.containsCourse(c3));
        assertFalse(cm.containsCourse(fakeCourse));
        assertFalse(cm.containsCourse(c4));


    }
}

