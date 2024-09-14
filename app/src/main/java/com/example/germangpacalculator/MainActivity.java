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

public class MainActivity extends AppCompatActivity {
    private LinearLayout coursesBox;
    private Button addCourseButton;
    private Button calculate;
    private TextView GPA;

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

        addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LinearLayout courseData = new LinearLayout(MainActivity.this);
                courseData.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
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

                deleteCourse.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Remove the course row from the parent layout
                        coursesBox.removeView(courseData);
                    }
                });
            }
        });
    }

}