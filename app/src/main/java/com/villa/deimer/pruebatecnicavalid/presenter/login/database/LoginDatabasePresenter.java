package com.villa.deimer.pruebatecnicavalid.presenter.login.database;

public interface LoginDatabasePresenter {

    void login(String username, String password);

    void resultLogin(boolean result, String message);

}
