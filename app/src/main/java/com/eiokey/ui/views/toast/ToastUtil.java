package com.eiokey.ui.views.toast;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.widget.Toast;


public class ToastUtil
{
    private static Toast toast;

    private static final Handler M_HANDLER = new Handler(Looper.getMainLooper());

    /**
     * description 显示位置与现实时间的常量
     * param  SHOW_TOP        顶部
     * param  SHOW_CENTER     中间
     * param  SHOW_LEFT       左边
     * param  SHOW_RIGHT      右边
     * param  SHOW_BOTTOM     底部
     * param  SHOW_SHORT      显示短
     * param  SHOW_LONG       显示长
     * return
     * Author JetQiao
     */
    public static final int SHOW_TOP = Gravity.TOP;
    public static final int SHOW_CENTER = Gravity.CENTER;
    @SuppressLint("RtlHardcoded")
    public static final int SHOW_LEFT = Gravity.LEFT;
    @SuppressLint("RtlHardcoded")
    public static final int SHOW_RIGHT = Gravity.RIGHT;
    public static final int SHOW_BOTTOM = Gravity.BOTTOM;


    public static final int SHOW_SHORT = Toast.LENGTH_SHORT;
    public static final int SHOW_LONG = Toast.LENGTH_LONG;


    /**
     * description  显示Toast,默认显示,位置居中，显示时间短
     * 用法        showToast(context,text);
     * param
     * return
     * Author JetQiao
     * Time 2019/12/27 0027 16:42
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
     * Author JetQiao
     * Time 2019/12/27 0027 17:07
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
     * Author JetQiao
     * Time 2019/12/27 0027 17:10
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
}
