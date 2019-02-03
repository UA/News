package com.ua.news.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.ua.news.di.ActivityContext;
import com.ua.news.di.PerActivity;
import com.ua.news.ui.base.BaseActivity;
import com.ua.news.ui.main.feed.FeedPresenter;
import com.ua.news.ui.main.feed.IFeedPresenter;
import com.ua.news.ui.main.feed.IFeedView;
import com.ua.news.ui.main.settings.ISettingsPresenter;
import com.ua.news.ui.main.settings.ISettingsView;
import com.ua.news.ui.main.settings.SettingsPresenter;
import com.ua.news.ui.registration.login.ILoginPresenter;
import com.ua.news.ui.registration.login.ILoginView;
import com.ua.news.ui.registration.login.LoginPresenter;
import com.ua.news.ui.registration.signup.ISignUpPresenter;
import com.ua.news.ui.registration.signup.ISignUpView;
import com.ua.news.ui.registration.signup.SignUpPresenter;
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

    @Provides
    @PerActivity
    ISignUpPresenter<ISignUpView> provideSignUpPresenter(SignUpPresenter<ISignUpView> presenter){
        return presenter;
    }

    @Provides
    @PerActivity
    ILoginPresenter<ILoginView> provideLoginPresenter(LoginPresenter<ILoginView> presenter){
        return presenter;
    }

    @Provides
    @PerActivity
    IFeedPresenter<IFeedView> provideFeedPresenter(FeedPresenter<IFeedView> presenter){
        return presenter;
    }

    @Provides
    @PerActivity
    ISettingsPresenter<ISettingsView> provideSettingsPresenter(SettingsPresenter<ISettingsView> presenter){
        return presenter;
    }
}
