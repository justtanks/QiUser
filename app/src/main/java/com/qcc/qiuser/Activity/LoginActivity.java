package com.qcc.qiuser.Activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.qcc.qiuser.Base.BaseActivity;
import com.qcc.qiuser.R;
import com.qcc.qiuser.databinding.ActivityLoginBinding;

import java.util.HashMap;
import java.util.Map;

//登录界面
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    ActivityLoginBinding b;
    Map<String, Boolean> isEnable = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = DataBindingUtil.setContentView(this, R.layout.activity_login);
        init();
    }

    private void init() {
        b.loginRegist.setOnClickListener(this);
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
        }
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
