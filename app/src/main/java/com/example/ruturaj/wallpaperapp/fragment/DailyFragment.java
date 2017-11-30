package com.example.ruturaj.wallpaperapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.ruturaj.wallpaperapp.R;
import com.example.ruturaj.wallpaperapp.adapter.WallpaperAdapter;
import com.example.ruturaj.wallpaperapp.model.WallpaperDetails;
import com.example.ruturaj.wallpaperapp.model.Wallpapers;
import com.example.ruturaj.wallpaperapp.rest.Client;
import com.example.ruturaj.wallpaperapp.rest.WallpaperInterface;
import com.jpardogo.android.googleprogressbar.library.ChromeFloatingCirclesDrawable;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DailyFragment extends Fragment {

    private String key = "7176583-14037eb9839f93dcf525673f6";

    public DailyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_random, container, false);
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        final GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setVisibility(View.INVISIBLE);
        final ProgressBar mProgressBar = (ProgressBar) view.findViewById(R.id.loadingIndicator);
        mProgressBar.setIndeterminateDrawable(new ChromeFloatingCirclesDrawable
                .Builder(getContext())
                .build());

        WallpaperInterface wallpaperInterface = Client.getClient().create(WallpaperInterface.class);
        Call<WallpaperDetails> wallpaperDetailsCall = wallpaperInterface.getImages(key, "daily");
        wallpaperDetailsCall.enqueue(new Callback<WallpaperDetails>() {
            @Override
            public void onResponse(Call<WallpaperDetails> call, Response<WallpaperDetails> response) {
                List<Wallpapers> wallpapersList = response.body().getHits();
                recyclerView.setAdapter(new WallpaperAdapter(wallpapersList, getContext()));
                mProgressBar.setVisibility(View.INVISIBLE);
                recyclerView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<WallpaperDetails> call, Throwable t) {
                Log.e("Error: ", t.toString());
            }
        });
        return view;
    }

}
