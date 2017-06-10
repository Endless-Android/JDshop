package com.example.endless.jdshop.ui.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.endless.jdshop.R;
import com.example.endless.jdshop.adapter.MyFragmentAdapter;
import com.example.endless.jdshop.base.BaseActivity;
import com.example.endless.jdshop.ui.fragment.DiscoverFragment;
import com.example.endless.jdshop.ui.fragment.MainFragement;
import com.example.endless.jdshop.ui.fragment.MyFragment;
import com.example.endless.jdshop.ui.fragment.ShoppingCartFragment;
import com.example.endless.jdshop.ui.fragment.ShortFragment;
import com.example.endless.jdshop.ui.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.rb_home)
    RadioButton mRbHome;
    @BindView(R.id.rb_short)
    RadioButton mRbShort;
    @BindView(R.id.rb_discover)
    RadioButton mRbDiscover;
    @BindView(R.id.rb_shopping_cart)
    RadioButton mRbShoppingCart;
    @BindView(R.id.rb_my)
    RadioButton mRbMy;
    @BindView(R.id.rg_main)
    RadioGroup mRgMain;
    @BindView(R.id.my_viewpager)
    NoScrollViewPager mMyViewpager;
    private MyFragmentAdapter mAdapter;
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private int mPagerPos = 0;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(View view) {
        ButterKnife.bind(this);
        mRbHome.setChecked(true);   //默认选中第一个
        initViewPager();
        initListener();
    }

    private void initListener() {
        mRgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        mPagerPos = 0;
                        break;
                    case R.id.rb_short:
                        mPagerPos = 1;
                        break;
                    case R.id.rb_discover:
                        mPagerPos = 2;
                        break;
                    case R.id.rb_shopping_cart:
                        mPagerPos = 3;
                        break;
                    case R.id.rb_my:
                        mPagerPos = 4;
                        break;
                }
                mMyViewpager.setCurrentItem(mPagerPos, false);
            }
        });


    }

    private void initViewPager() {
        mFragmentList.add(new MainFragement());
        mFragmentList.add(new DiscoverFragment());
        mFragmentList.add(new MyFragment());
        mFragmentList.add(new ShortFragment());
        mFragmentList.add(new ShoppingCartFragment());
        mAdapter = new MyFragmentAdapter(getSupportFragmentManager(), mFragmentList);
        mMyViewpager.setAdapter(mAdapter);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
