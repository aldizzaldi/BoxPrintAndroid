package com.example.boxprintandroid.ui.dumies_product;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.boxprintandroid.R;

import java.util.ArrayList;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ListViewHolder> {
    private ArrayList<Item> listItems;

    public ListItemAdapter(ArrayList<Item> list) {
        this.listItems = list;
    }


    @NonNull

    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card_product, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Item item = listItems.get(position);
        Glide.with(holder.itemView.getContext())
                .load(item.getPhoto())
                .apply(new RequestOptions().override(350, 350))
                .into(holder.imgPhoto);
        holder.tvName.setText(item.getName());
        holder.tvDetail.setText(item.getDetail());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;

        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
        }
    }
}