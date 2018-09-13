package com.villa.deimer.pruebatecnicavalid.presenter.login;

public interface LoginDatabasePresenter {

    void login(String username, String password);
    void logout();

    void resultLogin(boolean result, String message);
    void resultLogout(boolean result);

}
