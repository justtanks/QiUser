package com.qcc.qiuser.Fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.qcc.qiuser.Base.BaseData;
import com.qcc.qiuser.Base.BaseFragment;
import com.qcc.qiuser.Bean.NetError;
import com.qcc.qiuser.Bean.WaitersBean;
import com.qcc.qiuser.R;
import com.qcc.qiuser.Util.NetUtils;
import com.qcc.qiuser.databinding.FragmentWaitersBinding;

import org.greenrobot.eventbus.EventBus;
import org.xutils.common.Callback;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/5/4.
 * 首页显示代理人的界面
 */

public class WaitersFragment extends BaseFragment {
    FragmentWaitersBinding b;
    ChengDanFragment mChengDanFragment;
    HaopingFragment mHaopingFragment;
    ZhongHeFragment mZhongHeFragment;
    FragmentTransaction transaction;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        b = DataBindingUtil.inflate(inflater, R.layout.fragment_waiters, container, false);
        init();
        setDefaultFragment();
        getDataFromNet();
        return b.getRoot();
    }

    private void init() {
        b.waitersTab1.setTextColor(getResources().getColor(R.color.titletextcolor));
        setCircle();
        b.waitersTab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = getFragmentManager().beginTransaction();
                hideFragment(transaction);
                transaction.show(mZhongHeFragment);
                transaction.commit();
                setTextColor();
                b.waitersTab1.setTextColor(getResources().getColor(R.color.titletextcolor));
            }
        });
        b.waitersTab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = getFragmentManager().beginTransaction();
                hideFragment(transaction);
                transaction.show(mHaopingFragment);
                transaction.commit();
                setTextColor();
                b.waitersTab2.setTextColor(getResources().getColor(R.color.titletextcolor));
            }
        });
        b.waitersTab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = getFragmentManager().beginTransaction();
                hideFragment(transaction);
                transaction.show(mChengDanFragment);
                transaction.commit();
                setTextColor();
                b.waitersTab3.setTextColor(getResources().getColor(R.color.titletextcolor));
            }
        });

    }

    private void setCircle() {
        b.waiterFresh.setColorSchemeResources(android.R.color.holo_blue_bright);
        b.waiterFresh.setDistanceToTriggerSync(300);
        b.waiterFresh.setSize(SwipeRefreshLayout.DEFAULT);
        b.waiterFresh.setEnabled(false);
    }

    private void setDefaultFragment() {
        transaction = getFragmentManager().beginTransaction();
        mChengDanFragment = new ChengDanFragment();
        mHaopingFragment = new HaopingFragment();
        mZhongHeFragment = new ZhongHeFragment();
        transaction.add(R.id.waiters_fl, mChengDanFragment);
        transaction.add(R.id.waiters_fl, mHaopingFragment);
        transaction.add(R.id.waiters_fl, mZhongHeFragment);
        transaction.hide(mChengDanFragment);
        transaction.hide(mHaopingFragment);
        transaction.commit();
    }

    //隐藏所有的fragment
    private void hideFragment(FragmentTransaction transaction) {
        if (mChengDanFragment != null) {
            transaction.hide(mChengDanFragment);
        }
        if (mHaopingFragment != null) {
            transaction.hide(mHaopingFragment);
        }
        if (mZhongHeFragment != null) {
            transaction.hide(mZhongHeFragment);
        }
    }

    //获取到所有代理人信息并进行发送
    public void getDataFromNet() {
        freshData();
    }

    private void freshData() {
        b.waiterFresh.setRefreshing(true);
        NetUtils.Get(BaseData.DAILILIEBIAO, new HashMap<String, String>() {
        }, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                if (result.substring(0, 18).contains("Error")) {
                    NetError err = gson.fromJson(result, NetError.class);

                } else {
                    WaitersBean bean = gson.fromJson(result, WaitersBean.class);
                    EventBus.getDefault().post(bean);


                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                b.waiterFresh.setRefreshing(false);

            }
        });
    }

    private void setTextColor() {
        b.waitersTab1.setTextColor(getResources().getColor(R.color.gray2));
        b.waitersTab2.setTextColor(getResources().getColor(R.color.gray2));
        b.waitersTab3.setTextColor(getResources().getColor(R.color.gray2));
    }
}
