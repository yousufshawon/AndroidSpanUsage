package com.yousuf.shawon.androidspanusage.utils;

import android.app.Activity;
import android.content.Context;

import java.util.HashMap;

/**
 * Created by Yousuf on 2/22/17.
 */

public class ListItem extends HashMap<String, String> {

    public static final String KEY_TITLE = "title";
    public static final String KEY_SUBTITLE = "subtitle";
    public final Class<?> activityClass;

    public ListItem(Context context, Class<? extends Activity> activityClass, int titleId, int subtitleId) {
        this.activityClass = activityClass;

        put(KEY_TITLE, context.getString(titleId));
        put(KEY_SUBTITLE, context.getString(subtitleId));
    }
}
