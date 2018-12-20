package com.jeryzhang.common.module_network.config;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.annotations.NonNull;

public class RequestConfig {
    private static RequestConfig INSTANCE;
    private Context mContext;
    private String mBaseUrl;
    private Map<String, Object> mParameters;
    private Map<String, String> mHeaders;

    private RequestConfig(Context context, String baseUrl, Map<String, String> headers, Map<String, Object> parameters) {
        mContext = context;
        mBaseUrl = baseUrl;
        mHeaders = headers;
        mParameters = parameters;
    }

    public static RequestConfig getInstance() throws IllegalStateException {
        if (INSTANCE == null)
            throw new IllegalStateException("RequestConfig has not been created");
        return INSTANCE;
    }

    public Context getContext() {
        return mContext;
    }


    public String getBaseUrl() {
        return mBaseUrl;
    }

    public Map<String, Object> getParameters() {
        return mParameters;
    }

    public Map<String, String> getHeaders() {
        return mHeaders;
    }

    public static class Builder {
        private Context context;
        private String baseUrl;
        private Map<String, Object> parameters;
        private Map<String, String> headers;

        public Builder(@NonNull Context context) {
            this.context = context.getApplicationContext();
        }

        public Builder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder headers(Map<String, String> headers) {
            this.headers = headers;
            return this;
        }

        public Builder parameters(Map<String, Object> parameters) {
            this.parameters = parameters;
            return this;
        }


        public RequestConfig build() throws IllegalStateException {
            if (INSTANCE != null)
                throw new IllegalStateException("RequestConfig already created");
            if (parameters == null) {
                parameters = new HashMap<>();
            }
            if (headers == null) {
                headers = new HashMap<>();
            }
            INSTANCE = new RequestConfig(context, baseUrl, headers, parameters);
            return INSTANCE;
        }
    }
}
