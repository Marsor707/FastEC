package com.github.marsor.fastec.event;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.marsor.mars.delegates.web.event.Event;
import com.github.marsor.mars.util.log.MarsLogger;

import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */

public class ShareEvent extends Event {

    @Override
    public String execute(String params) {
        MarsLogger.d("ShareEvent", params);
        final JSONObject object = JSON.parseObject(params).getJSONObject("params");
        final String title = object.getString("title");
        final String url = object.getString("url");
        final String imageUrl = object.getString("imageUrl");
        final String text = object.getString("text");

        final OnekeyShare oks = new OnekeyShare();
        oks.disableSSOWhenAuthorize();
        oks.setTitle(title);
        oks.setText(text);
        oks.setImageUrl(imageUrl);
        oks.setUrl(url);
        oks.show(getContext());
        return null;
    }
}
