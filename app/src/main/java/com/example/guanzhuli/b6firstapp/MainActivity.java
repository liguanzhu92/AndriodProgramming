package com.example.guanzhuli.b6firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // get reference,
    Button clickButtonSignIn;
    Button clickButtonSignUp;
    EditText usernameEditText;
    EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // set design, R : create any resources, id generated and saved to R
        clickButtonSignIn = (Button) findViewById(R.id.buttonSignIn);
        clickButtonSignUp = (Button) findViewById(R.id.buttonSignUp);
        usernameEditText = (EditText) findViewById(R.id.editUsername);
        passwordEditText = (EditText) findViewById(R.id.editPassword);
        // set activity listener
        // execute when you click the button
        clickButtonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = usernameEditText.getText().toString();
                String userPassword = passwordEditText.getText().toString();
                if (userName.equals("Lily") && userPassword.equals("123")) {
                    Toast.makeText(MainActivity.this, "Successfully Match", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "The username and password does not match", Toast.LENGTH_LONG).show();
                }
                usernameEditText.setText("");
                passwordEditText.setText("");
            }
        });
        clickButtonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = usernameEditText.getText().toString();
                // navigation: two type of intent?????
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                // pass information
                i.putExtra("keyUsername", userName);
                startActivity(i);
            }
        });

    }
}
