package com.villa.deimer.pruebatecnicavalid.model.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArtistDetail {

    private String ontour;
    private String mbid;
    private Stats stats;
    private String name;
    private String streamable;
    @SerializedName("image")
    private List<ImageItem> images;
    private String url;

    public ArtistDetail() {}
    public ArtistDetail(String ontour, String mbid, Stats stats, String name, String streamable, List<ImageItem> images, String url) {
        this.ontour = ontour;
        this.mbid = mbid;
        this.stats = stats;
        this.name = name;
        this.streamable = streamable;
        this.images = images;
        this.url = url;
    }

    //region Getters
    public String getOntour() {
        return ontour;
    }
    public String getMbid() {
        return mbid;
    }
    public Stats getStats() {
        return stats;
    }
    public String getName() {
        return name;
    }
    public String getStreamable() {
        return streamable;
    }
    public List<ImageItem> getImages() {
        return images;
    }
    public String getUrl() {
        return url;
    }
    //endregion

    //region Setters
    public void setOntour(String ontour) {
        this.ontour = ontour;
    }
    public void setMbid(String mbid) {
        this.mbid = mbid;
    }
    public void setStats(Stats stats) {
        this.stats = stats;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStreamable(String streamable) {
        this.streamable = streamable;
    }
    public void setImages(List<ImageItem> images) {
        this.images = images;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    //endregion

    @Override
    public String toString() {
        return "ArtistDetail{" +
                "ontour='" + ontour + '\'' +
                ", mbid='" + mbid + '\'' +
                ", stats=" + stats +
                ", name='" + name + '\'' +
                ", streamable='" + streamable + '\'' +
                ", images=" + images +
                ", url='" + url + '\'' +
                '}';
    }
}
