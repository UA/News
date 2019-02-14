package com.ua.news.ui.splash;

import com.ua.news.data.IDataManager;
import com.ua.news.ui.base.BasePresenter;
import com.ua.news.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class SplashPresenter<V extends ISplashView> extends BasePresenter<V> implements ISplashPresenter<V> {
    @Inject
    public SplashPresenter(IDataManager dataManager,
                           SchedulerProvider mSchedulerProvider,
                           CompositeDisposable mCompositeDisposable) {
        super(dataManager, mSchedulerProvider, mCompositeDisposable);
    }

     private void isLogin() {
        if (getDataManager().getLoggedInMode()) {
            getBaseView().openMainActivity();
        } else {
            getBaseView().openLoginActivity();
        }
    }

    @Override
    public void onAttach(V baseView) {
        super.onAttach(baseView);
        isLogin();
    }
}
