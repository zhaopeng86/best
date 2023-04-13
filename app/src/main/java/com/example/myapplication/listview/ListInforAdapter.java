package com.example.myapplication.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.entity.PromoteEntity;

public class ListInforAdapter extends BaseAdapter {

    private Context context;
    private PromoteEntity[]  data;

    public ListInforAdapter(Context context, PromoteEntity[]  data) {
        this.context = context;
        this.data = data;
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
            view = LayoutInflater.from(context).inflate(R.layout.listitem,viewGroup,false);
            viewHolder=new ViewHolder();
            viewHolder.textViewTitle = (TextView) view.findViewById(R.id.textViewTitle);
            viewHolder.textViewDes = (TextView) view.findViewById(R.id.textViewDes);
            viewHolder.settlement = (TextView) view.findViewById(R.id.textViewSet);
            viewHolder.price = (TextView) view.findViewById(R.id.textViewPrice);
            viewHolder.topPrice = (TextView) view.findViewById(R.id.textViewTopPrice);
            viewHolder.allowance = (TextView) view.findViewById(R.id.textViewAllowance);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.textViewTitle.setText(data[i].getTitle());
        viewHolder.textViewDes.setText(data[i].getDescription());
        viewHolder.settlement.setText(data[i].getSettlement());
        viewHolder.price.setText(data[i].getPrice());
        viewHolder.topPrice.setText(data[i].getTopprice());
        viewHolder.allowance.setText(data[i].getAllowance());
        return view;
    }

    class ViewHolder{
        TextView textViewTitle;
        TextView textViewDes;
        TextView settlement;
        TextView price;
        TextView topPrice;
        TextView allowance;
    }
}
