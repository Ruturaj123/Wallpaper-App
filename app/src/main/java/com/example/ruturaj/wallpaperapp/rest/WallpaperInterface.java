package com.example.ruturaj.wallpaperapp.rest;

import com.example.ruturaj.wallpaperapp.model.WallpaperDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ruturaj on 27/11/17.
 */

public interface WallpaperInterface {

    @GET("api/")
    Call<WallpaperDetails> getImages(@Query("key") String key, @Query("q") String searchQuery);

}
