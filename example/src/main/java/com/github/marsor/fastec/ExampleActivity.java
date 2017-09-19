package com.github.marsor.fastec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;

import com.github.marsor.mars.activities.ProxyActivity;
import com.github.marsor.mars.delegates.MarsDelegate;
import com.github.marsor.mars.ec.launcher.LauncherDelegate;
import com.github.marsor.mars.ec.launcher.LauncherScrollDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    @Override
    public MarsDelegate setRootDelegate() {
        return new LauncherDelegate();
    }
}
