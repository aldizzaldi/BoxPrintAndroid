package com.example.boxprintandroid.model.response;

import com.example.boxprintandroid.pojo.Item;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ItemsResponse {
    @SerializedName("item")
    ArrayList<Item> itmes;

    public ArrayList<Item> getItmes() {
        return itmes;
    }

    public void setItmes(ArrayList<Item> itmes) {
        this.itmes = itmes;
    }
}
