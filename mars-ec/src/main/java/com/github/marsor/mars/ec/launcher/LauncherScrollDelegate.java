package com.github.marsor.mars.ec.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.github.marsor.mars.app.AccountManager;
import com.github.marsor.mars.app.IUserChecker;
import com.github.marsor.mars.delegates.MarsDelegate;
import com.github.marsor.mars.ec.R;
import com.github.marsor.mars.ui.launcher.ILauncherListener;
import com.github.marsor.mars.ui.launcher.LauncherHolderCreator;
import com.github.marsor.mars.ui.launcher.OnLauncherFinishTag;
import com.github.marsor.mars.ui.launcher.ScrollLauncherTag;
import com.github.marsor.mars.util.storage.MarsPreference;

import java.util.ArrayList;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */

public class LauncherScrollDelegate extends MarsDelegate implements OnItemClickListener {

    private ConvenientBanner<Integer> mConvenientBanner = null;
    private static final ArrayList<Integer> INTEGERS = new ArrayList<>();
    private ILauncherListener mILauncherListener = null;

    private void initBanner() {
        INTEGERS.add(R.mipmap.launcher_01);
        INTEGERS.add(R.mipmap.launcher_02);
        INTEGERS.add(R.mipmap.launcher_03);
        INTEGERS.add(R.mipmap.launcher_04);
        INTEGERS.add(R.mipmap.launcher_05);
        mConvenientBanner.setPages(new LauncherHolderCreator(), INTEGERS)
                .setPageIndicator(new int[]{R.drawable.dot_normal, R.drawable.dot_focus})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener(this)
                .setCanLoop(false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ILauncherListener) {
            mILauncherListener = (ILauncherListener) activity;
        }
    }

    @Override
    public Object setLayout() {
        mConvenientBanner = new ConvenientBanner<>(getContext());
        return mConvenientBanner;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initBanner();
    }

    @Override
    public void onItemClick(int position) {
        if(position==INTEGERS.size()-1){
            MarsPreference.setAppFlag(ScrollLauncherTag.HAS_FIRST_LAUNCHER_APP.name(),true);
            //检查是否已经登录
            AccountManager.checkAccount(new IUserChecker() {
                @Override
                public void onSignIn() {
                    if (mILauncherListener != null) {
                        mILauncherListener.onLauncherFinish(OnLauncherFinishTag.SIGNED);
                    }
                }

                @Override
                public void onNotSignIn() {
                    if (mILauncherListener != null) {
                        mILauncherListener.onLauncherFinish(OnLauncherFinishTag.NOT_SIGNED);
                    }
                }
            });
        }
    }
}
