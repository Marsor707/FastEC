package com.github.marsor.mars.delegates.web;

import com.alibaba.fastjson.JSON;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */

public class MarsWebInterface {

    private final WebDelegate DELEGATE;

    private MarsWebInterface(WebDelegate delegate) {
        this.DELEGATE = delegate;
    }

    static MarsWebInterface create(WebDelegate delegate) {
        return new MarsWebInterface(delegate);
    }

    public String event(String params) {
        final String action = JSON.parseObject(params).getString("action");
        return null;
    }
}
