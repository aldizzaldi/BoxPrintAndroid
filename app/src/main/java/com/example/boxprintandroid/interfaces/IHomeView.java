package com.example.boxprintandroid.interfaces;

import com.example.boxprintandroid.pojo.Item;

import java.util.ArrayList;

public interface IHomeView extends IBase {
    void getAllItems(ArrayList<Item> items);
}
