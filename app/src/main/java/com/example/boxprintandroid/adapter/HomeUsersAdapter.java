package com.example.boxprintandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boxprintandroid.R;
import com.example.boxprintandroid.pojo.User;

import java.util.ArrayList;

public class HomeUsersAdapter extends RecyclerView.Adapter<HomeUsersAdapter.HomeUsersViewHolder> {
    private ArrayList<User> users;
    private final Context context;

    public HomeUsersAdapter(ArrayList<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeUsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_percetakan, parent, false);
        return new HomeUsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeUsersViewHolder holder, int position) {
        holder.namaUser.setText(users.get(position).getNama());
        holder.alamatuser.setText(users.get(position).getAlamat());
    }

    @Override
    public int getItemCount() {
        return (users != null) ? users.size() : 0;
    }

    public class HomeUsersViewHolder extends RecyclerView.ViewHolder{
        TextView namaUser;
        TextView alamatuser;

        public HomeUsersViewHolder(@NonNull View itemView) {
            super(itemView);
            namaUser = itemView.findViewById(R.id.tv_item_name);
            alamatuser = itemView.findViewById(R.id.tv_item_detail);
        }
    }

}
