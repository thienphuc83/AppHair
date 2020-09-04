package com.example.hair.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hair.R;
import com.example.hair.model.Tho;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AllThoAdapter extends RecyclerView.Adapter<AllThoAdapter.ViewHolder> {

    Context context;
    ArrayList<Tho> thoArrayList;

    public AllThoAdapter(Context context, ArrayList<Tho> thoArrayList) {
        this.context = context;
        this.thoArrayList = thoArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.dong_tho,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tho tho = thoArrayList.get(position);
        holder.tvTenTho.setText(tho.getTenTho());
        Picasso.with(context).load(tho.getHinhAnhTho()).into(holder.imgTho);

    }

    @Override
    public int getItemCount() {
        return thoArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTenTho;
        ImageView imgTho;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenTho = itemView.findViewById(R.id.tvdongtenthocattoc);
            imgTho = itemView.findViewById(R.id.imgdongthocattoc);
        }
    }
}
