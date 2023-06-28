package com.example.myapplication.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.entity.OwerProjectEntity;

public class OwerProjectListAdapter extends BaseAdapter {
    private Context context;
    private OwerProjectEntity[]  data;
    public  OwerProjectListAdapter(Context context,OwerProjectEntity [] data){
        this.context=context;
        this.data=data;
    }
    @Override
    public int getCount() {
        return data.length;
    }
    @Override
    public Object getItem(int i) {
        return data[i];
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if (view ==null){
            view = LayoutInflater.from(context).inflate(R.layout.owerproject,viewGroup,false);
            viewHolder=new ViewHolder();
            viewHolder.textViewProjectTitle = (TextView) view.findViewById(R.id.textViewTitle);
            viewHolder.textViewAddTime = (TextView) view.findViewById(R.id.textViewAddTime);
            viewHolder.textViewName = (TextView) view.findViewById(R.id.textViewName);
            viewHolder.textViewStatus = (TextView) view.findViewById(R.id.textViewStatus);
            viewHolder.buttonCopy = (Button) view.findViewById(R.id.button);
            viewHolder.buttonQr = (Button) view.findViewById(R.id.button2);
            viewHolder.buttonCommit = (Button) view.findViewById(R.id.button3);
            viewHolder.OrderDetail = (Button) view.findViewById(R.id.button4);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.textViewProjectTitle.setText(data[i].getProjecttype());
        viewHolder.textViewAddTime.setText("报名时间:"+data[i].getAdd_time());
        viewHolder.textViewName.setText("业务员姓名："+data[i].getUsername());
        viewHolder.buttonCopy.setOnClickListener(new Mylistener());
        viewHolder.buttonQr.setOnClickListener(new Mylistener());
        viewHolder.buttonCommit.setOnClickListener(new Mylistener());
        viewHolder.OrderDetail.setOnClickListener(new Mylistener());
        return view;
    }
    class ViewHolder{
        TextView textViewProjectTitle;
        TextView textViewAddTime;
        TextView textViewName;
        TextView textViewStatus;
        Button buttonCopy;
        Button buttonQr;
        Button buttonCommit;
        Button OrderDetail;
    }

    class Mylistener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(context, "功能暂未开通，请持续关注", Toast.LENGTH_SHORT).show();
        }
    }
}
