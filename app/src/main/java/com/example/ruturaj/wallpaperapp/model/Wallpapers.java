package com.example.ruturaj.wallpaperapp.model;

/**
 * Created by Ruturaj on 26-11-2017.
 */

public class Wallpapers {
    private String previewURL;
    private String webformatURL;
    private int downloads;

    public Wallpapers(String previewURL, String webformatURL, int downloads){
        this.previewURL = previewURL;
        this.webformatURL = webformatURL;
        this.downloads = downloads;
    }

    public String getPreviewURL(){
        return previewURL;
    }

    public String getWebformatURL(){
        return webformatURL;
    }

    public int getDownloads(){
        return downloads;
    }
}
