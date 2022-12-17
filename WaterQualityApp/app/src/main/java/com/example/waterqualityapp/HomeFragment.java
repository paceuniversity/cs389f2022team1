package com.example.waterqualityapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class HomeFragment extends Fragment {
    public static final String EXTRA_MESSAGE = "com.example.WaterQualityApp.MESSAGE";
    private View returnedView;
    private String currentLocationZipCode = "";
    @SuppressLint("MissingPermission")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        returnedView = inflater.inflate(R.layout.fragment_home, container, false);

        EditText zipCodeInput = returnedView.findViewById(R.id.inputBox);

        Button button = (Button) returnedView.findViewById(R.id.enter_button);
        WebView browser = (WebView) returnedView.findViewById(R.id.news_feed);
        browser.loadUrl("https://www.sciencedaily.com/news/earth_climate/water/");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempZip = zipCodeInput.getText().toString();
                TextView errorMessageTextView = returnedView.findViewById(R.id.error_message);

                if (tempZip.matches("^\\d{5}$")) {
                    MainActivity.zipCode = tempZip;
                    errorMessageTextView.setVisibility(View.INVISIBLE);
                    ContaminantThread contaminantThread = new ContaminantThread();
                    contaminantThread.start();
                    try {
                        contaminantThread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Fragment fragment = new DisplayButtons();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                else {
                    errorMessageTextView.setVisibility(View.VISIBLE);
                }
            }
        });

        return returnedView;
    }
}
