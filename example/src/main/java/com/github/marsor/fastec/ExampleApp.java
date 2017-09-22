package com.github.marsor.fastec;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.github.marsor.mars.app.Mars;
import com.github.marsor.mars.ec.database.DatabaseManager;
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
                .withApiHost("http://116.196.95.67/RestServer/api/")
                .withInterceptor(new DebugInterceptor("test", R.raw.test))
                .withAppId("")
                .withAppSecret("")
                .configure();
        initStetho();
        DatabaseManager.getInstance().init(this);
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
