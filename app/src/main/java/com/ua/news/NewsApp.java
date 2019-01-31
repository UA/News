package com.ua.news;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.ua.news.di.component.DaggerIApplicationComponent;
import com.ua.news.di.component.IApplicationComponent;
import com.ua.news.di.module.ApplicationModule;

public class NewsApp extends Application {

    protected IApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initialize();
        setUpInjector();
    }

    private void initialize() {
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.back4app_app_id))
                // if defined
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build()
        );

        ParseInstallation.getCurrentInstallation().saveInBackground();
    }

    private void setUpInjector() {
        mApplicationComponent = DaggerIApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mApplicationComponent.inject(this);

    }

    public IApplicationComponent getApplicationComponent(){return mApplicationComponent;}
}
