package com.example.user.homework6;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;

public class MainActivity extends AppCompatActivity {
    public static final long DEFAULT_ANIMATION_DURATION = 2500L;
    protected View mRocket;
    protected float mScreenHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRocket = findViewById(R.id.rocket);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        mScreenHeight = displaymetrics.heightPixels;

        ObjectAnimator animatorY = ObjectAnimator.ofFloat(mRocket, "y", mScreenHeight, 0);
        animatorY.setDuration(DEFAULT_ANIMATION_DURATION);
        animatorY.setRepeatCount(Animation.INFINITE);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatorY);

        animatorSet.start();
    }
}
