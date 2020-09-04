package com.example.hair.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hair.R;
import com.example.hair.adapter.AllKhachHangAdapter;
import com.example.hair.model.KhachHang;
import com.example.hair.server.APIService;
import com.example.hair.server.DataService;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ImageView imgThem;
    TextView tvAll, tvNam, tvNu;
    EditText edtTenKH, edt3SDT;
    RecyclerView rvDanhsachKH;
    AllKhachHangAdapter allKhachHangAdapter;
    public ArrayList<KhachHang> mangkhachhang;

    //lọc
    String nameKH = "";
    String sdt = "";
    TextView arrTvGioitinh[];
    int chonGioitinh = 0; // 0 là all, 1 nam, 2 nữ

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        GetData();
        LocKhachHang();

    }

    public void setColorGioiTinh() {
        for (TextView tv : arrTvGioitinh) {
            tv.setTextColor(this.getResources().getColor(R.color.colorPrimaryDark));
            tv.setBackgroundColor(this.getResources().getColor(R.color.colorWhite));
        }
        arrTvGioitinh[chonGioitinh].setTextColor(this.getResources().getColor(R.color.colorAccent));
        arrTvGioitinh[chonGioitinh].setBackgroundColor(this.getResources().getColor(R.color.colorPrimaryDark));
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
                if (tentimkiem.length() >= 2) {
                    tentimkiem = tentimkiem.toLowerCase();//cho viết hoa hết
                    //tiến hành kiểm tra và update lại list
                    nameKH = tentimkiem;
                    KiemTra();
                } else {
                    // nếu không nhập thì get lại data
                    GetData();
                }
            }
        });
        edt3SDT.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String sdttimkiem = edt3SDT.getText().toString();
                String tentim = edtTenKH.getText().toString();
                if (sdttimkiem.length() == 3) {
                    //tiến hành kiểm tra và update lại list
                    sdt = sdttimkiem;
                    KiemTra();
                }
                if (sdttimkiem.length() == 0 && tentim.length() == 0) {
                    GetData(); // mày thông  minh vãi lòn
                    // nếu ko nhập 3 số thì ko tìm mà vẫn load dữ liệu u như kỷ và thằng ten cũng phải rỗng
                } else {
                    sdt = "";
                }
            }
        });
        tvAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonGioitinh = 0;
                setColorGioiTinh();
                KiemTra();
            }
        });
        tvNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonGioitinh = 1;
                setColorGioiTinh();
                KiemTra();
            }
        });
        tvNu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonGioitinh = 2;
                setColorGioiTinh();
                KiemTra();
            }
        });
    }

    private void KiemTra() {
        ArrayList<KhachHang> arrTen = null;
        if (nameKH.length() >= 2) {
            arrTen = new ArrayList<>();
            for (KhachHang khachHang : mangkhachhang) {
                String tenkhach = khachHang.getTenKH().toLowerCase();
                if (tenkhach.indexOf(nameKH) >= 0) {
                    arrTen.add(khachHang);
                }
            }
        } else {
            arrTen = mangkhachhang;
        }
        //kiểm tra số điện thoại
        ArrayList<KhachHang> arrSDT = null;
        if (sdt.length() == 3) {
            arrSDT = new ArrayList<>();
            for (KhachHang khachHang : arrTen) {
                String sdtkhach = khachHang.getSoDienThoaiKH();
                // 0123456 789
                if (sdtkhach.indexOf(sdt) == sdtkhach.length() - 3) {
                    arrSDT.add(khachHang);
                }
            }
        } else {
            arrSDT = arrTen;
        }

        // tiến hành kiểm tra giới tính
        ArrayList<KhachHang> arrGT = null;
        if (chonGioitinh != 0) {
            arrGT = new ArrayList<>();
            if (chonGioitinh == 1) {
                for (KhachHang khachHang : arrSDT) {
                    String gtkhach = khachHang.getGioiTinhKH();
                    if (gtkhach.equals("Nam")) {
                        arrGT.add(khachHang);
                    }
                }
            }
            if (chonGioitinh ==2){
                for (KhachHang khachHang : arrSDT) {
                    String gtkhach = khachHang.getGioiTinhKH();
                    if (gtkhach.equals("Nữ")) {
                        arrGT.add(khachHang);
                    }
                }
            }
        } else {
            arrGT = arrSDT;
        }

        // update dữ liệu sau khi lọc
        allKhachHangAdapter.updateKH(arrGT);

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
        tvAll = findViewById(R.id.tvbolocall);
        edtTenKH = findViewById(R.id.edtboloctenkhachhang);
        edt3SDT = findViewById(R.id.edtboloc3socuoidienthoaikhachhang);
        rvDanhsachKH = findViewById(R.id.rvdanhsachkhachhang);
        arrTvGioitinh = new TextView[]{tvAll, tvNam, tvNu};
    }
}