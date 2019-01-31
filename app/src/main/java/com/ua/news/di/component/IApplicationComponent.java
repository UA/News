package com.ua.news.di.component;

import android.app.Application;
import android.content.Context;

import com.ua.news.NewsApp;
import com.ua.news.data.DataManager;
import com.ua.news.data.IDataManager;
import com.ua.news.di.ApplicationContext;
import com.ua.news.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface IApplicationComponent {

    void inject(NewsApp newsApp);

    @ApplicationContext
    Context context();

    Application application();

    IDataManager getDataManager();

}
