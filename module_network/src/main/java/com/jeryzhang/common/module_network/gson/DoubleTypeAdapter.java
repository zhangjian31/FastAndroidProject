package com.jeryzhang.common.module_network.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class DoubleTypeAdapter extends TypeAdapter<Double> {
    @Override
    public void write(JsonWriter out, Double value) throws IOException {
        out.value(value);
    }

    @Override
    public Double read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return 0d;
        }
        String result = in.nextString();
        if ("".equals(result)) {
            return 0d;
        }
        try {
            return Double.parseDouble(result);
        }catch (Exception e){
            e.printStackTrace();
            return 0D;
        }

    }
}
