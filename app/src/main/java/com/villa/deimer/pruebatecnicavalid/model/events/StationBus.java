package com.villa.deimer.pruebatecnicavalid.model.events;

import com.squareup.otto.Bus;

public class StationBus {

    private static Bus bus = new Bus();
    public static Bus getBus() {
        return bus;
    }

}
