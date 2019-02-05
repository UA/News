package com.ua.news.data.network.api;

import com.ua.news.data.network.api.model.Article;

import io.reactivex.Single;

public interface IApiHelper {

    ApiHeader getApiHeader();

    Single<Article> getArticles();
}
