package com.sulaimanms.presensimdnu;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Sulaiman MS on 6/8/2017.
 */

public class AlertDialogManager {
    public void showAlertDialog(Context context, String title,
                                Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();

        // Setting Dialog Title
        alertDialog.setTitle(title);

        // Setting Dialog Message
        //alertDialog.setMessage(message);

        if(status != null)
            // Setting alert dialog icon


        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }
}
