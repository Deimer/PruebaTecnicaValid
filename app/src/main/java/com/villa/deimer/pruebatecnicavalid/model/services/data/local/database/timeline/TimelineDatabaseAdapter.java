package com.villa.deimer.pruebatecnicavalid.model.services.data.local.database.timeline;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.villa.deimer.pruebatecnicavalid.model.entities.User;
import com.villa.deimer.pruebatecnicavalid.model.services.data.local.database.helper.DatabaseHelper;
import com.villa.deimer.pruebatecnicavalid.presenter.timeline.database.TimelineDatabasePresenter;

public class TimelineDatabaseAdapter {

    private DatabaseHelper helper;
    private Context context;
    private TimelineDatabasePresenter timelineDatabasePresenter;

    public TimelineDatabaseAdapter(Context context, TimelineDatabasePresenter timelineDatabasePresenter) {
        this.context = context;
        this.timelineDatabasePresenter = timelineDatabasePresenter;
    }

    public void show() {
        User user;
        try {
            helper = OpenHelperManager.getHelper(context,DatabaseHelper.class);
            RuntimeExceptionDao<User, Integer> userDao = helper.getUserRuntimeDao();
            user = userDao.queryForId(1);
        } catch (Exception ex) {
            user = null;
            Log.e(this.getClass().getSimpleName(), "Error: " + ex.getMessage());
        }
        timelineDatabasePresenter.resultShowUser(user);
    }

    public void logout() {
        try {
            helper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
            RuntimeExceptionDao<User, Integer> userDao = helper.getUserRuntimeDao();
            User user = userDao.queryForId(1);
            user.setSession(false);
            userDao.update(user);
            timelineDatabasePresenter.resultLogout(true);
        }catch (Exception ex){
            timelineDatabasePresenter.resultLogout(false);
            Log.e(this.getClass().getSimpleName(), "Error: " + ex.toString());
        }
    }

    /*
    @Override
    public void logout() {
        LoginDatabaseAdapter loginDatabaseAdapter = new LoginDatabaseAdapter(context, this);
        loginDatabaseAdapter.logout();
    }
    * */

}
