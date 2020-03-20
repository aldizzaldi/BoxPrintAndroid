package com.example.boxprintandroid.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boxprintandroid.R;
import com.example.boxprintandroid.adapter.HomeItemsAdapter;
import com.example.boxprintandroid.adapter.HomeUsersAdapter;
import com.example.boxprintandroid.data.HomePresenter;
import com.example.boxprintandroid.interfaces.IHomeView;
import com.example.boxprintandroid.pojo.Item;
import com.example.boxprintandroid.pojo.User;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements IHomeView {
    private View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_home, container, false);
        HomePresenter presenter = new HomePresenter(this);
        presenter.getAllItemsInHome();
        presenter.getAllUserInHome();

        return root;
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void getAllItems(ArrayList<Item> items) {
        RecyclerView recyclerView1 = root.findViewById(R.id.rv_item);
        HomeItemsAdapter homeItemsAdapter = new HomeItemsAdapter(items, getContext());
        int i = items.size();
//        Log.e("jumlah adapter", Integer.toString(i));

        recyclerView1.setAdapter(homeItemsAdapter);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));
//        Log.e("nyampe", "duar");
    }

    @Override
    public void getAllUsers(ArrayList<User> users) {
        RecyclerView recyclerView2 = root.findViewById(R.id.rv_percetakan);
        int i = users.size();
        HomeUsersAdapter homeUsersAdapter = new HomeUsersAdapter(users, getContext());
        recyclerView2.setAdapter(homeUsersAdapter);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));


    }
}