package com.jeryzhang.common.module_network.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;


public class IntTypeAdapter extends TypeAdapter<Integer> {
    @Override
    public void write(JsonWriter out, Integer value) throws IOException {
        out.value(value);
    }

    @Override
    public Integer read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return 0;
        }
        String result = in.nextString();
        if ("".equals(result)) {
            return 0;
        }
        try {
            return Integer.parseInt(result);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
