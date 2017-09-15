package com.kuson.mvpproject.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kuson.mvpproject.view.TopBar;

/**
 * Created by Kuson on 17/6/21.
 */

public class BaseActivity extends AppCompatActivity {

    private TopBar mTopbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTopbarLeftListener();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void setOnClickListener(View.OnClickListener listener, View... views) {
        for (View view : views)
            view.setOnClickListener(listener);
    }

    public void setOnClickListener(View.OnClickListener listener, int... ids) {
        for (int id : ids)
            findViewById(id).setOnClickListener(listener);
    }

    /**
     * 该方法使用一定要保证在setContentView之后
     * 并且xml布局里include了topbar
     *
     * this method must be called after setContentView
     * and activity's xml must include topbar
     * @return
     */
    public TopBar getTopbar() {
        if (mTopbar == null)
            mTopbar = new TopBar(getWindow().getDecorView());
        return mTopbar;
    }

    private void setTopbarLeftListener() {
        if (mTopbar != null && mTopbar.getLeftView() != null) {
            mTopbar.getLeftView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

}
