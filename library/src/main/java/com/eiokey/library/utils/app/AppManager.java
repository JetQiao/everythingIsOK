package com.eiokey.library.utils.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Stack;

/**
 * Activity 管理
 *
 * @author Jet
 */
public class AppManager
{
    private static Stack<Activity> mActivityStack;
    private static AppManager mAppManager;

    private AppManager()
    {
    }

    /**
     * 单一实例
     */
    public static AppManager getInstance()
    {
        if (mAppManager == null)
        {
            mAppManager = new AppManager();
        }
        return mAppManager;
    }

    /**
     * 添加Activity到堆栈
     */
    public static void addActivity(Activity activity)
    {
        if (mActivityStack == null)
        {
            mActivityStack = new Stack<>();
        }
        mActivityStack.add(activity);
    }

    /**
     * 获取栈顶Activity（堆栈中最后一个压入的）
     */
    public static Activity getTopActivity()
    {
        return mActivityStack.lastElement();
    }

    /**
     * 结束栈顶Activity（堆栈中最后一个压入的）
     */
    public static void killTopActivity()
    {
        Activity activity = mActivityStack.lastElement();
        killActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public static void killActivity(Activity activity)
    {
        if (activity != null)
        {
            mActivityStack.remove(activity);
            activity.finish();
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public static void killActivity(Class<?> cls)
    {
        for (Activity activity : mActivityStack)
        {
            if (activity.getClass().equals(cls))
            {
                killActivity(activity);
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public static void killAllActivity()
    {
        for (int i = 0, size = mActivityStack.size(); i < size; i++)
        {
            if (null != mActivityStack.get(i))
            {
                mActivityStack.get(i).finish();
            }
        }
        mActivityStack.clear();
    }

    /**
     * 退出应用程序
     */
    public static void AppExit(Context context)
    {
        try
        {
            killAllActivity();
            ActivityManager activityMgr = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.restartPackage(context.getPackageName());
            System.exit(0);
        } catch (Exception ignored)
        {
        }
    }
}
