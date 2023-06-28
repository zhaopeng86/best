package com.example.myapplication.listview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.myapplication.R;
import com.example.myapplication.entity.AdItem;
import java.lang.ref.WeakReference;

public class AdvideoAdapter extends BaseAdapter {
    private WeakReference<Context> context;
    private AdItem[]  data;

    public AdvideoAdapter(Context context,AdItem[] da){
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
                convertView = LayoutInflater.from(context.get()).inflate(R.layout.advideoitem,parent,false);
                viewHolder=new ViewHolder();
                viewHolder.title = (TextView) convertView.findViewById(R.id.adtitle);
                viewHolder.textViewDes = (TextView) convertView.findViewById(R.id.addes);
                viewHolder.corn=convertView.findViewById(R.id.corn);
                convertView.setTag(viewHolder);
            }
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(data[position].getTitle());
        viewHolder.textViewDes.setText(data[position].getDes());
        viewHolder.corn.setText(data[position].getCorn());
        return convertView;
    }
    class ViewHolder{
        TextView title;
        TextView textViewDes;

        TextView corn;
    }
}
