package com.example.waterqualityapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class DisplayButtons extends Fragment {
    private View returnedView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        returnedView = inflater.inflate(R.layout.fragment_display_buttons, container, false);
        Button waterDrinkabilityButton = (Button) returnedView.findViewById(R.id.water_drink);
        waterDrinkabilityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new WaterDrinkability();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        Button contaminantLevelButton = (Button) returnedView.findViewById(R.id.water_cont);
        contaminantLevelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new LevelContaminants();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return returnedView;
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