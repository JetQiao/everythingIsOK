package com.eiokey.ui.activity.dialog;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.eiokey.library.activity.BaseActivity;
import com.eiokey.library.models.dialog.DialogEditMoreModel;
import com.eiokey.ui.R;
import com.eiokey.ui.databinding.ActivityDialogsBinding;
import com.eiokey.ui.views.dialog.DialogButtons;
import com.eiokey.ui.views.dialog.DialogEdit;
import com.eiokey.ui.views.dialog.DialogEditMore;
import com.eiokey.ui.views.dialog.DialogMessage;
import com.eiokey.ui.views.dialog.DialogSure;
import com.eiokey.ui.views.dialog.DialogUtils;
import com.eiokey.ui.views.toast.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 * param
 * return
 *
 * @author JetQiao
 * @version 1.0.0
 * @Time 2021/3/18 0018 10:33
 */
public class DialogActivity extends BaseActivity implements View.OnClickListener
{
    ActivityDialogsBinding activityDialogsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        activityDialogsBinding = DataBindingUtil.setContentView(this, R.layout.activity_dialogs);
        initView();
    }

    @Override
    protected void initView()
    {
        activityDialogsBinding.btnDialogSingle.setOnClickListener(this);
        activityDialogsBinding.btnDialogTipsTop.setOnClickListener(this);
        activityDialogsBinding.btnDialogTipsCenter.setOnClickListener(this);
        activityDialogsBinding.btnDialogTipsCenterLeft.setOnClickListener(this);
        activityDialogsBinding.btnDialogButtons.setOnClickListener(this);
        activityDialogsBinding.btnDialogEdt.setOnClickListener(this);
        activityDialogsBinding.btnDialogEdtMore.setOnClickListener(this);
    }

    @SuppressLint({"NonConstantResourceId", "UseCompatLoadingForDrawables"})
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            //?????????Toast
            case R.id.btn_dialog_single:
                DialogMessage dialogMessage = new DialogMessage(this, Gravity.CENTER);
                dialogMessage.setContent("??????????????????");
                dialogMessage.setViewHeight(200);
                dialogMessage.setContentSize(20);
                dialogMessage.setContentColor(Color.BLUE);
                //????????????
                dialogMessage.setContentHeight(Gravity.CENTER);
                //5?????????
                dialogMessage.setTimeFinish(5);
                dialogMessage.setImg(getResources().getDrawable(R.mipmap.icon_toast_tips), DialogUtils.IMG_TOP);
                //???????????? dialog?????????
                dialogMessage.setCanceledOnTouchOutside(false);
                dialogMessage.show();
                break;
            //???????????????
            case R.id.btn_dialog_tips_top:
                DialogSure rxDialogSure = new DialogSure(this, Gravity.TOP);
                rxDialogSure.setContent("Test", Gravity.CENTER);
                rxDialogSure.show();
                rxDialogSure.setSureListener(v1 -> {
                    rxDialogSure.cancel();
                });
                break;
            //???????????????
            case R.id.btn_dialog_tips_center:
                DialogSure rxDialogSureCenter = new DialogSure(this, Gravity.CENTER);
                rxDialogSureCenter.setContent("Test", Gravity.CENTER);
                rxDialogSureCenter.show();
                rxDialogSureCenter.setSureListener(v1 -> {
                    rxDialogSureCenter.cancel();
                });
                break;
            //???????????????
            case R.id.btn_dialog_tips_center_left:
                DialogSure rxDialogSureCenterLeft = new DialogSure(this, Gravity.CENTER);
                rxDialogSureCenterLeft.setContent("Test", Gravity.LEFT | Gravity.CENTER);
                rxDialogSureCenterLeft.setImg(getResources().getDrawable(R.mipmap.icon_toast_tips), DialogUtils.IMG_LEFT);
                rxDialogSureCenterLeft.show();
                rxDialogSureCenterLeft.setSureListener(v1 -> {
                    rxDialogSureCenterLeft.cancel();
                });
                break;
            //????????????
            case R.id.btn_dialog_buttons:
                DialogButtons dialogButtons = new DialogButtons(this, Gravity.TOP);
                dialogButtons.setTitle("??????");
                dialogButtons.setContent("??????????????????");
                dialogButtons.setLogo(R.mipmap.icon_toast_tips);
                dialogButtons.setImg(getResources().getDrawable(R.mipmap.icon_toast_tips), DialogUtils.IMG_LEFT);
                dialogButtons.show();
                dialogButtons.setCancelListener(v13 -> {
                    dialogButtons.cancel();
                });
                dialogButtons.setSureListener(v14 -> {
                    dialogButtons.cancel();
                });
                break;
            //??????
            case R.id.btn_dialog_edt:
                DialogEdit dialogEdit = new DialogEdit(this, Gravity.TOP);
                dialogEdit.setTitle("Test");
                dialogEdit.show();
                dialogEdit.setViewMarginTop(50);
                dialogEdit.setSureListener(v12 -> {
                    dialogEdit.cancel();
                    ToastUtil.showMsg(this, dialogEdit.getEditText().getText().toString());
                });
                dialogEdit.setCancelListener(v15 -> dialogEdit.cancel());
                break;
            //????????????
            case R.id.btn_dialog_edt_more:
                DialogEditMore dialogEditMore = new DialogEditMore(this, Gravity.TOP);
                dialogEditMore.setTitle("??????EditText");
                dialogEditMore.show();
                List<DialogEditMoreModel> dialogEditMoreModels = new ArrayList<>();

                DialogEditMoreModel dialogEditMoreModel = new DialogEditMoreModel("??????1", "111", false);
                dialogEditMoreModels.add(dialogEditMoreModel);

                DialogEditMoreModel dialogEditMoreMode2 = new DialogEditMoreModel("??????2", "222", false);
                dialogEditMoreModels.add(dialogEditMoreMode2);

                DialogEditMoreModel dialogEditMoreMode3 = new DialogEditMoreModel("??????3", "333", false);
                dialogEditMoreModels.add(dialogEditMoreMode3);

                DialogEditMoreModel dialogEditMoreMode4 = new DialogEditMoreModel("??????4", "444", false);
                dialogEditMoreModels.add(dialogEditMoreMode4);

                dialogEditMore.setData(dialogEditMoreModels);

                dialogEditMore.setSureListener(v16 -> {
                    StringBuilder value = new StringBuilder();

                    for (DialogEditMoreModel i : dialogEditMoreModels)
                    {
                        value.append(i.getKey()).append(":").append(i.getValue()).append("  ").append("\n");
                    }
                    ToastUtil.showMsg(this, value.toString());

                });
                dialogEditMore.setCancelListener(v17 -> {
                    dialogEditMore.cancel();
                });
                break;
            default:
                break;
        }
    }
}
