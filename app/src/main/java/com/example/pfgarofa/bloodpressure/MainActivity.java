package com.example.pfgarofa.bloodpressure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MAINACTIVITY";
    private static final String KEY_CATEGORY = "category";

    EditText mSystolic;
    EditText mDiastolic;
    Button mDiagnoseBtn;
    TextView mCategoryTextView;
    TextView mFollowUpTextView;

    int mCategory = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSystolic = findViewById(R.id.systolic_number);
        mDiastolic = findViewById(R.id.diastolic_number);
        mDiagnoseBtn = findViewById(R.id.diagnose_button);
        mDiagnoseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int systolic = Integer.parseInt(mSystolic.getText().toString());
                    int diastolic = Integer.parseInt(mDiastolic.getText().toString());
                    mCategory = BloodPressure.bp(systolic, diastolic);
                    mCategoryTextView.setText(BloodPressure.mCategories[mCategory]);
                    mFollowUpTextView.setText(BloodPressure.mRecommendations[mCategory]);
                } catch (RuntimeException rtex) {
                    mCategoryTextView.setText("Input fields must contain numbers");
                    mFollowUpTextView.setText("");
                    mCategory = 0;
                }
            }
        });
        mCategoryTextView = findViewById(R.id.category_text);
        mFollowUpTextView = findViewById(R.id.recommendation);

        if (savedInstanceState != null) {
            mCategory = savedInstanceState.getInt(KEY_CATEGORY, 0);
            if (mCategory > 0) {
                mCategoryTextView.setText(BloodPressure.mCategories[mCategory]);
                mFollowUpTextView.setText(BloodPressure.mRecommendations[mCategory]);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CATEGORY, mCategory);
    }
}
