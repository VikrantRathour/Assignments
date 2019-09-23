package com.example.assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//handler for the post delayed method
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                loginActivity();
            }
        }, 3000);//delay will be of 3000ms
    }
    public void loginActivity(){

        //intent to login activity
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);

        //to destroy the splash screen activity
        finish();
    }
}
