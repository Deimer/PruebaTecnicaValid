package com.villa.deimer.pruebatecnicavalid.model.entities;

public class Stats {

    private String listeners;
    private String playcount;

    public Stats() {}
    public Stats(String listeners, String playcount) {
        this.listeners = listeners;
        this.playcount = playcount;
    }

    //region Getters
    public String getListeners() {
        return listeners;
    }
    public String getPlaycount() {
        return playcount;
    }
    //endregion

    //region Setters
    public void setListeners(String listeners) {
        this.listeners = listeners;
    }
    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }
    //endregion

    @Override
    public String toString() {
        return "Stats{" +
                "listeners='" + listeners + '\'' +
                ", playcount='" + playcount + '\'' +
                '}';
    }
}
