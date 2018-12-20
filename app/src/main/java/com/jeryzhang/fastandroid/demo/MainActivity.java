package com.jeryzhang.fastandroid.demo;

import android.widget.TextView;

import com.jeryzhang.common.module_base.BaseActivity;
import com.jeryzhang.fastandroid.demo.bean.PoetryBean;
import com.jeryzhang.fastandroid.demo.bean.RecommendPoetry;
import com.jeryzhang.fastandroid.demo.bean.TangPoetryBean;
import com.jeryzhang.fastandroid.demo.manger.PoetryServiceManger;
import com.jeryzhang.common.module_network.entity.ResponseData;
import com.jeryzhang.common.module_network.entity.ResponseList;
import com.jeryzhang.common.module_utils.util.ALog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.functions.Consumer;

public class MainActivity extends BaseActivity {
    private TextView contentTv;

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onBindView() {
        contentTv = findViewById(R.id.content);
    }

    @Override
    protected void onSetListener() {

    }

    @Override
    protected void onRequestData() {
        test2();
    }

    private void test() {
        Map<String, Object> map = new HashMap<>();
        mCompositeDisposable.add(PoetryServiceManger.getPoetryList(map).subscribe(new Consumer<ResponseData<PoetryBean>>() {
            @Override
            public void accept(ResponseData<PoetryBean> responseData) throws Exception {
                PoetryBean bean = null;
                if (responseData != null) {
                    bean = responseData.getResult();
                }
                if (bean == null) {
                    return;
                }
                contentTv.setText(bean.toString());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                ALog.d(throwable.toString());
            }
        }));
    }

    private void test2() {
        Map<String, Object> map = new HashMap<>();
        mCompositeDisposable.add(PoetryServiceManger.getRecommendPoetry(map).subscribe(new Consumer<ResponseData<RecommendPoetry>>() {
            @Override
            public void accept(ResponseData<RecommendPoetry> responseData) throws Exception {
                RecommendPoetry bean = null;
                if (responseData != null) {
                    bean = responseData.getResult();
                }
                if (bean == null) {
                    return;
                }
                contentTv.setText(bean.toString());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                ALog.d(throwable.toString());
            }
        }));
    }

    private void testList() {
        Map<String, Object> map = new HashMap<>();
        map.put("page", "1");
        map.put("count", "20");
        mCompositeDisposable.add(PoetryServiceManger.getTangPoetryList(map).subscribe(new Consumer<ResponseList<TangPoetryBean>>() {
            @Override
            public void accept(ResponseList<TangPoetryBean> responseData) throws Exception {
                List<TangPoetryBean> list = null;
                if (responseData != null) {
                    list = responseData.getResult();
                }
                if (list == null) {
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                for (TangPoetryBean bean : list) {
                    stringBuilder.append(bean.getTitle());
                    stringBuilder.append("\n");
                    stringBuilder.append(bean.getContent());
                    stringBuilder.append("\n");
                    stringBuilder.append(bean.getAuthors());
                    stringBuilder.append("\n\n");
                }
                contentTv.setText(stringBuilder.toString());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                ALog.d(throwable.toString());
            }
        }));
    }

    @Override
    protected void onDestroy() {
        mCompositeDisposable.dispose();
        super.onDestroy();
    }
}
