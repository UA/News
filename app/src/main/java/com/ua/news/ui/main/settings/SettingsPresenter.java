package com.ua.news.ui.main.settings;

import com.ua.news.data.IDataManager;
import com.ua.news.ui.base.BasePresenter;

import javax.inject.Inject;

public class SettingsPresenter<V extends ISettingsView> extends BasePresenter<V> implements ISettingsPresenter<V> {

    @Inject
    public SettingsPresenter(IDataManager dataManager) {
        super(dataManager);
    }
}
