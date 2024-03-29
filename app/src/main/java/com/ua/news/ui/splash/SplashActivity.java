package com.ua.news.ui.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ua.news.R;
import com.ua.news.ui.base.BaseActivity;
import com.ua.news.ui.base.IBaseView;
import com.ua.news.ui.main.MainActivity;
import com.ua.news.ui.registration.RegistrationActivity;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity implements ISplashView {

    @Inject
    ISplashPresenter<ISplashView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //getActivityComponent().inject(SplashActivity.this);
       // mPresenter.onAttach(SplashActivity.this);
    }

    @Override
    protected void setUp() {


    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.getStartIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void openLoginActivity() {
        Intent intent = RegistrationActivity.getStartIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }
}
