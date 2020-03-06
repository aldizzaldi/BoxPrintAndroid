package com.example.boxprintandroid.model.response;

import com.example.boxprintandroid.pojo.Item;
import com.google.gson.annotations.SerializedName;

public class ItemResponse {
    @SerializedName("item")
    Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
