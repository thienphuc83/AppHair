package com.example.hair.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hair.R;

public class ThemKhachHangActivity extends AppCompatActivity {

    EditText edtTenKH, edtSDTKH, edtDiachiKH, edtMotaKH;
    TextView tvNam, tvNu;
    Button btnThemKH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_khach_hang);

        AnhXa();
    }

    private void AnhXa() {
        edtTenKH = findViewById(R.id.edttenkhachhang);
        edtSDTKH = findViewById(R.id.edtsdtkhachhang);
        edtMotaKH = findViewById(R.id.edtmotakhachhang);
        edtDiachiKH = findViewById(R.id.edtdiachikhachhang);
        tvNam = findViewById(R.id.tvnamkhachhang);
        tvNu = findViewById(R.id.tvnukhachhang);
        btnThemKH = findViewById(R.id.btnthemkhachhang);
    }
}