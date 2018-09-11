package com.villa.deimer.pruebatecnicavalid.presenter.timeline;

import com.villa.deimer.pruebatecnicavalid.model.entities.TopArtistsResponse;
import com.villa.deimer.pruebatecnicavalid.model.entities.TopTracksResponse;
import com.villa.deimer.pruebatecnicavalid.model.services.data.remote.RetrofitArtistAdapter;
import com.villa.deimer.pruebatecnicavalid.model.services.data.remote.RetrofitTrackAdapter;
import com.villa.deimer.pruebatecnicavalid.view.timeline.TimelineInterface;

public class TimelinePresenterImpl implements TimelinePresenter {

    private TimelineInterface timelineInterface;

    public TimelinePresenterImpl(TimelineInterface timelineInterface) {
        this.timelineInterface = timelineInterface;
    }

    @Override
    public void getTopTracks(String baseUrl, String method, String country, String apiKey, String format) {
        RetrofitTrackAdapter retrofitTrackAdapter = new RetrofitTrackAdapter(baseUrl,this);
        retrofitTrackAdapter.getTopTracks(baseUrl, method, country, apiKey, format);
    }

    @Override
    public void getTopArtists(String baseUrl, String method, String country, String apiKey, String format) {
        RetrofitArtistAdapter retrofitArtistAdapter = new RetrofitArtistAdapter(this);
        retrofitArtistAdapter.getTopArtists(baseUrl, method, country, apiKey, format);
    }

    @Override
    public void susccessTopTracks(TopTracksResponse tracks) {
        timelineInterface.getTracksSuccess(tracks);
    }

    @Override
    public void susccessTopArtists(TopArtistsResponse artists) {
        timelineInterface.getArtistsSuccess(artists);
    }

    @Override
    public void getDataError(String error) {
        timelineInterface.getError(error);
    }
}
