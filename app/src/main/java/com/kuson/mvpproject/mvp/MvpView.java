package com.kuson.mvpproject.mvp;

/**
 * Created by Kuson on 17/8/22.
 * MVP基类接口，继承并扩展使用
 * 具体扩展根据activity活着fragment功能而定
 */

public interface MvpView {
    /**
     * 发生错误
     * @param requestId
     * @param errorMsg
     */
    void onFail(int requestId, String errorMsg);

}
