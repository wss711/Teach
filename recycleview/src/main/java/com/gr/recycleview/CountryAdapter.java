package com.gr.recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    private List<Country> mCountryList;

    // 内部类，持有Item的视图View
    static class ViewHolder extends RecyclerView.ViewHolder{
        View countryView;
        ImageView countryFlag;
        TextView countryName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            countryView = itemView;
            countryFlag = (ImageView)itemView.findViewById(R.id.flag_item_country_iv);
            countryName = (TextView)itemView.findViewById(R.id.name_item_country_tv);
        }
    }

    public CountryAdapter(List<Country> countryList) {
        this.mCountryList = countryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_stagger_country,parent,false);
//        ViewHolder holder = new ViewHolder(view);

        final ViewHolder holder = new ViewHolder(view);
        holder.countryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Country country = mCountryList.get(position);
                Toast.makeText(v.getContext(),"你点击了 " + country.getName(),Toast.LENGTH_SHORT).show();
            }
        });

        holder.countryFlag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Country country = mCountryList.get(position);
                Toast.makeText(v.getContext(),"你点击了~~~~~~~ " + country.getName() + "~~~~~~的国旗",Toast.LENGTH_SHORT).show();
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.ViewHolder holder, int position) {
        Country country = mCountryList.get(position);
        holder.countryFlag.setImageResource(country.getImgId());
        holder.countryName.setText(country.getName());
    }

    @Override
    public int getItemCount() {
        return mCountryList.size();
    }
}
