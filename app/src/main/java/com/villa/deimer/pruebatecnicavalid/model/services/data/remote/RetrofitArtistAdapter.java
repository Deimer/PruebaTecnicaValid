package com.villa.deimer.pruebatecnicavalid.model.services.data.remote;

import android.support.annotation.NonNull;
import com.villa.deimer.pruebatecnicavalid.model.entities.TopArtistsResponse;
import com.villa.deimer.pruebatecnicavalid.presenter.timeline.network.TimelinePresenter;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitArtistAdapter implements Callback<TopArtistsResponse> {

    private TimelinePresenter timelinePresenter;

    public RetrofitArtistAdapter(TimelinePresenter timelinePresenter) {
        this.timelinePresenter = timelinePresenter;
    }

    private OkHttpClient setupOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    public void getTopArtists(String baseUrl, String method, String country, String apiKey, String format) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(setupOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService api = retrofit.create(ApiService.class);
        Call<TopArtistsResponse> call = api.getTopArtists(method, country, apiKey, format);
        call.enqueue(this);
    }

    @Override
    public void onResponse(@NonNull Call<TopArtistsResponse> call, @NonNull Response<TopArtistsResponse> response) {
        if(response.isSuccessful()) {
            timelinePresenter.susccessTopArtists(response.body());
        } else {
            timelinePresenter.getDataError("code: " + response.code());
        }
    }

    @Override
    public void onFailure(@NonNull Call<TopArtistsResponse> call, @NonNull Throwable t) {
        timelinePresenter.getDataError(t.getMessage());
    }
}
