package com.ua.news.ui.registration.login;

import com.ua.news.data.IDataManager;
import com.ua.news.ui.base.BasePresenter;

import javax.inject.Inject;

public class LoginPresenter<V extends ILoginView> extends BasePresenter<V> implements ILoginPresenter<V> {

    @Inject
    public LoginPresenter(IDataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onLoginClick(String email, String password) {

    }
}
