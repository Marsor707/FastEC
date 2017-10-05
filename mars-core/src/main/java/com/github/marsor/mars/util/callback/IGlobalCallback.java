package com.github.marsor.mars.util.callback;

import android.support.annotation.Nullable;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */

public interface IGlobalCallback<T> {

    void executeCallback(@Nullable T args);
}
