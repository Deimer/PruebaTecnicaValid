package com.villa.deimer.pruebatecnicavalid.view.timeline.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.villa.deimer.pruebatecnicavalid.R;
import com.villa.deimer.pruebatecnicavalid.model.entities.Artist;
import com.villa.deimer.pruebatecnicavalid.model.entities.TopArtists;
import com.villa.deimer.pruebatecnicavalid.model.entities.TopArtistsResponse;
import com.villa.deimer.pruebatecnicavalid.model.entities.TopTracksResponse;
import com.villa.deimer.pruebatecnicavalid.presenter.timeline.TimelinePresenter;
import com.villa.deimer.pruebatecnicavalid.presenter.timeline.TimelinePresenterImpl;
import com.villa.deimer.pruebatecnicavalid.view.timeline.TimelineInterface;
import com.villa.deimer.pruebatecnicavalid.view.timeline.adapter.ArtistRecyclerAdapter;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TabArtists extends Fragment implements TimelineInterface {

    //Components
    private Context context;
    private TimelinePresenter timelinePresenter;
    //Views
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.recycler)
    RecyclerView recycler;

    public static TabArtists newInstance() {
        return new TabArtists();
    }

    public TabArtists(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frame_artists, container, false);
        ButterKnife.bind(this, view);
        setupFragment();
        return view;
    }

    private void setupFragment() {
        context = this.getContext();
        timelinePresenter = new TimelinePresenterImpl(this);
        getData();
    }

    private void getData() {
        String baseUrl = getString(R.string.base_url);
        String apiKey = getString(R.string.api_key);
        String method = getString(R.string.method_top_artists);
        String country = getString(R.string.country);
        String format = getString(R.string.format);
        timelinePresenter.getTopArtists(baseUrl, method, country, apiKey, format);
    }

    @Override
    public void getTracksSuccess(TopTracksResponse tracks) {}

    @Override
    public void getArtistsSuccess(TopArtistsResponse artists) {
        progressBar.setVisibility(View.GONE);
        TopArtists topArtists = artists.getTopArtists();
        List<Artist> list = topArtists.getArtists();
        if(!list.isEmpty()) {
            setupRecycler(list);
        } else {
            String message = "Not data found.";
            Snackbar.make(recycler, message, Snackbar.LENGTH_LONG).show();
        }
    }

    private void setupRecycler(List<Artist> artists) {
        ArtistRecyclerAdapter adapter = new ArtistRecyclerAdapter(context, artists);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recycler.setLayoutManager(staggeredGridLayoutManager);
        recycler.setAdapter(adapter);
        recycler.setVisibility(View.VISIBLE);
    }

    @Override
    public void getError(String error) {
        Snackbar.make(recycler, error, Snackbar.LENGTH_LONG).show();
    }
}
