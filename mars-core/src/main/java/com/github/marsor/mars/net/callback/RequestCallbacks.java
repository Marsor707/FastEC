package com.github.marsor.mars.net.callback;

import android.os.Handler;

import com.github.marsor.mars.app.ConfigKeys;
import com.github.marsor.mars.app.Mars;
import com.github.marsor.mars.net.RestCreator;
import com.github.marsor.mars.ui.LoaderStyle;
import com.github.marsor.mars.ui.MarsLoader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */

public class RequestCallbacks implements Callback<String> {

    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final LoaderStyle LOADER_STYLE;
    private static final Handler HANDLER = new Handler();

    public RequestCallbacks(IRequest request, ISuccess success, IFailure failure, IError error, LoaderStyle style) {
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.LOADER_STYLE = style;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful()) {
            if (call.isExecuted()) {
                if (SUCCESS != null) {
                    SUCCESS.onSuccess(response.body());
                }
            }
        } else {
            if (ERROR != null) {
                ERROR.onError(response.code(), response.message());
            }
        }

        onRequestFinish();
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if (FAILURE != null) {
            FAILURE.onFailure();
        }

        if (REQUEST != null) {
            REQUEST.onRequestEnd();
        }

        onRequestFinish();
    }

    private void onRequestFinish() {
        long delayed = Mars.getConfiguration(ConfigKeys.LOADER_DELAYED);
        if (LOADER_STYLE != null) {
            HANDLER.postDelayed(new Runnable() {
                @Override
                public void run() {
                    RestCreator.getParams().clear();
                    MarsLoader.stopLoading();
                }
            }, delayed);
        }
    }
}
