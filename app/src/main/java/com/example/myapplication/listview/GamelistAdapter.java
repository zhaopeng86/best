package com.example.myapplication.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myapplication.R;
import com.example.myapplication.entity.GameItemBean;
import java.lang.ref.WeakReference;

public class GamelistAdapter extends BaseAdapter {
    private WeakReference<Context> context;
    private GameItemBean[]  data;
    public GamelistAdapter(Context context,GameItemBean[] da){
        this.context=new WeakReference<>(context);
        this.data=da;
    }
    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView ==null){
            if (context.get()!=null){
                convertView = LayoutInflater.from(context.get()).inflate(R.layout.gameitem,parent,false);
                viewHolder=new ViewHolder();
                viewHolder.imageButton = (ImageView) convertView.findViewById(R.id.imbtn);
                viewHolder.textViewDes = (TextView) convertView.findViewById(R.id.descrition);
                viewHolder.DesDetaile=convertView.findViewById(R.id.detail);
                convertView.setTag(viewHolder);
            }
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.imageButton.setBackgroundResource(R.drawable.aa);
        viewHolder.textViewDes.setText(data[position].getDes());
        viewHolder.DesDetaile.setText(data[position].getDetatle());
        return convertView;
    }
    class ViewHolder{
        ImageView imageButton;
        TextView textViewDes;
        TextView DesDetaile;
    }
}
