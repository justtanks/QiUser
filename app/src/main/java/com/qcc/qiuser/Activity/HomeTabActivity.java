package com.qcc.qiuser.Activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.qcc.qiuser.Adapter.FragmentPagerAdapter;
import com.qcc.qiuser.Base.BaseActivity;
import com.qcc.qiuser.Fragment.HomeFragment;
import com.qcc.qiuser.Fragment.MineFragment;
import com.qcc.qiuser.Fragment.UtilsFragment;
import com.qcc.qiuser.Fragment.WaitersFragment;
import com.qcc.qiuser.R;
import com.qcc.qiuser.Util.BottomNavigationViewHelper;
import com.qcc.qiuser.databinding.ActivityHomeTabBinding;

import java.util.ArrayList;

//首页的底部带有tab的activity
public class HomeTabActivity extends BaseActivity implements ViewPager.OnPageChangeListener{
    ActivityHomeTabBinding b;
    private ArrayList<Fragment> mList=new ArrayList<>();
    HomeFragment mHomeFragment=new HomeFragment();
    UtilsFragment mUtilsFragment=new UtilsFragment();
    MineFragment mMineFragment =new MineFragment();
    WaitersFragment mWaitersFragment=new WaitersFragment();
    MenuItem prevMenuItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = DataBindingUtil.setContentView(this, R.layout.activity_home_tab);
        BottomNavigationViewHelper.disableShiftMode(b.homeNavigation);
        b.homeNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initAdapter();
    }

    private void initAdapter(){
        mList.add(mHomeFragment);
        mList.add(mWaitersFragment);
        mList.add(mUtilsFragment);
        mList.add(mMineFragment);
        b.homeVp.setCurrentItem(0);
        b.homeVp.setOffscreenPageLimit(3);
        b.homeVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(), mList));//解决fragment嵌套问题
        b.homeVp.addOnPageChangeListener(this);
    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    b.homeVp.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    b.homeVp.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    b.homeVp.setCurrentItem(2);
                    return true;
                case R.id.navigation_mine:
                    b.homeVp.setCurrentItem(3);
                    return true;
            }
            return false;
        }

    };

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (prevMenuItem != null) {
            prevMenuItem.setChecked(false);
        } else {
            b.homeNavigation.getMenu().getItem(0).setChecked(false);
        }
        b.homeNavigation.getMenu().getItem(position).setChecked(true);
        prevMenuItem =  b.homeNavigation.getMenu().getItem(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
