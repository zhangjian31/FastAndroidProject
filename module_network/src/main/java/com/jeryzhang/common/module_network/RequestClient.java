package com.jeryzhang.common.module_network;


import com.jeryzhang.common.module_network.config.RequestConfig;
import com.jeryzhang.common.module_network.gson.GsonUtil;

import java.io.IOException;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RequestClient {
    private static RequestClient sInstance;
    private Retrofit mRetrofit;


    public static RequestClient getInstance() {
        if (sInstance == null) {
            synchronized (RequestClient.class) {
                if (sInstance == null) {
                    sInstance = new RequestClient();
                }
            }
        }
        return sInstance;
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

    private RequestClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request.Builder requestBuilder = chain.request().newBuilder();
                        for (Map.Entry<String, String> entry : RequestConfig.getInstance().getHeaders().entrySet()) {
                            requestBuilder.addHeader(entry.getKey(), entry.getValue());
                        }
                        return chain.proceed(requestBuilder.build());
                    }
                });

        SSLParams sslParams = SSLParams.getSslSocketFactory();
        builder.sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager);

        OkHttpClient okHttpClient = builder.build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(RequestConfig.getInstance().getBaseUrl())
                .client(okHttpClient)
                .addConverterFactory(MultiCoverFactory.create(GsonUtil.createGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


    public static Map<String, Object> warpParameters(Map<String, Object> outParams) {

        Map<String, Object> params = RequestConfig.getInstance().getParameters();
        params.putAll(outParams);
        return params;
    }
}
