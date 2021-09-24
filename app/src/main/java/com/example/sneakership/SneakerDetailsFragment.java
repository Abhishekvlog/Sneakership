package com.example.sneakership;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class SneakerDetailsFragment extends Fragment {
    private Button mBtnAddToCard;
    private TextView mTvNameDetail;
    private TextView mTvPriseDetail;
    private TextView mTvYearDetail;
    private TextView mTvBrandDetail;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mBtnAddToCard = view.findViewById(R.id.addtocard);
        mTvNameDetail = view.findViewById(R.id.tvNamedetail);
        mTvYearDetail = view.findViewById(R.id.tvYeardetail);
        mTvBrandDetail = view.findViewById(R.id.tvBranddetail);
        mTvPriseDetail = view.findViewById(R.id.tvPrisedetail);

    }
}