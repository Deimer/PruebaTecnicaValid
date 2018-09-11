package com.villa.deimer.pruebatecnicavalid.model.entities;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TopArtists {

    @SerializedName("artist")
    private List<Artist> artists;

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }
}
