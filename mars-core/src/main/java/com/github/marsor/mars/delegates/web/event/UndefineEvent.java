package com.github.marsor.mars.delegates.web.event;

import com.github.marsor.mars.util.log.MarsLogger;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */

public class UndefineEvent extends Event {

    @Override
    public String execute(String params) {
        MarsLogger.e("UndefineEvent", params);
        return null;
    }
}
