package com.villa.deimer.pruebatecnicavalid.view.timeline.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.villa.deimer.pruebatecnicavalid.model.events.StationBus;
import com.villa.deimer.pruebatecnicavalid.model.events.EventDialogMessage;

public class InfoDialogs {

    private Context context;

    public InfoDialogs(Context context) {
        this.context = context;
    }

    public void createDialogQuestion(String message) {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setCancelable(true).setMessage(message);
        dialog.setNegativeButton("No", createoptionsButtons());
        dialog.setPositiveButton("si", createoptionsButtons());
        dialog.create().show();
    }

    private DialogInterface.OnClickListener createoptionsButtons() {
        return new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        StationBus.getBus().post(new EventDialogMessage(1, true));
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        StationBus.getBus().post(new EventDialogMessage(1, false));
                        break;
                }
                dialog.dismiss();
            }
        };
    }

}
