package com.github.marsor.fastec;

import android.support.annotation.Nullable;
import android.support.multidex.MultiDexApplication;

import com.facebook.stetho.Stetho;
import com.github.marsor.fastec.event.ShareEvent;
import com.github.marsor.mars.app.Mars;
import com.github.marsor.mars.ec.database.DatabaseManager;
import com.github.marsor.mars.ec.icon.FontEcModule;
import com.github.marsor.mars.net.Interceptors.DebugInterceptor;
import com.github.marsor.mars.net.rx.AddCookieInterceptor;
import com.github.marsor.mars.util.callback.CallbackManager;
import com.github.marsor.mars.util.callback.CallbackType;
import com.github.marsor.mars.util.callback.IGlobalCallback;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by marsor on 2017/9/16.
 */

public class ExampleApp extends MultiDexApplication {

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
                .withWebEvent("share", new ShareEvent())
                .withWebHost("https://www.baidu.com/")
                .withInterceptor(new AddCookieInterceptor())
                .configure();
        initStetho();
        DatabaseManager.getInstance().init(this);

        //开启极光推送
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);

        CallbackManager.getInstance()
                .addCallback(CallbackType.TAG_OPEN_PUSH, new IGlobalCallback() {
                    @Override
                    public void executeCallback(@Nullable Object args) {
                        if (JPushInterface.isPushStopped(Mars.getApplicationContext())) {
                            //开启
                            JPushInterface.setDebugMode(true);
                            JPushInterface.init(Mars.getApplicationContext());
                        }
                    }
                })
                .addCallback(CallbackType.TAG_STOP_PUSH, new IGlobalCallback() {
                    @Override
                    public void executeCallback(@Nullable Object args) {
                        if (!JPushInterface.isPushStopped(Mars.getApplicationContext())) {
                            JPushInterface.isPushStopped(Mars.getApplicationContext());
                        }
                    }
                });
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
