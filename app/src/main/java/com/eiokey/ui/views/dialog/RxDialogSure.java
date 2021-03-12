package com.eiokey.ui.views.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eiokey.ui.R;


/**
 * description 确认弹出框
 * param
 * return
 * @author JetQiao
 * @Time 2021/2/25 0025 14:26
 * @version 1.0.0
 *  Copyright (C), 2015-2020, 江苏亚楠电子科技有限公司
 */
public class RxDialogSure extends RxDialog
{

    private TextView mTvTitle;
    private TextView mTvContent;
    private TextView mTvSure;
    private LinearLayout linearLayout;

    public RxDialogSure(Context context, int themeResId)
    {
        super(context, themeResId);
        initView();
    }

    public RxDialogSure(Context context, boolean cancelable, DialogInterface.OnCancelListener cancelListener)
    {
        super(context, cancelable, cancelListener);
        initView();
    }

    public RxDialogSure(Context context)
    {
        super(context);
        initView();
    }

    public RxDialogSure(Context context, float alpha, int gravity)
    {
        super(context, alpha, gravity);
        initView();
    }

    public TextView getTitleView()
    {
        return mTvTitle;
    }

    public TextView getSureView()
    {
        return mTvSure;
    }

    public void setSureListener(View.OnClickListener listener)
    {
        mTvSure.setOnClickListener(listener);
    }

    public TextView getContentView()
    {
        return mTvContent;
    }

    public void setTitle(String title)
    {
        if (TextUtils.isEmpty(title))
        {
            mTvTitle.setVisibility(View.GONE);
        } else
        {
            mTvTitle.setVisibility(View.VISIBLE);
        }
        mTvTitle.setText(title);
    }

    public void setSure(String content)
    {
        mTvSure.setText(content);
    }

    public void setContent(String str, int gravity)
    {
        if (TextUtils.isEmpty(str))
        {
            mTvContent.setVisibility(View.GONE);
        } else
        {
            mTvContent.setVisibility(View.VISIBLE);
        }
        mTvContent.setText(str);
        mTvContent.setGravity(gravity);
    }

    public void setViewWidth(int width)
    {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(layoutParams);
    }

    private void initView()
    {
        @SuppressLint("InflateParams") View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_sure, null);
        mTvSure = dialogView.findViewById(R.id.tv_sure);
        mTvTitle = dialogView.findViewById(R.id.tv_title);
        mTvTitle.setTextIsSelectable(true);
        mTvContent = dialogView.findViewById(R.id.tv_content);
        mTvContent.setMovementMethod(ScrollingMovementMethod.getInstance());
        mTvContent.setTextIsSelectable(true);
        linearLayout = dialogView.findViewById(R.id.ly_root);
        setContentView(dialogView);
    }

}
