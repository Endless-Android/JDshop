package com.example.endless.jdshop.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2017/6/7.
 */

public abstract class BaseActivity extends AppCompatActivity implements IUIOperation {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        initView(view);
    }
}
