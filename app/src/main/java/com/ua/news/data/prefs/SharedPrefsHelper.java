package com.ua.news.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.ua.news.di.ApplicationContext;
import com.ua.news.utils.AppConst;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SharedPrefsHelper implements ISharedPrefsHelper {

    private SharedPreferences mSharedPreferences;

    @Inject
    public SharedPrefsHelper(@ApplicationContext Context context) {
        mSharedPreferences = context.getSharedPreferences(AppConst.NEWS_PREFS,Context.MODE_PRIVATE);
    }

    @Override
    public void clear() {
        mSharedPreferences.edit().clear().apply();
    }

    @Override
    public void putEmail(String email) {
        mSharedPreferences.edit().putString(AppConst.EMAIL,email).apply();
    }

    @Override
    public String getEmail() {
        return mSharedPreferences.getString(AppConst.EMAIL,null);
    }

    @Override
    public boolean getLoggedInMode() {
        return mSharedPreferences.getBoolean("IS_LOGGED_IN",false);
    }

    @Override
    public void setLoggedInMode(boolean loggedIn) {
        mSharedPreferences.edit().putBoolean("IS_LOGGED_IN",loggedIn).apply();
    }
}
