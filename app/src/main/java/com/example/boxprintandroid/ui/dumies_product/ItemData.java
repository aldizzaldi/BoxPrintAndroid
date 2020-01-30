package com.example.boxprintandroid.ui.dumies_product;

import com.example.boxprintandroid.R;

import java.util.ArrayList;

public class ItemData {
    private static String[] itemNames = {
            "Brochure",
            "Namecard",
            "Poster",
            "Stiker",
            "Photo",
            "Banner",
            "Brochure",
            "Namecard",
            "Poster",
            "Stiker",
            "Photo",
            "Banner"
    };

    private static String[] itemDetails = {
            "Rp 40.000",
            "Rp 40.000",
            "Rp 40.000",
            "Rp 40.000",
            "Rp 40.000",
            "Rp 40.000",
            "Rp 40.000",
            "Rp 40.000",
            "Rp 40.000",
            "Rp 40.000",
            "Rp 40.000",
            "Rp 40.000"
    };

    private static int[] itemImages = {
            R.drawable.brochure,
            R.drawable.namecard,
            R.drawable.poster,
            R.drawable.sticker,
            R.drawable.b4,
            R.drawable.banneer,
            R.drawable.brochure,
            R.drawable.namecard,
            R.drawable.poster,
            R.drawable.sticker,
            R.drawable.b4,
            R.drawable.banneer
    };

    static ArrayList<Item> getListData() {
        ArrayList<Item> list = new ArrayList<>();
        for (int position = 0; position < itemNames.length; position++) {
            Item item = new Item();
            item.setName(itemNames[position]);
            item.setDetail(itemDetails[position]);
            item.setPhoto(itemImages[position]);
            list.add(item);
        }
        return list;
    }
}