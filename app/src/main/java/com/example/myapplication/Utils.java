package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;

import com.example.myapplication.entity.BaseDataEntity;
import com.example.myapplication.entity.OwerProjectEntity;
import com.example.myapplication.entity.PromoteEntity;
import com.example.myapplication.listview.ListInforAdapter;
import com.example.myapplication.listview.OwerProjectListAdapter;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.Console;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import okhttp3.Response;

public class Utils {
    public static String stringToMD5(String string) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10)
                hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }
    public static void parseJsonWithJsonObject(Response response, Handler handler) throws IOException {
        try{
            if (response.code()==200){
                if (handler!=null){
                    handler.sendEmptyMessage(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void parseJsonWithListJsonObject(Response response, Context context) throws IOException {
        String responseData=response.body().string();
        try{
            if (response.code()==200){
                JSONObject jsonArray=new JSONObject(responseData);
                String s22 = jsonArray.getJSONObject("data").getJSONArray("list").toString();
                Gson gson=new Gson();
                BaseDataEntity[] userInfers = gson.fromJson(s22, PromoteEntity[].class);
                if (userInfers==null||userInfers.length==0) return;
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        switch (userInfers[0].getClassName()){
                            case "PromoteEntity":
                                ListInforAdapter listInforAdapter=new ListInforAdapter(context, (PromoteEntity[]) userInfers);
                                ListInfoActivity listInfoActivity= (ListInfoActivity) context;
                                listInfoActivity.listView.setAdapter(listInforAdapter);
                                break;
                            case "OwerProjectEntity":

                                break;


                            default:
                                break;
                        }


                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void parseJsonWithProjectJsonObject(Response response, Context context) throws IOException {
        String responseData=response.body().string();
        try{
            if (response.code()==200){
                JSONObject jsonArray=new JSONObject(responseData);
                String listData = jsonArray.getJSONObject("data").getJSONArray("list").toString();
                Gson gson=new Gson();
                OwerProjectEntity[] userInfers = gson.fromJson(listData, OwerProjectEntity[].class);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        OwerProjectListAdapter listInforAdapter=new OwerProjectListAdapter(context, userInfers);
                        OwnerProjectActivity activity= (OwnerProjectActivity) context;
                        activity.listView.setAdapter(listInforAdapter);
                        activity.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent intent=new Intent(activity,DetailActivity.class);
                                intent.putExtra("data",userInfers[position].getCommitinfo());
                                context.startActivity(intent);
                            }
                        });
                    }
                });

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
