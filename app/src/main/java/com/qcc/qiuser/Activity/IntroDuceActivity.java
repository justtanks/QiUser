package com.qcc.qiuser.Activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;


import com.qcc.qiuser.Fragment.Intro1Fragment;
import com.qcc.qiuser.Fragment.Intro2Fragment;
import com.qcc.qiuser.Fragment.Intro3Fragment;
import com.qcc.qiuser.R;
import com.qcc.qiuser.Util.SystemSetting;
import com.qcc.qiuser.databinding.ActivityIntroDuceBinding;

import java.util.ArrayList;

//产品介绍界面
public class IntroDuceActivity extends AppCompatActivity {
    ActivityIntroDuceBinding b;
    private ArrayList<Fragment> mList = new ArrayList<>();
    Intro1Fragment mIntro1Fragment = new Intro1Fragment();
    Intro2Fragment mIntro2Fragment = new Intro2Fragment();
    Intro3Fragment mIntro3Fragment = new Intro3Fragment();
    SystemSetting su=new SystemSetting(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isFirstLogin();
        setStates();
        b = DataBindingUtil.setContentView(this, R.layout.activity_intro_duce);
        init();
    }

    private void init() {
        mList.add(mIntro1Fragment);
        mList.add(mIntro2Fragment);
        mList.add(mIntro3Fragment);
        b.introVp.setCurrentItem(0);
        b.introVp.setOffscreenPageLimit(3);
        b.introVp.setAdapter(new com.qcc.qiuser.Adapter.FragmentPagerAdapter(getSupportFragmentManager(), mList));
    }

    //判断是否是第一次进行登录，然后进行登录操作
    public void isFirstLogin() {
        if(su.isFirstLogin()){
            su.saveFirstLog(false);
        }else{
            Intent intent=new Intent(this,WellcomeActivity.class);
            startActivity(intent);
            finish();
        }
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
