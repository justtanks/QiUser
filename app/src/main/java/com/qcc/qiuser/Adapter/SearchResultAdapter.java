package com.qcc.qiuser.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qcc.qiuser.Base.BaseData;
import com.qcc.qiuser.Bean.SearchResultBean;
import com.qcc.qiuser.R;
import com.qcc.qiuser.Util.SystemSetting;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/4.
 */

public class SearchResultAdapter extends BaseAdapter {
    private List< SearchResultBean.ResultBean.DataBean> mDataBeens =new ArrayList<>();
    private LayoutInflater mInflater;
    private Context mContext;
    private SystemSetting st;
    public SearchResultAdapter (List< SearchResultBean.ResultBean.DataBean> mDataBeens,Context mContext){
     this.mContext=mContext;
        this.mDataBeens=mDataBeens;
        this.mInflater=LayoutInflater.from(mContext);
        this.st=new SystemSetting(mContext);
    }
    public void setDataBeens(List< SearchResultBean.ResultBean.DataBean> mDataBeens){
        this.mDataBeens=mDataBeens;
    }
    @Override
    public int getCount() {
        if(mDataBeens==null)
            return 0;
        return mDataBeens.size();
    }


    public Object getItem(int position) {
        return mDataBeens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder=new ViewHolder();
            convertView=mInflater.inflate(R.layout.item_searchlv,null);
            holder.headimg= (ImageView) convertView.findViewById(R.id.item_search_head);
            holder.sbname= (TextView) convertView.findViewById(R.id.item_search_title);
            holder.zhucehao= (TextView) convertView.findViewById(R.id.item_search_zhucehao);
            holder.shenqingren= (TextView) convertView.findViewById(R.id.item_search_user);
            holder.zhuangtai= (TextView) convertView.findViewById(R.id.item_search_result);
            holder.leibie= (TextView) convertView.findViewById(R.id.search_leibie);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        x.image().bind(holder.headimg, BaseData.IMGPRO+mDataBeens.get(position).getTmImg());
        holder.leibie.setText("第"+mDataBeens.get(position).getIntCls()+"类");
        holder.sbname.setText(mDataBeens.get(position).getTmName());
        holder.zhuangtai.setText(mDataBeens.get(position).getCurrentStatus());
        holder.shenqingren.setText(mDataBeens.get(position).getApplicantCn());
        holder.zhucehao.setText(mDataBeens.get(position).getRegNo());
        return convertView;
    }

    class ViewHolder{
        ImageView headimg;
        TextView  sbname;
        TextView  zhucehao;
        TextView shenqingren;
        TextView leibie;
        TextView zhuangtai;
    }

}
