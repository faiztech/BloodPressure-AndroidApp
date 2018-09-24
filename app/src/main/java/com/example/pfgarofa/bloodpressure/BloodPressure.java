package com.example.pfgarofa.bloodpressure;

/**
 * Created by pfgarofa on 2/5/2018.
 *
 * Source: http://www.merckmanuals.com/home/heart-and-blood-vessel-disorders/high-blood-pressure/high-blood-pressure#v718040
 */

public class BloodPressure {

    /*

    mCategories and mRecommendations are parallel arrays
    TODO: make these strings resources

    */
    public static final String mCategories[] = {
            "Low reading; reevaluate",
            "Normal blood pressure",
            "Elevated blood pressure",  // formerly "prehypertension"
            "Stage 1 hypertension",
            "Stage 2 hypertension"
    };

    public static final String mRecommendations[] = {
            "Take blood pressure reading again.",
            "Normal blood pressure, no treatment needed.",
            "Lifestyle changes. Reexamine in 3-6 months.",
            "Low-risk of ASCVD: Lifestyle changes; Reexamine in 3-6 months. Otherwise, treatment with 1 blood pressure lowering drug; reexamine in 1 month.",
            "Treatment with 2 blood pressure-lowering drugs. Reexamine in one month."
    };

    public static int bp(int systolic, int diastolic) {

        if (systolic < 100 || diastolic < 60)
            return 0;   // "Low reading; reevaluate";
        else if (systolic < 120 && diastolic < 80)
            return 1;   // "Normal blood pressure";
        else if (systolic < 130 && diastolic < 80)
            return 2;   // "Elevated blood pressure";
        else if (systolic < 140 && diastolic < 90)
            return 3;   // "Stage 1 hypertension";
        else
            return 4;   // "Stage 2 hypertension":
    }


}
