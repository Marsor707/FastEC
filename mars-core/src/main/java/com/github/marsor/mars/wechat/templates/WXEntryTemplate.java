package com.github.marsor.mars.wechat.templates;

import com.github.marsor.mars.wechat.BaseWXEntryActivity;
import com.github.marsor.mars.wechat.MarsWeChat;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */

public class WXEntryTemplate extends BaseWXEntryActivity {

    @Override
    protected void onResume() {
        super.onResume();
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onSignInSuccess(String userInfo) {
        MarsWeChat.getInstance().getSignInCallback().onSignInSuccess(userInfo);
    }
}
