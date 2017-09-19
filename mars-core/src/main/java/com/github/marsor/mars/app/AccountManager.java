package com.github.marsor.mars.app;

import com.github.marsor.mars.util.storage.MarsPreference;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */

public class AccountManager {

    private enum SignTag {
        SIGN_TAG
    }

    //保存用户登录状态
    public static void setSignState(boolean state) {
        MarsPreference.setAppFlag(SignTag.SIGN_TAG.name(), state);
    }

    private static boolean isSignIn() {
        return MarsPreference.getAppFlag(SignTag.SIGN_TAG.name());
    }

    public static void checkAccount(IUserChecker checker) {
        if (isSignIn()) {
            checker.onSignIn();
        } else {
            checker.onNotSignIn();
        }
    }
}
