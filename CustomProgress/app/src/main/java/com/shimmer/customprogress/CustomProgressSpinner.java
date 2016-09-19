package com.shimmer.customprogress;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class CustomProgressSpinner extends FrameLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    private ImageView mIcon;
    private ProgressBar mProgressBar;

    public CustomProgressSpinner(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.custom_progress_spinner, this);
        mIcon = (ImageView) findViewById(R.id.progress_icon);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        getViewTreeObserver().addOnGlobalLayoutListener(this);

    }

    @Override
    public void setBackgroundColor(int color) {
        View container = findViewById(R.id.container);
        GradientDrawable gradientDrawable = (GradientDrawable) container.getBackground();
        gradientDrawable.setColor(color);
    }

    public void setIconDrawable(int iconDrawable) {
        mIcon.setImageDrawable(ContextCompat.getDrawable(getContext(), iconDrawable));
    }

    public CustomProgressSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    public void onGlobalLayout() {
        mProgressBar.getLayoutParams().width = getWidth();
        mProgressBar.getLayoutParams().height = getHeight();
        mIcon.getLayoutParams().height = getWidth() / 2;
        mIcon.getLayoutParams().width = getHeight() / 2;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this);
        } else {
            getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }

    }
}
