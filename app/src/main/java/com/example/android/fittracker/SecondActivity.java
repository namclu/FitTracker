package com.example.android.fittracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * Created by namlu on 15-Oct-15.
 */
public class SecondActivity extends AppCompatActivity {

    public static final String NAME_KEY = "com.example.android.fittracker.name_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent nameIntent = getIntent();
        String userMessage = createUserSummary(nameIntent.getStringExtra(NAME_KEY));
        displayMessage(userMessage);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab2);
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

    /**
     * This method displays the given text on the screen.
     */
    public void displayMessage(String message){
        TextView userSummaryTextView = (TextView) findViewById(R.id.user_summary_text_view);
        userSummaryTextView.setText(message);
    }

    /**
    * This method creates a summary of the user's info.
    */
    public String createUserSummary(String userName){
        StringBuilder userSummary = new StringBuilder();

        userSummary.append("Welcome " + userName);

        return userSummary.toString();
    }
}
