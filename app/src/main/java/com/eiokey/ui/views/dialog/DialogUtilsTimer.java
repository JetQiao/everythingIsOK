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
 * description  倒计时,Dialog消失
 * param
 * return
 * @author JetQiao
 * @Time 2021/4/1 0001 15:26
 * @version 1.0.0
 */
public class DialogUtilsTimer extends DialogUtils
{

    private TextView mTvTitle;
    private TextView mTvContent;

    public DialogUtilsTimer(Context context, int position, int themeResId)
    {
        super(context, position, themeResId);
        initView();
    }

    public DialogUtilsTimer(Context context, int position, boolean cancelable, DialogInterface.OnCancelListener cancelListener)
    {
        super(context, position, cancelable, cancelListener);
        initView();
    }

    public DialogUtilsTimer(Context context, int position)
    {
        super(context, position);
        initView();
    }

    public DialogUtilsTimer(Context context, float alpha, int gravity)
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
