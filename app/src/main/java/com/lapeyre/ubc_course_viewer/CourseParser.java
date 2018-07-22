package com.lapeyre.ubc_course_viewer;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class CourseParser {

    private static JSONArray JSONArray;

    public static void parseCourseData(Context context) {
        JSONArray = parseRawData(context);

        if (JSONArray != null) {
            for (int i = 0; i < JSONArray.length(); i++) {
                try {
                    JSONObject o = JSONArray.getJSONObject(i);
                    String end = o.getString("course_end");
                    String title = o.getString("course_title");
                    String section = o.getString("course_section");
                    String days = o.getString("course_days");
                    String term = o.getString("course_term");
                    String activity = o.getString("course_activity");
                    String start = o.getString("course_start");
                    title = title.substring(9);

                    if (!section.equals("")) {
                        String[] arr = section.split("\\s+");
                        if (arr.length >= 3) {
                            String code = arr[0];
                            String number = arr[1];
                            String secNum = arr[2];
                            Course c = new Course(title, code, number, secNum, start, end, days, term, activity);
                            CourseManager cm = CourseManager.getInstance();
                            cm.addCourse(c);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    private static JSONArray parseRawData(Context context) {
        String JSONString = null;
        
        try {
            InputStream i = context.getAssets().open("courses.json");
            int size = i.available();

            byte[] bytes = new byte[size];

            i.read(bytes);

            i.close();

            JSONString = new String(bytes, "UTF-8");
            JSONArray = new JSONArray(JSONString);

        } catch (IOException | JSONException ex) {
            ex.printStackTrace();
            return null;
        }

        return JSONArray;

    }
}
