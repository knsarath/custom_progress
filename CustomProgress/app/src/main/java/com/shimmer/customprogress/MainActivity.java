package com.shimmer.customprogress;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CustomProgressSpinner customProgressSpinner = (CustomProgressSpinner) findViewById(R.id.spinner);
        customProgressSpinner.setIconDrawable(R.drawable.logo2);
        customProgressSpinner.setBackgroundColor(ContextCompat.getColor(this, R.color.spinner_color));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                customProgressSpinner.done();
            }
        }, 2000);
    }
}
