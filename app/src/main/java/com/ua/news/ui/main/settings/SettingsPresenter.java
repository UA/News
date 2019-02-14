package com.ua.news.ui.main.settings;

import com.ua.news.data.IDataManager;
import com.ua.news.ui.base.BasePresenter;
import com.ua.news.utils.rx.ISchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class SettingsPresenter<V extends ISettingsView> extends BasePresenter<V> implements ISettingsPresenter<V> {

    @Inject
    public SettingsPresenter(IDataManager dataManager, ISchedulerProvider mSchedulerProvider, CompositeDisposable mCompositeDisposable) {
        super(dataManager, mSchedulerProvider, mCompositeDisposable);
    }
}
