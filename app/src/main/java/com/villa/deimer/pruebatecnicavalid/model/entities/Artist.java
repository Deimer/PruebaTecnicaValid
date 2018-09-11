package com.villa.deimer.pruebatecnicavalid.model.entities;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Artist {

    private String mbid;
    private String name;
    @SerializedName("image")
    private List<ImageItem> images;
    private String streamable;
    private String listeners;
    private String url;

    public Artist() {}
    public Artist(String mbid, String name, List<ImageItem> images, String streamable, String listeners, String url) {
        this.mbid = mbid;
        this.name = name;
        this.images = images;
        this.streamable = streamable;
        this.listeners = listeners;
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
    public String getStreamable() {
        return streamable;
    }
    public String getListeners() {
        return listeners;
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
    public void setStreamable(String streamable) {
        this.streamable = streamable;
    }
    public void setListeners(String listeners) {
        this.listeners = listeners;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    //endregion

    @Override
    public String toString() {
        return "Artist{" +
                "mbid='" + mbid + '\'' +
                ", name='" + name + '\'' +
                ", images=" + images +
                ", streamable='" + streamable + '\'' +
                ", listeners='" + listeners + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
