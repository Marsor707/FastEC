package com.github.marsor.fastec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.github.marsor.mars.delegates.MarsDelegate;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */

public class ExampleDelegate extends MarsDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
