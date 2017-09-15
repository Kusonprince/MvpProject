package com.kuson.mvpproject.mvp;

/**
 * Created by Kuson on 17/8/22.
 * presenter基类接口，用于和视图产生关联和取消关联
 */

public interface Presenter<V extends MvpView> {

    /**
     * 关联
     * @param mvpView
     */
    void attachView(V mvpView);

    /**
     * 取消关联
     */
    void detachView();

}
