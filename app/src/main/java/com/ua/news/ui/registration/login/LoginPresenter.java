package com.ua.news.ui.registration.login;

import com.parse.ParseUser;
import com.ua.news.R;
import com.ua.news.data.IDataManager;
import com.ua.news.ui.base.BasePresenter;
import com.ua.news.utils.CommonUtils;
import com.ua.news.utils.rx.ISchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class LoginPresenter<V extends ILoginView> extends BasePresenter<V> implements ILoginPresenter<V> {

    @Inject
    public LoginPresenter(IDataManager dataManager, ISchedulerProvider mSchedulerProvider, CompositeDisposable mCompositeDisposable) {
        super(dataManager, mSchedulerProvider, mCompositeDisposable);
    }

    @Override
    public void onLoginClick(String email, String password) {
        if(validate(email,password)){
            getBaseView().showProgressDialog(R.string.loading_please_wait);
            ParseUser.logInInBackground(email, password, (parseUser, e) -> {
                getBaseView().hideDialog();
                if (e == null) {
                    getDataManager().putEmail(email);
                    getDataManager().setLoggedInMode(true);
                    getBaseView().openMainActivity();
                } else {
                    getBaseView().onError(e.getMessage());
                }
            });
        }else {
            getBaseView().onError(R.string.some_error);
        }
    }

    private boolean validate(String email, String password) {
        boolean valid = true;


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
