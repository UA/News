package com.ua.news.ui.main.feed;

import com.ua.news.data.IDataManager;
import com.ua.news.ui.base.BasePresenter;

import javax.inject.Inject;

public class FeedPresenter<V extends IFeedView> extends BasePresenter<V> implements IFeedPresenter<V> {

    @Inject
    public FeedPresenter(IDataManager dataManager) {
        super(dataManager);
    }
}
