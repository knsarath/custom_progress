package com.shimmer.customprogress;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomProgressSpinner customProgressSpinner = (CustomProgressSpinner) findViewById(R.id.spinner);
        customProgressSpinner.setIconDrawable(R.drawable.logo2);
        customProgressSpinner.setBackgroundColor(ContextCompat.getColor(this, R.color.spinner_color));
    }
}
