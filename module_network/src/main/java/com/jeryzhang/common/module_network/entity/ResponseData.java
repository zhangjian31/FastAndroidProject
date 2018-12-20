package com.jeryzhang.common.module_network.entity;


public class ResponseData<T> extends BaseResult {
    private T result;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
