package com.example.saqsi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView signin= findViewById(R.id.signupText);
        SpannableString spannableString = new SpannableString("Not registered yet? Sign up here");
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(LoginActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        };
        spannableString.setSpan(clickableSpan, 20, spannableString.length(), 0);
        spannableString.setSpan(new ForegroundColorSpan(Color.WHITE), 20, spannableString.length(), 0);
        // Set the SpannableString to the TextView
        signin.setText(spannableString);

        // Enable the movement method for the TextView to make the link clickable
        signin.setMovementMethod(LinkMovementMethod.getInstance());
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(username.getText().toString().equals("username") && password.getText().toString().equals("password")){
                    Toast.makeText(LoginActivity.this, "login done successfully", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginActivity.this, "login failed !", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}