package com.shimmer.customprogress;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class CustomProgressSpinner extends FrameLayout {
    private static final String TAG = CustomProgressSpinner.class.getSimpleName();
    private ImageView mIcon;
    private ProgressBar mProgressBar;
    public static int sDefaultHeight = 100;
    public static int sDefaultWidth = 100;
    private int mHeight = sDefaultHeight;
    private int mWidth = sDefaultWidth;
    private int mIconRes = -1;
    private static int sDefaultNoIcon = -1;

    public CustomProgressSpinner(Context context) {
        super(context);
        init();
    }

    public CustomProgressSpinner(Context context, int iConResId) {
        super(context);
        mIconRes = iConResId;
        init();
    }

    private void init() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setBackground(ContextCompat.getDrawable(getContext(), R.drawable.circulr));
        } else {
            setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circulr));
        }
        mProgressBar = (ProgressBar) LayoutInflater.from(getContext()).inflate(R.layout.progressbar, null);
        mProgressBar.setLayoutParams(new LayoutParams(mHeight, mWidth));
        addView(mProgressBar);
        mIcon = new ImageView(getContext());
        final LayoutParams params = new LayoutParams(mWidth / 2, mHeight / 2);
        params.gravity = Gravity.CENTER;
        params.width = mWidth / 2;
        params.height = mHeight / 2;
        mIcon.setLayoutParams(params);
        addView(mIcon);
        if (mIconRes != sDefaultNoIcon)
            setIconDrawable(mIconRes);
    }

    @Override
    public void setBackgroundColor(int color) {
        GradientDrawable gradientDrawable = (GradientDrawable) getBackground();
        if (gradientDrawable != null)
            gradientDrawable.setColor(color);
    }

    public void setIconDrawable(int iconDrawable) {
        mIcon.setImageDrawable(ContextCompat.getDrawable(getContext(), iconDrawable));
    }

    public CustomProgressSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        int[] attrsArray = new int[]{
                android.R.attr.layout_width, // 2
                android.R.attr.layout_height // 3
        };
        TypedArray ta = context.obtainStyledAttributes(attrs, attrsArray);
        mWidth = ta.getDimensionPixelSize(0, sDefaultHeight);
        mHeight = ta.getDimensionPixelSize(1, sDefaultWidth);
        ta.recycle();
        init();
    }

}
