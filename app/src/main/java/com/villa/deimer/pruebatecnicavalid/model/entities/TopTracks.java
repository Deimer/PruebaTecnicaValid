package com.villa.deimer.pruebatecnicavalid.model.entities;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TopTracks {

    @SerializedName("track")
    private List<Track> tracks;

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}
