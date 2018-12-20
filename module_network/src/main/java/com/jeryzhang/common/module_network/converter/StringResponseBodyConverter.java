package com.jeryzhang.common.module_network.converter;

import com.jeryzhang.common.module_utils.util.ZLibUtil;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;


public class StringResponseBodyConverter implements Converter<ResponseBody, String> {
    @Override
    public String convert(ResponseBody value) throws IOException {
        byte[] responseData = value.bytes();
        try {
            responseData = ZLibUtil.decompress(responseData);
        } catch (Exception e) {
            responseData = new byte[0];
        }
        value.close();
        return new String(responseData);
    }
}