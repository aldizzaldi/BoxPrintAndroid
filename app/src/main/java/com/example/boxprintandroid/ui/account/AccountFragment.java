package com.example.boxprintandroid.ui.account;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.boxprintandroid.R;
import com.example.boxprintandroid.data.ProfilePresenter;
import com.example.boxprintandroid.interfaces.IProfileView;
import com.example.boxprintandroid.pojo.User;

public class AccountFragment extends Fragment implements IProfileView {
    TextView name, address;

    private View root;

    private ProfilePresenter profilePresenter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_account, container, false);

        name = root.findViewById(R.id.text_name);
        address = root.findViewById(R.id.text_address);

        profilePresenter = new ProfilePresenter(this);
        profilePresenter.showProfile();

        return root;
    }

    @Override
    public void showProfile(User user) {
        name.setText(user.getNama());
        address.setText(user.getAlamat());
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message , Toast.LENGTH_LONG).show();
    }
}
