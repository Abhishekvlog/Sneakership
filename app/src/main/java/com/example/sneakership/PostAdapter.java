package com.example.sneakership;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {
    private ArrayList<ResponseDTO> responseList;
    public PostAdapter(ArrayList<ResponseDTO> responseList){
        this.responseList = responseList;
    }
    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.setData(responseList.get(position));
    }

    @Override
    public int getItemCount() {
        return responseList.size();
    }
}
class PostViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView Name;
    private TextView Prize;
    public PostViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.PosterView);
        Name = itemView.findViewById(R.id.Name);
        Prize = itemView.findViewById(R.id.price);
    }
    public void setData(ResponseDTO responseDTO){
        if (responseDTO.getMedia().getImageUrl() != null){
            Glide.with(imageView).load(responseDTO.getMedia().getImageUrl());
        }
        Name.setText(responseDTO.getName());
        Prize.setText(responseDTO.getRetailPrice());

    }
}
