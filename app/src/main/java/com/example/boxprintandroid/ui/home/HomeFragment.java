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
import com.example.boxprintandroid.data.HomePresenter;
import com.example.boxprintandroid.interfaces.IHomeView;
import com.example.boxprintandroid.pojo.Item;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements IHomeView {
    private HomePresenter presenter;
    private View root;
    private RecyclerView recyclerView;
    private HomeItemsAdapter homeItemsAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_home, container, false);
        presenter = new HomePresenter(this);
        presenter.getAllItemsInHome();

        return root;
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void getAllItems(ArrayList<Item> items) {
        recyclerView = root.findViewById(R.id.rv_item);
        homeItemsAdapter = new HomeItemsAdapter(items, getContext());
        int i = items.size();
        Log.e("jumlah adapter", Integer.toString(i));

        recyclerView.setAdapter(homeItemsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Log.e("nyampe", "duar");
    }
}