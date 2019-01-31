package com.ua.news.ui.registration.signup;

import com.ua.news.ui.base.IBasePresenter;

public interface ISignUpPresenter<V extends ISignUpView> extends IBasePresenter<V> {
    void onSignUpClick(String userName, String email, String password);
}
