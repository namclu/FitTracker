package com.example.android.fittracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText userNameField = (EditText) findViewById(R.id.name_field);
    public static final String NAME_KEY = "com.example.android.fittracker.name_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
    * Sends the user info from text fields
    * */
    public void sendUserInfo(){
        userNameField = (EditText) findViewById(R.id.name_field);
        String userName = userNameField.getText().toString();

        Intent nameIntent = new Intent(this, SecondActivity.class);
        nameIntent.putExtra(NAME_KEY, userName);
        startActivity(nameIntent);
    }

    /*
    * This method is called when the SUBMIT button is clicked, handles opening SecondActivity
    * */
    public void submitInfo(View view){
        Intent newIntent = new Intent(this, SecondActivity.class);
        newIntent.putExtra("key", "value");
        startActivity(newIntent);

        sendUserInfo();
        //Log.i("FitTracker", "from submitInfo");
    }

}
