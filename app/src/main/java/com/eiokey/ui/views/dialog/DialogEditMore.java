package com.eiokey.ui.views.dialog;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;

import androidx.databinding.DataBindingUtil;

import com.eiokey.library.models.dialog.DialogEditMoreModel;
import com.eiokey.ui.R;
import com.eiokey.ui.adapters.dialog.DialogEditMoreAdapter;
import com.eiokey.ui.databinding.DialogEdittextBinding;
import com.eiokey.ui.databinding.DialogEdittextMoreBinding;

import java.util.List;


/**
 * description  多个EditText
 * param
 * return
 *
 * @author JetQiao
 * @version 1.0.0
 * @Time 2021/4/2 0002 16:55
 */
public class DialogEditMore extends DialogUtils
{
    DialogEdittextMoreBinding dialogEdittextMoreBinding;
    DialogEditMoreAdapter dialogEditMoreAdapter;

    public DialogEditMore(Context context, int position, int themeResId)
    {
        super(context, position, themeResId);
        initView();
    }

    public DialogEditMore(Context context, int position, boolean cancelable, OnCancelListener cancelListener)
    {
        super(context, position, cancelable, cancelListener);
        initView();
    }

    public DialogEditMore(Context context, int position)
    {
        super(context, position);
        initView();
    }

    public DialogEditMore(Activity context, int position)
    {
        super(context, position);
        initView();
    }

    public DialogEditMore(Context context, float alpha, int gravity)
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
        layoutParams.setMargins(0, height, 0, 0);
        dialogEdittextMoreBinding.llDlEditMore.setLayoutParams(layoutParams);
    }


    public void setTitle(String title)
    {
        dialogEdittextMoreBinding.tvDlEditMoreTitle.setText(title);
    }


    public void setData(List<DialogEditMoreModel> dialogEditMoreModels)
    {
        dialogEditMoreAdapter = new DialogEditMoreAdapter(dialogEditMoreModels, mContext);
        dialogEdittextMoreBinding.lvDlEditMore.setAdapter(dialogEditMoreAdapter);
        dialogEditMoreAdapter.notifyDataSetChanged();
    }

    /**
     * description 确认文字
     * param
     */
    public void setSureText(String strSure)
    {
        dialogEdittextMoreBinding.tvDlEditMoreSure.setText(strSure);
    }


    /**
     * description 取消文字
     * param
     */
    public void setCancelText(String strCancel)
    {
        dialogEdittextMoreBinding.tvDlEditMoreCancel.setText(strCancel);
    }


    public void setSureListener(View.OnClickListener sureListener)
    {
        dialogEdittextMoreBinding.tvDlEditMoreSure.setOnClickListener(sureListener);
    }

    public void setCancelListener(View.OnClickListener cancelListener)
    {
        dialogEdittextMoreBinding.tvDlEditMoreCancel.setOnClickListener(cancelListener);
    }

    private void initView()
    {
        dialogEdittextMoreBinding = DataBindingUtil.inflate(((Activity) mContext).getLayoutInflater(), R.layout.dialog_edittext_more, null, false);
        setContentView(dialogEdittextMoreBinding.getRoot());

    }
}
