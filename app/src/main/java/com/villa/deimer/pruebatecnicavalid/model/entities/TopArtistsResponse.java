package com.villa.deimer.pruebatecnicavalid.model.entities;

import com.google.gson.annotations.SerializedName;

public class TopArtistsResponse {

    @SerializedName("topartists")
    private TopArtists topArtists;

    public TopArtists getTopArtists() {
        return topArtists;
    }

    public void setTopArtists(TopArtists topArtists) {
        this.topArtists = topArtists;
    }

}
