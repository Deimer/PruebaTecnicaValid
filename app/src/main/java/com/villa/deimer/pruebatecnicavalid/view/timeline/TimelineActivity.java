package com.villa.deimer.pruebatecnicavalid.view.timeline;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.villa.deimer.pruebatecnicavalid.R;
import com.villa.deimer.pruebatecnicavalid.view.timeline.adapter.TabPagerTimelineAdapter;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressLint("LongLogTag, SetTextI18n, InflateParams")
public class TimelineActivity extends AppCompatActivity {

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

}
