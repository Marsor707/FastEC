package com.github.marsor.fastec;

import com.github.marsor.mars.activities.ProxyActivity;
import com.github.marsor.mars.delegates.MarsDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public MarsDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}
