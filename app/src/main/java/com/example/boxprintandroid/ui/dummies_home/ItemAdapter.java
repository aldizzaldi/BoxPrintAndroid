package com.example.boxprintandroid.ui.dummies_home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boxprintandroid.R;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {
    Context context ;
    List<Item> mData;
//    MovieItemClickListener movieItemClickListener;


    public ItemAdapter(Context context, List<Item> mData) {
        this.context = context;
        this.mData = mData;
//        movieItemClickListener = listener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_homepage,viewGroup,false);
        return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {


        myViewHolder.titleProduct.setText(mData.get(i).getTitle());
        myViewHolder.imgProduct.setImageResource(mData.get(i).getThumbnail());


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        private TextView titleProduct;
        private ImageView imgProduct;


        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            titleProduct = itemView.findViewById(R.id.item_title_product);
            imgProduct = itemView.findViewById(R.id.item_img_product);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

//                    movieItemClickListener.onMovieClick(mData.get(getAdapterPosition()),ImgMovie);

                }
            });

        }
    }
}
