package com.ua.news.ui.splash;

import com.ua.news.data.IDataManager;
import com.ua.news.ui.base.BasePresenter;

import javax.inject.Inject;

public class SplashPresenter<V extends ISplashView> extends BasePresenter<V> implements ISplashPresenter<V> {

    IDataManager mDataManager;

    @Inject
    public SplashPresenter(IDataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public void isLogin() {
        if (mDataManager.getLoggedInMode()) {
            getBaseView().openMainActivity();
        } else {
            getBaseView().openLoginActivity();
        }
    }

}
