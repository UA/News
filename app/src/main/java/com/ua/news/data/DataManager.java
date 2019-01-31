package com.ua.news.data;

import com.ua.news.data.prefs.ISharedPrefsHelper;
import com.ua.news.data.prefs.SharedPrefsHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataManager implements IDataManager {
    ISharedPrefsHelper mSharedPrefsHelper;

    @Inject
    public DataManager(ISharedPrefsHelper sharedPrefsHelper){
        this.mSharedPrefsHelper = sharedPrefsHelper;
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
}
