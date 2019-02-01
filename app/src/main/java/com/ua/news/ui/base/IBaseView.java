package com.ua.news.ui.base;

import android.support.annotation.StringRes;

import com.afollestad.materialdialogs.MaterialDialog;

public interface IBaseView {

    void showProgressDialog(String content);

    void showProgressDialog(@StringRes int content);

    void showDialog(MaterialDialog.Builder builder);

    void hideDialog();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);
}
