package com.github.marsor.mars.delegates.web;

import android.webkit.JavascriptInterface;

import com.alibaba.fastjson.JSON;
import com.github.marsor.mars.delegates.web.event.Event;
import com.github.marsor.mars.delegates.web.event.EventManager;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */

final class MarsWebInterface {

    private final WebDelegate DELEGATE;

    private MarsWebInterface(WebDelegate delegate) {
        this.DELEGATE = delegate;
    }

    static MarsWebInterface create(WebDelegate delegate) {
        return new MarsWebInterface(delegate);
    }

    @SuppressWarnings("unused")
    @JavascriptInterface
    public String event(String params) {
        final String action = JSON.parseObject(params).getString("action");
        final Event event = EventManager.getInstance().createEvent(action);
        if (event != null) {
            event.setAction(action);
            event.setDelegate(DELEGATE);
            event.setContext(DELEGATE.getContext());
            event.setUrl(DELEGATE.getUrl());
            return event.execute(params);
        }
        return null;
    }
}
