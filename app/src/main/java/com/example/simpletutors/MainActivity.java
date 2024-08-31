package com.example.simpletutors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button chatWithTutor = findViewById(R.id.chatWithTutorButton);
        final Button sendFeedback = findViewById(R.id.sendFeedbackButton);

        chatWithTutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChatWindow.class);
                startActivity(intent);
            }
        });
        sendFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, student_feedback_final.class);
                startActivity(intent);
            }
        });

    }

    public void launchBrowseTutors(View view) {
        Intent intent = new Intent(this, BrowseTutorsActivity.class);
        startActivity(intent);
    }

}