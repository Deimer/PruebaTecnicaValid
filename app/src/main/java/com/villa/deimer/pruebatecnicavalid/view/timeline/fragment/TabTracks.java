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
import com.villa.deimer.pruebatecnicavalid.model.entities.TopArtistsResponse;
import com.villa.deimer.pruebatecnicavalid.model.entities.TopTracks;
import com.villa.deimer.pruebatecnicavalid.model.entities.TopTracksResponse;
import com.villa.deimer.pruebatecnicavalid.model.entities.Track;
import com.villa.deimer.pruebatecnicavalid.presenter.timeline.network.TimelinePresenter;
import com.villa.deimer.pruebatecnicavalid.presenter.timeline.network.TimelinePresenterImpl;
import com.villa.deimer.pruebatecnicavalid.view.timeline.network.TimelineInterface;
import com.villa.deimer.pruebatecnicavalid.view.timeline.adapter.TrackRecyclerAdapter;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TabTracks extends Fragment implements TimelineInterface {

    //Components
    private Context context;
    private TimelinePresenter timelinePresenter;
    //Views
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.recycler)
    RecyclerView recycler;

    public static TabTracks newInstance() {
        return new TabTracks();
    }

    public TabTracks(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frame_tracks, container, false);
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
        String method = getString(R.string.method_top_tracks);
        String country = getString(R.string.country);
        String format = getString(R.string.format);
        timelinePresenter.getTopTracks(baseUrl, method, country, apiKey, format);
    }

    @Override
    public void getTracksSuccess(TopTracksResponse tracks) {
        progressBar.setVisibility(View.GONE);
        TopTracks topTracks = tracks.getTopTracks();
        List<Track> list = topTracks.getTracks();
        if(!list.isEmpty()) {
            setupRecycler(list);
        } else {
            String message = "Not data found.";
            Snackbar.make(recycler, message, Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    public void getArtistsSuccess(TopArtistsResponse artists) {}

    private void setupRecycler(List<Track> tracks) {
        TrackRecyclerAdapter adapter = new TrackRecyclerAdapter(context, tracks);
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
