package com.example.simpletutors;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class student_feedback_final extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "student_feedback_final";
    Button SubmitButton;
    EditText generalFeedback;
    EditText TopicsUnderstood;
    EditText TopicsNotUnderstood;
    EditText StudentName;
    static String generalFeedbackString;
    static String TopicsUnderstoodString;
    static String TopicsNotUnderstoodString;
    static String StudentNameString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_feedback_final);
        generalFeedback = findViewById(R.id.editTextGenFeedback);
        TopicsUnderstood = findViewById(R.id.editTextTopicsUnderstood);
        TopicsNotUnderstood = findViewById(R.id.editTextBadTopics);
        StudentName = findViewById(R.id.StudentNameText);
        SubmitButton = findViewById(R.id.SubmitButton);
        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(student_feedback_final.this);
                builder.setMessage(getString(R.string.Submit));
                builder.setPositiveButton(getString(R.string.Yes), (dialog, id) -> {
                    //strings that will be used for the tutor's feedback
                    StudentNameString = StudentName.getText().toString();
                    generalFeedbackString = generalFeedback.getText().toString();
                    TopicsUnderstoodString = TopicsUnderstood.getText().toString();
                    TopicsNotUnderstoodString = TopicsNotUnderstood.getText().toString();
                    Log.i(ACTIVITY_NAME, "no");
                    Intent intent = new Intent(student_feedback_final.this, Tutor_view_feedback.class);
                    startActivity(intent);

                });
                builder.setNegativeButton(getString(R.string.No), (dialog, id) -> {
                    Log.i(ACTIVITY_NAME, "yes");
                });
                builder.show();


            }

        });
    }

    public String getGeneralFeedbackString() {
        if (generalFeedbackString == null) {
            return "";
        }
        else {
            return generalFeedbackString;
        }
    }
    public String getTopicsUnderstoodString() {

        if (TopicsUnderstoodString == null) {
            return "";
        }
        else {
            return TopicsUnderstoodString;
        }

    }
    public String getTopicsNotUnderstoodString() {
        if (TopicsNotUnderstoodString == null) {
            return "";
        }
        else {
            return TopicsNotUnderstoodString;
        }
    }

    public String getStudentNameString() {
        if (StudentNameString == null) {
            return "";
        }
        else {
            return StudentNameString;
        }
    }
}
