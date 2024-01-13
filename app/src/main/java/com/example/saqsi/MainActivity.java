package com.example.saqsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button nextButton;
    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // textView = findViewById(R.id.welcomeTextView);

        //imageView.setImageResource(R.drawable.sa9sini_without_background);
        nextButton= findViewById(R.id.navigate);
       nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //TODO we'll need to verify first using splashscreen wrapper for the login or not
                navigateToLogin();
            }
        });

    }
    private void navigateToLogin(){
        Intent i = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}