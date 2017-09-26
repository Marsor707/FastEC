package com.github.marsor.mars.delegates.web.event;

import android.content.Context;
import android.webkit.WebView;

import com.github.marsor.mars.delegates.MarsDelegate;
import com.github.marsor.mars.delegates.web.WebDelegate;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */

public abstract class Event implements IEvent {

    private Context mContext = null;
    private String mAction = null;
    private WebDelegate mDelegate = null;
    private String mUrl = null;
    private WebView mWebView = null;

    public Context getContext() {
        return mContext;
    }

    public WebView getWebView() {
        return mDelegate.getWebView();
    }

    public void setContext(Context mContent) {
        this.mContext = mContent;
    }

    public String getAction() {
        return mAction;
    }

    public void setAction(String mAction) {
        this.mAction = mAction;
    }

    public MarsDelegate getDelegate() {
        return mDelegate;
    }

    public void setDelegate(WebDelegate mDelegate) {
        this.mDelegate = mDelegate;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}
