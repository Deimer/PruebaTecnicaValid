package com.villa.deimer.pruebatecnicavalid.model.services.data.remote;

import android.support.annotation.NonNull;
import android.util.Log;

import com.villa.deimer.pruebatecnicavalid.model.entities.TrackDetail;
import com.villa.deimer.pruebatecnicavalid.model.entities.TrackDetailResponse;
import com.villa.deimer.pruebatecnicavalid.presenter.detail.network.DetailPresenter;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitTrackDetailAdapter implements Callback<TrackDetailResponse> {

    private DetailPresenter detailPresenter;

    public RetrofitTrackDetailAdapter(DetailPresenter detailPresenter) {
        this.detailPresenter = detailPresenter;
    }

    private OkHttpClient setupOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    public void getInfoArtist(String baseUrl, String method, String apiKey, String mbid, String format) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(setupOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService api = retrofit.create(ApiService.class);
        Call<TrackDetailResponse> call = api.getInfoTrack(method, apiKey, mbid, format);
        call.enqueue(this);
    }

    @Override
    public void onResponse(@NonNull Call<TrackDetailResponse> call, @NonNull Response<TrackDetailResponse> response) {
        if(response.isSuccessful()) {
            TrackDetail trackDetail = response.body().getTrackDetail();
            detailPresenter.susccessTrackDetail(trackDetail);
        } else {
            detailPresenter.getDataError("Code error: " + response.code());
        }
    }

    @Override
    public void onFailure(@NonNull Call<TrackDetailResponse> call, @NonNull Throwable t) {
        System.out.println("error: " + t.getMessage());
        detailPresenter.getDataError(t.getMessage());
    }
}
