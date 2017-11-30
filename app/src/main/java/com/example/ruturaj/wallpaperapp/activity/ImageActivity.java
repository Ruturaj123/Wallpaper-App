package com.example.ruturaj.wallpaperapp.activity;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dd.morphingbutton.MorphingButton;
import com.example.ruturaj.wallpaperapp.R;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Intent intent = getIntent();
        String url = intent.getStringExtra("Selected Image");
        final Uri uri = Uri.parse(url);

        ImageView fullScreenImage = (ImageView) findViewById(R.id.fullScreenImage);
        Glide.with(this).load(url).into(fullScreenImage);

        final MorphingButton button = (MorphingButton) findViewById(R.id.downloadBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DownloadImage(uri);
                MorphingButton.Params circle = MorphingButton.Params.create()
                        .duration(1000)
                        .cornerRadius(120) // 56 dp
                        .width(120) // 56 dp
                        .height(120) // 56 dp
                        .color(getColor(R.color.green)) // normal state color
                        .colorPressed(R.color.colorAccent) // pressed state color
                        .icon(R.drawable.ic_done); // icon
                button.morph(circle);
            }
        });
    }

    private long DownloadImage(Uri uri){
        long download;

        DownloadManager downloadManager = (DownloadManager)getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setTitle("Image Download");
        request.setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS, "Image.jpg");
        download = downloadManager.enqueue(request);
        return download;
    }
}
