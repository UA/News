package com.ua.news.ui.base;


import com.ua.news.data.IDataManager;
import com.ua.news.utils.rx.ISchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    private V mBaseView;
    private final IDataManager mDataManager;
    private final ISchedulerProvider mSchedulerProvider;
    private final CompositeDisposable mCompositeDisposable;

    public BasePresenter(IDataManager dataManager, ISchedulerProvider mSchedulerProvider, CompositeDisposable mCompositeDisposable) {
        this.mDataManager = dataManager;
        this.mSchedulerProvider = mSchedulerProvider;
        this.mCompositeDisposable = mCompositeDisposable;
    }

    @Override
    public void onAttach(V baseView) {
        mBaseView = baseView;
    }

    @Override
    public void onDetach() {
        mBaseView = null;
    }

    public V getBaseView() {
        return mBaseView;
    }

    public IDataManager getDataManager() {
        return mDataManager;
    }

    public ISchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

}
