package com.ua.news.data.network.api;

import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.ua.news.data.network.api.model.Article;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class ApiHelper implements IApiHelper {
    private ApiHeader mApiHeader;

    @Inject
    public ApiHelper(ApiHeader mApiHeader) {
        this.mApiHeader = mApiHeader;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    @Override
    public Single<Article> getArticles() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_GET_ARTICLE)
                .addHeaders(mApiHeader.getApiKey())
                .build()
                .getObjectSingle(Article.class);
    }
}
