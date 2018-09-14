package com.villa.deimer.pruebatecnicavalid.presenter.login.database;

import android.content.Context;
import com.villa.deimer.pruebatecnicavalid.view.login.LoginDatabaseInterface;
import com.villa.deimer.pruebatecnicavalid.model.services.data.local.database.login.LoginDatabaseAdapter;

public class LoginDatabasePresenterImpl implements LoginDatabasePresenter {

    private Context context;
    private LoginDatabaseInterface loginDatabaseInterface;

    public LoginDatabasePresenterImpl(Context context, LoginDatabaseInterface loginDatabaseInterface) {
        this.context = context;
        this.loginDatabaseInterface = loginDatabaseInterface;
    }

    @Override
    public void login(String username, String password) {
        LoginDatabaseAdapter loginDatabaseAdapter = new LoginDatabaseAdapter(context, this);
        loginDatabaseAdapter.login(username, password);
    }

    @Override
    public void resultLogin(boolean result, String message) {
        loginDatabaseInterface.resultLogin(result, message);
    }

}
