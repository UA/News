package com.ua.news.ui.base;

import com.ua.news.data.DataManager;
import com.ua.news.data.IDataManager;

public class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    private V mBaseView;
    private IDataManager mDataManager;

    public BasePresenter(IDataManager dataManager) {
        this.mDataManager = dataManager;
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
}
