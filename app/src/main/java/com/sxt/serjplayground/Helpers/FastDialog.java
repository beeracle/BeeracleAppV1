package com.sxt.serjplayground.Helpers;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import com.sxt.serjplayground.App.TheApplication;

public class FastDialog
{
    public static void Show(Context context, CharSequence message )
    {
        Show(context, message, "DAEMON");
    }

    public static void Show(Context context, CharSequence message, CharSequence title )
    {
        Show(context, message, title, new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
            }
        }, null);
    }

    public static void Show(Context context, CharSequence message, CharSequence title, DialogInterface.OnClickListener onPositive, DialogInterface.OnClickListener  onNegative)
    {
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(context);
        dlgAlert.setMessage(message);
        dlgAlert.setTitle(title);

        if (onPositive != null)
            dlgAlert.setPositiveButton("OK", onPositive);
        if (onNegative != null)
            dlgAlert.setNegativeButton("Cancel", onNegative);

        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }

    public static void Popup(final CharSequence message)
    {
        final Activity act = TheApplication.getInstance().getCurrentActivity();
        act.runOnUiThread(new Runnable() {
            @Override
            public void run()
            {
                Toast.makeText(act, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}
