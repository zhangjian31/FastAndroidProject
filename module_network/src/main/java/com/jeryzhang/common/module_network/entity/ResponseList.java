package com.jeryzhang.common.module_network.entity;


import java.util.List;

public class ResponseList<T> extends BaseResult {

    private List<T> result;

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
