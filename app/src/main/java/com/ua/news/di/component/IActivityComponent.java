package com.ua.news.di.component;

import com.ua.news.di.PerActivity;
import com.ua.news.di.module.ActivityModule;
import com.ua.news.ui.registration.login.LoginFragment;
import com.ua.news.ui.registration.signup.SignUpFragment;
import com.ua.news.ui.splash.SplashActivity;

import dagger.Component;

@PerActivity
@Component(modules = ActivityModule.class, dependencies = IApplicationComponent.class)
public interface IActivityComponent {

    void inject(SplashActivity splashActivity);

    void inject(SignUpFragment signUpFragment);

    void inject(LoginFragment loginFragment);
}
