package com.example.myapplication;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.example.myapplication.entity.PromoteEntity;
import com.example.myapplication.listview.ListInforAdapter;
import com.example.myapplication.utils.HttpUtil;
import com.example.myapplication.utils.UrlUtils;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Response;
public class ListInfoActivity extends AppCompatActivity {
    public ListView listView;
    SwipeRefreshLayout swipeRefreshLayout;
    PromoteEntity[] userInfors;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listinfolayout);
        listView =findViewById(R.id.list);
        swipeRefreshLayout=findViewById(R.id.swipeRefreshLayout);
        HttpUtil.sendRequestAsynchronous(UrlUtils.App_Get_Info_list, new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {}
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Utils.parseJsonWithListJsonObject(response,ListInfoActivity.this);
            }
        });
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                HttpUtil.sendRequestAsynchronous(UrlUtils.App_Get_Info_list, new okhttp3.Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {}
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Utils.parseJsonWithListJsonObject(response,ListInfoActivity.this);
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(ListInfoActivity.this,DetailActivity.class);
                intent.putExtra("data",userInfors[i].getTitle());
                startActivity(intent);
            }
        });
    }
}
