package com.jeryzhang.fastandroid.demo.manger;

import com.jeryzhang.fastandroid.demo.api.PoetryService;
import com.jeryzhang.fastandroid.demo.bean.PoetryBean;
import com.jeryzhang.fastandroid.demo.bean.RecommendPoetry;
import com.jeryzhang.fastandroid.demo.bean.TangPoetryBean;
import com.jeryzhang.common.module_network.RequestClient;
import com.jeryzhang.common.module_network.RxSchedulers;
import com.jeryzhang.common.module_network.entity.ResponseData;
import com.jeryzhang.common.module_network.entity.ResponseList;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.QueryMap;

public class PoetryServiceManger {
    public static Observable<ResponseData<PoetryBean>> getPoetryList(Map<String, Object> map) {
        return RequestClient.getInstance().getRetrofit().create(PoetryService.class)
                .getPoetryList(RequestClient.warpParameters(map))
                .compose(RxSchedulers.<ResponseData<PoetryBean>>io_main());
    }

    public static Observable<ResponseData<RecommendPoetry>> getRecommendPoetry(@QueryMap Map<String, Object> map) {
        return RequestClient.getInstance().getRetrofit().create(PoetryService.class)
                .getRecommendPoetry(RequestClient.warpParameters(map))
                .compose(RxSchedulers.<ResponseData<RecommendPoetry>>io_main());
    }

    public static Observable<ResponseList<TangPoetryBean>> getTangPoetryList(@QueryMap Map<String, Object> map) {
        return RequestClient.getInstance().getRetrofit().create(PoetryService.class)
                .getTangPoetryList(RequestClient.warpParameters(map))
                .compose(RxSchedulers.<ResponseList<TangPoetryBean>>io_main());
    }

}
