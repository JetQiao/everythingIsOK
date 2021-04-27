package com.eiokey.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.eiokey.library.activity.BaseActivity;
import com.eiokey.ui.R;
import com.eiokey.ui.activity.dialog.DialogActivity;
import com.eiokey.ui.activity.tips.TipsActivity;
import com.eiokey.ui.databinding.ActivityMainBinding;


/**
 * @author JetQiao
 */
public class MainActivity extends BaseActivity implements View.OnClickListener
{
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initView();
    }


    @Override
    protected void initView()
    {
        activityMainBinding.btnMainTextview.setOnClickListener(this);
        activityMainBinding.btnMainDialog.setOnClickListener(this);
        activityMainBinding.btnMainTips.setOnClickListener(this);
    }

    //    private void initView()
    //    {
    //        activityMainBinding.btnMainTextview.setOnClickListener(this);
    //    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_main_textview:
                break;

            case R.id.btn_main_dialog:
                openActivity(DialogActivity.class, false);
                break;

            //Tips:Toast & snackbar
            case R.id.btn_main_tips:
                openActivity(TipsActivity.class, false);
                break;
            case R.id.btn_main_image:
                break;
            case R.id.btn_main_other:
                break;
            default:
                break;
        }
    }
}

