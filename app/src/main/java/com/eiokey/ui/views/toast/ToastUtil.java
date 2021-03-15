package com.eiokey.ui.views.toast;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.eiokey.library.utils.ColorUtil;
import com.eiokey.ui.R;


/**
 * @author JetQiao
 * @description ToastUtils
 * @Time 2019/12/27 0027 16:42
 */
public class ToastUtil
{
    private static Toast toast;

    private static final Handler M_HANDLER = new Handler(Looper.getMainLooper());

    /**
     * description 显示位置与现实时间的常量
     * param    SHOW_TOP        顶部
     * param    SHOW_CENTER     中间
     * param    SHOW_LEFT       左边
     * param    SHOW_RIGHT      右边
     * param    SHOW_BOTTOM     底部
     * param    SHOW_SHORT      显示短
     * param    SHOW_LONG       显示长
     * return
     */
    public static final int SHOW_TOP = Gravity.TOP;
    public static final int SHOW_CENTER = Gravity.CENTER;
    public static final int SHOW_START = Gravity.START;
    public static final int SHOW_END = Gravity.END;
    public static final int SHOW_BOTTOM = Gravity.BOTTOM;

    public static final int SHOW_SHORT = Toast.LENGTH_SHORT;
    public static final int SHOW_LONG = Toast.LENGTH_LONG;


    /**
     * description
     * param
     * return
     *
     * @author JetQiao
     * @Time 2021/3/15 0015 16:20
     * @version 1.0.0
     * Copyright (C), 2015-2020, 江苏亚楠电子科技有限公司
     */
    public static void showMsg(Context context, String message)
    {
        @SuppressLint("InflateParams") View toastView = LayoutInflater.from(context).inflate(R.layout.toast_text_message, null);
        LinearLayout ll_toast_text_msg = toastView.findViewById(R.id.ll_toast_text_msg);
        ll_toast_text_msg.setBackgroundColor(Color.BLUE);
        TextView tvToastMsg = toastView.findViewById(R.id.tv_toast_text_msg);

        //要提示的文本
        tvToastMsg.setText(message);
        Toast toast = new Toast(context);
        //位置居中
        toast.setGravity(Gravity.CENTER, 0, 0);


        //设置短暂提示
        toast.setDuration(Toast.LENGTH_SHORT);
        //把定义好的View布局设置到Toast里面
        toast.setView(toastView);
        toast.show();

    }


    /**
     * description
     * param
     * return
     *
     * @Time 2021/3/15 0015 16:17
     * @version 1.0.0
     */
    //    public static void showImg(Context context, String message, int position)
    //    {
    //        View toastview = LayoutInflater.from(context).inflate(R.layout.toast_image_layout, null);
    //        TextView text = toastview.findViewById(R.id.tv_message);
    //        text.setText(message);    //要提示的文本
    //        Toast toast = new Toast(context);   //上下文
    //        toast.setGravity(Gravity.CENTER, 0, 0);   //位置居中
    //        toast.setDuration(Toast.LENGTH_SHORT);  //设置短暂提示
    //        toast.setView(toastview);   //把定义好的View布局设置到Toast里面
    //        toast.show();
    //
    //    }


    /**
     * description  显示Toast,默认显示,位置居中，显示时间短
     * 用法        showToast(context,text);
     * param
     * return
     */
    public static void showToast(Context mContext, String text)
    {
        showToastUtil(mContext, text, 0);
    }

    /**
     * description 显示Toast,带显示时间长短,默认居中
     * 用法        showToast(context,text,ToastUtil.SHOW_SHORT);
     * param
     * return
     */
    public static void showToast(Context mContext, String text, int duration)
    {
        showToastUtil(mContext, text, duration);
    }

    /**
     * description  显示Toast,带显示位置，不带显示时长
     * 用法          showToast(context,ToastUtil.SHOW_TOP,text);
     * param
     * return
     */
    public static void showToast(Context mContext, int position, String text)
    {
        showToastUtil(mContext, position, text, 0);
    }

    /**
     * description 显示Toast,带显示位置，带显示时长
     * param       showToast(context,ToastUtil.SHOW_TOP,text,ToastUtil.SHOW_LONG);
     * return
     * Author JetQiao
     * Time 2019/12/27 0027 17:13
     */
    public static void showToast(Context mContext, int position, String text, int duration)
    {
        showToastUtil(mContext, position, text, duration);
    }

    /**
     * description Toast显示工具，下同
     * param    mContext   context
     * param    position   位置
     * param    text       内容
     * param    duration   时间
     * return
     * Author JetQiao
     * Time 2019/12/27 0027 17:15
     */
    private static void showToastUtil(Context mContext, final String text, final int duration)
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            show(mContext, text, duration);
        } else
        {
            M_HANDLER.post(() -> show(mContext, text, duration));
        }
    }

    private static void showToastUtil(Context mContext, int position, final String text, final int duration)
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            show(mContext, position, text, duration);
        } else
        {
            M_HANDLER.post(() -> show(mContext, position, text, duration));
        }
    }


    private static void show(Context mContext, String text, int duration)
    {
        if (toast != null)
        {
            toast.cancel();
        }
        toast = Toast.makeText(mContext, text, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }


    private static void show(Context mContext, int position, String text, int duration)
    {
        if (toast != null)
        {
            toast.cancel();
        }
        toast = Toast.makeText(mContext, text, duration);
        toast.setGravity(position, 0, 0);
        toast.show();
    }


    //    public static void showImageToas(Context context, String message)
    //    {
    //        View toastview = LayoutInflater.from(context).inflate(R.layout.toast_image_layout, null);
    //        TextView text = toastview.findViewById(R.id.tv_message);
    //        text.setText(message);    //要提示的文本
    //        Toast toast = new Toast(context);   //上下文
    //        toast.setGravity(Gravity.CENTER, 0, 0);   //位置居中
    //        toast.setDuration(Toast.LENGTH_SHORT);  //设置短暂提示
    //        toast.setView(toastview);   //把定义好的View布局设置到Toast里面
    //        toast.show();
    //
    //    }
}
