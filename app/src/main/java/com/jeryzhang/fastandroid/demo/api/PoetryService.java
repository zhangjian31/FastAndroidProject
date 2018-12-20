package com.jeryzhang.fastandroid.demo.api;

import com.jeryzhang.fastandroid.demo.bean.PoetryBean;
import com.jeryzhang.fastandroid.demo.bean.RecommendPoetry;
import com.jeryzhang.fastandroid.demo.bean.TangPoetryBean;
import com.jeryzhang.common.module_network.entity.ResponseData;
import com.jeryzhang.common.module_network.entity.ResponseList;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface PoetryService {

    @GET("/singlePoetry")
    Observable<ResponseData<PoetryBean>> getPoetryList(@QueryMap Map<String, Object> map);

    @GET("/recommendPoetry")
    Observable<ResponseData<RecommendPoetry>> getRecommendPoetry(@QueryMap Map<String, Object> map);
//getTangPoetry?page=1&count=20

    @GET("/getTangPoetry")
    Observable<ResponseList<TangPoetryBean>> getTangPoetryList(@QueryMap Map<String, Object> map);
}
