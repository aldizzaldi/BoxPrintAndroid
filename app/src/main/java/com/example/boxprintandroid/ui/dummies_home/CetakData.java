package com.example.boxprintandroid.ui.dummies_home;

import com.example.boxprintandroid.R;

import java.util.ArrayList;

public class CetakData {
    private static String[] cetakNames = {
            "Smile Island",
            "Theater Print 2",
            "Theater Print Express"
    };

    private static String[]cetakDetails = {
            "Jl. Ngagel Jaya Tengah no 90B, Barata Jaya",
            "Jl. Ngagel Jaya Tengah no 90B, Barata Jaya",
            "Jl. Ngagel Jaya Tengah no 90B, Barata Jaya"
    };

    private static int[] cetakImages = {
            R.drawable.smile,
            R.drawable.smile,
            R.drawable.smile
    };

    public static ArrayList<Cetak> getListData() {
        ArrayList<Cetak> list = new ArrayList<>();
        for (int position = 0; position < cetakNames.length; position++) {
            Cetak cetak = new Cetak();
            cetak.setName(cetakNames[position]);
            cetak.setDetail(cetakDetails[position]);
            cetak.setPhoto(cetakImages[position]);
            list.add(cetak);
        }
        return list;
    }
}
