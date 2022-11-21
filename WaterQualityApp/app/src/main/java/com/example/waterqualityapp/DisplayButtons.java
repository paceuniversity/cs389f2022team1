package com.example.waterqualityapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayButtons extends Fragment {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_display_buttons);
//    }
//
//    // Get the Intent that started this activity and extract the string
//    //Intent intent = getIntent();
//    //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
//
//    // Capture the layout's TextView and set the string as its text
//    //TextView textView = findViewById(R.id.inputBox);
//        //textView.setText();
//}


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_display_buttons, container, false);
    }
}