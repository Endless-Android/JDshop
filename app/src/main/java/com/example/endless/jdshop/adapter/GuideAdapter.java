package com.example.endless.jdshop.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */

public class GuideAdapter extends PagerAdapter {
    private List<ImageView> imags = new ArrayList<ImageView>();

    public GuideAdapter(List<ImageView> list) {
        imags = list;
    }


    @Override
    public int getCount() {
        return imags.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = imags.get(position);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView((View) object);
    }
}
