package com.eiokey.ui.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.eiokey.library.utils.logutils.LogUtils;
import com.eiokey.ui.R;
import com.eiokey.ui.databinding.ActivityMainBinding;
import com.eiokey.ui.views.toast.ToastUtil;


/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initView();
    }

    private void initView()
    {
        activityMainBinding.btnMainTextview.setOnClickListener(this);
    }


    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_main_textview:
                LogUtils.d("--------------");
                ToastUtil.showToast(this, "显示TextView");
                break;

            case R.id.btn_main_dialog:
                break;

            case R.id.btn_main_toast:
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

