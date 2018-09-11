package com.villa.deimer.pruebatecnicavalid.presenter.timeline;

import com.villa.deimer.pruebatecnicavalid.model.entities.TopArtistsResponse;
import com.villa.deimer.pruebatecnicavalid.model.entities.TopTracksResponse;

public interface TimelinePresenter {

    void getTopTracks(String baseUrl, String method, String country, String apiKey, String format);
    void getTopArtists(String baseUrl, String method, String country, String apiKey, String format);

    void susccessTopTracks(TopTracksResponse tracks);
    void susccessTopArtists(TopArtistsResponse artists);
    void getDataError(String error);

}
