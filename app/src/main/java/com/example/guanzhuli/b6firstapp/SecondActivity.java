package com.example.guanzhuli.b6firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.content.Intent;

import static com.example.guanzhuli.b6firstapp.MainBrowserActivity.KEY_USERNAME;

public class SecondActivity extends AppCompatActivity {
    Button mregCancel;
    Button mregComfirm;
    EditText editUserName;
    Spinner spinnerLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // receive the information, using key
        // make sure the consistency for the passing information key
        Intent i = getIntent();
        String userName = i.getExtras().getString(KEY_USERNAME);
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
        // build Confirm
        mregComfirm = (Button) findViewById(R.id.regConfirm);
        mregComfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = editUserName.getText().toString();
                Intent i = new Intent(SecondActivity.this, MainBrowserActivity.class);
                i.putExtra(KEY_USERNAME, userName);
                startActivity(i);
            }
        });
        // build Cancel Register
        mregCancel = (Button) findViewById(R.id.regCancel);
        mregCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( SecondActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }


}
