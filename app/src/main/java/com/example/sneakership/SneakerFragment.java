package com.example.sneakership;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SneakerFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<ResponseDTO> responseList = new ArrayList<>();
    private PostAdapter postAdapter;
    private TextView mTvSneakerShip;
    private TextView mTvPopular;
    private TextView mTvSortBy;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        setRecyclerView();
        ApiCall();
    }

    private void ApiCall() {
        ApiClient apiClient = Network.getRetrofitInstance().create(ApiClient.class);
        apiClient.getShoe().enqueue(new Callback<List<ResponseDTO>>() {
            @Override
            public void onResponse(Call<List<ResponseDTO>> call, Response<List<ResponseDTO>> response) {
             responseList.addAll(response.body());
             postAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<ResponseDTO>> call, Throwable t) {

            }
        });
    }

    private void setRecyclerView() {
        postAdapter = new PostAdapter(responseList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext() , 2);
        recyclerView.setAdapter(postAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        mTvSneakerShip = view.findViewById(R.id.TvSneakerShip);
        mTvPopular = view.findViewById(R.id.TvPopular);
        mTvSortBy = view.findViewById(R.id.TvsortBy);
    }
}