package com.ua.news.ui.registration.signup;

import com.ua.news.ui.base.IBaseView;

public interface ISignUpView extends IBaseView {
    void setUserNameError();
    void setEmailError();
    void setPasswordError();
    void openLogin();
}
