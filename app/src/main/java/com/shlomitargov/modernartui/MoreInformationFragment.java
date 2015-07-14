package com.shlomitargov.modernartui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/**
 * Created by Shlomit on 14-Jul-15.
 */
public class MoreInformationFragment extends DialogFragment {
    private static final String MOMA_NYC_URL = "http://www.moma.org";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialog_text)
                .setPositiveButton(R.string.visit_moma, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //Go to MOMA NYC site
                        Intent momaIntent = new Intent();
                        momaIntent.setData(Uri.parse(MOMA_NYC_URL));
                        momaIntent.setAction(Intent.ACTION_VIEW);
                        momaIntent.addCategory(Intent.CATEGORY_BROWSABLE);
                        startActivity(momaIntent);
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
