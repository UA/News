package com.ua.news.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ua.news.NewsApp;
import com.ua.news.di.component.DaggerIActivityComponent;
import com.ua.news.di.component.IActivityComponent;
import com.ua.news.di.module.ActivityModule;

import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity implements IBaseView, BaseFragment.Callback {

    private IActivityComponent mActivityComponent;
    private Unbinder mUnBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setUpInjector();
    }

    private void setUpInjector(){
        mActivityComponent = DaggerIActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .iApplicationComponent(((NewsApp) getApplication()).getApplicationComponent())
                .build();
    }

    public IActivityComponent getActivityComponent() {
        return mActivityComponent;
    }


    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    protected void onDestroy() {

        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    protected abstract void setUp();
}
