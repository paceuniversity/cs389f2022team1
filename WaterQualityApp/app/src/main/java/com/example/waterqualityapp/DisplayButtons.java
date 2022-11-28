package com.example.waterqualityapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DisplayButtons extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_display_buttons, container, false);
    }

    public void sendMessage(View view) {
        // Do something in response to button
        //Intent intent = new Intent(this, DarkMode.class);
        //EditText editText = (EditText) findViewById(R.id.inputBox);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
       // startActivity(intent);
    }
}