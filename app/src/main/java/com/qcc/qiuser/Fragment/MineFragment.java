package com.qcc.qiuser.Fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qcc.qiuser.Activity.kotlinActivity.FankuiActivity;
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
        //跳转到意见反馈界面
        b.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(getActivity(), FankuiActivity.class));
            }
        });

    }

}
