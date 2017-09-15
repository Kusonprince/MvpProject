package com.kuson.mvpproject.mvp;

import android.content.Context;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Kuson on 17/8/22.
 */

public abstract class BasePresenter<T extends MvpView> implements Presenter<T> {

    private T mMvpView;

    private Context mContext;

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();  //rxjava产生的订阅管理集

    protected void addDisposable(Disposable disposable) {
        if (disposable != null && !disposable.isDisposed()) {
            mCompositeDisposable.add(disposable);
        }
    }

    protected void removeDisposiable(Disposable disposable) {
        if (disposable != null)
            mCompositeDisposable.remove(disposable);
    }

    protected void clear() {
        if (mCompositeDisposable != null && !mCompositeDisposable.isDisposed())
            mCompositeDisposable.clear();
    }

    @Override
    public void attachView(T mvpView) {
        this.mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        this.mMvpView = null;
        clear();
    }

    public T getMvpView() {
        return mMvpView;
    }

    public boolean isAttachedView() {
        return mMvpView != null;
    }

    protected abstract void init(Context context);

    public void initial(Context context) {
        mContext = context;
        init(context);
    }

    public abstract void cancelApi();
}
