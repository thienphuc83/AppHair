package com.example.hair.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hair.R;
import com.example.hair.model.KhachHang;

import java.util.ArrayList;

public class AllKhachHangAdapter extends RecyclerView.Adapter<AllKhachHangAdapter.ViewHolder> {

    Context context;
    ArrayList<KhachHang> khachHangArrayList;

    public AllKhachHangAdapter(Context context, ArrayList<KhachHang> khachHangArrayList) {
        this.context = context;
        this.khachHangArrayList = khachHangArrayList;
    }

    public void updateKH(ArrayList<KhachHang> arr){
        this.khachHangArrayList = arr;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.dong_khachhang,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        KhachHang khachHang = khachHangArrayList.get(position);
        holder.tvTenKH.setText(khachHang.getTenKH());
        holder.tvGioitinhKH.setText(khachHang.getGioiTinhKH());
        holder.tvSDTKH.setText(khachHang.getSoDienThoaiKH());

    }

    @Override
    public int getItemCount() {
        return khachHangArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTenKH, tvGioitinhKH, tvSDTKH, tvSolancattoc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenKH = itemView.findViewById(R.id.tvdongtenkhachhang);
            tvGioitinhKH = itemView.findViewById(R.id.tvdonggioitinhkhachhang);
            tvSDTKH = itemView.findViewById(R.id.tvdongsdtkhachhang);
            tvSolancattoc = itemView.findViewById(R.id.tvdongsolancattoc);
        }
    }
}
