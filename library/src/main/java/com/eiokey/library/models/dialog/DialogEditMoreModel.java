package com.eiokey.library.models.dialog;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;


import com.eiokey.library.BR;

import java.io.Serializable;

/**
 * description
 * param
 * return
 *
 * @author JetQiao
 * @version 1.0.0
 * @Time 2021/4/1 0001 17:34
 */
public class DialogEditMoreModel extends BaseObservable implements Serializable
{
    /**
     * Keys
     */
    private String key;

    /**
     * EditText的值
     */
    private String value;

    /**
     * 是否显示Key
     */
    private boolean keyVisible;


    public DialogEditMoreModel()
    {
    }

    public DialogEditMoreModel(String key, String value, boolean keyVisible)
    {
        this.key = key;
        this.value = value;
        this.keyVisible = keyVisible;
    }

    @Bindable
    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
        notifyPropertyChanged(BR.key);
    }

    @Bindable
    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
        notifyPropertyChanged(BR.value);
    }

    @Bindable
    public boolean isKeyVisible()
    {
        return keyVisible;
    }

    public void setKeyVisible(boolean keyVisible)
    {
        this.keyVisible = keyVisible;
        notifyPropertyChanged(BR.keyVisible);
    }
}
