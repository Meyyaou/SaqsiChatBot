package com.example.saqsi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity {
    EditText username;
    EditText email;
    EditText password;
    Button signinButton;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        signinButton = findViewById(R.id.signinButton);

        signinButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                    Toast.makeText(SigninActivity.this, "Signin done successfully", Toast.LENGTH_SHORT).show();
                    navigateToChat();
            }
        });

    }
    private void navigateToChat(){
        Intent i = new Intent(SigninActivity.this, ChatActivity.class);
        startActivity(i);
        finish();
    }
}