package com.qcc.qiuser.Fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qcc.qiuser.Base.BaseFragment;
import com.qcc.qiuser.R;
import com.qcc.qiuser.databinding.FragmentWaitersBinding;

/**
 * Created by Administrator on 2017/5/4.
 * 首页显示代理人的界面
 */

public class WaitersFragment extends BaseFragment {
    FragmentWaitersBinding b;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        b= DataBindingUtil.inflate(inflater, R.layout.fragment_waiters,container,false);
        return b.getRoot();
    }
}
