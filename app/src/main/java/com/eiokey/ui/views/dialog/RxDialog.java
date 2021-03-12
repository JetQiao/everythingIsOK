package com.eiokey.ui.views.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;


import com.eiokey.ui.R;

import java.util.Objects;


/**
 * description Dialog基类
 * param
 * return
 *
 * @author vondear
 * @version 1.0.0
 * @Time 2021/2/23 0023 15:38
 */
public class RxDialog extends Dialog
{
    protected Context mContext;

    protected LayoutParams mLayoutParams;

    public LayoutParams getLayoutParams()
    {
        return mLayoutParams;
    }

    public RxDialog(Context context, int themeResId)
    {
        super(context, themeResId);
        initView(context);
    }

    public RxDialog(Context context, boolean cancelable, OnCancelListener cancelListener)
    {
        super(context, cancelable, cancelListener);
        initView(context);
    }

    public RxDialog(Context context)
    {
        super(context);
        initView(context);
    }

    private void initView(Context context)
    {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(this.getWindow()).setBackgroundDrawableResource(R.mipmap.bg_transparent);
        mContext = context;
        Window window = this.getWindow();
        window.setGravity(Gravity.TOP);
    }

    public void setTimeFinish(long timeFinish)
    {
        //单位秒
        new DownTimer(timeFinish).start();
    }

    /**
     * description 继承CountDownTimer类
     * param
     * return
     *
     * @author JetQiao
     * @version 1.0.0
     * @Time 2021/2/23 0023 15:40
     */
    class DownTimer extends CountDownTimer
    {

        public DownTimer(long timeFinish)
        {
            // 设置总时间
            super(timeFinish * 1000, 1000);
        }

        // 重写CountDownTimer的两个方法
        @Override
        public void onTick(long millisUntilFinished)
        {
            //            tv_time.setText(millisUntilFinished / 1000 + "s");
        }

        @Override
        public void onFinish()
        {
           RxDialog.this.dismiss();

        }

    }

    /**
     * description
     * param  alpha   透明度 0.0f--1f(不透明)
     * param  gravity 方向(Gravity.BOTTOM,Gravity.TOP,Gravity.LEFT,Gravity.RIGHT)
     * return
     *
     * @Time 2021/2/23 0023 16:00
     * @version 1.0.0
     */
    public RxDialog(Context context, float alpha, int gravity)
    {
        super(context);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(this.getWindow()).setBackgroundDrawableResource(R.mipmap.bg_transparent);
        mContext = context;
        Window window = this.getWindow();
        mLayoutParams = window.getAttributes();
        mLayoutParams.alpha = 1f;
        window.setAttributes(mLayoutParams);
        if (mLayoutParams != null)
        {
            mLayoutParams.height = android.view.ViewGroup.LayoutParams.MATCH_PARENT;
            mLayoutParams.gravity = gravity;
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
        Objects.requireNonNull(getWindow()).setFlags(LayoutParams.FLAG_FULLSCREEN, LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * 设置全屏显示
     */
    public void setFullScreen()
    {
        Window window = getWindow();
        Objects.requireNonNull(window).getDecorView().setPadding(0, 0, 0, 0);
        LayoutParams lp = window.getAttributes();
        lp.width = LayoutParams.MATCH_PARENT;
        lp.height = LayoutParams.MATCH_PARENT;
        window.setAttributes(lp);
    }

    /**
     * 设置宽度match_parent
     */
    public void setFullScreenWidth()
    {
        Window window = getWindow();
        Objects.requireNonNull(window).getDecorView().setPadding(0, 0, 0, 0);
        LayoutParams lp = window.getAttributes();
        lp.width = LayoutParams.MATCH_PARENT;
        lp.height = LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
    }

    /**
     * 设置高度为match_parent
     */
    public void setFullScreenHeight()
    {
        Window window = getWindow();
        Objects.requireNonNull(window).getDecorView().setPadding(0, 0, 0, 0);
        LayoutParams lp = window.getAttributes();
        lp.width = LayoutParams.WRAP_CONTENT;
        lp.height = LayoutParams.MATCH_PARENT;
        window.setAttributes(lp);
    }

    public void setOnWhole()
    {
        Objects.requireNonNull(getWindow()).setType(LayoutParams.TYPE_SYSTEM_ALERT);
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

    @Override
    public void show()
    {
        Objects.requireNonNull(this.getWindow()).setFlags(LayoutParams.FLAG_NOT_FOCUSABLE, LayoutParams.FLAG_NOT_FOCUSABLE);
        if (!((Activity) mContext).isFinishing())
        {
            super.show();
        }
        fullScreenImmersive(getWindow().getDecorView());
        this.getWindow().clearFlags(LayoutParams.FLAG_NOT_FOCUSABLE);
    }
}
