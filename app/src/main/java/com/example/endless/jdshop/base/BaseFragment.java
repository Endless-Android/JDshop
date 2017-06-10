package com.example.endless.jdshop.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/6/7.
 */

public abstract class BaseFragment extends Fragment implements IUIOperation{

    private View view ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view == null){

            view = inflater.inflate(getLayoutRes(),null);
        }
        initView(view);

        return view;
    }


}
