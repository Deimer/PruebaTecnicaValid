package com.villa.deimer.pruebatecnicavalid.presenter.timeline.database;

import android.content.Context;
import com.villa.deimer.pruebatecnicavalid.model.entities.User;
import com.villa.deimer.pruebatecnicavalid.view.timeline.database.TimelineDatabaseInterface;
import com.villa.deimer.pruebatecnicavalid.model.services.data.local.database.timeline.TimelineDatabaseAdapter;

public class TimelineDatabasePresenterImpl implements TimelineDatabasePresenter {

    private Context context;
    private TimelineDatabaseInterface timelineDatabaseInterface;

    public TimelineDatabasePresenterImpl(Context context, TimelineDatabaseInterface timelineDatabaseInterface) {
        this.context = context;
        this.timelineDatabaseInterface = timelineDatabaseInterface;
    }

    @Override
    public void showUser() {
        TimelineDatabaseAdapter timelineDatabaseAdapter = new TimelineDatabaseAdapter(context, this);
        timelineDatabaseAdapter.show();
    }

    @Override
    public void logout() {
        TimelineDatabaseAdapter timelineDatabaseAdapter = new TimelineDatabaseAdapter(context, this);
        timelineDatabaseAdapter.logout();
    }

    @Override
    public void resultShowUser(User user) {
        timelineDatabaseInterface.resultShowUser(user);
    }

    @Override
    public void resultLogout(boolean result) {
        timelineDatabaseInterface.resultLogout(result);
    }
}
