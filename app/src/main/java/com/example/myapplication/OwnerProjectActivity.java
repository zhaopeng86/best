package com.example.myapplication;

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
import com.example.myapplication.entity.OwerProjectEntity;
import com.example.myapplication.entity.PromoteEntity;
import com.example.myapplication.listview.OwerProjectListAdapter;
import com.example.myapplication.utils.HttpUtil;
import com.example.myapplication.utils.ParseManager;
import com.example.myapplication.utils.UrlUtils;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Response;
public class OwnerProjectActivity extends AppCompatActivity implements UpDateView{
    public ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.owerprojectmain);
        listView=findViewById(R.id.listower);
        HttpUtil.sendRequestAsynchronous(UrlUtils.App_Get_MyProject_list, new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {}
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ParseManager.parseJsonWithListJsonObject(response,OwnerProjectActivity.this);
            }
        });
    }

    @Override
    public void updateView(Object ob) {
        OwerProjectEntity[] userInfers = (OwerProjectEntity[]) ob;
        OwerProjectListAdapter listInferAdapter=new OwerProjectListAdapter(OwnerProjectActivity.this, userInfers);
        listView.setAdapter(listInferAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(OwnerProjectActivity.this,DetailActivity.class);
                intent.putExtra("data",userInfers[position].getCommitinfo());
                startActivity(intent);
            }
        });
    }
}
