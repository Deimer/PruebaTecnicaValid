package com.villa.deimer.pruebatecnicavalid.model.services.data.remote;

import android.support.annotation.NonNull;
import com.villa.deimer.pruebatecnicavalid.model.entities.TrackDetail;
import com.villa.deimer.pruebatecnicavalid.presenter.detail.DetailPresenter;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitTrackDetailAdapter implements Callback<TrackDetail> {

    private DetailPresenter detailPresenter;

    public RetrofitTrackDetailAdapter(DetailPresenter detailPresenter) {
        this.detailPresenter = detailPresenter;
    }

    private OkHttpClient setupOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    public void getInfoArtist(String baseUrl, String method, String country, String apiKey, String format) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(setupOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService api = retrofit.create(ApiService.class);
        Call<TrackDetail> call = api.getInfoTrack(method, country, apiKey, format);
        call.enqueue(this);
    }

    @Override
    public void onResponse(@NonNull Call<TrackDetail> call, @NonNull Response<TrackDetail> response) {
        if(response.isSuccessful()) {
            detailPresenter.susccessTrackDetail(response.body());
        } else {
            detailPresenter.getDataError("Code error: " + response.code());
        }
    }

    @Override
    public void onFailure(@NonNull Call<TrackDetail> call, @NonNull Throwable t) {
        detailPresenter.getDataError(t.getMessage());
    }
}
