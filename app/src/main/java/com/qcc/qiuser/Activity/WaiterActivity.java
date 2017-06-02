package com.qcc.qiuser.Activity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.qcc.qiuser.Base.BaseActivity;
import com.qcc.qiuser.Fragment.MineFragment;
import com.qcc.qiuser.R;
import com.qcc.qiuser.View.ItemContainer;

import org.w3c.dom.Text;

/**
 * Created by Administrator on 2017/5/8.
 */

public class WaiterActivity extends BaseActivity {
    LinearLayout content;
    ItemContainer mItemContainer;
    ProgressBar haoping,zhongping,chaping;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiter);
        content = (LinearLayout) this.findViewById(R.id.waiter_judgecontainer);
        mItemContainer = (ItemContainer) findViewById(R.id.waiter_bestarea);
        chaping= (ProgressBar) findViewById(R.id.waiter_chapin_progress);
        for (int i = 0; i < 10; i++) {
            init();
            initBestArea();
        }

    }

    private void init() {
        View view = getLayoutInflater().inflate(R.layout.item_waiter_judge, content, false);
        TextView name = (TextView) view.findViewById(R.id.judge_name);
        TextView judge = (TextView) view.findViewById(R.id.judge_content);
        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.judge_start);
        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(getResources().getColor(R.color.maincolor), PorterDuff.Mode.SRC_ATOP);  //设置星星颜色
        name.setText("小红红");
        judge.setText("是傻逼'");
        content.addView(view);
    }
    //初始化所有擅长领域的button
    private void initBestArea(){
        Button button = new Button(getApplicationContext());
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT
                , 0);
        button.setLayoutParams(params);
        button.setBackgroundResource(R.mipmap.waiter_btback);
        button.setText("擅长挖掘机");
        button.setGravity(Gravity.CENTER);
        button.setTextSize(8);
        button.setTextColor(getResources().getColor(R.color.bestareatextcolor));
        mItemContainer.addView(button);
    }
}
