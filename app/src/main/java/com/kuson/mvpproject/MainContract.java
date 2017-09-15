package com.kuson.mvpproject;

import com.kuson.mvpproject.mvp.MvpView;

/**
 * Created by kuson on 17/9/15.
 *
 * 契约类的主要功能是为了mapview跟presenter的功能关系明了
 */

public class MainContract {

    public interface MainPresneter {
        void getUserInfo();
    }

    public interface MainView extends MvpView {
        void getUserInfoResult();
    }

}
