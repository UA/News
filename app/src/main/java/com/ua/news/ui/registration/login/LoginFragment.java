package com.ua.news.ui.registration.login;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ua.news.R;
import com.ua.news.ui.base.BaseFragment;
import com.ua.news.ui.registration.RegistrationActivity;
import com.ua.news.ui.registration.signup.SignUpFragment;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginFragment extends BaseFragment {

    @BindView(R.id.link_sign_up)
    protected TextView signUp;

    @BindView(R.id.btn_login)
    protected Button login;

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
        Toast.makeText(getContext(),"Clicked",Toast.LENGTH_LONG);
    }



}
