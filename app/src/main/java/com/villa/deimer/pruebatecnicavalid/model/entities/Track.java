package com.villa.deimer.pruebatecnicavalid.model.entities;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Track {

    private String mbid;
    private String duration;
    private String name;
    @SerializedName("image")
    private List<ImageItem> images;
    private String listeners;
    private Artist artist;
    private String url;

    public Track() {}
    public Track(String mbid, String duration, String name, List<ImageItem> images, String listeners, Artist artist, String url) {
        this.mbid = mbid;
        this.duration = duration;
        this.name = name;
        this.images = images;
        this.listeners = listeners;
        this.artist = artist;
        this.url = url;
    }

    //region Getters
    public String getMbid() {
        return mbid;
    }
    public String getDuration() {
        return duration;
    }
    public String getName() {
        return name;
    }
    public List<ImageItem> getImages() {
        return images;
    }
    public String getListeners() {
        return listeners;
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
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setImages(List<ImageItem> images) {
        this.images = images;
    }
    public void setListeners(String listeners) {
        this.listeners = listeners;
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
        return "Track{" +
                "mbid='" + mbid + '\'' +
                ", duration='" + duration + '\'' +
                ", name='" + name + '\'' +
                ", images=" + images +
                ", listeners='" + listeners + '\'' +
                ", artist=" + artist +
                ", url='" + url + '\'' +
                '}';
    }
}
