package com.qcc.qiuser.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.qcc.qiuser.R;
//首页欢迎界面
public class WellcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStates();
        setContentView(R.layout.activity_wellcome);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toLogin();
                WellcomeActivity.this.finish();
            }
        }, 1000);
    }
    Handler mHandler=new Handler();
    private void toLogin(){
        Intent intent=new Intent(this,HomeTabActivity.class);
        startActivity(intent);
    }
    //设置全屏展示
    private void setStates(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }
}
