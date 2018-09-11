package com.villa.deimer.pruebatecnicavalid.view.timeline.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.villa.deimer.pruebatecnicavalid.view.timeline.fragment.TabArtists;
import com.villa.deimer.pruebatecnicavalid.view.timeline.fragment.TabTracks;
import java.util.List;

public class TabPagerTimelineAdapter extends FragmentPagerAdapter {

    private List<String> tab_titles;

    public TabPagerTimelineAdapter(FragmentManager fm, List<String> tabs) {
        super(fm);
        this.tab_titles = tabs;
    }

    @Override
    public int getCount() {
        return tab_titles.size();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f = null;
        String title = tab_titles.get(position);
        switch (title){
            case "Pistas":
                f = TabTracks.newInstance();
                break;
            case "Artistas":
                f = TabArtists.newInstance();
                break;
        }
        return f;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tab_titles.get(position);
    }

}
