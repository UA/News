package com.ua.news.ui.registration.login;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ua.news.R;
import com.ua.news.ui.base.BaseFragment;
import com.ua.news.ui.main.MainActivity;
import com.ua.news.ui.registration.RegistrationActivity;
import com.ua.news.ui.registration.forgotPassword.ForgotPasswordFragment;
import com.ua.news.ui.registration.signup.SignUpFragment;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginFragment extends BaseFragment implements ILoginView {

    @BindView(R.id.input_email)
    protected EditText email;

    @BindView(R.id.input_password)
    protected EditText password;

    @Inject
    ILoginPresenter<ILoginView> mPresenter;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    protected void setUp(View view) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        getBaseActivity().getActivityComponent().inject(LoginFragment.this);
        mPresenter.onAttach(LoginFragment.this);

        setUnBinder(ButterKnife.bind(this,view));
        // Inflate the layout for this fragment
        return view;
    }

    @OnClick(R.id.link_sign_up)
    void replaceSignUp(){
        Fragment mFragment = new SignUpFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_registration, mFragment, RegistrationActivity.SignUp_Fragment);
        fragmentTransaction.commit();
    }

    @OnClick(R.id.btn_login)
    void login(){
        mPresenter.onLoginClick(email.getText().toString(),password.getText().toString());
    }

    @OnClick(R.id.link_forgot_password)
    void forgotPassword(){
        Fragment mFragment = new ForgotPasswordFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_registration, mFragment, RegistrationActivity.ForgotPassword_Fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void setEmailError() {
        email.setError("enter a valid email address");
    }

    @Override
    public void setPasswordError() {
        password.setError("between 4 and 10 alphanumeric characters");
    }

    @Override
    public void openMainActivity() {
        Intent intent = new Intent(getBaseActivity(), MainActivity.class);
        startActivity(intent);
        getBaseActivity().finish();
    }

    @Override
    public void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }
}
