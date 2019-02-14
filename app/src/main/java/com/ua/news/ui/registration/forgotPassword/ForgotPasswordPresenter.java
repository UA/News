package com.ua.news.ui.registration.forgotPassword;

import com.ua.news.data.IDataManager;
import com.ua.news.ui.base.BasePresenter;
import com.ua.news.utils.rx.ISchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

public class ForgotPasswordPresenter<V extends IForgotPasswordView> extends BasePresenter<V> implements IForgotPasswordPresenter<V> {
    public ForgotPasswordPresenter(IDataManager dataManager, ISchedulerProvider mSchedulerProvider, CompositeDisposable mCompositeDisposable) {
        super(dataManager, mSchedulerProvider, mCompositeDisposable);
    }
}
