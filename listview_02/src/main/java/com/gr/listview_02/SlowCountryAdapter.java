package com.gr.listview_02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-03
 **/
public class SlowCountryAdapter extends ArrayAdapter<Country> {
    int resId;

    public SlowCountryAdapter(@NonNull Context context, int resource, @NonNull List<Country> objects) {
        super(context, resource, objects);
        //记录布局资源id
        resId = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //获取当前位置条目的数据实例
        Country country = getItem(position);
//        View view = LayoutInflater.from(getContext()).inflate(resId,parent,false);
        View view;
        if(convertView == null){
             view = LayoutInflater.from(getContext()).inflate(resId,parent,false);
        }else {
            view = convertView;
        }

        ImageView imageView = (ImageView)view.findViewById(R.id.flag_item_country_iv);
        TextView textView = (TextView)view.findViewById(R.id.name_item_country_tv);
        imageView.setImageResource(country.getImgId());
        textView.setText(country.getName());

        return view;
    }
    
}
