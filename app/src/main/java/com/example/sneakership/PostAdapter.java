package com.example.sneakership;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {
    private ArrayList<ResponseDTO> responseList;
    private onItemClick onItemClick;
    public PostAdapter(ArrayList<ResponseDTO> responseList ,onItemClick onItemClick){
        this.responseList = responseList;
        this.onItemClick = onItemClick;
    }
    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new PostViewHolder(view, onItemClick);
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
    private onItemClick onItemClick;
    private RelativeLayout relativeLayout;
    public PostViewHolder(@NonNull View itemView , onItemClick onItemClick) {
        super(itemView);
        this.onItemClick = onItemClick;
        imageView = itemView.findViewById(R.id.PosterView);
        Name = itemView.findViewById(R.id.Name);
        Prize = itemView.findViewById(R.id.price);
        relativeLayout = itemView.findViewById(R.id.relativelayout);
    }
    public void setData(ResponseDTO responseDTO){
        if (responseDTO.getMedia().getImageUrl() != null){
            Glide.with(imageView).load(responseDTO.getMedia().getImageUrl()).into(imageView);
        }
        Name.setText(responseDTO.getName());
        Prize.setText(responseDTO.getRetailPrice()+"");
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

            }
        });
    }
}
