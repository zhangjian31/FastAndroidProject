package com.jeryzhang.common.module_network;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

public class RxSchedulers {
    public static <T> ObservableTransformer<T, T> io_main() {
        return new ObservableTransformer() {
            @Override
            public ObservableSource apply(@NonNull final Observable upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
