package com.example.waterqualityapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

public class SettingsFragment extends Fragment {
    private View returnedView;
    private Switch switchToggleDark;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        returnedView = inflater.inflate(R.layout.fragment_settings, container, false);

        switchToggleDark = returnedView.findViewById(R.id.darkModeSwitch);

        switchToggleDark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.setDarkMode();
            }
        });

        return returnedView;
    }
}
