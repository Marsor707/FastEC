package com.github.marsor.fastec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import com.github.marsor.mars.activities.ProxyActivity;
import com.github.marsor.mars.app.Mars;
import com.github.marsor.mars.delegates.MarsDelegate;
import com.github.marsor.mars.ec.launcher.LauncherDelegate;
import com.github.marsor.mars.ec.launcher.LauncherScrollDelegate;
import com.github.marsor.mars.ec.main.EcBottomDelegate;
import com.github.marsor.mars.ec.sign.ISignListener;
import com.github.marsor.mars.ec.sign.SignInDelegate;
import com.github.marsor.mars.ec.sign.SignUpDelegate;
import com.github.marsor.mars.ui.launcher.ILauncherListener;
import com.github.marsor.mars.ui.launcher.OnLauncherFinishTag;

import qiu.niorgai.StatusBarCompat;

public class ExampleActivity extends ProxyActivity implements ISignListener, ILauncherListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        Mars.getConfigurator().withActivity(this);
        StatusBarCompat.translucentStatusBar(this, true);
    }

    @Override
    public MarsDelegate setRootDelegate() {
        return new LauncherDelegate();
    }

    @Override
    public void onSignInSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(this, "注册成功", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag tag) {
        switch (tag) {
            case SIGNED:
//                Toast.makeText(this, "启动结束用户登录了", Toast.LENGTH_LONG).show();
                startWithPop(new EcBottomDelegate());
                break;
            case NOT_SIGNED:
//                Toast.makeText(this, "启动结束用户没登录", Toast.LENGTH_LONG).show();
                startWithPop(new SignInDelegate());
                break;
            default:
                break;
        }
    }
}
