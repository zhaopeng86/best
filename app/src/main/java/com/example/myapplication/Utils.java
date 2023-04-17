package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;

import androidx.core.app.NavUtils;

import com.example.myapplication.entity.BaseDataEntity;
import com.example.myapplication.entity.OwerProjectEntity;
import com.example.myapplication.entity.PromoteEntity;
import com.example.myapplication.listview.ListInferAdapter;
import com.example.myapplication.listview.OwerProjectListAdapter;
import com.google.gson.Gson;

import org.json.JSONObject;

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
    public static void parseJsonWithJsonObject(Response response, UpDateView upDateView) throws IOException {
        try{
            if (response.code()==200){
                if (upDateView!=null)
                    upDateView.updateView(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void parseJsonWithListJsonObject(Response response,UpDateView upDateView) throws IOException {
        String responseData=response.body().string();
        try{
            if (response.code()==200){
                JSONObject jsonArray=new JSONObject(responseData);
                String buffer = jsonArray.getJSONObject("data").getJSONArray("list").toString();
//                 BaseDataEntity[] userInfers;
//                switch (upDateView.getClass().getName()){
//                    case "ListInfoActivity":
//                        userInfers=new Gson().fromJson(buffer, PromoteEntity[].class);
//                        break;
//                    case "OwnerProjectActivity":
//                        userInfers=new Gson().fromJson(buffer, OwerProjectEntity[].class);
//                        break;
//                    default:
//                        break;
//                }
//                if (userInfers==null||userInfers.length==0) return;

                BaseDataEntity[] userInfer=null;

                userInfer= new Gson().fromJson(buffer, PromoteEntity[].class);

//                new Handler(Looper.getMainLooper()).post(() -> {
//                    if (upDateView!=null)
//                        upDateView.updateView(userInfer);
//                });
                BaseDataEntity[] aaaUserInfer = userInfer;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Object a= aaaUserInfer;
//                        upDateView.updateView(userInfer);

                    }
                }).start();
//                new Handler(Looper.getMainLooper()).post(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (upDateView!=null)
//                            upDateView.updateView(userInfer);
//                    }
//                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
