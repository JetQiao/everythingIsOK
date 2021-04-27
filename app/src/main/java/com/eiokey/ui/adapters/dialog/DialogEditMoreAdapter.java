package com.eiokey.ui.adapters.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.databinding.DataBindingUtil;

import com.eiokey.library.models.dialog.DialogEditMoreModel;
import com.eiokey.ui.R;
import com.eiokey.ui.databinding.ItemDialogEditMoreBinding;

import java.util.List;

/**
 * description   多个EditText的Dialog的Adapter
 * param
 * return
 *
 * @author JetQiao
 * @version 1.0.0
 * @Time 2021/4/1 0001 17:12
 */
public class DialogEditMoreAdapter extends BaseAdapter
{
    List<DialogEditMoreModel> dialogEditMoreModels;

    ItemDialogEditMoreBinding itemDialogEditMoreBinding;

    private final Context mContext;

    public DialogEditMoreAdapter(List<DialogEditMoreModel> list, Context mContext)
    {
        super();
        this.dialogEditMoreModels = list;
        this.mContext = mContext;
    }


    @Override
    public int getCount()
    {
        return dialogEditMoreModels == null ? 0 : dialogEditMoreModels.size();
    }

    @Override
    public Object getItem(int position)
    {
        return dialogEditMoreModels.get(position);
    }


    public String getKey(int position)
    {
        return dialogEditMoreModels.get(position).getKey();
    }

    public String getValue(int position)
    {
        return dialogEditMoreModels.get(position).getValue();
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        itemDialogEditMoreBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_dialog_edit_more, null, false);
        convertView = itemDialogEditMoreBinding.getRoot();
        itemDialogEditMoreBinding.setDialogEditMoreModel(dialogEditMoreModels.get(position));
        return convertView;
    }


}
