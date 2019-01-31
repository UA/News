package com.ua.news.ui.registration.signup;

import com.ua.news.data.IDataManager;
import com.ua.news.ui.base.BasePresenter;
import com.ua.news.utils.CommonUtils;

public class SignUpPresenter<V extends ISignUpView> extends BasePresenter<V> implements ISignUpPresenter<V> {


    public SignUpPresenter(IDataManager dataManager) {
        super(dataManager);
    }




    @Override
    public void onSignUpClick(String userName, String email, String password) {
        if (!validate(userName,email,password)) {
            return;
        }
    }

    public boolean validate(String userName, String email, String password) {
        boolean valid = true;


        if (userName.isEmpty() || userName.length() < 3) {
           // _nameText.setError("at least 3 characters");
            valid = false;
        } else {
            //_nameText.setError(null);
        }

        if (email.isEmpty() || CommonUtils.isEmailValid(email)) {
            //_emailText.setError("enter a valid email address");
            valid = false;
        } else {
            //_emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            //_passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            //_passwordText.setError(null);
        }

        return valid;
    }

}
