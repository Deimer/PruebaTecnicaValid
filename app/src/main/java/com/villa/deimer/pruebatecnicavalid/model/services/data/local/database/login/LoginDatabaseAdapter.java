package com.villa.deimer.pruebatecnicavalid.model.services.data.local.database.login;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.villa.deimer.pruebatecnicavalid.model.entities.User;
import com.villa.deimer.pruebatecnicavalid.model.services.data.local.database.helper.DatabaseHelper;
import com.villa.deimer.pruebatecnicavalid.presenter.login.database.LoginDatabasePresenter;

public class LoginDatabaseAdapter {

    private DatabaseHelper helper;
    private Context context;
    private LoginDatabasePresenter loginDatabasePresenter;

    public LoginDatabaseAdapter(Context context, LoginDatabasePresenter loginDatabasePresenter) {
        this.context = context;
        this.loginDatabasePresenter = loginDatabasePresenter;
    }

    private User show() {
        User user;
        try {
            helper = OpenHelperManager.getHelper(context,DatabaseHelper.class);
            RuntimeExceptionDao<User, Integer> userDao = helper.getUserRuntimeDao();
            user = userDao.queryForId(1);
        } catch (Exception ex) {
            user = null;
            Log.e(this.getClass().getSimpleName(), "Error: " + ex.getMessage());
        }
        return user;
    }

    public void login(String username, String password) {
        try {
            helper = OpenHelperManager.getHelper(context,DatabaseHelper.class);
            RuntimeExceptionDao<User, Integer> userDao = helper.getUserRuntimeDao();
            User user = show();
            if(username.equalsIgnoreCase(user.getUser()) && password.equalsIgnoreCase(user.getPassword())) {
                user.setSession(true);
                userDao.update(user);
                loginDatabasePresenter.resultLogin(true, "");
            } else {
                String message = "Usuario y/o contraseña incorrecta.";
                loginDatabasePresenter.resultLogin(false, message);
            }
        }catch (Exception ex){
            loginDatabasePresenter.resultLogin(false, ex.toString());
            Log.e(this.getClass().getSimpleName(), "Error: " + ex.toString());
        }
    }

}
