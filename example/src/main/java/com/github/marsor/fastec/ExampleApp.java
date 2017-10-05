package com.github.marsor.fastec;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.github.marsor.mars.app.Mars;
import com.github.marsor.mars.ec.database.DatabaseManager;
import com.github.marsor.mars.ec.icon.FontEcModule;
import com.github.marsor.mars.net.Interceptors.DebugInterceptor;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

import cn.jpush.android.api.JPushInterface;

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
                .withLoaderDelayed(100)
                .withApiHost("http://115.159.62.44/RestServer/api/")
                .withInterceptor(new DebugInterceptor("test", R.raw.test))
                .withAppId("")
                .withAppSecret("")
                .withJavascriptInterface("mars")
                .configure();
        initStetho();
        DatabaseManager.getInstance().init(this);

        //开启极光推送
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }

    private void initStetho() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build()
        );
    }
}
