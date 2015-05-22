package com.phuocdai.demoxlistview.utility;

import android.text.TextUtils;
import android.util.Log;

import com.phuocdai.demoxlistview.application.Constants;

public class LogUtil {
    /**
     *  Log debug
     * @param message - message want to log
     */
    public static void LogDebug(String message) {
        String tag = "==================>";
        if (Constants.LOG_DEBUG && !TextUtils.isEmpty(message)) {
            Log.e(tag, message);
        }
    }
}
