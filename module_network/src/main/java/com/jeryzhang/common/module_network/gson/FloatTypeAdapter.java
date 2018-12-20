package com.jeryzhang.common.module_network.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class FloatTypeAdapter extends TypeAdapter<Float> {
    @Override
    public void write(JsonWriter out, Float value) throws IOException {
        out.value(value);
    }

    @Override
    public Float read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return 0f;
        }
        String result = in.nextString();
        if ("".equals(result)) {
            return 0f;
        }
        try {
            return Float.parseFloat(result);
        }catch (Exception e){
            e.printStackTrace();
            return 0F;
        }
    }
}
