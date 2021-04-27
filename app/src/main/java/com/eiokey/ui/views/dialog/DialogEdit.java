package com.eiokey.ui.views.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.databinding.DataBindingUtil;

import com.eiokey.ui.R;
import com.eiokey.ui.databinding.DialogEdittextBinding;


/**
 * description
 * param
 * return
 * @author JetQiao
 * @Time 2021/4/1 0001 15:25
 * @version 1.0.0
 */
public class DialogEdit extends DialogUtils
{

    DialogEdittextBinding dialogEdittextBinding;

    public DialogEdit(Context context, int position, int themeResId)
    {
        super(context, position, themeResId);
        initView();
    }

    public DialogEdit(Context context, int position, boolean cancelable, DialogInterface.OnCancelListener cancelListener)
    {
        super(context, position, cancelable, cancelListener);
        initView();
    }

    public DialogEdit(Context context, int position)
    {
        super(context, position);
        initView();
    }

    public DialogEdit(Activity context, int position)
    {
        super(context, position);
        initView();
    }

    public DialogEdit(Context context, float alpha, int gravity)
    {
        super(context, alpha, gravity);
        initView();
    }


    /**
     * description  设置Dialog的高度
     * param
     */
    public void setViewMarginTop(int height)
    {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0,height,0,0);
        dialogEdittextBinding.llDlEdit.setLayoutParams(layoutParams);
    }


    public void setTitle(String title)
    {
        dialogEdittextBinding.tvDlEditTitle.setText(title);
    }


    public EditText getEditText()
    {
        return dialogEdittextBinding.edtDlEditContent;
    }


    /**
     * description 确认文字
     * param
     */
    public void setSureText(String strSure)
    {
        dialogEdittextBinding.tvDlEditSure.setText(strSure);
    }


    /**
     * description 取消文字
     * param
     */
    public void setCancelText(String strCancel)
    {
        dialogEdittextBinding.tvDlEditCancel.setText(strCancel);
    }


    public void setSureListener(View.OnClickListener sureListener)
    {
        dialogEdittextBinding.tvDlEditSure.setOnClickListener(sureListener);
    }

    public void setCancelListener(View.OnClickListener cancelListener)
    {
        dialogEdittextBinding.tvDlEditCancel.setOnClickListener(cancelListener);
    }

    private void initView()
    {
        dialogEdittextBinding = DataBindingUtil.inflate(((Activity) mContext).getLayoutInflater(), R.layout.dialog_edittext, null, false);
        setContentView(dialogEdittextBinding.getRoot());

    }
}
