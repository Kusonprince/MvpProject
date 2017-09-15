package com.kuson.mvpproject.mvp;

import android.os.Bundle;

import com.kuson.mvpproject.base.BaseActivity;


/**
 * Created by Kuson on 17/8/22.
 */

public abstract class BaseMvpActivity<V extends MvpView, T extends BasePresenter<V>> extends BaseActivity {

    private T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createPresenters();
    }

    private void createPresenters() {
        if (mPresenter == null) {
            mPresenter = createPresenter();
        }
        if (mPresenter != null && !mPresenter.isAttachedView()) {
            mPresenter.attachView((V)this);
            mPresenter.initial(this);
        }
    }

    protected abstract T createPresenter();

    public T getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter.cancelApi();
        }
    }
}
