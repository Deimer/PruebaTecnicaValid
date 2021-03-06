package com.villa.deimer.pruebatecnicavalid.presenter.detail.network;

import com.villa.deimer.pruebatecnicavalid.model.entities.ArtistDetail;
import com.villa.deimer.pruebatecnicavalid.model.entities.TrackDetail;
import com.villa.deimer.pruebatecnicavalid.model.services.data.remote.RetrofitArtistDetailAdapter;
import com.villa.deimer.pruebatecnicavalid.model.services.data.remote.RetrofitTrackDetailAdapter;
import com.villa.deimer.pruebatecnicavalid.view.details.DetailInterface;

public class DetailPresenterImpl implements DetailPresenter {

    private DetailInterface detailInterface;

    public DetailPresenterImpl(DetailInterface detailInterface) {
        this.detailInterface = detailInterface;
    }

    @Override
    public void getDetailArtist(String baseUrl, String method, String mbid, String apiKey, String format) {
        RetrofitArtistDetailAdapter retrofitDetailAdapter = new RetrofitArtistDetailAdapter(this);
        retrofitDetailAdapter.getInfoArtist(baseUrl, method, mbid, apiKey, format);
    }

    @Override
    public void getDetailTrack(String baseUrl, String method, String apiKey, String mbid, String format) {
        RetrofitTrackDetailAdapter retrofitDetailAdapter = new RetrofitTrackDetailAdapter(this);
        retrofitDetailAdapter.getInfoArtist(baseUrl, method, apiKey, mbid, format);
    }

    @Override
    public void susccessArtistDetail(ArtistDetail artist) {
        detailInterface.susccessArtistDetail(artist);
    }

    @Override
    public void susccessTrackDetail(TrackDetail track) {
        detailInterface.susccessTrackDetail(track);
    }

    @Override
    public void getDataError(String error) {
        detailInterface.getDataError(error);
    }
}
