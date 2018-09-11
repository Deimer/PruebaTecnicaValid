package com.villa.deimer.pruebatecnicavalid.view.timeline;

import com.villa.deimer.pruebatecnicavalid.model.entities.TopArtistsResponse;
import com.villa.deimer.pruebatecnicavalid.model.entities.TopTracksResponse;

public interface TimelineInterface {

    void getTracksSuccess(TopTracksResponse tracks);
    void getArtistsSuccess(TopArtistsResponse tracks);
    void getError(String error);

}
