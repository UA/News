package com.ua.news.ui.registration;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.ua.news.R;
import com.ua.news.ui.base.BaseActivity;
import com.ua.news.ui.registration.login.LoginFragment;

import butterknife.ButterKnife;

public class RegistrationActivity extends BaseActivity {

    //Fragments Tags
    public static final String Login_Fragment = "Login_Fragment";
    public static final String SignUp_Fragment = "SignUp_Fragment";
    public static final String ForgotPassword_Fragment = "ForgotPassword_Fragment";
    private Fragment mFragment;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, RegistrationActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        setUnBinder(ButterKnife.bind(this));

        mFragment = new LoginFragment();

        // Begin the transaction
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_registration, mFragment, Login_Fragment);
        fragmentTransaction.commit();


    }

    @Override
    protected void setUp() {

    }
}
