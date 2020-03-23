package com.gr.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    List<Country> countryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        initDatas();
        initRandomDatas();

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

    private void initRandomDatas(){
        for(int i = 0; i < 2; i++){
            Country albania = new Country(getRandomLengthName("阿尔巴尼亚"),R.drawable.albania);
            countryList.add(albania);
            Country andorra = new Country(getRandomLengthName("安道尔"),R.drawable.andorra);
            countryList.add(andorra);
            Country austria = new Country(getRandomLengthName("奥地利"),R.drawable.austria);
            countryList.add(austria);
            Country belarus = new Country(getRandomLengthName("白俄罗斯"),R.drawable.belarus);
            countryList.add(belarus);
            Country belgium = new Country(getRandomLengthName("保加利亚"),R.drawable.belgium);
            countryList.add(belgium);
            Country france = new Country(getRandomLengthName("法国"),R.drawable.france);
            countryList.add(france);
            Country germany = new Country(getRandomLengthName("德国"),R.drawable.germany);
            countryList.add(germany);
            Country italy = new Country(getRandomLengthName("意大利"),R.drawable.italy);
            countryList.add(italy);
            Country portugal = new Country(getRandomLengthName("葡萄牙"),R.drawable.portugal);
            countryList.add(portugal);
            Country romania = new Country(getRandomLengthName("罗马尼亚"),R.drawable.romania);
            countryList.add(romania);
            Country russia = new Country(getRandomLengthName("俄罗斯"),R.drawable.russia);
            countryList.add(russia);
            Country serbia = new Country(getRandomLengthName("塞尔维亚"),R.drawable.serbia);
            countryList.add(serbia);
            Country spain = new Country(getRandomLengthName("西班牙"),R.drawable.spain);
            countryList.add(spain);
            Country united_kingdom = new Country(getRandomLengthName("英国"),R.drawable.united_kingdom);
            countryList.add(united_kingdom);

        }
    }

    private String getRandomLengthName(String name){
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < length; i++){
            builder.append(name);
        }
        return builder.toString();
    }

    private void initView(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.country_recycler_view);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(RecyclerView.HORIZONTAL);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        CountryAdapter adapter = new CountryAdapter(countryList);
        recyclerView.setAdapter(adapter);
    }
}
