package com.jeryzhang.common.module_base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseActivity extends AppCompatActivity {
    protected String TAG = getClass().getName();
    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        onBindView();
        onSetListener();
        onRequestData();
    }

    @LayoutRes
    public abstract int getContentView();

    protected abstract void onBindView();

    protected abstract void onSetListener();

    protected abstract void onRequestData();


    @Override
    protected void onDestroy() {
        mCompositeDisposable.clear();
        super.onDestroy();
    }
}
