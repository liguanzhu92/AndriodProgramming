package com.example.guanzhuli.b6firstapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import static com.example.guanzhuli.b6firstapp.MainBrowserActivity.KEY_USERNAME;


public class MainActivity extends AppCompatActivity {

    // get reference,
    Button mClickButtonSignIn;
    Button mClickButtonSignUp;
    EditText mUsernameEditText;
    EditText mPasswordEditText;
    TextView mContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // set design, R : create any resources, id generated and saved to R
        mClickButtonSignIn = (Button) findViewById(R.id.buttonSignIn);
        mClickButtonSignUp = (Button) findViewById(R.id.buttonSignUp);
        mUsernameEditText = (EditText) findViewById(R.id.editUsername);
        mPasswordEditText = (EditText) findViewById(R.id.editPassword);
        mContact = (TextView) findViewById(R.id.textViewContect);
        registerForContextMenu(mContact);
        // set activity listener
        // execute when you click the button
        mClickButtonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = mUsernameEditText.getText().toString();
                String userPassword = mPasswordEditText.getText().toString();
                if (userName.equals("Lily") && userPassword.equals("123")) {
                    Toast.makeText(MainActivity.this, "Successfully Match", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(MainActivity.this, MainBrowserActivity.class);
                    i.putExtra(KEY_USERNAME, userName);
                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "The username and password does not match", Toast.LENGTH_LONG).show();
                }
                mUsernameEditText.setText("");
                mPasswordEditText.setText("");
                // intent i
                // intent includes many functions, and It fulfill different functionality
                // direct to a file ? url???
                // phone dial
                //ACTION_VIEW, uri.parse("INTERNET address")
                // Intent i = new Intent(Intent.Action_dial, uri.parse("tel : 1234567890"));
            }
        });
        mClickButtonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = mUsernameEditText.getText().toString();
                // navigation: two type of intent?????
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                // pass information
                i.putExtra(KEY_USERNAME, userName);
                startActivity(i);
            }
        });
        mContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openContextMenu(mContact);
/*                String[] TO = {getString(R.string.developeremail)};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("test/type");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                try {
                    startActivity(Intent.createChooser(emailIntent, "Send email"));
                    finish();
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this,
                            "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }*/

            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Contact");
        menu.add(0, v.getId(), 0, "Email");
        menu.add(0, v.getId(), 0, "Text");
        menu.add(0, v.getId(), 0, "Call");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        super.onContextItemSelected(item);
        if(item.getTitle().equals("Email")){
            email();
        } else if(item.getTitle().equals("Text")){
            function2();
        } else if (item.getTitle().equals("Call")) {
            function3();
        } else {
            return false;
        }
        return true;
    }

    private void email() {
        String[] TO = {getString(R.string.developeremail)};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("test/type");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        try {
            startActivity(Intent.createChooser(emailIntent, "Send email"));
            Toast.makeText(this, "function 1 called", Toast.LENGTH_SHORT).show();
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
    private void function2(){
        Toast.makeText(this, "function 2 called", Toast.LENGTH_SHORT).show();
    }
    private void function3(){
        Toast.makeText(this, "function 3 called", Toast.LENGTH_SHORT).show();
    }
}
