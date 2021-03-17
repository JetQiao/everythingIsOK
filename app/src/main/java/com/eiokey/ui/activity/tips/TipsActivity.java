package com.eiokey.ui.activity.tips;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.eiokey.library.activity.BaseActivity;
import com.eiokey.ui.R;
import com.eiokey.ui.activity.tips.toast.ToastActivity;
import com.eiokey.ui.databinding.ActivityTipsBinding;

/**
 * description
 * param
 * return
 *
 * @author JetQiao
 * @version 1.0.0
 * @Time 2021/3/16 0016 9:25
 */
public class TipsActivity extends BaseActivity implements View.OnClickListener
{
    ActivityTipsBinding activityTipsBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        activityTipsBinding = DataBindingUtil.setContentView(this, R.layout.activity_tips);
        initView();
    }

    @Override
    protected void initView()
    {
        activityTipsBinding.btnTipsToast.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_tips_toast:
                openActivity(ToastActivity.class,false);
                break;
            case R.id.btn_tips_snackbar:
                break;
            default:
                break;
        }
    }
}
