package com.kuson.mvpproject;

import android.os.Bundle;

import com.kuson.mvpproject.mvp.BaseMvpActivity;

public class MainActivity extends BaseMvpActivity<MainContract.MainView, MainPresenterImpl> implements
        MainContract.MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getPresenter().getUserInfo();
    }

    @Override
    protected MainPresenterImpl createPresenter() {
        return new MainPresenterImpl();
    }

    @Override
    public void onFail(int requestId, String errorMsg) {

    }

    @Override
    public void getUserInfoResult() {

    }
}
