package com.example.waterqualityapp;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LevelContaminants extends Fragment {
    private View returnedView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        returnedView =  inflater.inflate(R.layout.fragment_level_contaminants, container, false);

        TextView contaminantTextView = (TextView) returnedView.findViewById(R.id.contaminants);

        ConstraintLayout elementContainer = (ConstraintLayout) returnedView.findViewById(R.id.contaminant_container);

        elementContainer.setBackgroundColor(Color.parseColor(MainActivity.waterQualityEvaluator.getWaterQualityBackgroundColor()));

        TextView zipCodeTextView = (TextView) returnedView.findViewById(R.id.zip_code);

        contaminantTextView.setText("" + MainActivity.numberOfContaminants);
        zipCodeTextView.setText(MainActivity.zipCode);
        contaminantTextView.setTextColor(Color.parseColor("" + MainActivity.waterQualityEvaluator.getWaterQualityColor()));

        return returnedView;
    }
}