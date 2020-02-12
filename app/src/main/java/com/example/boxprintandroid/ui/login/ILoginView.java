package com.example.boxprintandroid.ui.login;

public interface ILoginView {
    void moveToHomepage();
    void showMessage(String message);

    void showLoading();
    void hideLoading();
    void showError();
}
