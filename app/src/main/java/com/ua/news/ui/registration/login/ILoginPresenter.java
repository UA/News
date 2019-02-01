package com.ua.news.ui.registration.login;

import com.ua.news.ui.base.IBasePresenter;

public interface ILoginPresenter<V extends ILoginView> extends IBasePresenter<V> {
    void onLoginClick(String email, String password);
}
