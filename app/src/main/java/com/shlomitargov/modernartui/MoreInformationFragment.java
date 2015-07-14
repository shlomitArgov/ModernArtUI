package com.shlomitargov.modernartui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by Shlomit on 14-Jul-15.
 */
public class MoreInformationFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialog_text)
                .setPositiveButton(R.string.visit_moma, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //Go to MOMA NYC site
                    }
                })
                .setNegativeButton(R.string.not_now, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog - do nothing
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
