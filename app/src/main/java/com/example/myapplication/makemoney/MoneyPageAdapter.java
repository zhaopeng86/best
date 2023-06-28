package com.example.myapplication.makemoney;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;

public class MoneyPageAdapter extends PagerAdapter {
    private List<View> viewlist;

    public MoneyPageAdapter(List<View> viewlist){
        this.viewlist=viewlist;
    }
    @Override
    public int getCount() {
        return viewlist==null?0:viewlist.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(viewlist.get(position));
        return viewlist.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(viewlist.get(position));
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
}
