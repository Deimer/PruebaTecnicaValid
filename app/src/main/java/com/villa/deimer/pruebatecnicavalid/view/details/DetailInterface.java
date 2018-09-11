package com.villa.deimer.pruebatecnicavalid.view.details;

import com.villa.deimer.pruebatecnicavalid.model.entities.ArtistDetail;
import com.villa.deimer.pruebatecnicavalid.model.entities.TrackDetail;

public interface DetailInterface {

    void susccessArtistDetail(ArtistDetail artist);
    void susccessTrackDetail(TrackDetail track);
    void getDataError(String error);

}
