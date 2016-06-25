package com.example.onasu.filmshopbookstore;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by onasu on 6/25/2016.
 */
public class MyAlert {

    public void mydialog(Context context,
                         String strTitle,
                         String strmassage) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.nobita48);
        builder.setTitle(strTitle);
        builder.setMessage(strmassage);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }


} // Main Class
