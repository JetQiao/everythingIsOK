package com.eiokey.ui.views.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.eiokey.ui.R;
import com.eiokey.ui.databinding.DialogSureBinding;


/**
 * description 确认弹出框
 * param
 * return
 *
 * @author JetQiao
 * @version 1.0.0
 * @Time 2021/2/25 0025 14:26
 */
public class DialogSure extends DialogUtils
{
    DialogSureBinding dialogSureBinding;

    public DialogSure(Context context, int position, int themeResId)
    {
        super(context, position, themeResId);
        initView();
    }

    public DialogSure(Context context, int position, boolean cancelable, DialogInterface.OnCancelListener cancelListener)
    {
        super(context, position, cancelable, cancelListener);
        initView();
    }

    public DialogSure(Context context, int position)
    {
        super(context, position);
        initView();
    }

    public DialogSure(Context context, float alpha, int gravity)
    {
        super(context, alpha, gravity);
        initView();
    }


    public void setSureListener(View.OnClickListener listener)
    {
        dialogSureBinding.tvDlSureButton.setOnClickListener(listener);
    }

    /**
     * description 设置标题文字
     * param
     */
    public void setTitle(String title)
    {
        if (TextUtils.isEmpty(title))
        {
            dialogSureBinding.tvDlSureTitle.setVisibility(View.GONE);
        } else
        {
            dialogSureBinding.tvDlSureTitle.setVisibility(View.VISIBLE);
        }
        dialogSureBinding.tvDlSureTitle.setText(title);
    }

    /**
     * description 设置按钮文字
     * param
     */
    public void setSure(String content)
    {
        dialogSureBinding.tvDlSureButton.setText(content);
    }

    /**
     * description  设置内容文字
     * param
     */
    public void setContent(String str, int gravity)
    {
        if (TextUtils.isEmpty(str))
        {
            dialogSureBinding.tvDlSureContent.setVisibility(View.GONE);
        } else
        {
            dialogSureBinding.tvDlSureContent.setVisibility(View.VISIBLE);
        }
        dialogSureBinding.tvDlSureContent.setText(str);
        dialogSureBinding.tvDlSureContent.setGravity(gravity);
    }

    public void setImg(Drawable drawable, int position)
    {
        if (position != 0)
        {
            switch (position)
            {
                case IMG_LEFT:
                    dialogSureBinding.tvDlSureContent.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
                    break;
                case IMG_RIGHT:
                    dialogSureBinding.tvDlSureContent.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
                    break;
                case IMG_TOP:
                    dialogSureBinding.tvDlSureContent.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
                    break;
                case IMG_BOTTOM:
                    dialogSureBinding.tvDlSureContent.setCompoundDrawablesWithIntrinsicBounds(null, null, null, drawable);
                    break;
                default:
                    dialogSureBinding.tvDlSureContent.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    break;
            }
            dialogSureBinding.tvDlSureContent.setCompoundDrawablePadding(10);
        }
    }

    /**
     * description  初始化
     * param
     */
    private void initView()
    {
        dialogSureBinding = DataBindingUtil.inflate(((Activity) mContext).getLayoutInflater(), R.layout.dialog_sure, null, false);
        setContentView(dialogSureBinding.getRoot());
    }

}
