package com.villa.deimer.pruebatecnicavalid.model.entities;

public class TrackDetail {

    private String mbid;
    private String name;
    private String url;
    private String duration;
    private String listeners;
    private String playcount;
    private Artist artist;
    private Album album;
    private Wiki wiki;

    public TrackDetail() {}
    public TrackDetail(String mbid, String name, String url, String duration, String listeners, String playcount, Artist artist, Album album, Wiki wiki) {
        this.mbid = mbid;
        this.name = name;
        this.url = url;
        this.duration = duration;
        this.listeners = listeners;
        this.playcount = playcount;
        this.artist = artist;
        this.album = album;
        this.wiki = wiki;
    }

    //region Getters
    public String getMbid() {
        return mbid;
    }
    public String getName() {
        return name;
    }
    public String getUrl() {
        return url;
    }
    public String getDuration() {
        return duration;
    }
    public String getListeners() {
        return listeners;
    }
    public String getPlaycount() {
        return playcount;
    }
    public Artist getArtist() {
        return artist;
    }
    public Album getAlbum() {
        return album;
    }
    public Wiki getWiki() {
        return wiki;
    }
    //endregion

    //region Setters
    public void setMbid(String mbid) {
        this.mbid = mbid;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public void setListeners(String listeners) {
        this.listeners = listeners;
    }
    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }
    public void setArtist(Artist artist) {
        this.artist = artist;
    }
    public void setAlbum(Album album) {
        this.album = album;
    }
    public void setWiki(Wiki wiki) {
        this.wiki = wiki;
    }
    //endregion

    @Override
    public String toString() {
        return "TrackDetail{" +
                "mbid='" + mbid + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", duration='" + duration + '\'' +
                ", listeners='" + listeners + '\'' +
                ", playcount='" + playcount + '\'' +
                ", artist=" + artist +
                ", album=" + album +
                ", wiki=" + wiki +
                '}';
    }
}
