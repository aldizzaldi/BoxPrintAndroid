package com.example.boxprintandroid.ui;

public interface ILoginView {
    void moveToHomepage();
    void showMessage(String message);

    void showLoading();
    void hideLoading();
    void showError();
}
