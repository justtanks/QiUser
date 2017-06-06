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
import com.qcc.qiuser.Activity.WaiterActivity;
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
 * 代理人综合排序的frament  按照综合进行排序
 */
public class ZhongHeFragment extends BaseFragment {
    ListView lv;
    HomeTabActivity activity;
    List<WaitersBean.DataBean.personDataBean> datas = new ArrayList<>();
    ListAdapter<WaitersBean.DataBean.personDataBean> adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_waiter, container, false);
        init(view);
        return view;
    }

    private void init(View v) {
        EventBus.getDefault().register(this);
        lv = (ListView) v.findViewById(R.id.waiter_lv);
        activity = (HomeTabActivity) getActivity();

        adapter = new ListAdapter<>(activity, datas, BR.waitersdata, R.layout.item_waiter_lv);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(activity, WaiterActivity.class);
                if(datas!=null&&datas.size()!=0){
                    intent.putExtra("waiterdata",datas.get(position) );
                }
                startActivity(intent);
            }
        });
    }

    @Subscribe
    public void onMessageEvent(WaitersBean event) {
        datas = event.getData().get(0).getZonghe();
        adapter.setDatas(datas);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
