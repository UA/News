package com.ua.news.ui.main.feed;

import com.ua.news.ui.base.IBasePresenter;

public interface IFeedPresenter<V extends IFeedView> extends IBasePresenter<V> {
    void onViewPrepared();
}
