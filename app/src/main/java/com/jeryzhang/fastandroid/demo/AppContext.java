package com.jeryzhang.fastandroid.demo;

import android.app.Application;
import android.os.Build;

import com.jeryzhang.common.module_network.config.RequestConfig;
import com.jeryzhang.common.module_utils.util.ScreenUtils;

import java.util.HashMap;
import java.util.Map;

public class AppContext extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        new RequestConfig.Builder(this)
                .baseUrl("https://api.apiopen.top")
                .headers(getHeaders())
                .parameters(getParameters())
                .build();
    }


    private Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append("com.jery.test")
                .append("/android")
                .append("/").append(Build.VERSION.CODENAME)
                .append("/").append("1.0");

        headers.put("User-Agent", sb.toString());
        return headers;
    }

    private Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("width", ScreenUtils.getScreenWidth(this));
        parameters.put("height", ScreenUtils.getScreenHeight(this));

        return parameters;
    }
}
