package com.eiokey.ui.views.dialog;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;

import com.eiokey.ui.R;
import com.eiokey.ui.databinding.DialogMessageBinding;


/**
 * description Dialog,无按钮，单纯的提示消息
 * param
 * return
 *
 * @author JetQiao
 * @version 1.0.0
 * @Time 2021/3/25 0025 16:16
 */
public class DialogMessage extends DialogUtils
{
    DialogMessageBinding dialogMessageBinding;


    public DialogMessage(Context context, int position)
    {
        super(context, position);
        initView(context);
    }

    public TextView getContentView()
    {
        return dialogMessageBinding.tvDlMsgContent;
    }

    /**
     * description  设置文字内容
     * param
     */
    public void setContent(String str)
    {
        if (TextUtils.isEmpty(str))
        {
            dialogMessageBinding.tvDlMsgContent.setVisibility(View.GONE);
        } else
        {
            dialogMessageBinding.tvDlMsgContent.setVisibility(View.VISIBLE);
        }
        dialogMessageBinding.tvDlMsgContent.setText(str);
    }

    /**
     * description  设置Dialog的高度
     * param
     */
    public void setViewHeight(int height)
    {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height);
        dialogMessageBinding.tvDlMsgContent.setLayoutParams(layoutParams);
    }

    /**
     * description  设置文字的位置
     * param
     */
    public void setContentHeight(int position)
    {
        dialogMessageBinding.tvDlMsgContent.setGravity(position);
    }

    /**
     * description  设置文字字号
     * param    size
     * used 也也直接用DialogMessage.getContentView().setTextSize(int size)
     */
    public void setContentSize(float size)
    {
        dialogMessageBinding.tvDlMsgContent.setTextSize(size);
    }

    /**
     * description 设置文字内容颜色
     * param    color   颜色
     */
    public void setContentColor(int color)
    {
        dialogMessageBinding.tvDlMsgContent.setTextColor(color);
    }

    public void setImg(Drawable drawable, int position)
    {
        if (position != 0)
        {
            switch (position)
            {
                case IMG_LEFT:
                    dialogMessageBinding.tvDlMsgContent.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
                    break;
                case IMG_RIGHT:
                    dialogMessageBinding.tvDlMsgContent.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
                    break;
                case IMG_TOP:
                    dialogMessageBinding.tvDlMsgContent.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
                    break;
                case IMG_BOTTOM:
                    dialogMessageBinding.tvDlMsgContent.setCompoundDrawablesWithIntrinsicBounds(null, null, null, drawable);
                    break;
                default:
                    dialogMessageBinding.tvDlMsgContent.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    break;
            }
            dialogMessageBinding.tvDlMsgContent.setCompoundDrawablePadding(10);
        }
    }


    private void initView(Context context)
    {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setBackgroundDrawableResource(R.mipmap.bg_transparent);
        dialogMessageBinding = DataBindingUtil.inflate(((Activity) context).getLayoutInflater(), R.layout.dialog_message, null, false);
        setContentView(dialogMessageBinding.getRoot());
        dialogMessageBinding.tvDlMsgContent.setMovementMethod(ScrollingMovementMethod.getInstance());
    }
}
