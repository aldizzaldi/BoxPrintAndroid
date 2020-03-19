package com.example.boxprintandroid.interfaces;

import com.example.boxprintandroid.pojo.Item;
import com.example.boxprintandroid.pojo.User;

import java.util.ArrayList;

public interface IHomeView extends IBase {
    void getAllItems(ArrayList<Item> items);
    void getAllUsers(ArrayList<User> users);
}
