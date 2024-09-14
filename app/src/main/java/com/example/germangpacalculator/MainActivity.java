package com.example.germangpacalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private LinearLayout coursesBox;
    private Button addCourseButton;
    private Button calculate;
    private TextView GPA;
    private HashMap<String, Integer> databaseCreditHours = new HashMap<>();
    private HashMap<String, Float> databaseGPA = new HashMap<>();
    private ArrayList<LinearLayout> courseLayouts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        coursesBox = findViewById(R.id.courses);
        addCourseButton = findViewById(R.id.addCourse);
        calculate = findViewById(R.id.calculateGPA);
        GPA = findViewById(R.id.GPA);

        addCourseButton.setOnClickListener(v -> {
            LinearLayout courseData = new LinearLayout(MainActivity.this);
            courseData.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(10, 0, 10, 0);

            EditText courseName = new EditText(MainActivity.this);
            courseName.setHint("Course Name");
            courseName.setLayoutParams(layoutParams);

            EditText creditHours = new EditText(MainActivity.this);
            creditHours.setHint("Credit Hours");
            creditHours.setLayoutParams(layoutParams);

            EditText gpa = new EditText(MainActivity.this);
            gpa.setHint("GPA");
            gpa.setLayoutParams(layoutParams);

            Button deleteCourse = new Button(MainActivity.this);
            deleteCourse.setText("Delete");

            courseData.addView(courseName);
            courseData.addView(creditHours);
            courseData.addView(gpa);
            courseData.addView(deleteCourse);
            coursesBox.addView(courseData);
            courseLayouts.add(courseData);

            deleteCourse.setOnClickListener(v1 -> {
                coursesBox.removeView(courseData);
                courseLayouts.remove(courseData);

                // Remove associated data from HashMaps
                String courseNameText = ((EditText) courseData.getChildAt(0)).getText().toString();
                databaseCreditHours.remove(courseNameText);
                databaseGPA.remove(courseNameText);
            });
        });

        calculate.setOnClickListener(v -> {
            // Clear previous data
            databaseCreditHours.clear();
            databaseGPA.clear();

            // Extract data from all course views
            for (LinearLayout courseData : courseLayouts) {
                EditText courseName = (EditText) courseData.getChildAt(0);
                EditText creditHours = (EditText) courseData.getChildAt(1);
                EditText gpa = (EditText) courseData.getChildAt(2);

                String courseNameText = courseName.getText().toString();
                String credHoursText = creditHours.getText().toString();
                String gpaText = gpa.getText().toString();

                try {
                    if (!courseNameText.isEmpty() && !credHoursText.isEmpty() && !gpaText.isEmpty()) {
                        int creditHoursValue = Integer.parseInt(credHoursText);
                        float gpaValue = Float.parseFloat(gpaText);

                        databaseCreditHours.put(courseNameText, creditHoursValue);
                        databaseGPA.put(courseNameText, gpaValue);
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            float totalNumberOfCreditHours = 0;
            float creditTimesGPA = 0;

            // Calculate total credit hours and weighted GPA
            for (Map.Entry<String, Integer> entry : databaseCreditHours.entrySet()) {
                totalNumberOfCreditHours += entry.getValue();
            }

            for (Map.Entry<String, Integer> entry : databaseCreditHours.entrySet()) {
                creditTimesGPA += databaseGPA.get(entry.getKey()) * entry.getValue();
            }

            if (totalNumberOfCreditHours > 0) {
                float finalGPA = creditTimesGPA / totalNumberOfCreditHours;
                GPA.setText(String.format("Your GPA is %.2f", finalGPA));
            } else {
                GPA.setText("No courses added.");
            }
        });
    }
}
