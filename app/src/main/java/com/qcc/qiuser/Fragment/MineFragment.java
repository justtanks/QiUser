package com.qcc.qiuser.Fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qcc.qiuser.Base.BaseFragment;
import com.qcc.qiuser.R;
import com.qcc.qiuser.databinding.FragmentMineBinding;

/**
 * Created by Administrator on 2017/5/4.
 * 首页显示我的界面的fragment
 */
public class MineFragment extends BaseFragment{
   FragmentMineBinding b;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        b= DataBindingUtil.inflate(inflater, R.layout.fragment_mine,container,false);
        init();
        return b.getRoot();
    }

    private void init() {
        b.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
    }
}
