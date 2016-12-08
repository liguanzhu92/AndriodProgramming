package com.example.guanzhuli.b6firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainBrowserActivity extends AppCompatActivity {
    public static final String KEY_USERNAME = "keyUsername";
    TextView mUserName;
    ListView mLeftBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_browser);
        String userName = getIntent().getStringExtra(KEY_USERNAME);
        mUserName = (TextView) findViewById(R.id.userName);
        mUserName.setText(userName);
        // create left bar
        mLeftBar = (ListView) findViewById(R.id.left_bar);
        ArrayAdapter<String> adp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.left_bar));
        mLeftBar.setAdapter(adp);

        // use this method to register Context menu
        // registerForContextMenu(mLeftBar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logout) {
            Intent i = new Intent(MainBrowserActivity.this, MainActivity.class);
            startActivity(i);
        }
        if (id == R.id.refresh) {

        }
        return super.onOptionsItemSelected(item);
    }
}
