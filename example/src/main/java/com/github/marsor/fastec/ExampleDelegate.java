package com.github.marsor.fastec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.github.marsor.mars.delegates.MarsDelegate;
import com.github.marsor.mars.net.RestClient;
import com.github.marsor.mars.net.callback.IError;
import com.github.marsor.mars.net.callback.IFailure;
import com.github.marsor.mars.net.callback.ISuccess;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */

public class ExampleDelegate extends MarsDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        testClient();
    }

    private void testClient() {
        RestClient.builder()
                .url("https://127.0.0.1/index")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .build()
                .get();
    }
}
