package com.example.boxprintandroid.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.boxprintandroid.R;
import com.example.boxprintandroid.ui.dummies_home.Cetak;
import com.example.boxprintandroid.ui.dummies_home.CetakAdapter;
import com.example.boxprintandroid.ui.dummies_home.CetakData;
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
    private RecyclerView percetakanRV;
    private ArrayList<Cetak> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        sliderPager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        itemRV = findViewById(R.id.rv_item);
        percetakanRV = findViewById(R.id.rv_percetakan);
        percetakanRV.setHasFixedSize(true);

        list.addAll(CetakData.getListData());
        percetakanRV.setLayoutManager(new LinearLayoutManager(this));
        CetakAdapter cetakAdapter = new CetakAdapter(list);
        percetakanRV.setAdapter(cetakAdapter);


        listSlide = new ArrayList<>();
        listSlide.add(new Slide(R.drawable.namecard, "Popular Name Card"));
        listSlide.add(new Slide(R.drawable.banneer, "Cheap Banner"));
        listSlide.add(new Slide(R.drawable.brochure, "Popular Order Brochure"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this, listSlide);
        sliderPager.setAdapter(adapter);

        // setup timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(),4000,6000);
        indicator.setupWithViewPager(sliderPager,true);

        // Recyclerview Setup
        // ini data

        List<Item> listItem = new ArrayList<>();
        listItem.add(new Item("Xbanner",R.drawable.namecard,R.drawable.poster));
        listItem.add(new Item("Majalah",R.drawable.picture,R.drawable.pamphlet));
        listItem.add(new Item("Brosur",R.drawable.banneer));
        listItem.add(new Item("Pamflet",R.drawable.brochure));
        listItem.add(new Item("Poster",R.drawable.lighthouse));
        listItem.add(new Item("Name card",R.drawable.namecard));

        ItemAdapter itemAdapter = new ItemAdapter(this, listItem);
        itemRV.setAdapter(itemAdapter);
        itemRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


//        List<Cetak> listCetak = new ArrayList<>();
//        listCetak.add(new Item("Xbanner",R.drawable.xbanner,R.drawable.pamphlet));
//        listCetak.add(new Item("Majalah",R.drawable.gadis,R.drawable.iklan));

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
