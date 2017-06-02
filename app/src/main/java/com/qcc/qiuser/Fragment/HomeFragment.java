package com.qcc.qiuser.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.qcc.qiuser.Activity.LoginActivity;
import com.qcc.qiuser.Activity.WaiterActivity;
import com.qcc.qiuser.Activity.TanTanActivity;
import com.qcc.qiuser.Base.BaseFragment;
import com.qcc.qiuser.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/*
   首页fragments
 */

@ContentView(R.layout.fragment_home)
public class HomeFragment extends BaseFragment implements TextView.OnEditorActionListener ,View.OnClickListener{
//    @ViewInject(R.id.home_search_edit)
//    private EditText msearchText;
    @ViewInject(R.id.fragment_home_head)
    private ImageView mheadImg;
    @ViewInject(R.id.home_msgbt)
    private ImageView mmsgImg;
    @ViewInject(R.id.home_search_before)
    private ImageView msearchBefore;
    @ViewInject(R.id.home_img_reg)
    private ImageView  mregis;
    @ViewInject(R.id.home_img_buy)
    private ImageView mbuy;
    @ViewInject(R.id.home_world_reg)
    private ImageView mworldRig;
    @ViewInject(R.id.home_img_search)
    private ImageView msearch;
    @ViewInject(R.id.home_img_name)
    private ImageView mname;
    @ViewInject(R.id.home_img_fenlei)
    private ImageView mfenlei;
    @ViewInject(R.id.home_img_jindu)
    private ImageView mregSearch;
    @ViewInject(R.id.home_showimg)
    private ImageView mShow;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initview();
    }
    private void initview() {
//        msearchText.setOnEditorActionListener(this);
        mheadImg.setOnClickListener(this);
        mbuy.setOnClickListener(this);
        mfenlei.setOnClickListener(this);
        mheadImg.setOnClickListener(this);
        mmsgImg.setOnClickListener(this);
        mname.setOnClickListener(this);
        mregis.setOnClickListener(this);
        mregSearch.setOnClickListener(this);
        msearchBefore.setOnClickListener(this);
        mworldRig.setOnClickListener(this);
        msearch.setOnClickListener(this);
        mShow.setOnClickListener(this);

    }

/*
   点击搜索之后操作
 */
    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == EditorInfo.IME_ACTION_SEARCH) {
            //收起软键盘
            InputMethodManager im = (InputMethodManager)getActivity().getSystemService(getContext().INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(getActivity().getCurrentFocus().getApplicationWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);


        return true;
        }
        return false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.home_search_before:
                Toast.makeText(getContext(), "前查询", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getActivity(), WaiterActivity.class);
                startActivity(intent);
                break;
            case R.id.home_img_reg:
                Toast.makeText(getContext(), "注册", Toast.LENGTH_SHORT).show();
                Intent intent1=new Intent(getActivity(), TanTanActivity.class);
                startActivity(intent1);
                break;
            case R.id.home_img_buy:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            case R.id.home_world_reg:
                Toast.makeText(getContext(), "国际注册", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_img_search:
                Toast.makeText(getContext(), "商标查询", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_img_fenlei:
                Toast.makeText(getContext(), "分类", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_img_name:
                Toast.makeText(getContext(), "命名", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_img_jindu:
                Toast.makeText(getContext(), "进度", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fragment_home_head:
                Toast.makeText(getContext(), "头像", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_msgbt:
                Toast.makeText(getContext(), "头像", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_showimg:
                Toast.makeText(getContext(), "图片仅作为展示，不可点击", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;

    }
    }
}
