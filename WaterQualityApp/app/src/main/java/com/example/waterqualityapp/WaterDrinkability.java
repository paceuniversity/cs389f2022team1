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

public class WaterDrinkability extends Fragment {

    private View returnedView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        returnedView = inflater.inflate(R.layout.fragment_water_drinkability, container, false);

        TextView zipCodeTextView = (TextView) returnedView.findViewById(R.id.overall_zip);

        TextView ratingTextView = (TextView) returnedView.findViewById(R.id.rate);

        ConstraintLayout elementContainer = (ConstraintLayout) returnedView.findViewById(R.id.overall_container);

        elementContainer.setBackgroundColor(Color.parseColor(MainActivity.waterQualityEvaluator.getWaterQualityBackgroundColor()));

        ratingTextView.setText("" + MainActivity.waterQualityEvaluator.getOverallDrinkingQuality());
        zipCodeTextView.setText(MainActivity.zipCode);
        ratingTextView.setTextColor(Color.parseColor("" + MainActivity.waterQualityEvaluator.getWaterQualityColor()));


        return returnedView;
    }
}