package com.example.ruturaj.wallpaperapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.example.ruturaj.wallpaperapp.R;
import com.example.ruturaj.wallpaperapp.activity.ImageActivity;
import com.example.ruturaj.wallpaperapp.model.Wallpapers;
import java.util.List;

public class WallpaperAdapter extends RecyclerView.Adapter<WallpaperAdapter.MyViewHolder> {

    private static List<Wallpapers> wallpaper;
    private static Context context;

    public WallpaperAdapter(List<Wallpapers> wallpaper, Context context) {
        this.wallpaper = wallpaper;
        this.context = context;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Wallpapers selectedWallpaper = wallpaper.get(getAdapterPosition());
            Intent intent = new Intent(context, ImageActivity.class);
            intent.putExtra("Selected Image", selectedWallpaper.getWebformatURL());
            context.startActivity(intent);
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Glide.with(context).load(wallpaper.get(position).getPreviewURL()).into(holder.imageView);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return wallpaper.size();
    }
}
