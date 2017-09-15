package com.kuson.mvpproject.mvp;

import android.content.Context;

import com.kuson.mvpproject.base.BaseFragment;


/**
 * Created by Kuson on 17/8/23.
 */

public abstract class BaseMvpFragment<V extends MvpView, T extends BasePresenter<V>> extends BaseFragment {

    private T mPresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (mPresenter == null) {
            mPresenter = createPresenter();
        }
        if (mPresenter != null && !mPresenter.isAttachedView()) {
            mPresenter.attachView((V)this);
            mPresenter.initial(getActivity());
        }
    }

    protected abstract T createPresenter();

    public T getPresenter() {
        return mPresenter;
    }

    @Override
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter.cancelApi();
        }
        super.onDestroy();
    }
}
