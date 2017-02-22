package com.yousuf.shawon.androidspanusage.utils;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;

/**
 * Created by Yousuf on 2/22/17.
 */

public class AnimatedColorSpan extends CharacterStyle implements UpdateAppearance {

    private int mAlpha = 25;
    private int mForeGroundColor;

    public AnimatedColorSpan(int mAlpha, int mForeGroundColor) {
        this.mAlpha = mAlpha;
        this.mForeGroundColor = mForeGroundColor;
    }

    public int getAlpha() {
        return mAlpha;
    }

    public void setAlpha(int mAlpha) {
        this.mAlpha = mAlpha;
    }

    public int getForeGroundColor() {
        return mForeGroundColor;
    }

    public void setForeGroundColor(int mForeGroundColor) {
        this.mForeGroundColor = mForeGroundColor;

    }

    @Override
    public void updateDrawState(TextPaint tp) {

        tp.setColor(getForeGroundColor());
    }
}
