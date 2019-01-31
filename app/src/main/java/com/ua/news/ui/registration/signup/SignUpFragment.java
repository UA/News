package com.ua.news.ui.registration.signup;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ua.news.R;
import com.ua.news.ui.base.BaseFragment;
import com.ua.news.ui.registration.RegistrationActivity;
import com.ua.news.ui.registration.login.LoginFragment;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends BaseFragment {

    @BindView(R.id.link_login)
    protected TextView login;

    ISignUpPresenter<ISignUpView> mPresenter;

    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        setUnBinder(ButterKnife.bind(this, view));

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    protected void setUp(View view) {

    }

    @OnClick(R.id.link_login)
    void replaceLogin(){
        Fragment mFragment = new LoginFragment();
        FragmentTransaction fragmentTransaction = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_registration,mFragment, RegistrationActivity.Login_Fragment);
        fragmentTransaction.commit();
    }

    @OnClick(R.id.btn_sign_up)
    void signUp(){

    }

}
