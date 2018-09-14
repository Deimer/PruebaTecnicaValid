package com.villa.deimer.pruebatecnicavalid.view.details;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.squareup.picasso.Picasso;
import com.villa.deimer.pruebatecnicavalid.R;
import com.villa.deimer.pruebatecnicavalid.model.entities.ArtistDetail;
import com.villa.deimer.pruebatecnicavalid.model.entities.ImageItem;
import com.villa.deimer.pruebatecnicavalid.model.entities.TrackDetail;
import com.villa.deimer.pruebatecnicavalid.presenter.detail.network.DetailPresenter;
import com.villa.deimer.pruebatecnicavalid.presenter.detail.network.DetailPresenterImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@SuppressLint("SetTextI18n")
public class DetailActivity extends AppCompatActivity implements DetailInterface {

    private Context context;
    private DetailPresenter detailPresenter;
    private boolean isArtist;
    private String mbid;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.img_cover)
    ImageView imgCover;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.scroll)
    NestedScrollView scroll;
    @BindView(R.id.lbl_title)
    TextView lblTitle;

    @BindView(R.id.lbl_duration)
    TextView lblDuration;
    @BindView(R.id.lbl_listeners)
    TextView lblListeners;
    @BindView(R.id.lbl_playcount)
    TextView lblPlaycount;
    @BindView(R.id.lbl_album)
    TextView lblAlbum;
    @BindView(R.id.lbl_homepage)
    TextView lblHomepage;
    @BindView(R.id.lbl_published)
    TextView lblPublished;
    @BindView(R.id.lbl_summary)
    TextView lblSummary;
    @BindView(R.id.lbl_content)
    TextView lblContent;
    @BindView(R.id.lbl_ontour)
    TextView lblOntour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        setupActivity();
    }

    private void setupActivity() {
        context = this;
        detailPresenter = new DetailPresenterImpl(this);
        getExtras();
        setupToolbar();
        getDetailsItem();
    }

    private void getExtras() {
        Bundle extras = getIntent().getExtras();
        assert extras != null;
        mbid = extras.getString("mbid");
        isArtist = extras.getBoolean("isArtist");
        String title = extras.getString("title");
        lblTitle.setText(title);
    }

    public void setupToolbar() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            toolbar.setContentInsetStartWithNavigation(0);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    private void getDetailsItem() {
        String baseUrl = getString(R.string.base_url);
        String apiKey = getString(R.string.api_key);
        String format = getString(R.string.format);
        if(isArtist) {
            String method = getString(R.string.method_details_artists);
            detailPresenter.getDetailArtist(baseUrl, method, mbid, apiKey, format);
        } else {
            String method = getString(R.string.method_details_tracks);
            detailPresenter.getDetailTrack(baseUrl, method, apiKey, mbid, format);
        }
    }

    @Override
    public void susccessArtistDetail(ArtistDetail artist) {
        progressBar.setVisibility(View.GONE);
        setupInfoArtist(artist);
        setupNestedScrollView();
    }

    private void setupInfoArtist(ArtistDetail artist) {
        lblListeners.setText(getString(R.string.lbl_listeners) + artist.getStats().getListeners());
        lblPlaycount.setText(getString(R.string.lbl_playcount) + artist.getStats().getPlaycount());
        setupOpenUrl(artist.getUrl());
        lblDuration.setVisibility(View.GONE);
        lblAlbum.setVisibility(View.GONE);
        lblPublished.setText(getString(R.string.lbl_published) + artist.getWiki().getPublished());
        lblSummary.setText(getString(R.string.lbl_summary) + artist.getWiki().getSummary());
        lblContent.setText(getString(R.string.lbl_content) + artist.getWiki().getContent());
        if(artist.getOntour().equalsIgnoreCase("1")) {
            lblOntour.setText(getString(R.string.lbl_ontour) + "Si");
        } else {
            lblOntour.setText(getString(R.string.lbl_ontour) + "No");
        }
        String path = pathImageLarge(artist.getImages());
        setImageItem(path);
    }

    private void setupOpenUrl(final String url) {
        if(url == null || url.isEmpty()) {
            lblHomepage.setText(getString(R.string.space) + "No tiene página");
            lblHomepage.setTextColor(ContextCompat.getColor(context, R.color.secondaryText));
        } else {
            lblHomepage.setText(getString(R.string.space) + "Ver página online");
            lblHomepage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(browserIntent);
                }
            });
        }
    }

    @Override
    public void susccessTrackDetail(TrackDetail track) {
        progressBar.setVisibility(View.GONE);
        setupInfoTracks(track);
        setupNestedScrollView();
    }

    @Override
    public void getDataError(String error) {
        progressBar.setVisibility(View.GONE);
        Snackbar.make(toolbar, error, Snackbar.LENGTH_LONG).show();
    }

    private void setupInfoTracks(TrackDetail track) {
        lblDuration.setText(getString(R.string.lbl_duration) + track.getDuration());
        lblListeners.setText(getString(R.string.lbl_listeners) + track.getListeners());
        lblPlaycount.setText(getString(R.string.lbl_playcount) + track.getPlaycount());
        lblAlbum.setText(getString(R.string.lbl_album) + track.getAlbum().getTitle());
        setupOpenUrl(track.getUrl());
        lblPublished.setText(getString(R.string.lbl_published) + track.getWiki().getPublished());
        lblSummary.setText(getString(R.string.lbl_summary) + track.getWiki().getSummary());
        lblContent.setText(getString(R.string.lbl_content) + track.getWiki().getContent());
        lblOntour.setVisibility(View.GONE);
        String path = pathImageLarge(track.getAlbum().getImages());
        setImageItem(path);
    }

    private void setupNestedScrollView() {
        scroll.setVisibility(View.VISIBLE);
        YoYo.with(Techniques.FadeIn)
                .duration(700)
                .playOn(scroll);
    }

    private void setImageItem(String path) {
        Picasso.with(context)
                .load(path)
                .placeholder(R.drawable.ic_radio_primary)
                .error(R.drawable.ic_radio_primary)
                .fit()
                .into(imgCover);
    }

    private String pathImageLarge(List<ImageItem> images) {
        String path = "";
        for (int i = 0; i < images.size(); i++) {
            ImageItem image = images.get(i);
            if(image.getSize().equalsIgnoreCase("extralarge")) {
                path = image.getUrl();
                break;
            }
        }
        return path;
    }

}
