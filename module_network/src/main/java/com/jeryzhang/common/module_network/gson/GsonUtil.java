package com.jeryzhang.common.module_network.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class GsonUtil {

    public static Gson createGson() {
        return new GsonBuilder()
//                .registerTypeAdapter(boolean.class, new BooleanTypeAdapter())
//                .registerTypeAdapter(Boolean.class, new BooleanTypeAdapter())
                .registerTypeAdapter(long.class, new LongTypeAdapter())
                .registerTypeAdapter(Long.class, new LongTypeAdapter())
                .registerTypeAdapter(int.class, new IntTypeAdapter())
                .registerTypeAdapter(Integer.class, new IntTypeAdapter())
                .registerTypeAdapter(float.class, new FloatTypeAdapter())
                .registerTypeAdapter(Float.class, new FloatTypeAdapter())
                .registerTypeAdapter(double.class, new DoubleTypeAdapter())
                .registerTypeAdapter(Double.class, new DoubleTypeAdapter()).create();
    }


}
