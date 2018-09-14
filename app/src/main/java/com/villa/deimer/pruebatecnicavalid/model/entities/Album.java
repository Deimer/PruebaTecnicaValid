package com.villa.deimer.pruebatecnicavalid.model.entities;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Album {

    private String mbid;
    private String title;
    @SerializedName("image")
    private List<ImageItem> images;
    private String playcount;
    private String artist;
    private String url;

    public Album() {}
    public Album(String mbid, String title, List<ImageItem> images, String playcount, String artist, String url) {
        this.mbid = mbid;
        this.title = title;
        this.images = images;
        this.playcount = playcount;
        this.artist = artist;
        this.url = url;
    }

    //region Getters
    public String getMbid() {
        return mbid;
    }
    public String getTitle() {
        return title;
    }
    public List<ImageItem> getImages() {
        return images;
    }
    public String getPlaycount() {
        return playcount;
    }
    public String getArtist() {
        return artist;
    }
    public String getUrl() {
        return url;
    }
    //endregion

    //region Setters
    public void setMbid(String mbid) {
        this.mbid = mbid;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setImages(List<ImageItem> images) {
        this.images = images;
    }
    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    //endregion

    @Override
    public String toString() {
        return "Album{" +
                "mbid='" + mbid + '\'' +
                ", title='" + title + '\'' +
                ", images=" + images +
                ", playcount='" + playcount + '\'' +
                ", artist='" + artist + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
