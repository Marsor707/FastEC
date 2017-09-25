package com.github.marsor.mars.delegates.web.client;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.github.marsor.mars.delegates.web.WebDelegate;
import com.github.marsor.mars.delegates.web.route.Router;
import com.github.marsor.mars.util.log.MarsLogger;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */

public class WebViewClientImpl extends WebViewClient {

    private final WebDelegate DELEGATE;

    public WebViewClientImpl(WebDelegate delegate) {
        this.DELEGATE = delegate;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        MarsLogger.d("shouldOverrideUrlLoading", url);
        return Router.getInstance().handleWebUrl(DELEGATE, url);
    }
}
