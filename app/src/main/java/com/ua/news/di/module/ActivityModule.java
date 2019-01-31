package com.ua.news.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.ua.news.di.ActivityContext;
import com.ua.news.di.PerActivity;
import com.ua.news.ui.base.BaseActivity;
import com.ua.news.ui.splash.ISplashPresenter;
import com.ua.news.ui.splash.ISplashView;
import com.ua.news.ui.splash.SplashPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity mActivity) {
        this.mActivity = mActivity;
    }


    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    @PerActivity
    ISplashPresenter<ISplashView> provideSplashPresenter(
            SplashPresenter<ISplashView> presenter) {
        return presenter;
    }

}
