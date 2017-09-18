package com.github.marsor.fastec;

import android.app.Application;

import com.github.marsor.mars.app.Mars;
import com.github.marsor.mars.ec.icon.FontEcModule;
import com.github.marsor.mars.net.Interceptors.DebugInterceptor;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * Created by marsor on 2017/9/16.
 */

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Mars.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withLoaderDelayed(1000)
                .withApiHost("http://127.0.0.1/")
                .withInterceptor(new DebugInterceptor("index", R.raw.test))
                .configure();
    }
}
