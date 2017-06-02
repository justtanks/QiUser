package com.qcc.qiuser.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.support.v4.content.FileProvider;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.qcc.qiuser.Base.BaseActivity;
import com.qcc.qiuser.Base.BaseData;
import com.qcc.qiuser.Bean.Regist_phoneback;
import com.qcc.qiuser.R;
import com.qcc.qiuser.Util.NetUtils;
import com.qcc.qiuser.databinding.ActivityRegistBinding;

import org.xutils.common.Callback;

import java.util.HashMap;
import java.util.Map;

//注册界面
public class RegistActivity extends BaseActivity implements View.OnClickListener {
    ActivityRegistBinding b;
    Map<String, Boolean> isEnable = new HashMap<>();
    Gson gson = new Gson();
    int yanzheng;
    String userphone;
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = DataBindingUtil.setContentView(this, R.layout.activity_regist);
        init();
    }

    private void init() {
        isEnable.put("username", false);
        isEnable.put("userpass", false);
        isEnable.put("yanzheng", false);
        b.registPhone.addTextChangedListener(new PhoneWatcher());
        b.registPass.addTextChangedListener(new PWatcher());
        b.registYanzheng.addTextChangedListener(new YanZheng());
        b.registGetyanzheng.setOnClickListener(this);
        b.registBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.regist_getyanzheng:
                getTextOnNet();
                break;
            case R.id.regist_bt:
                registOnNet();
                break;
        }
    }


    private class PhoneWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String text = b.registPhone.getText().toString();
            if (!"".equals(text)) {
                isEnable.put("username", true);
            } else {
                isEnable.put("username", false);
            }
            judge();
        }
    }

    private class PWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String text = b.registPass.getText().toString();
            if (!"".equals(text)) {
                isEnable.put("userpass", true);
            } else {
                isEnable.put("userpass", false);
            }
            judge();

        }
    }

    //请求访问网络返回验证码
    private void getTextOnNet() {
        final String phone = b.registPhone.getText().toString();
        if ("".equals(phone)) {
            toast("请输入手机号");
            return;
        }
        b.registGetyanzheng.setClickable(false);
        handler.post(runnable);
        Map<String, String> apends = new HashMap<>();
        apends.put("agent_tel", phone);
        NetUtils.Get(BaseData.DUANXINYANZHENG, apends, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Regist_phoneback phoneMsg = gson.fromJson(result, Regist_phoneback.class);
                yanzheng = Integer.parseInt(phoneMsg.getMsg());
                loge(yanzheng+"返回的验证码");
                userphone = phone;
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                toast(getString(R.string.net_error));

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private class YanZheng implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String text = b.registYanzheng.getText().toString();
            if (!"".equals(text)) {
                isEnable.put("yanzheng", true);
            } else {
                isEnable.put("yanzheng", false);
            }
            judge();
        }
    }

    private void judge() {
        if (isEnable.get("username") && isEnable.get("userpass") && isEnable.get("yanzheng")) {
            b.registBt.setImageDrawable(getResources().getDrawable(R.mipmap.regsit_btyes));
            b.registBt.setEnabled(true);
        } else {
            b.registBt.setImageDrawable(getResources().getDrawable(R.mipmap.regsit_btnot));
            b.registBt.setEnabled(false);
        }
    }

    private int beginTime = 30;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    b.registGetyanzheng.setText("请等待" + "(" + beginTime + ")");
                    break;
                case 2:
                    beginTime = 30;
                    b.registGetyanzheng.setClickable(true);
                    b.registGetyanzheng.setText(R.string.getyanzheng);
                    break;
            }
        }
    };
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            handler.sendEmptyMessage(1);
            if (beginTime > 0) {
                beginTime--;
                handler.postDelayed(runnable, 1000);
            } else {
                handler.sendEmptyMessage(2);
            }
        }
    };

    //服务器进行注册
    private void registOnNet() {
         String yanzhengStr = b.registYanzheng.getText().toString();
        if (yanzhengStr.equals("")) {
            toast("请输入验证码");
            return;
        }
        int yanzhengma = Integer.parseInt(yanzhengStr);
        if (yanzhengma != yanzheng) {
            toast("验证码错误,请重新输入");
            return;
        }
        mProgressDialog = ProgressDialog.show(this, "", "正在进行注册");
        mProgressDialog.show();
        Map<String, Object> param = new HashMap<>();
        param.put("user", b.registPhone.getText());
        param.put("password", b.registPass.getText());
        NetUtils.Post(BaseData.USERREGIST, param, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Regist_phoneback back = new Gson().fromJson(result, Regist_phoneback.class);
                if ("Success".equals(back.getFlag())) {
                    startActivity(new Intent(RegistActivity.this, LoginActivity.class));
                } else {
                    toast(back.getMsg());
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                toast("注册失败，请检查网络后重试");

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                mProgressDialog.dismiss();
            }
        });
    }

}
