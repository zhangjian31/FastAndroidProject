package com.jeryzhang.common.module_network;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.jeryzhang.common.module_network.converter.CompressResponseBodyConverter;
import com.jeryzhang.common.module_network.converter.StringResponseBodyConverter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;


public final class MultiCoverFactory extends Converter.Factory {

    public static MultiCoverFactory create(Gson gson) {
        if (gson == null) throw new NullPointerException("gson is null");
        return new MultiCoverFactory(gson);
    }

    private final Gson gson;

    private MultiCoverFactory(Gson gson) {
        this.gson = gson;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (type == String.class) {
            return new StringResponseBodyConverter();
        } else {
            TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
            return new CompressResponseBodyConverter<>(adapter);
        }
    }
}