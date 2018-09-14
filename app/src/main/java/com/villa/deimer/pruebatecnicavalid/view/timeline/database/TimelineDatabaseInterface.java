package com.villa.deimer.pruebatecnicavalid.view.timeline.database;

import com.villa.deimer.pruebatecnicavalid.model.entities.User;

public interface TimelineDatabaseInterface {

    void resultShowUser(User user);
    void resultLogout(boolean result);

}
