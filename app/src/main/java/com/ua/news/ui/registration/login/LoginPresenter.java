package com.ua.news.ui.registration.login;

import com.ua.news.data.IDataManager;
import com.ua.news.ui.base.BasePresenter;

public class LoginPresenter<V extends ILoginView> extends BasePresenter<V> implements ILoginPresenter<V> {
    public LoginPresenter(IDataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onLoginClick() {

    }
}
