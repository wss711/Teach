package com.gr.listview_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    List<Country> countryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();
        initView();

    }

    private void initDatas(){
        countryList.add(new Country("阿尔巴尼亚",R.drawable.albania));
        countryList.add(new Country("安道尔",R.drawable.andorra));
        countryList.add(new Country("奥地利",R.drawable.austria));
        countryList.add(new Country("白俄罗斯",R.drawable.belarus));
        countryList.add(new Country("保加利亚",R.drawable.belgium));
        countryList.add(new Country("法国",R.drawable.france));
        countryList.add(new Country("德国",R.drawable.germany));
        countryList.add(new Country("意大利",R.drawable.italy));
        countryList.add(new Country("葡萄牙",R.drawable.portugal));
        countryList.add(new Country("罗马尼亚",R.drawable.romania));
        countryList.add(new Country("俄罗斯",R.drawable.russia));
        countryList.add(new Country("塞尔维亚",R.drawable.serbia));
        countryList.add(new Country("西班牙",R.drawable.spain));
        countryList.add(new Country("英国",R.drawable.united_kingdom));
    }

    private void initView(){

        listView = (ListView)findViewById(R.id.list_view);

        // 设置适配器
//        final SlowCountryAdapter adapter = new SlowCountryAdapter(this,R.layout.item_horizontal_country,countryList);
        final CountryAdapter adapter = new CountryAdapter(this,R.layout.item_country,countryList);
        listView.setAdapter(adapter);

        // 设置Item点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),countryList.get(i).getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
