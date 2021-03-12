package com.eiokey.ui.views.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.eiokey.ui.R;

import java.util.Objects;


/**
 * description 实时信息 弹出框
 * param
 * return
 *
 * @author JetQiao
 * @version 1.0.0
 * Copyright (C), 2015-2020, 江苏亚楠电子科技有限公司
 * @Time 2021/2/25 0025 14:17
 */
public class RxDialogMessage extends Dialog
{

    private TextView mTvContent;
    protected Context mContext;
    private RelativeLayout relativeLayout;

    public RxDialogMessage(Context context)
    {
        super(context);
        initView(context);
    }


    public TextView getContentView()
    {
        return mTvContent;
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

    public void setViewWidth(int height)
    {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, height);
        mTvContent.setLayoutParams(layoutParams);
    }

    public void setLayoutParams(RelativeLayout.LayoutParams layoutParams)
    {
        //        relativeLayout.setLayoutParams(layoutParams);
        mTvContent.setLayoutParams(layoutParams);
    }

    private void initView(Context context)
    {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setBackgroundDrawableResource(R.mipmap.bg_transparent);
/*        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);*/
        mContext = context;
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_message, null);
        mTvContent = dialogView.findViewById(R.id.tv_content);
        mTvContent.setMovementMethod(ScrollingMovementMethod.getInstance());
        relativeLayout = dialogView.findViewById(R.id.ly_root);
        setContentView(dialogView);

        Window window = this.getWindow();
        window.setGravity(Gravity.TOP | Gravity.LEFT);
        window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        WindowManager.LayoutParams mLayoutParams = window.getAttributes();
        if (mLayoutParams != null)
        {
            mLayoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            mLayoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
            window.setAttributes(mLayoutParams);
        }
    }

    /**
     * 隐藏头部导航栏状态栏
     */
    public void skipTools()
    {
        if (Build.VERSION.SDK_INT < 19)
        {
            return;
        }
        Objects.requireNonNull(getWindow()).setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public void show()
    {
        if (!((Activity) mContext).isFinishing())
        {
            super.show();
            Objects.requireNonNull(this.getWindow()).setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
            super.show();
            fullScreenImmersive(getWindow().getDecorView());
            this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        }
    }

    private void fullScreenImmersive(View view)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_FULLSCREEN;
            view.setSystemUiVisibility(uiOptions);
        }
    }

    /**
     * 隐藏虚拟按键，并且全屏
     */
    protected void hideBottomUIMenu()
    {
        //隐藏虚拟按键，并且全屏
        if (Build.VERSION.SDK_INT < 19)
        { // lower api
            View v = Objects.requireNonNull(this.getWindow()).getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else
        {
            Window _window = getWindow();
            assert _window != null;
            WindowManager.LayoutParams params = _window.getAttributes();
            params.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE;
            _window.setAttributes(params);
        }
    }
}
