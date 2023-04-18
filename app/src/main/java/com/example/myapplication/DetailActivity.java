package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.utils.HttpUtil;
import com.example.myapplication.utils.ParseManager;
import com.example.myapplication.utils.UrlUtils;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Response;

public class DetailActivity extends AppCompatActivity implements  UpDateView{
    TextView textViewInfo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        textViewInfo=findViewById(R.id.textView3);
        Intent intent = getIntent();
        String str = intent.getStringExtra("data");
        textViewInfo.setText(str+"：报备信息");
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etUserName=findViewById(R.id.editTextTextPersonName);
                String userName=etUserName.getText().toString();
                EditText etNumber=findViewById(R.id.passwordEditText);
                String strNumber=etNumber.getText().toString();
                if (!TextUtils.isEmpty(userName)&&!TextUtils.isEmpty(strNumber)){
                    HttpUtil.sendRequestAsynchronous(UrlUtils.createUrlInfor(userName,strNumber,str), new okhttp3.Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {}
                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            ParseManager.parseJsonWithJsonObject(response,DetailActivity.this);
                        }
                    });
                }else {
                    Toast.makeText(DetailActivity.this, "请填写必要信息", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void updateView(Object ob) {
        Intent intent =new Intent(DetailActivity.this, OwnerProjectActivity.class);
        startActivity(intent);
    }

}
