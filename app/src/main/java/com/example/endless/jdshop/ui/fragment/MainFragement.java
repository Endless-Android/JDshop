package com.example.endless.jdshop.ui.fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.endless.jdshop.R;
import com.example.endless.jdshop.base.BaseFragment;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/6/7.
 */

public class MainFragement extends BaseFragment {


    @BindView(R.id.iv_scanner)
    ImageView mIvScanner;
    @BindView(R.id.edt_search_text)
    EditText mEdtSearchText;
    @BindView(R.id.img_search_voice)
    ImageView mImgSearchVoice;
    @BindView(R.id.iv_message)
    ImageView mIvMessage;
    @BindView(R.id.home_rv)
    XRecyclerView mHomeRv;
    Unbinder unbinder;
    private ImageButton homeCategeoy01;
    private ImageButton homeCategeoy02;
    private ImageButton homeCategeoy03;
    private ImageButton homeCategeoy04;
    private ImageButton homeCategeoy05;
    private TextView tv_time;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_main;
    }


    @Override
    public void initView(View view) {
        unbinder = ButterKnife.bind(this, view);
        View head = View.inflate(getActivity(),R.layout.rv_header_home,null);
        homeCategeoy01 = (ImageButton) view.findViewById(R.id.home_categeoy01);
        homeCategeoy02 = (ImageButton) view.findViewById(R.id.home_categeoy02);
        homeCategeoy03 = (ImageButton) view.findViewById(R.id.home_categeoy03);
        homeCategeoy04 = (ImageButton) view.findViewById(R.id.home_categeoy04);
        homeCategeoy05 = (ImageButton) view.findViewById(R.id.home_categeoy05);
        tv_time = (TextView) view.findViewById(R.id.home_tv_time);
        mHomeRv.addHeaderView(head);

        List<String> list = new ArrayList<>();
        list.add("蓝瘦香菇");
        list.add("历害了我的哥");
        list.add("友谊的小船");
        list.add("不明真相的吃瓜群众");

        ViewFlipper vf = (ViewFlipper) head.findViewById(R.id.home_vf);
        for (String bean : list) {
            TextView textView = new TextView(getActivity());
            textView.setGravity(Gravity.CENTER);
            textView.setText(bean);
            textView.setTextSize(16);
            textView.setTextColor(Color.BLACK);
            vf.addView(textView);
        }
        vf.startFlipping();
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
