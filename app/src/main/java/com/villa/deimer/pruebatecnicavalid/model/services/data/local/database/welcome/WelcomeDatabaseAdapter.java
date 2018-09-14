package com.villa.deimer.pruebatecnicavalid.model.services.data.local.database.welcome;

import android.util.Log;
import android.content.Context;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.villa.deimer.pruebatecnicavalid.model.entities.User;
import com.villa.deimer.pruebatecnicavalid.presenter.welcome.database.WelcomeDatabasePresenter;
import com.villa.deimer.pruebatecnicavalid.model.services.data.local.database.helper.DatabaseHelper;

public class WelcomeDatabaseAdapter {

    private DatabaseHelper helper;
    private Context context;
    private WelcomeDatabasePresenter welcomeDatabasePresenter;

    public WelcomeDatabaseAdapter(Context context, WelcomeDatabasePresenter welcomeDatabasePresenter) {
        this.context = context;
        this.welcomeDatabasePresenter = welcomeDatabasePresenter;
    }

    private User generateDataUser() {
        return new User("user123", "pass123", false);
    }

    private void create() {
        User user = generateDataUser();
        try {
            helper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
            RuntimeExceptionDao<User, Integer> userDao = helper.getUserRuntimeDao();
            userDao.create(user);
        } catch (Exception ex) {
            Log.e(this.getClass().getSimpleName(), "Error: " + ex.getMessage());
        }
    }

    public void isLogged() {
        try {
            helper = OpenHelperManager.getHelper(context,DatabaseHelper.class);
            RuntimeExceptionDao<User, Integer> userDao = helper.getUserRuntimeDao();
            User user = userDao.queryForId(1);
            if(user != null) {
                boolean isSession = user.isSession();
                welcomeDatabasePresenter.resultIsLogged(isSession);
            } else {
                create();
                welcomeDatabasePresenter.resultIsLogged(false);
            }
        } catch (Exception ex) {
            welcomeDatabasePresenter.resultIsLogged(false);
            Log.e(this.getClass().getSimpleName(), "Error: " + ex.getMessage());
        }
    }

}
