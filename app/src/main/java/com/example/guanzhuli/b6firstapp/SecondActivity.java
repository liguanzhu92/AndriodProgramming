package com.example.guanzhuli.b6firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.Intent;

public class SecondActivity extends AppCompatActivity {
    Button regCancel;
    EditText editUserName;
    Spinner spinnerLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // receive the information, using key
        // make sure the consistency for the passing information key
        Intent i = getIntent();
        String userName = i.getExtras().getString("keyUsername");
        Toast.makeText(SecondActivity.this, "Receive UserName "+ getIntent().getExtras().getString("keyUsername"),
                Toast.LENGTH_LONG).show();
        editUserName = (EditText) findViewById(R.id.editUserName);
        editUserName.setText(userName);
        // 初始化控件
        spinnerLocation  = (Spinner) findViewById(R.id.spinnerLocation);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.location_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //绑定Adapter
        spinnerLocation.setAdapter(adapter);

        // build Cancel Register
        regCancel = (Button) findViewById(R.id.regCancel);
        regCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( SecondActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
