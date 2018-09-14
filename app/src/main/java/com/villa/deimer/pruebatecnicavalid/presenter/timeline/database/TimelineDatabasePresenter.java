package com.villa.deimer.pruebatecnicavalid.presenter.timeline.database;

import com.villa.deimer.pruebatecnicavalid.model.entities.User;

public interface TimelineDatabasePresenter {

    void showUser();
    void logout();

    void resultShowUser(User user);
    void resultLogout(boolean result);

}
