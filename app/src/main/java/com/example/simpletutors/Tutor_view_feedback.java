package com.example.simpletutors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;

public class Tutor_view_feedback  extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_view_feedback);

        TextView StudentName = findViewById(R.id.StudentNameTextView);
        TextView GenFeedback = findViewById(R.id.StudentGenFeedbackView);
        TextView Goodtopics = findViewById(R.id.StudentTopicsUnderstood);
        TextView BadTopics = findViewById(R.id.StudentBadTopics);


        StudentName.setText(student_feedback_final.StudentNameString);
        GenFeedback.setText(student_feedback_final.generalFeedbackString);
        Goodtopics.setText(student_feedback_final.TopicsUnderstoodString);
        BadTopics.setText(student_feedback_final.TopicsNotUnderstoodString);

    }
}