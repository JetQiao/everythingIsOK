package com.eiokey.ui.views.toast;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.eiokey.ui.R;


/**
 * description  ToastUtil
 * param
 * return
 *
 * @author JetQiao
 * @version 1.0.0
 * @Time 2021/3/17 0017 11:21
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
     * description  默认显示Toast
     * param    context         context
     * param    message         显示的文字
     * param    bgResourceId    背景资源
     * param    iconResourceId  图标资源
     * param    iconPosition    图标位置
     * param    position        Toast位置
     * param    duration        显示时间
     * return
     */
    public static void showMsg(Context context, String message)
    {
        showToastUtil(context, message, 0, 0, 0);
    }

    public static void showMsg(Context context, String message, int bgResourceId)
    {
        showToastUtil(context, message, bgResourceId, 0, 0);
    }

    public static void showMsg(Context context, String message, int bgResourceId, int position, int duration)
    {
        showToastUtil(context, message, bgResourceId, position, duration);
    }

    public static void showImg(Context context, String message, int bgResourceId, int iconResourceId, int iconPosition, int position, int duration)
    {
        showImgToastUtil(context, message, bgResourceId, iconResourceId, iconPosition, position, duration);
    }

    /**
     * description Toast显示工具，下同
     * param    mContext   context
     * param    position   位置
     * param    resourceId 资源
     * param    text       内容
     * param    duration   时间
     * return
     * Author JetQiao
     * Time 2019/12/27 0027 17:15
     */
    private static void showToastUtil(Context mContext, final String text, int resourceId, int position, final int duration)
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            showUtils(mContext, text, resourceId, position, duration);
        } else
        {
            M_HANDLER.post(() -> showUtils(mContext, text, resourceId, position, duration));
        }
    }


    private static void showImgToastUtil(Context mContext, final String text, int resourceId, int iconResourceId, int iconPosition, int position, final int duration)
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            showImgUtils(mContext, text, resourceId, iconResourceId, iconPosition, position, duration);
        } else
        {
            M_HANDLER.post(() -> showImgUtils(mContext, text, resourceId, iconResourceId, iconPosition, position, duration));
        }
    }


    /**
     * description  显示带位置的Toast
     * param    mContext    context
     * param    text        显示的内容
     * param    resourceId  资源ID
     * param    position    显示位置
     * param    duration    显示时间
     * return
     */
    private static void showUtils(Context mContext, String text, int resourceId, int position, int duration)
    {
        if (toast != null)
        {
            toast.cancel();
        }
        toast = new Toast(mContext);

        @SuppressLint("InflateParams") View toastView = LayoutInflater.from(mContext).inflate(R.layout.toast_text_message, null);
        LinearLayout llToastTextMeg = toastView.findViewById(R.id.ll_toast_text_msg);
        if (resourceId == 0)
        {
            llToastTextMeg.setBackgroundResource(R.drawable.shape_tips_toast_default);
        } else
        {
            llToastTextMeg.setBackgroundResource(resourceId);
        }
        TextView tvToastMsg = toastView.findViewById(R.id.tv_toast_text_msg);
        //要提示的文本
        tvToastMsg.setText(text);
        //位置
        switch (position)
        {
            case SHOW_TOP:
                toast.setGravity(SHOW_TOP, 0, 0);
                break;

            case SHOW_START:
                toast.setGravity(SHOW_START, 0, 0);
                break;

            case SHOW_END:
                toast.setGravity(SHOW_END, 0, 0);
                break;

            case SHOW_CENTER:
                toast.setGravity(SHOW_CENTER, 0, 0);
                break;

            case SHOW_BOTTOM:
                toast.setGravity(SHOW_BOTTOM, 0, 0);
                break;
            default:
                toast.setGravity(SHOW_BOTTOM, 0, 80);
                break;
        }
        //设置短暂提示
        toast.setDuration(duration);
        //把定义好的View布局设置到Toast里面
        toast.setView(toastView);
        toast.show();
    }

    private static void showImgUtils(Context mContext, String text, int resourceId, int iconResourceId, int iconPosition, int position, int duration)
    {
        if (toast != null)
        {
            toast.cancel();
        }
        toast = new Toast(mContext);
        @SuppressLint("InflateParams") View toastView = LayoutInflater.from(mContext).inflate(R.layout.toast_img_message, null);
        LinearLayout llToastImgMeg = toastView.findViewById(R.id.ll_toast_img_msg);
        if (resourceId == 0)
        {
            llToastImgMeg.setBackgroundResource(R.drawable.shape_tips_toast_default);
        } else
        {
            llToastImgMeg.setBackgroundResource(resourceId);
        }
        ImageView imgToastImgTop = toastView.findViewById(R.id.img_toast_img_msg_top);
        ImageView imgToastImgLeft = toastView.findViewById(R.id.img_toast_img_msg_left);
        ImageView imgToastImgRight = toastView.findViewById(R.id.img_toast_img_msg_right);
        ImageView imgToastImgBottom = toastView.findViewById(R.id.img_toast_img_msg_bottom);
        imgToastImgTop.setImageResource(iconResourceId);
        imgToastImgLeft.setImageResource(iconResourceId);
        imgToastImgRight.setImageResource(iconResourceId);
        imgToastImgBottom.setImageResource(iconResourceId);
        switch (iconPosition)
        {
            case SHOW_TOP:
                imgToastImgTop.setVisibility(View.VISIBLE);
                imgToastImgLeft.setVisibility(View.GONE);
                imgToastImgRight.setVisibility(View.GONE);
                imgToastImgBottom.setVisibility(View.GONE);
                break;
            case SHOW_END:
                imgToastImgTop.setVisibility(View.GONE);
                imgToastImgLeft.setVisibility(View.GONE);
                imgToastImgRight.setVisibility(View.VISIBLE);
                imgToastImgBottom.setVisibility(View.GONE);
                break;
            case SHOW_BOTTOM:
                imgToastImgTop.setVisibility(View.GONE);
                imgToastImgLeft.setVisibility(View.GONE);
                imgToastImgRight.setVisibility(View.GONE);
                imgToastImgBottom.setVisibility(View.VISIBLE);
                break;
            case SHOW_START:
            default:
                imgToastImgTop.setVisibility(View.GONE);
                imgToastImgLeft.setVisibility(View.VISIBLE);
                imgToastImgRight.setVisibility(View.GONE);
                imgToastImgBottom.setVisibility(View.GONE);
                break;
        }
        TextView tvToastImgMsg = toastView.findViewById(R.id.tv_toast_img_msg);
        tvToastImgMsg.setText(text);
        //Toast位置
        switch (position)
        {
            case SHOW_TOP:
                toast.setGravity(SHOW_TOP, 0, 0);
                break;
            case SHOW_START:
                toast.setGravity(SHOW_START, 0, 0);
                break;
            case SHOW_END:
                toast.setGravity(SHOW_END, 0, 0);
                break;
            case SHOW_CENTER:
                toast.setGravity(SHOW_CENTER, 0, 0);
                break;
            case SHOW_BOTTOM:
                toast.setGravity(SHOW_BOTTOM, 0, 0);
                break;
            default:
                toast.setGravity(SHOW_BOTTOM, 0, 80);
                break;
        }
        toast.setDuration(duration);
        toast.setView(toastView);
        toast.show();
    }
}
