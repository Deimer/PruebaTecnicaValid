package com.villa.deimer.pruebatecnicavalid.model.services.data.remote;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import com.villa.deimer.pruebatecnicavalid.model.entities.ArtistDetail;
import com.villa.deimer.pruebatecnicavalid.model.entities.ArtistDetailResponse;
import com.villa.deimer.pruebatecnicavalid.model.entities.TopArtistsResponse;
import com.villa.deimer.pruebatecnicavalid.model.entities.TopTracksResponse;
import com.villa.deimer.pruebatecnicavalid.model.entities.TrackDetail;
import com.villa.deimer.pruebatecnicavalid.model.entities.TrackDetailResponse;

public interface ApiService {

    @GET("/2.0/")
    Call<TopTracksResponse> getTopTracks(
            @Query("method")String method,
            @Query("country")String country,
            @Query("api_key")String apiKey,
            @Query("format")String format
    );

    @GET("/2.0/")
    Call<TopArtistsResponse> getTopArtists(
            @Query("method")String method,
            @Query("country")String country,
            @Query("api_key")String apiKey,
            @Query("format")String format
    );

    @GET("/2.0/")
    Call<ArtistDetailResponse> getInfoArtist(
            @Query("method")String method,
            @Query("mbid")String mbid,
            @Query("api_key")String apiKey,
            @Query("format")String format
    );

    @GET("/2.0/")
    Call<TrackDetailResponse> getInfoTrack(
            @Query("method")String method,
            @Query("api_key")String apiKey,
            @Query("mbid")String mbid,
            @Query("format")String format
    );

}
