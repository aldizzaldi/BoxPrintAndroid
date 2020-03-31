package com.example.boxprintandroid.interfaces;

import com.example.boxprintandroid.pojo.User;

public interface IProfileView extends IBase{
    void showProfile(User user);
    void moveToSplashscreen();
    void moveToEditProfile(User user);
}
