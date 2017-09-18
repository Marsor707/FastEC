package com.github.marsor.mars.util.dimen;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.github.marsor.mars.app.Mars;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */

public class DimenUtil {

    public static int getScreenWidth() {
        final Resources resources = Mars.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = Mars.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
