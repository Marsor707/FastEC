package com.github.marsor.mars.delegates.bottom;

import android.widget.Toast;

import com.github.marsor.mars.delegates.MarsDelegate;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */

public abstract class BottomItemDelegate extends MarsDelegate{

    //再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000;
    private long TOUCH_TIME = 0;

    @Override
    public boolean onBackPressedSupport() {
        if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
            _mActivity.finish();
        } else {
            TOUCH_TIME = System.currentTimeMillis();
            Toast.makeText(_mActivity, "双击退出", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
