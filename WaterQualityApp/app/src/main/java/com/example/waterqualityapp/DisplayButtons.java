package com.example.waterqualityapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayButtons extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.WaterQualityApp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_buttons);
    }

    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DarkMode.class);
        //EditText editText = (EditText) findViewById(R.id.inputBox);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}