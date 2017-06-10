package com.example.endless.jdshop.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.endless.jdshop.R;
import com.example.endless.jdshop.adapter.GuideAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/6/7.
 */

public class GuideActivity extends AppCompatActivity {
    private static final int IMAGE_GUIDS[] = {R.mipmap.guide_1, R.mipmap.guide_2, R.mipmap.guide_3};
    @BindView(R.id.vp_guide)
    ViewPager mVpGuide;
    @BindView(R.id.btn_start)
    Button mBtnStart;
    @BindView(R.id.ll_dot)
    LinearLayout mLlDot;
    @BindView(R.id.iv_dot)
    ImageView mIvDot;
    @BindView(R.id.fl_dot)
    FrameLayout mFlDot;
    private List<ImageView> imags = new ArrayList<ImageView>();
    private int mMax_Left;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        initView();
        initDate();

        initEven(); //初始化事件

    }

    private void initEven() {

        //小圆点的滑动
        mVpGuide.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                // i1:具体滑动的像素
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) mIvDot.getLayoutParams();
                params.leftMargin = (int) (mMax_Left * (i + v));
                mIvDot.setLayoutParams(params);

            }

            // 这个方法会被调用当滑到一个新的页面
            // position：新页面的位置
            @Override
            public void onPageSelected(int position) {
                // 滑到最后一页，显示按钮，其他隐藏
                if (position == imags.size() - 1) {
                    mBtnStart.setVisibility(View.VISIBLE);
                    mFlDot.setVisibility(View.GONE);
                } else {
                    mBtnStart.setVisibility(View.GONE);
                    mFlDot.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });

        //页面的跳转
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private void initDate() {
        for (int i = 0; i < IMAGE_GUIDS.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(IMAGE_GUIDS[i]);
            imags.add(imageView);
        }

        Log.e("aaaaa", "initDate: "+imags.size());
        mVpGuide.setAdapter(new GuideAdapter(imags));
        mMax_Left = mLlDot.getChildAt(1).getLeft() - mLlDot.getChildAt(0).getLeft();
        mIvDot.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //当iv_dot这个View可见 或者数已经形成
                mMax_Left = mLlDot.getChildAt(1).getLeft() - mLlDot.getChildAt(0).getLeft();
                //使用完之后必须要移除掉，不然影响性能
                mIvDot.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });


    }

    private void initView() {

        mBtnStart.setVisibility(View.GONE);
    }


}
