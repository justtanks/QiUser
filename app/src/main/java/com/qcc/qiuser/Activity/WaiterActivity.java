package com.qcc.qiuser.Activity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.qcc.qiuser.Base.BaseActivity;
import com.qcc.qiuser.R;

import org.w3c.dom.Text;

/**
 * Created by Administrator on 2017/5/8.
 */

public class WaiterActivity extends BaseActivity {
    LinearLayout content;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiter);
        content= (LinearLayout) this.findViewById(R.id.waiter_judgecontainer);
        for(int i=0;i<10;i++){
            init();
        }
    }
    private void init(){
        View view=getLayoutInflater().inflate(R.layout.item_waiter_judge,content,false);
        TextView name= (TextView) view.findViewById(R.id.judge_name);
        TextView judge= (TextView) view.findViewById(R.id.judge_content);
        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.judge_start);
        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(getResources().getColor(R.color.maincolor), PorterDuff.Mode.SRC_ATOP);  //设置星星颜色
        name.setText("小红红");
        judge.setText("是傻逼'");
        content.addView(view);
    }
}
