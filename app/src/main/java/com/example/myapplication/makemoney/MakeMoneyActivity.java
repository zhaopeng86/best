package com.example.myapplication.makemoney;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.example.myapplication.BaseActivity;
import com.example.myapplication.DetailActivity;
import com.example.myapplication.ListInfoActivity;
import com.example.myapplication.R;
import com.example.myapplication.UpDateView;
import com.example.myapplication.entity.AdItem;
import com.example.myapplication.entity.GameItemBean;
import com.example.myapplication.entity.PromoteEntity;
import com.example.myapplication.listview.AdvideoAdapter;
import com.example.myapplication.listview.GamelistAdapter;
import com.example.myapplication.listview.ListInferAdapter;
import com.example.myapplication.utils.HttpUtil;
import com.example.myapplication.utils.ParseManager;
import com.example.myapplication.utils.UrlUtils;

import java.io.IOException;
import java.util.LinkedList;

import okhttp3.Call;
import okhttp3.Response;

public class MakeMoneyActivity extends BaseActivity implements View.OnClickListener, UpDateView {
    ViewGroup linearLayoutAll;
    ViewPager viewPager;
    ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        linearLayoutAll= (ViewGroup) getLayoutInflater().inflate(R.layout.makemoney,null);
        setContentView(linearLayoutAll);

        HttpUtil.sendRequestAsynchronous(UrlUtils.App_Get_Game_list, new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ParseManager.parseJsonWithListJsonObject(response, MakeMoneyActivity.this);
            }
        });

        inittabBar();
        initViewPage();


    }
    public void inittabBar(){
        TextView textView = findViewById(R.id.ll_include).findViewById(R.id.textView5);
        textView.setText("游戏");
        TextView textView2 = findViewById(R.id.ll_include2).findViewById(R.id.textView5);
        textView2.setText("看视频");
        TextView textView3 = findViewById(R.id.ll_include3).findViewById(R.id.textView5);
        textView3.setText("购物");
        TextView textView4 = findViewById(R.id.ll_include4).findViewById(R.id.textView5);
        textView4.setText("我的");
        findViewById(R.id.ll_include).setOnClickListener(this);
        findViewById(R.id.ll_include2).setOnClickListener(this);
        findViewById(R.id.ll_include3).setOnClickListener(this);
        findViewById(R.id.ll_include4).setOnClickListener(this);
    }

    public void initViewPage(){
        viewPager=findViewById(R.id.viewpage);
        LinkedList list= new LinkedList();
        list.add(getLayoutInflater().inflate(R.layout.mingame,null));
        list.add(getLayoutInflater().inflate(R.layout.advideo,null));
        list.add(getLayoutInflater().inflate(R.layout.payment,null));
        list.add(getLayoutInflater().inflate(R.layout.setting,null));
        MoneyPageAdapter moneyPageAdapter=new MoneyPageAdapter(list);
        viewPager.setAdapter(moneyPageAdapter);
        listView=((ViewGroup)list.get(0)).findViewById(R.id.gamelist);
        GameItemBean []gameItemBean={ new GameItemBean("","1212"), new GameItemBean("","232"),new GameItemBean("","3342"),new GameItemBean("","3342"),new GameItemBean("","3342"),new GameItemBean("","3342"),new GameItemBean("","3342"),new GameItemBean("","3342"),new GameItemBean("","3342"),new GameItemBean("","3342")};
        GamelistAdapter gamelistAdapter=new GamelistAdapter(this,gameItemBean);
        listView.setAdapter(gamelistAdapter);
        ListView listView2=((ViewGroup)list.get(1)).findViewById(R.id.advideo);
        AdItem[]gameItemBean2={ new AdItem("看广告赚金币","看广告直接零钱，今天还剩8次","5000最高"),new AdItem("今天看10个广告领奖","以观看4个","200"),new AdItem("看广告赚金币","看广告直接零钱，今天还剩8次","100"),new AdItem("看广告赚金币","看广告直接零钱，今天还剩8次","5000最高"),new AdItem("看广告赚金币","看广告直接零钱，今天还剩8次","5000最高"),new AdItem("看广告赚金币","看广告直接零钱，今天还剩8次","5000最高"),new AdItem("看广告赚金币","看广告直接零钱，今天还剩8次","5000最高"),new AdItem("看广告赚金币","看广告直接零钱，今天还剩8次","5000最高"),new AdItem("看广告赚金币","看广告直接零钱，今天还剩8次","5000最高"),new AdItem("看广告赚金币","看广告直接零钱，今天还剩8次","5000最高"),new AdItem("看广告赚金币","看广告直接零钱，今天还剩8次","5000最高"),new AdItem("看广告赚金币","看广告直接零钱，今天还剩8次","5000最高") };
        AdvideoAdapter gamelistAdapter2=new AdvideoAdapter(this,gameItemBean2);
        listView2.setAdapter(gamelistAdapter2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_include:
                viewPager.setCurrentItem(0);
                break;
            case R.id.ll_include2:
                viewPager.setCurrentItem(1);
                break;
            case R.id.ll_include3:
                viewPager.setCurrentItem(2);
                break;
            case R.id.ll_include4:
                viewPager.setCurrentItem(3);
                break;
        }
    }

    @Override
    public void updateView(Object ob) {
        GameItemBean[] userInfers = (GameItemBean[]) ob;
        GamelistAdapter listInformAdapter = new GamelistAdapter(this, (GameItemBean[]) userInfers);
        listView.setAdapter(listInformAdapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent=new Intent(MakeMoneyActivity.this, GameDetailsActivity.class);
            intent.putExtra("url", userInfers[position].getClickUrl());
            startActivity(intent);
        });
    }
}
