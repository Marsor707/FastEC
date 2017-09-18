package com.github.marsor.mars.app;

import android.content.Context;

/**
 * Created by marsor on 2017/9/16.
 */

public final class Mars {

    public static Configurator init(Context context) {
        Configurator.getInstance()
                .getMarsConfigs()
                .put(ConfigKeys.APPLICATION_CONTEXT, context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    public static Context getApplicationContext() {
        return getConfiguration(ConfigKeys.APPLICATION_CONTEXT);
    }
}
