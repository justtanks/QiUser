package com.qcc.qiuser.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.qcc.qiuser.R;
//通过左右滑动控制的用户选择代理人布局
public class ShowWaitersActivity extends AppCompatActivity {
   RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_waiters);
        mRecyclerView= (RecyclerView) findViewById(R.id.show_rl);
        init();
    }

    private void init() {

    }
}
