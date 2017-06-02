package com.qcc.qiuser.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.qcc.qiuser.databinding.ActivityLoginBinding;

import org.xutils.common.Callback;

import java.util.HashMap;
import java.util.Map;

//登录界面
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    ActivityLoginBinding b;
    Map<String, Boolean> isEnable = new HashMap<>();
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = DataBindingUtil.setContentView(this, R.layout.activity_login);
        init();
    }

    private void init() {
        b.loginRegist.setOnClickListener(this);
        b.loginBt.setOnClickListener(this);
        b.loginUsername.addTextChangedListener(new NameWatcher());
        b.loginUserpass.addTextChangedListener(new PWatcher());
        isEnable.put("name", false);
        isEnable.put("pass", false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_regist:
                Intent intent = new Intent(this, RegistActivity.class);
                startActivity(intent);
                break;
            case R.id.login_bt:
                loginOnNet();
                break;
        }
    }

    //进行登录操作
    private void loginOnNet() {
        mProgressDialog = ProgressDialog.show(this, "", "正在登陆。。。");
        mProgressDialog.show();
        Map<String, Object> param = new HashMap<>();
        param.put("user", b.loginUsername.getText());
        param.put("password", b.loginUserpass.getText());
        NetUtils.Post(BaseData.USERlOGIN, param, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Regist_phoneback back = new Gson().fromJson(result, Regist_phoneback.class);
                if ("Success".equals(back.getFlag())) {
                    toast("登录成功");
                }else{
                    toast(back.getMsg());
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                loge(ex.getMessage());
                toast("登录失败");
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

    class NameWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String text = b.loginUsername.getText().toString();
            if (null != text && !"".equals(text)) {
                isEnable.put("name", true);
            } else {
                isEnable.put("name", false);
            }
            judge();
        }
    }

    class PWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String text = b.loginUserpass.getText().toString();
            if (null != text && !"".equals(text)) {
                isEnable.put("pass", true);
            } else {
                isEnable.put("pass", false);
            }
            judge();

        }
    }

    //设置点击按钮可以点击 及变化颜色
    private void judge() {
        if (isEnable.get("name") && isEnable.get("pass")) {
            b.loginBt.setImageDrawable(getResources().getDrawable(R.mipmap.login_bt_yes));
            b.loginBt.setEnabled(true);
        } else {
            b.loginBt.setImageDrawable(getResources().getDrawable(R.mipmap.login_bt_no));
            b.loginBt.setEnabled(false);
        }
    }
}
