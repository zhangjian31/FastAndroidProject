package com.jeryzhang.common.module_network.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;


public class LongTypeAdapter extends TypeAdapter<Long> {
    @Override
    public void write(JsonWriter out, Long value) throws IOException {
        out.value(value);
    }

    @Override
    public Long read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return 0L;
        }

        String result = in.nextString();
        if ("".equals(result)) {
            return 0L;
        }
        try {
            return Long.parseLong(result);
        }catch (Exception e){
            e.printStackTrace();
            return 0L;
        }
    }
}
