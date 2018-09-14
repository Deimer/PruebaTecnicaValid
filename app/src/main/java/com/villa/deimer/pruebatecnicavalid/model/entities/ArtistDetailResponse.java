package com.villa.deimer.pruebatecnicavalid.model.entities;

import com.google.gson.annotations.SerializedName;

public class ArtistDetailResponse {

    @SerializedName("artist")
    private ArtistDetail artistDetail;

    public ArtistDetail getArtistDetail() {
        return artistDetail;
    }

    public void setArtistDetail(ArtistDetail artistDetail) {
        this.artistDetail = artistDetail;
    }
}
