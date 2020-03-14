package com.example.boxprintandroid.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.boxprintandroid.R;
import com.example.boxprintandroid.activity.EditProfileActivity;
import com.example.boxprintandroid.data.ProfilePresenter;
import com.example.boxprintandroid.interfaces.IProfileView;
import com.example.boxprintandroid.pojo.User;
import com.example.boxprintandroid.ui.splashscreen.SplashScreen;

public class AccountFragment extends Fragment implements IProfileView {
    TextView name, address;
    Button logout, editProfile;

    private View root;

    private ProfilePresenter profilePresenter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_account, container, false);

        name = root.findViewById(R.id.text_name);
        address = root.findViewById(R.id.text_address);
        logout = root.findViewById(R.id.btn_logout);
        editProfile = root.findViewById(R.id.btn_editProfile);

        profilePresenter = new ProfilePresenter(this);
        profilePresenter.showProfile();

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profilePresenter.logout();
            }
        });

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profilePresenter.goEditProfile();
            }
        });

        return root;
    }

    @Override
    public void showProfile(User user) {
        name.setText(user.getNama());
        address.setText(user.getAlamat());
    }

    @Override
    public void moveToSplashscreen() {
        Intent intent = new Intent(getActivity(), SplashScreen.class);
        this.startActivity(intent);
    }

    @Override
    public void moveToEditProfile() {
        Intent intent = new Intent(getActivity(), EditProfileActivity.class);
        this.startActivity(intent);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message , Toast.LENGTH_LONG).show();
    }
}
