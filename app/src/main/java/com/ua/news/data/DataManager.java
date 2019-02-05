package com.ua.news.data;

import com.ua.news.data.network.api.ApiHeader;
import com.ua.news.data.network.api.IApiHelper;
import com.ua.news.data.network.api.model.Article;
import com.ua.news.data.prefs.ISharedPrefsHelper;
import com.ua.news.data.prefs.SharedPrefsHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class DataManager implements IDataManager {
    private ISharedPrefsHelper mSharedPrefsHelper;
    private IApiHelper mApiHelper;

    @Inject
    public DataManager(ISharedPrefsHelper sharedPrefsHelper, IApiHelper mApiHelper){
        this.mSharedPrefsHelper = sharedPrefsHelper;
        this.mApiHelper = mApiHelper;
    }

    @Override
    public void clear() {
        mSharedPrefsHelper.clear();
    }

    @Override
    public void putEmail(String email) {
        mSharedPrefsHelper.putEmail(email);
    }

    @Override
    public String getEmail() {
        return mSharedPrefsHelper.getEmail();
    }

    @Override
    public boolean getLoggedInMode() {
        return mSharedPrefsHelper.getLoggedInMode();
    }

    @Override
    public void setLoggedInMode(boolean loggedIn) {
        mSharedPrefsHelper.setLoggedInMode(loggedIn);
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }

    @Override
    public Single<Article> getArticles() {
        return mApiHelper.getArticles();
    }
}
