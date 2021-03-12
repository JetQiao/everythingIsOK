package com.eiokey.ui.views.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.eiokey.ui.R;


/**
 * @author vondear
 * @date 2016/7/19
 * 倒计时消失 弹出框
 */
public class RxDialogTimer extends RxDialog
{

    private TextView mTvTitle;
    private TextView mTvContent;

    public RxDialogTimer(Context context, int themeResId)
    {
        super(context, themeResId);
        initView();
    }

    public RxDialogTimer(Context context, boolean cancelable, DialogInterface.OnCancelListener cancelListener)
    {
        super(context, cancelable, cancelListener);
        initView();
    }

    public RxDialogTimer(Context context)
    {
        super(context);
        initView();
    }

    public RxDialogTimer(Context context, float alpha, int gravity)
    {
        super(context, alpha, gravity);
        initView();
    }

    public TextView getTitleView()
    {
        return mTvTitle;
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


    public void setContent(String str)
    {
        if (TextUtils.isEmpty(str))
        {
            mTvContent.setVisibility(View.GONE);
        } else
        {
            mTvContent.setVisibility(View.VISIBLE);
        }
        mTvContent.setText(str);
    }

    private void initView()
    {
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_time_count, null);
        mTvTitle = dialogView.findViewById(R.id.tv_title);
        mTvTitle.setTextIsSelectable(true);
        mTvContent = dialogView.findViewById(R.id.tv_content);
        mTvContent.setMovementMethod(ScrollingMovementMethod.getInstance());
        mTvContent.setTextIsSelectable(true);
        setContentView(dialogView);
    }

}
