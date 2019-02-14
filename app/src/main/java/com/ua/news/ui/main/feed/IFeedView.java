package com.ua.news.ui.main.feed;

import com.ua.news.data.network.api.model.Article;
import com.ua.news.ui.base.IBaseView;

public interface IFeedView extends IBaseView {
    void updateArticle(Article article);
}
