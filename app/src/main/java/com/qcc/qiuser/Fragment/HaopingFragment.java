package com.qcc.qiuser.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


import com.qcc.qiuser.Activity.HomeTabActivity;
import com.qcc.qiuser.Adapter.simpleAdapter.ListAdapter;
import com.qcc.qiuser.BR;
import com.qcc.qiuser.Base.BaseFragment;
import com.qcc.qiuser.Bean.WaitersBean;
import com.qcc.qiuser.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 * 代理人综合排序的frament  按照好评进行分组
 */

public class HaopingFragment extends BaseFragment {
    ListView lv;
    HomeTabActivity activity;
    List<WaitersBean.DataBean.WaiterBean> datas=new ArrayList<>();
    ListAdapter<WaitersBean.DataBean.WaiterBean> adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_waiter,container,false);
        init(view);
        return view;
    }
    private void init(View v){
        EventBus.getDefault().register(this);
        lv= (ListView) v.findViewById(R.id.waiter_lv);
        activity= (HomeTabActivity) getActivity();
            adapter=new ListAdapter<>(activity,datas, BR.waitersdata,R.layout.item_waiter_lv);
            lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent=new Intent(activity, ShareWaiterActivity.class);
//                if(datas!=null&&datas.size()!=0){
//                    intent.putExtra("waiterid",datas.get(position).getId());
//                    intent.putExtra("waiterpic",datas.get(position).getWaiter_pic());
//                }
//                startActivity(intent);
            }
        });

    }
    @Subscribe
    public void onMessageEvent(WaitersBean event){
        adapter.setDatas(event.getData().get(0).getGood_say());

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
