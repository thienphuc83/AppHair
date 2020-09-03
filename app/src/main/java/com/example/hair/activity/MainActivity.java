package com.example.hair.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hair.R;
import com.example.hair.adapter.AllKhachHangAdapter;
import com.example.hair.model.KhachHang;
import com.example.hair.server.APIService;
import com.example.hair.server.DataService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ImageView imgThem;
    TextView tvNam, tvNu;
    EditText edtTenKH, edt3SDT;
    RecyclerView rvDanhsachKH;
    AllKhachHangAdapter allKhachHangAdapter;
    ArrayList<KhachHang> mangkhachhang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        GetData();

    }

    private void GetData() {
        DataService dataService = APIService.getService();
        Call<List<KhachHang>> callback = dataService.GetAllKH();
        callback.enqueue(new Callback<List<KhachHang>>() {
            @Override
            public void onResponse(Call<List<KhachHang>> call, Response<List<KhachHang>> response) {
                mangkhachhang = (ArrayList<KhachHang>) response.body();
//                Log.d("AAA", mangkhachhang.get(0).getTenKH());
                allKhachHangAdapter = new AllKhachHangAdapter(MainActivity.this, mangkhachhang);
                rvDanhsachKH.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                rvDanhsachKH.setAdapter(allKhachHangAdapter);
            }

            @Override
            public void onFailure(Call<List<KhachHang>> call, Throwable t) {

            }
        });
    }

    private void Anhxa() {
        imgThem = findViewById(R.id.imgthemkhachhangvatho);
        tvNam = findViewById(R.id.tvbolocnam);
        tvNu = findViewById(R.id.tvbolocnu);
        edtTenKH = findViewById(R.id.edtboloctenkhachhang);
        edt3SDT = findViewById(R.id.edtboloc3socuoidienthoaikhachhang);
        rvDanhsachKH = findViewById(R.id.rvdanhsachkhachhang);

    }
}