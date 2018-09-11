package com.villa.deimer.pruebatecnicavalid.model.services.data.remote;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import okhttp3.OkHttpClient;
import android.support.annotation.NonNull;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.converter.gson.GsonConverterFactory;
import com.villa.deimer.pruebatecnicavalid.model.entities.TopTracksResponse;
import com.villa.deimer.pruebatecnicavalid.presenter.timeline.TimelinePresenter;

public class RetrofitTrackAdapter implements Callback<TopTracksResponse> {

    private String baseUrl;
    private TimelinePresenter timelinePresenter;

    public RetrofitTrackAdapter(String baseUrl, TimelinePresenter timelinePresenter) {
        this.baseUrl = baseUrl;
        this.timelinePresenter = timelinePresenter;
    }

    private OkHttpClient setupOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    public void getTopTracks(String baseUrl, String method, String country, String apiKey, String format) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(setupOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService api = retrofit.create(ApiService.class);
        Call<TopTracksResponse> call = api.getTopTracks(method, country, apiKey, format);
        call.enqueue(this);
    }

    @Override
    public void onResponse(@NonNull Call<TopTracksResponse> call, @NonNull Response<TopTracksResponse> response) {
        if(response.isSuccessful()) {
            timelinePresenter.susccessTopTracks(response.body());
        }
    }

    @Override
    public void onFailure(@NonNull Call<TopTracksResponse> call, @NonNull Throwable t) {
        timelinePresenter.getDataError(t.getMessage());
    }
}
