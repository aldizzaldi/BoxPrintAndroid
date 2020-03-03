package com.example.boxprintandroid.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.boxprintandroid.R;
import com.example.boxprintandroid.ui.dummies_home.Item;
import com.example.boxprintandroid.ui.dummies_home.ItemAdapter;
import com.example.boxprintandroid.ui.dummies_home.Slide;
import com.example.boxprintandroid.ui.dummies_home.SliderPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {
    private List<Slide> listSlide;
    private ViewPager sliderPager;
    private TabLayout indicator;
    private RecyclerView itemRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        sliderPager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        itemRV = findViewById(R.id.rv_item);

        listSlide = new ArrayList<>();
        listSlide.add(new Slide(R.drawable.namecard, "Popular Name Card"));
        listSlide.add(new Slide(R.drawable.banneer, "Cheap Banner"));
        listSlide.add(new Slide(R.drawable.brochure, "Popular Order Brochure"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this, listSlide);
        sliderPager.setAdapter(adapter);

        // setup timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new HomeActivity.SliderTimer(),4000,6000);
        indicator.setupWithViewPager(sliderPager,true);

        // Recyclerview Setup
        // ini data

        List<Item> listItem = new ArrayList<>();
//        listItem.add(new Item("Xbanner",R.drawable.xbanner,R.drawable.pamphlet));
//        listItem.add(new Item("Majalah",R.drawable.gadis,R.drawable.iklan));
//        listItem.add(new Item("Brosur",R.drawable.pm));
//        listItem.add(new Item("Pamflet",R.drawable.majalah));
//        listItem.add(new Item("Poster",R.drawable.brosur));
//        listItem.add(new Item("Name card",R.drawable.namecard));

        ItemAdapter itemAdapter = new ItemAdapter(this, listItem);
        itemRV.setAdapter(itemAdapter);
        itemRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
    }

    class SliderTimer extends TimerTask {


        @Override
        public void run() {

            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderPager.getCurrentItem()<listSlide.size()-1) {
                        sliderPager.setCurrentItem(sliderPager.getCurrentItem()+1);
                    }
                    else
                        sliderPager.setCurrentItem(0);
                }
            });


        }
    }
}
