package com.eiokey.library.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.eiokey.library.utils.app.AppManager;


/**
 * @author Jet
 */
public abstract class BaseActivity extends Activity
{
    protected Context mContext;
    public static final String TAG = BaseActivity.class.getSimpleName();
    protected Handler mHandler = null;

    public BaseActivity()
    {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        AppManager.addActivity(this);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
    }

    @Override
    protected void onStart()
    {
        super.onStart();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
    }

    /**
     * 绑定控件id
     */
//    protected abstract void findViewById();

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 通过类名启动Activity
     * @param pClass Activity名称
     * @param finish 是否结束前一个
     */
    protected void openActivity(Class<?> pClass, boolean finish)
    {
        this.openActivity(pClass, null);
        if (finish)
        {
            this.finish();
        }

    }

    /**
     * 通过类名启动带有数据的Activity
     * @param pClass Activity名称
     * @param pBundle 数据
     * @param finish 是否结束前一个
     */
    protected void openActivity(Class<?> pClass, Bundle pBundle, boolean finish)
    {
        Intent intent = new Intent(this, pClass);
        if (pBundle != null)
        {
            intent.putExtras(pBundle);
        }
        this.startActivity(intent);
        if (finish)
        {
            this.finish();
        }

    }

    protected void openActivity(Class<?> pClass, Bundle pBundle)
    {
        Intent intent = new Intent(this, pClass);
        if (pBundle != null)
        {
            intent.putExtras(pBundle);
        }

        this.startActivity(intent);
    }

    protected void openActivityForResult(Class<?> pClass, Bundle pBundle, boolean finish)
    {
        Intent intent = new Intent(this, pClass);
        if (pBundle != null)
        {
            intent.putExtras(pBundle);
        }

        this.startActivityForResult(intent, 0);
        if (finish)
        {
            this.finish();
        }

    }

    protected void openActivityForResult(Class<?> pClass, int code, boolean finish)
    {
        Intent intent = new Intent(this, pClass);
        this.startActivityForResult(intent, code);
        if (finish)
        {
            this.finish();
        }

    }

    protected void openActivity(String pAction)
    {
        this.openActivity(pAction, null);
    }

    /**
     * 关闭Activity
     */
    protected void closeActivity()
    {
        this.finish();
    }

    protected void openActivity(String pAction, Bundle pBundle)
    {
        Intent intent = new Intent(pAction);
        if (pBundle != null)
        {
            intent.putExtras(pBundle);
        }

        this.startActivity(intent);
    }
}
