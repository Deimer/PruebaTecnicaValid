package com.villa.deimer.pruebatecnicavalid.model.entities;

import com.google.gson.annotations.SerializedName;

public class TrackDetailResponse {

    @SerializedName("track")
    private TrackDetail trackDetail;

    public TrackDetail getTrackDetail() {
        return trackDetail;
    }

    public void setTrackDetail(TrackDetail trackDetail) {
        this.trackDetail = trackDetail;
    }
}
