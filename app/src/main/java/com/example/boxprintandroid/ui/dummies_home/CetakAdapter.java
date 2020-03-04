package com.example.boxprintandroid.ui.dummies_home;

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

public class CetakAdapter extends RecyclerView.Adapter<CetakAdapter.ListViewHolder> {
    private ArrayList<Cetak> listCetak;

    public CetakAdapter(ArrayList<Cetak> list) {
        this.listCetak = list;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_percetakan, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Cetak cetak = listCetak.get(position);
        Glide.with(holder.itemView.getContext())
                .load(cetak.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(cetak.getName());
        holder.tvDetail.setText(cetak.getDetail());
    }

    @Override
    public int getItemCount() {
        return listCetak.size();
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
