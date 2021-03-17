package com.eiokey.ui.activity.tips.toast;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.eiokey.library.activity.BaseActivity;
import com.eiokey.ui.R;
import com.eiokey.ui.databinding.ActivityTipsToastBinding;
import com.eiokey.ui.views.toast.ToastUtil;

/**
 * description
 * param
 * return
 *
 * @author JetQiao
 * @version 1.0.0
 * @Time 2021/3/16 0016 9:25
 */
public class ToastActivity extends BaseActivity implements View.OnClickListener
{
    ActivityTipsToastBinding activityTipsToastBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        activityTipsToastBinding = DataBindingUtil.setContentView(this, R.layout.activity_tips_toast);
        initView();
    }

    @Override
    protected void initView()
    {
        activityTipsToastBinding.btnToastDefault.setOnClickListener(this);
        activityTipsToastBinding.btnToastTop.setOnClickListener(this);
        activityTipsToastBinding.btnToastLeft.setOnClickListener(this);
        activityTipsToastBinding.btnToastRight.setOnClickListener(this);
        activityTipsToastBinding.btnToastCenter.setOnClickListener(this);
        activityTipsToastBinding.btnToastBottom.setOnClickListener(this);
        activityTipsToastBinding.btnToastBgDefault.setOnClickListener(this);
        activityTipsToastBinding.btnToastBgCenter.setOnClickListener(this);
        activityTipsToastBinding.btnToastImgTop.setOnClickListener(this);
        activityTipsToastBinding.btnToastImgLeft.setOnClickListener(this);
        activityTipsToastBinding.btnToastBgImgTop.setOnClickListener(this);
        activityTipsToastBinding.btnToastBgImgLeft.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_toast_default:
                ToastUtil.showMsg(this, "默认显示");
                break;
            case R.id.btn_toast_top:
                ToastUtil.showMsg(this, "显示在上面",0, ToastUtil.SHOW_TOP, 0);
                break;
            case R.id.btn_toast_left:
                ToastUtil.showMsg(this, "显示在左侧", 0,ToastUtil.SHOW_START, 0);
                break;
            case R.id.btn_toast_right:
                ToastUtil.showMsg(this, "显示在右侧",0, ToastUtil.SHOW_END, 0);
                break;
            case R.id.btn_toast_center:
                ToastUtil.showMsg(this, "显示在中间", 0,ToastUtil.SHOW_CENTER, 0);
                break;
            case R.id.btn_toast_bottom:
                ToastUtil.showMsg(this, "显示在底部", 0,ToastUtil.SHOW_BOTTOM, 0);
                break;
            case R.id.btn_toast_bg_default:
                ToastUtil.showMsg(this,"默认换背景",R.drawable.shape_tips_toast_yellow);
                break;

            case R.id.btn_toast_bg_center:
                ToastUtil.showMsg(this,"默认换背景",R.drawable.shape_tips_toast_yellow,ToastUtil.SHOW_CENTER,0);
                break;
            case R.id.btn_toast_img_top:
                ToastUtil.showImg(this,"图标在上面",0,R.mipmap.icon_toast_tips,ToastUtil.SHOW_TOP,0,0);
                break;
            case R.id.btn_toast_img_left:
                ToastUtil.showImg(this,"左侧图标",0,R.mipmap.icon_toast_tips,ToastUtil.SHOW_START,0,0);
                break;
            case R.id.btn_toast_bg_img_top:
                ToastUtil.showImg(this,"图标在上面其他背景",R.drawable.shape_tips_toast_yellow,R.mipmap.icon_toast_tips,ToastUtil.SHOW_TOP,0,0);
                break;
            case R.id.btn_toast_bg_img_left:
                ToastUtil.showImg(this,"左侧图标其他背景",R.drawable.shape_tips_toast_yellow,R.mipmap.icon_toast_tips,ToastUtil.SHOW_START,ToastUtil.SHOW_CENTER,0);
                break;

            default:
                break;
        }
    }
}
