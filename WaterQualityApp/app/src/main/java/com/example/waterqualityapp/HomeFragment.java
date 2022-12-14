package com.example.waterqualityapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeFragment extends Fragment {
    public static final String EXTRA_MESSAGE = "com.example.WaterQualityApp.MESSAGE";
    private View returnedView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        returnedView = inflater.inflate(R.layout.fragment_home, container, false);

        EditText zipCodeInput = returnedView.findViewById(R.id.inputBox);

        Button button = (Button) returnedView.findViewById(R.id.enter_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.zipCode = "";
                EditText zipCodeInput = returnedView.findViewById(R.id.inputBox);
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
