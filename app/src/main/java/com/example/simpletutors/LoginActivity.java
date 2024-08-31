package com.example.simpletutors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "LoginActivity";
    String loginEmail = "";
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button loginButton = findViewById(R.id.loginButton);
        final EditText loginName = findViewById(R.id.loginText);
        final EditText password = findViewById(R.id.PasswordText);
        sp = getSharedPreferences("DefaultEmail", MODE_PRIVATE);
        String emailDefaulted = sp.getString("DefaultEmail","email@domain.com");
        loginName.setText(emailDefaulted);

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {

                loginEmail = loginName.getText().toString();
                SharedPreferences.Editor editor = sp.edit();

                editor.putString("LoginEmail",loginEmail);
                editor.commit();
                //Check validation of email and password
                if ((!loginEmail.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(loginEmail).matches()) && !password.getText().toString().isEmpty())  {
                    Toast.makeText(LoginActivity.this, "Email and Password Verified !", Toast.LENGTH_SHORT).show();
                    //Code that brings you to the specified page => From Login to Main Activity
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(LoginActivity.this, "Enter valid Email address or Password!", Toast.LENGTH_SHORT).show();
                }

            }

        });

    }

    protected void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }
    protected void onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }
    protected void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }
    protected void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }
    protected void onDestroy(){
        Log.i(ACTIVITY_NAME, "In onDestroy()");
        super.onDestroy();
    }
    private void myClickHandler(View view){

    }

}