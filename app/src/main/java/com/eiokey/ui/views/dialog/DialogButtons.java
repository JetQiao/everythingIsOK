package com.eiokey.ui.views.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;

import com.eiokey.ui.R;
import com.eiokey.ui.databinding.DialogButtonsBinding;


/**
 * description  确认取消
 * param
 * return
 * @author JetQiao
 * @Time 2021/4/1 0001 15:25
 * @version 1.0.0
 */
public class DialogButtons extends DialogUtils
{
    DialogButtonsBinding dialogButtonsBinding;

    public DialogButtons(Context context, int position, int themeResId)
    {
        super(context, position, themeResId);
        initView();
    }

    public DialogButtons(Context context, int position, boolean cancelable, DialogInterface.OnCancelListener cancelListener)
    {
        super(context, position, cancelable, cancelListener);
        initView();
    }

    public DialogButtons(Context context, int position)
    {
        super(context, position);
        initView();
    }


    public DialogButtons(Context context, float alpha, int gravity)
    {
        super(context, alpha, gravity);
        initView();
    }

    //    public ImageView getLogoView()
    //    {
    //        return mIvLogo;
    //    }
    //

    /**
     * description 设置标题文字
     * param
     */
    public void setTitle(String title)
    {
        if (TextUtils.isEmpty(title))
        {
            dialogButtonsBinding.tvDlButtonsTitle.setVisibility(View.GONE);
        } else
        {
            dialogButtonsBinding.tvDlButtonsTitle.setVisibility(View.VISIBLE);
        }
        dialogButtonsBinding.tvDlButtonsTitle.setText(title);
    }


    public void setLogo(int resourceId)
    {
        if (resourceId == 0)
        {
            dialogButtonsBinding.llDlButtonsIcon.setVisibility(View.GONE);
        } else
        {
            dialogButtonsBinding.llDlButtonsIcon.setVisibility(View.VISIBLE);
        }
        dialogButtonsBinding.imgDlButtonsIcon.setImageResource(resourceId);
    }


    public void setImg(Drawable drawable, int position)
    {
        if (position != 0)
        {
            switch (position)
            {
                case IMG_LEFT:
                    dialogButtonsBinding.tvDlButtonsContent.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
                    break;
                case IMG_RIGHT:
                    dialogButtonsBinding.tvDlButtonsContent.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
                    break;
                case IMG_TOP:
                    dialogButtonsBinding.tvDlButtonsContent.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
                    break;
                case IMG_BOTTOM:
                    dialogButtonsBinding.tvDlButtonsContent.setCompoundDrawablesWithIntrinsicBounds(null, null, null, drawable);
                    break;
                default:
                    dialogButtonsBinding.tvDlButtonsContent.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    break;
            }
            dialogButtonsBinding.tvDlButtonsContent.setCompoundDrawablePadding(10);
        }
    }

    /**
     * description  设置内容
     * param
     */
    public void setContent(String content)
    {
        if (TextUtils.isEmpty(content))
        {
            dialogButtonsBinding.tvDlButtonsContent.setVisibility(View.GONE);
        } else
        {
            dialogButtonsBinding.tvDlButtonsContent.setVisibility(View.VISIBLE);
        }
        dialogButtonsBinding.tvDlButtonsContent.setText(content);
    }


    /**
     * description 确认文字
     * param
     */
    public void setSureText(String strSure)
    {
        dialogButtonsBinding.tvDlButtonsSure.setText(strSure);
    }


    /**
     * description 取消文字
     * param
     */
    public void setCancelText(String strCancel)
    {
        dialogButtonsBinding.tvDlButtonsCancel.setText(strCancel);
    }


    public void setSureListener(View.OnClickListener sureListener)
    {
        dialogButtonsBinding.tvDlButtonsSure.setOnClickListener(sureListener);
    }

    public void setCancelListener(View.OnClickListener cancelListener)
    {
        dialogButtonsBinding.tvDlButtonsCancel.setOnClickListener(cancelListener);
    }

    private void initView()
    {
        dialogButtonsBinding = DataBindingUtil.inflate(((Activity) mContext).getLayoutInflater(), R.layout.dialog_buttons, null, false);
        setContentView(dialogButtonsBinding.getRoot());
    }
}
