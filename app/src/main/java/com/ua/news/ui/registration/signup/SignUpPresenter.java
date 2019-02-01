package com.ua.news.ui.registration.signup;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.ua.news.R;
import com.ua.news.data.IDataManager;
import com.ua.news.ui.base.BasePresenter;
import com.ua.news.utils.CommonUtils;

import javax.inject.Inject;

public class SignUpPresenter<V extends ISignUpView> extends BasePresenter<V> implements ISignUpPresenter<V> {

    @Inject
    public SignUpPresenter(IDataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onSignUpClick(String userName, String email, String password) {
        if(!validate(userName,email,password)){
            ParseUser user = new ParseUser();
            user.setUsername(email);
            user.setEmail(email);
            user.setPassword(password);
            getBaseView().showProgressDialog(R.string.loading_please_wait);
            user.signUpInBackground(e -> {
                getBaseView().hideDialog();
                if (e == null) {
                    getBaseView().openLoginActivity();
                } else {
                    getBaseView().onError(e.getMessage());
                }
            });
        }
    }

    private boolean validate(String userName, String email, String password) {
        boolean valid = true;

        if (userName.isEmpty() || userName.length() < 3) {
            getBaseView().setUserNameError();
            valid = false;
        }

        if (email.isEmpty() || CommonUtils.isEmailValid(email)) {
            getBaseView().setEmailError();
            valid = false;
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            getBaseView().setPasswordError();
            valid = false;
        }
        return valid;
    }

}
