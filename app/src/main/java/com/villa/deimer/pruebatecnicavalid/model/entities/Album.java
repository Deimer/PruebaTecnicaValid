package com.villa.deimer.pruebatecnicavalid.model.entities;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Album {

    private String mbid;
    private String name;
    @SerializedName("image")
    private List<ImageItem> images;
    private String playcount;
    private Artist artist;
    private String url;

    public Album() {}
    public Album(String mbid, String name, List<ImageItem> images, String playcount, Artist artist, String url) {
        this.mbid = mbid;
        this.name = name;
        this.images = images;
        this.playcount = playcount;
        this.artist = artist;
        this.url = url;
    }

    //region Getters
    public String getMbid() {
        return mbid;
    }
    public String getName() {
        return name;
    }
    public List<ImageItem> getImages() {
        return images;
    }
    public String getPlaycount() {
        return playcount;
    }
    public Artist getArtist() {
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
    public void setName(String name) {
        this.name = name;
    }
    public void setImages(List<ImageItem> images) {
        this.images = images;
    }
    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }
    public void setArtist(Artist artist) {
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
                ", name='" + name + '\'' +
                ", images=" + images +
                ", playcount='" + playcount + '\'' +
                ", artist=" + artist +
                ", url='" + url + '\'' +
                '}';
    }
}
