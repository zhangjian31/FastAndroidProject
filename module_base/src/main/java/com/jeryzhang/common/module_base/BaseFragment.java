package com.jeryzhang.common.module_base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseFragment extends android.support.v4.app.Fragment {
    protected final String TAG = getClass().getName();
    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    protected Context context;
    private boolean hasInit;
    private View rootView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        if (rootView == null) {
            rootView = inflater.inflate(getContentView(), container, false);
        }
        return rootView;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!hasInit) {
            hasInit = true;
            onBindView();
            onSetListener();
            onRequestData();
        }

    }

    @LayoutRes
    public abstract int getContentView();

    protected abstract void onBindView();

    protected abstract void onSetListener();

    protected abstract void onRequestData();


    @Override
    public void onDestroy() {
        mCompositeDisposable.clear();
        super.onDestroy();
    }

}
