package com.yousuf.shawon.androidspanusage.activity;

import android.animation.ArgbEvaluator;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.format.DateUtils;
import android.util.Property;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.yousuf.shawon.androidspanusage.R;
import com.yousuf.shawon.androidspanusage.utils.AnimatedColorSpan;
import com.yousuf.shawon.androidspanusage.utils.AnimatedRainbowColorSpan;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimatedSpanActivity extends AppCompatActivity {

    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.buttonStart)
    Button buttonStart;
    @Bind(R.id.buttonStartRainbow)
    Button buttonStartRainbow;

    private int textColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animated_span);
        ButterKnife.bind(this);

        textColor = getResources().getColor(R.color.text_color);


    }


    private void startAnimation() {
        String str = getString(R.string.java_language_intro);
        String subString = getString(R.string.animated_sub_string).toLowerCase();


        int start = str.toLowerCase().indexOf(subString);
        int end = start + subString.length();


        AnimatedColorSpan span = new AnimatedColorSpan(255, textColor);
        final SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(span, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //

        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(span, ANIMATED_FOREGROUND_COLOR_SPAN_INT_PROPERTY, Color.BLACK, Color.RED);
        objectAnimator.setEvaluator(new ArgbEvaluator());
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                textView.setText(spannableString);
            }
        });
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        // objectAnimator.setDuration(DateUtils.MINUTE_IN_MILLIS*3);
        objectAnimator.setDuration(2000);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.start();
    }


    private void startRainbowAnimation(){
        String str = getString(R.string.java_language_intro);
        String subString = getString(R.string.animated_sub_string).toLowerCase();


        int start = str.toLowerCase().indexOf(subString);
        int end = start + subString.length();

        AnimatedRainbowColorSpan animatedColorSpan = new AnimatedRainbowColorSpan(this);

        final SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(animatedColorSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(
                animatedColorSpan, ANIMATED_RAINBOW_COLOR_SPAN_FLOAT_PROPERTY, 0, 100);
        objectAnimator.setEvaluator(new FloatEvaluator());
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                textView.setText(spannableString);
            }
        });
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.setDuration(DateUtils.MINUTE_IN_MILLIS * 3);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.start();

    }



    private static final Property<AnimatedColorSpan, Integer> ANIMATED_FOREGROUND_COLOR_SPAN_INT_PROPERTY =
            new Property<AnimatedColorSpan, Integer>(Integer.class, "ANIMATED_FOREGROUND_COLOR_SPAN_INT_PROPERTY") {

                @Override
                public void set(AnimatedColorSpan span, Integer value) {
                    span.setForeGroundColor(value);
                }

                @Override
                public Integer get(AnimatedColorSpan span) {
                    return span.getForeGroundColor();
                }
            };

    private static final Property<AnimatedRainbowColorSpan, Float> ANIMATED_RAINBOW_COLOR_SPAN_FLOAT_PROPERTY
            = new Property<AnimatedRainbowColorSpan, Float>(Float.class, "ANIMATED_RAINBOW_COLOR_SPAN_FLOAT_PROPERTY") {
        @Override
        public void set(AnimatedRainbowColorSpan span, Float value) {
            span.setTranslateXPercentage(value);
        }
        @Override
        public Float get(AnimatedRainbowColorSpan span) {
            return span.getTranslateXPercentage();
        }
    };


    @OnClick({R.id.buttonStart, R.id.buttonStartRainbow})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonStart:
                startAnimation();
                break;
            case R.id.buttonStartRainbow:
                startRainbowAnimation();
                break;
        }
    }
}
