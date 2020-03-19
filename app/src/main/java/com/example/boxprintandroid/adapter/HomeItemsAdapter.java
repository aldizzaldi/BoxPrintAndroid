package com.example.boxprintandroid.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boxprintandroid.R;
import com.example.boxprintandroid.pojo.Item;

import java.util.ArrayList;

public class HomeItemsAdapter extends RecyclerView.Adapter<HomeItemsAdapter.HomeItemsViewHolder>{
    private ArrayList<Item> items;
    private final Context context;
    int idItem;

    public HomeItemsAdapter(ArrayList<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.item_home, parent, false);
        return new HomeItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeItemsViewHolder holder, int position) {
        idItem = items.get(position).getId();
//        Log.e("ada isi", items.get(position).getNamaItem());
        holder.namaItem.setText(items.get(position).getNamaItem());
        holder.hargaItem.setText(Integer.toString(items.get(position).getHargaItem().intValue()));
    }

    @Override
    public int getItemCount() {
        return (items != null) ? items.size() : 0;
    }

    public class HomeItemsViewHolder extends RecyclerView.ViewHolder{
        TextView namaItem;
        TextView hargaItem;

        public HomeItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            namaItem = itemView.findViewById(R.id.item_title_product);
            hargaItem = itemView.findViewById(R.id.item_price_product);
        }
    }
}
