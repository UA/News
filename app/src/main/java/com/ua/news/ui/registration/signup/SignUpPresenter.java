package com.ua.news.ui.registration.signup;

import com.parse.ParseUser;
import com.ua.news.R;
import com.ua.news.data.IDataManager;
import com.ua.news.ui.base.BasePresenter;
import com.ua.news.utils.CommonUtils;
import com.ua.news.utils.rx.ISchedulerProvider;
import com.ua.news.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class SignUpPresenter<V extends ISignUpView> extends BasePresenter<V> implements ISignUpPresenter<V> {

    @Inject
    public SignUpPresenter(IDataManager dataManager,
                           ISchedulerProvider mSchedulerProvider,
                           CompositeDisposable mCompositeDisposable) {
        super(dataManager, mSchedulerProvider, mCompositeDisposable);
    }

    @Override
    public void onSignUpClick(String userName, String email, String password) {
        if(validate(userName,email,password)){
            ParseUser user = new ParseUser();
            user.setUsername(email);
            user.setEmail(email);
            user.setPassword(password);
            getBaseView().showProgressDialog(R.string.loading_please_wait);
            user.signUpInBackground(e -> {
                getBaseView().hideDialog();
                if (e == null) {
                    getBaseView().openLogin();
                } else {
                    getBaseView().onError(e.getMessage());
                }
            });
        }else {
            getBaseView().onError("Invalid field");
        }
    }

    private boolean validate(String userName, String email, String password) {
        boolean valid = true;

        if (userName.isEmpty() || userName.length() < 3) {
            getBaseView().setUserNameError();
            valid = false;
        }

        if (email.isEmpty() || !CommonUtils.isEmailValid(email)) {
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
