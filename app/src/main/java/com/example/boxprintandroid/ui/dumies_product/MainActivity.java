package com.example.boxprintandroid.ui.dumies_product;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boxprintandroid.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvItem;
    private ArrayList<Item> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_list_item);

        rvItem = findViewById(R.id.rv_item);
        rvItem.setHasFixedSize(true);

        list.addAll(ItemData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvItem.setLayoutManager(new GridLayoutManager(this,2));
        ListItemAdapter listItemAdapter = new ListItemAdapter(list);
        rvItem.setAdapter(listItemAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list:
                break;
        }
    }
}
