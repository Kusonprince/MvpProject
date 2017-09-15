package com.kuson.mvpproject.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kuson.mvpproject.R;


/**
 * Created by Kuson on 17/6/21.
 */

public class TopBar {

    private Context mContext;

    private RelativeLayout mTopLayout;

    private TextView mLeftView;

    private TextView mTitle;

    private TextView mRightView;

    public TopBar(View view) {
        mContext = view.getContext();
        mTopLayout = (RelativeLayout) view.findViewById(R.id.topbar);
        mLeftView = (TextView) view.findViewById(R.id.image_back);
        mTitle = (TextView) view.findViewById(R.id.title);
        mRightView = (TextView) view.findViewById(R.id.right);
    }

    public TextView getLeftView() {
        return mLeftView;
    }

    public TextView getRightView() {
        return mRightView;
    }

    public void setTopLayoutBackground(int id) {
        if (mTopLayout != null)
            mTopLayout.setBackgroundColor(id);
    }

    public void setLeftVisibility(boolean visible) {
        if (mLeftView != null){
            mLeftView.setVisibility(visible ? View.VISIBLE : View.GONE);
        }
    }

    public void setRightVisibility(boolean visuble) {
        if (mRightView != null) {
            mRightView.setVisibility(visuble ? View.VISIBLE : View.GONE);
        }
    }

    public void setTitle(String title) {
        if (mTitle != null)
            mTitle.setText(title);
    }

    public void setTitle(int id) {
        if (mTitle != null)
            mTitle.setText(id);
    }

    public void setLeftViewText(String msg) {
        if (mLeftView != null && !TextUtils.isEmpty(msg))
            mLeftView.setText(msg);
    }

    public void setLeftViewText(int id) {
        if (mLeftView != null)
            mLeftView.setText(id);
    }

    public void setRightViewText(String msg) {
        if (mRightView != null && !TextUtils.isEmpty(msg))
            mRightView.setText(msg);
    }

    public void setRightViewText(int id) {
        if (mRightView != null)
            mRightView.setText(id);
    }

    public void setLeftDrawable(int id) {
        Drawable drawable = mContext.getResources().getDrawable(id);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        mLeftView.setCompoundDrawables(drawable, null, null, null);
    }

    public void setLeftDrawable(Drawable drawable) {
        if (drawable == null) {
            mLeftView.setCompoundDrawables(null, null, null, null);
            return;
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        mLeftView.setCompoundDrawables(drawable, null, null, null);
    }

    public void setRightDrawable(int id) {
        Drawable drawable = mContext.getResources().getDrawable(id);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        mRightView.setCompoundDrawables(drawable, null, null, null);
    }

    public void setRightDrawable(Drawable drawable) {
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        mRightView.setCompoundDrawables(drawable, null, null, null);
    }
}
