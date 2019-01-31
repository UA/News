package com.ua.news.di.module;

import android.app.Application;
import android.content.Context;

import com.ua.news.NewsApp;
import com.ua.news.data.DataManager;
import com.ua.news.data.IDataManager;
import com.ua.news.data.prefs.ISharedPrefsHelper;
import com.ua.news.data.prefs.SharedPrefsHelper;
import com.ua.news.di.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }


    @Provides
    Application provideApplication() {
        return mApplication;
    }



    @Provides
    @Singleton
    IDataManager provideDataManager(DataManager dataManager) {
        return dataManager;
    }

    @Provides
    @Singleton
    ISharedPrefsHelper providePreferencesHelper(SharedPrefsHelper sharedPrefsHelper){
        return sharedPrefsHelper;
    }
}
