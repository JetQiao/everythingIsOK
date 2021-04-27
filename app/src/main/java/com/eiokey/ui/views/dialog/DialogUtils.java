package com.eiokey.ui.views.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

import com.eiokey.ui.R;

import java.util.Objects;


/**
 * description Dialog基类
 * param
 * return
 *
 * @author JetQiao
 * @version 1.0.0
 * @Time 2021/3/19 0019 16:11
 */
public class DialogUtils extends Dialog
{

    public static final int IMG_LEFT = 1;
    public static final int IMG_RIGHT = 2;
    public static final int IMG_TOP = 3;
    public static final int IMG_BOTTOM = 4;

    protected Context mContext;

    protected LayoutParams mLayoutParams;

    public LayoutParams getLayoutParams()
    {
        return mLayoutParams;
    }

    public DialogUtils(Context context, int position, int themeResId)
    {
        super(context, themeResId);
        initView(context, position);
    }

    public DialogUtils(Context context, int position, boolean cancelable, OnCancelListener cancelListener)
    {
        super(context, cancelable, cancelListener);
        initView(context, position);
    }

    public DialogUtils(Context context, int position)
    {
        super(context);
        initView(context, position);
    }

    /**
     * description  初始化
     * param    context     context
     * param    position    dialog显示的位置
     * return
     */
    private void initView(Context context, int position)
    {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(this.getWindow()).setBackgroundDrawableResource(R.mipmap.bg_transparent);
        mContext = context;
        Window window = this.getWindow();
        window.setGravity(position);
    }

    /**
     * description 倒计时消失
     * param
     * return
     */
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
        }

        @Override
        public void onFinish()
        {
            DialogUtils.this.dismiss();
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
    public DialogUtils(Context context, float alpha, int gravity)
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

    @Override
    public void show()
    {
        Objects.requireNonNull(this.getWindow()).setFlags(LayoutParams.FLAG_NOT_FOCUSABLE, LayoutParams.FLAG_NOT_FOCUSABLE);
        if (!((Activity) mContext).isFinishing())
        {
            super.show();
        }
        this.getWindow().clearFlags(LayoutParams.FLAG_NOT_FOCUSABLE);
    }
}
