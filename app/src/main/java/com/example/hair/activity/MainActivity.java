package com.example.hair.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hair.R;

public class MainActivity extends AppCompatActivity {

    ImageView imgThem;
    TextView tvNam, tvNu;
    EditText edtTenKH, edt3SDT;
    RecyclerView rvDanhsachKH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();


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