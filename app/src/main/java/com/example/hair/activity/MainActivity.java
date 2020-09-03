package com.example.hair.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
    public ArrayList<KhachHang> mangkhachhang;

    //lọc
    String nameKH = "";
    String sdt = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        GetData();
        LocKhachHang();

    }

    // bộ lọc khách hàng
    private void LocKhachHang() {
        edtTenKH.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String tentimkiem = edtTenKH.getText().toString();
                if (tentimkiem.length()>=2){
                    tentimkiem = tentimkiem.toLowerCase();//cho viết hoa hết
                    //tiến hành kiểm tra và update lại list
                    nameKH = tentimkiem;
                    KiemTra();
                }else {
                    // nếu không nhập thì get lại data
                    GetData();
                }
            }
        });
//        edt3SDT.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                String sdttimkiem = edt3SDT.getText().toString();
//                if (sdttimkiem.length()==3){
//                    sdttimkiem = sdttimkiem;//cho viết hoa hết
//                    //tiến hành kiểm tra và update lại list
//                    sdt = sdttimkiem;
//                    KiemTra();
//                }else {
//                    // nếu không nhập thì get lại data
//                    GetData();
//                }
//            }
//        });
    }

    private void KiemTra(){
        ArrayList<KhachHang> listTen = null;
        if (nameKH.length()>=2){
            listTen =new ArrayList<>();
            for (KhachHang khachHang : mangkhachhang){
                String tenkhach= khachHang.getTenKH().toLowerCase();
                if (tenkhach.indexOf(nameKH)>=0){
                    listTen.add(khachHang);
                }
            }
        }
//        //kiểm tra số điện thpaij
//        if (sdt.length()==3){
//
//        }


        allKhachHangAdapter.updateKH(listTen);

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