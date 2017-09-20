package com.github.marsor.mars.wechat;

import android.app.Activity;

import com.github.marsor.mars.app.ConfigKeys;
import com.github.marsor.mars.app.Mars;
import com.github.marsor.mars.wechat.callbacks.IWeChatSignInCallback;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */

public class MarsWeChat {

    static final String APP_ID = Mars.getConfiguration(ConfigKeys.WE_CHAT_APP_ID);
    static final String APP_SECRET = Mars.getConfiguration(ConfigKeys.WE_CHAT_APP_SECRET);
    private final IWXAPI WXAPI;
    private IWeChatSignInCallback mSignInCallback = null;

    private static final class Holder {
        private static final MarsWeChat INSTANCE = new MarsWeChat();
    }

    public static MarsWeChat getInstance() {
        return Holder.INSTANCE;
    }

    private MarsWeChat() {
        final Activity activity = Mars.getConfiguration(ConfigKeys.ACTIVITY);
        WXAPI = WXAPIFactory.createWXAPI(activity, APP_ID, true);
        WXAPI.registerApp(APP_ID);
    }

    public final IWXAPI getWXAPI() {
        return WXAPI;
    }

    public MarsWeChat onSignSuccess(IWeChatSignInCallback callback) {
        this.mSignInCallback = callback;
        return this;
    }

    public IWeChatSignInCallback getSignInCallback() {
        return mSignInCallback;
    }

    public final void signIn() {
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "random_state";
        WXAPI.sendReq(req);
    }
}
