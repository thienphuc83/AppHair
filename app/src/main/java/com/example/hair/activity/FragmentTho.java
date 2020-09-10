package com.example.hair.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hair.R;
import com.example.hair.adapter.AllThoAdapter;
import com.example.hair.model.Tho;
import com.example.hair.server.APIService;
import com.example.hair.server.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentTho extends Fragment {

    View view;
    RecyclerView rvDanhsachTho;
    public ArrayList<Tho> mangthocattoc;
    AllThoAdapter allThoAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tho,container,false);
        rvDanhsachTho = view.findViewById(R.id.rvthocattoc);
        GetDataThoCatToc();

        return view;
    }

    private void GetDataThoCatToc() {
        DataService dataService= APIService.getService();
        Call<List<Tho>> callback = dataService.GetAllTho();
        callback.enqueue(new Callback<List<Tho>>() {
            @Override
            public void onResponse(Call<List<Tho>> call, Response<List<Tho>> response) {
                mangthocattoc= (ArrayList<Tho>) response.body();
//                Log.d("THO", mangthocattoc.get(0).getTenTho());
                allThoAdapter = new AllThoAdapter(getContext(), mangthocattoc);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                rvDanhsachTho.setLayoutManager(linearLayoutManager);
                rvDanhsachTho.setAdapter(allThoAdapter);

            }

            @Override
            public void onFailure(Call<List<Tho>> call, Throwable t) {

            }
        });
    }
}
