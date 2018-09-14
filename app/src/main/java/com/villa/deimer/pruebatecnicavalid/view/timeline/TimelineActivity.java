package com.villa.deimer.pruebatecnicavalid.view.timeline;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.villa.deimer.pruebatecnicavalid.R;
import com.villa.deimer.pruebatecnicavalid.model.entities.User;
import com.villa.deimer.pruebatecnicavalid.presenter.timeline.database.TimelineDatabasePresenter;
import com.villa.deimer.pruebatecnicavalid.presenter.timeline.database.TimelineDatabasePresenterImpl;
import com.villa.deimer.pruebatecnicavalid.view.login.LoginActivity;
import com.villa.deimer.pruebatecnicavalid.view.timeline.adapter.TabPagerTimelineAdapter;
import com.villa.deimer.pruebatecnicavalid.view.timeline.database.TimelineDatabaseInterface;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@SuppressLint("LongLogTag, SetTextI18n, InflateParams")
public class TimelineActivity extends AppCompatActivity implements TimelineDatabaseInterface {

    private Context context;
    private TimelineDatabasePresenter timelineDatabasePresenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.lbl_title_activity)
    TextView lblTitle;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        ButterKnife.bind(this);
        setupActivity();
    }

    private void setupActivity() {
        context = this;
        timelineDatabasePresenter = new TimelineDatabasePresenterImpl(context, this);
        setupToolbar();
        setupViewPager();
    }

    public void setupToolbar() {
        setSupportActionBar(toolbar);
        toolbar.setTitle("");
        lblTitle.setText("FM.Com");
    }

    public void setupViewPager() {
        List<String> tab_titles = new ArrayList<>();
        tab_titles.add("Pistas");
        tab_titles.add("Artistas");
        viewPager.setAdapter(new TabPagerTimelineAdapter(
                getSupportFragmentManager(),
                tab_titles
        ));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            @Override
            public void onPageSelected(int position) { }
            @Override
            public void onPageScrollStateChanged(int state) {}
        });
        setupTabLayout();
    }

    public void setupTabLayout() {
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(0);
    }

    @OnClick(R.id.fab)
    public void clickLogout() {
        timelineDatabasePresenter.logout();
    }

    @Override
    public void resultShowUser(User user) {}

    @Override
    public void resultLogout(boolean result) {
        if(result) {
            startActivity(new Intent(context, LoginActivity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        }
    }
}
