package com.ua.news.ui.base;

import android.support.annotation.StringRes;

public interface IBaseView {
    void showLoading();

    void hideLoading();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);
}
