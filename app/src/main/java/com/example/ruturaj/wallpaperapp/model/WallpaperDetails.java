package com.example.ruturaj.wallpaperapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ruturaj on 27/11/17.
 */

public class WallpaperDetails {
    @SerializedName("totalHits")
    private int totalHits;
    @SerializedName("hits")
    private List<Wallpapers> hits;

    public List<Wallpapers> getHits(){
        return hits;
    }
}
