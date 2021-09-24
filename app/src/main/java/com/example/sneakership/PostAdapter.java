package com.example.sneakership;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {
    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
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
    public setData()
}
