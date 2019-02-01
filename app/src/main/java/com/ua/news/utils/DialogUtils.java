package com.ua.news.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.afollestad.materialdialogs.MaterialDialog;

public final class DialogUtils {


    public static MaterialDialog showDialog(MaterialDialog.Builder materialDialogBuilder) {
        materialDialogBuilder.show();
        return  materialDialogBuilder.build();
    }



    public static AlertDialog showDialog(Context context, AlertDialog dialog,
                                         DialogInterface.OnClickListener positiveListener,
                                         DialogInterface.OnClickListener negativeListener,
                                         CharSequence title, CharSequence message) {
        if (dialog == null) {
            dialog = new AlertDialog.Builder(context)
                    .setPositiveButton(android.R.string.ok, positiveListener)
                    .setNegativeButton(android.R.string.cancel, negativeListener)
                    .create();
        } else {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            // use disconnectListener for the correct profile(s)
            CharSequence okText = context.getText(android.R.string.ok);
            dialog.setButton(DialogInterface.BUTTON_POSITIVE, okText, positiveListener);
            CharSequence cancelText = context.getText(android.R.string.cancel);
            dialog.setButton(DialogInterface.BUTTON_NEGATIVE, cancelText, negativeListener);
        }
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.show();
        return dialog;
    }


    public static MaterialDialog showProgressDialog(Context context,
                                                    String contentResId,
                                                    boolean cancelable) {

        MaterialDialog materialDialog = new MaterialDialog.Builder(context)
                .progress(true, 0)
                .content(contentResId)
                .cancelable(cancelable)
                .show();

        return materialDialog;
    }
}
