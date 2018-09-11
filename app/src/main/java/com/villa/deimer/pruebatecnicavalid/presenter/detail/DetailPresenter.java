package com.villa.deimer.pruebatecnicavalid.presenter.detail;

import com.villa.deimer.pruebatecnicavalid.model.entities.ArtistDetail;
import com.villa.deimer.pruebatecnicavalid.model.entities.TrackDetail;

public interface DetailPresenter {

    void getDetailArtist(String baseUrl, String method, String country, String apiKey, String format);
    void getDetailTrack(String baseUrl, String method, String country, String apiKey, String format);

    void susccessArtistDetail(ArtistDetail artist);
    void susccessTrackDetail(TrackDetail track);
    void getDataError(String error);

}
