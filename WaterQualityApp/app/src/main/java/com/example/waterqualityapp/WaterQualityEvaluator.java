package com.example.waterqualityapp;

import android.graphics.Color;

public class WaterQualityEvaluator {
    private int numberOfContaminants;
    public  WaterQualityEvaluator (String numberOfContaminants) {
        this.numberOfContaminants = Integer.parseInt(numberOfContaminants);
    }

    public  WaterQualityEvaluator () {
        this.numberOfContaminants = 0;
    }

    public void setNumberOfContaminants (String numberOfContaminants) {
        this.numberOfContaminants = Integer.parseInt(numberOfContaminants);
    }

    public String getOverallDrinkingQuality () {
        if (this.numberOfContaminants == 0) {
            return "Perfect";
        }
        else if (this.numberOfContaminants <= 25) {
            return "Close To Perfect";
        }
        else if (this.numberOfContaminants <= 50) {
            return "Good";
        }
        else if (this.numberOfContaminants <= 75) {
            return "Ok";
        }
        else if (this.numberOfContaminants <= 100) {
            return "Poor";
        }
        else if (this.numberOfContaminants <= 125) {
            return "Bad";
        }
        else if (this.numberOfContaminants <= 150) {
            return "Very Bad";
        }
        else if (this.numberOfContaminants <= 175) {
            return "Horrible";
        }
        else {
            return "The Worst";
        }
    }

    public String getWaterQualityColor () {
        if (this.numberOfContaminants == 0) {
            return "#0080ff";
        }
        else if (this.numberOfContaminants <= 25) {
            return "#48a493";
        }
        else if (this.numberOfContaminants <= 50) {
            return "#4e887a";
        }
        else if (this.numberOfContaminants <= 75) {
            return "#446f54";
        }
        else if (this.numberOfContaminants <= 100) {
            return "#9c946e";
        }
        else if (this.numberOfContaminants <= 125) {
            return "#b79663";
        }
        else if (this.numberOfContaminants <= 150) {
            return "#876b4d";
        }
        else if (this.numberOfContaminants <= 175) {
            return "#695c43";
        }
        else {
            return "#483C32";
        }
    }


    public String getWaterQualityBackgroundColor () {
        int value = Color.parseColor(this.getWaterQualityColor());

        int red = value & 0xFF;

        value = value >> 8;

        int green = value & 0xFF;

        value = value >> 8;


        int blue = value & 0xFF;

        red = 255 - red;
        green = 255 - green;
        blue = 255 - blue;

        String invertedHexCode = String.format("#%02x%02x%02x", red, green, blue);

        return invertedHexCode;
    }
}
