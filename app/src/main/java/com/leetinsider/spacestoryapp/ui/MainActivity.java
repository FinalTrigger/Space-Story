package com.leetinsider.spacestoryapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.leetinsider.spacestoryapp.R;

public class MainActivity extends AppCompatActivity {
    // Declare View Variables

    private EditText mNameField;
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Set view variables
        mNameField = (EditText) findViewById(R.id.nameEditText);
        mStartButton = (Button) findViewById(R.id.startButton);

        // Create new onClick Listener for button to start the story
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Save the user inputted name to "name" and pass as intent throughout the story
                String name = mNameField.getText().toString();
                // Sending name to the startStory method to be used in the intent
                startStory(name);

//                Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
            }
        };

        mStartButton.setOnClickListener(listener);
    }

    // Method that passes the users name as an intent and starts the story
    private void startStory(String name) {
        Intent intent = new Intent(this, StoryActivity.class);
        intent.putExtra(getString(R.string.key_name), name);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mNameField.setText("");
    }
}
