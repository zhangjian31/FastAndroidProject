package com.jeryzhang.common.module_network.converter;

import com.google.gson.TypeAdapter;
import com.jeryzhang.common.module_utils.util.ZLibUtil;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;


public class CompressResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final TypeAdapter<T> adapter;

    public CompressResponseBodyConverter(TypeAdapter<T> adapter) {
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        byte[] responseData = value.bytes();
        try {
            responseData = ZLibUtil.decompress(responseData);
        } catch (Exception e) {
            responseData = new byte[0];
        }
        value.close();
        String result = new String(responseData);
        return adapter.fromJson(result);

    }
}
