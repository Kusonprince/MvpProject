package com.kuson.mvpproject;

import android.content.Context;

import com.kuson.mvpproject.mvp.BasePresenter;
import com.kuson.mvpproject.network.RetrofitHelper;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wangziyi on 17/9/15.
 */

public class MainPresenterImpl extends BasePresenter<MainContract.MainView> implements MainContract.MainPresneter {

    MainService mMainService;

    @Override
    protected void init(Context context) {
        mMainService = RetrofitHelper.getInstance().getApiService(MainService.class);
    }

    @Override
    public void cancelApi() {

    }

    @Override
    public void getUserInfo() {
        addDisposable(
                mMainService.getUserInfo("test")
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<String>(){

                            @Override
                            public void onNext(@NonNull String s) {

                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        })
        );
    }
}
