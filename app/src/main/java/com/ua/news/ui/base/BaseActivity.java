package com.ua.news.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.ua.news.NewsApp;
import com.ua.news.R;
import com.ua.news.di.component.DaggerIActivityComponent;
import com.ua.news.di.component.IActivityComponent;
import com.ua.news.di.module.ActivityModule;
import com.ua.news.utils.DialogUtils;

import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity implements IBaseView, BaseFragment.Callback {

    private IActivityComponent mActivityComponent;
    private Unbinder mUnBinder;
    private MaterialDialog mMaterialDialog;

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


    private void showSnackBar(String message){
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),message, Snackbar.LENGTH_LONG);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, R.color.white));
        snackbar.show();
    }

    @Override
    public void onError(int resId) {
        onError(getString(resId));
    }

    @Override
    public void onError(String message) {
        if (message != null){
            showSnackBar(message);
        }else {
            showSnackBar(getString(R.string.some_error));
        }
    }

    @Override
    public void showMessage(int resId) {
        showMessage(getString(resId));
    }

    @Override
    public void showMessage(String message) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.some_error), Toast.LENGTH_SHORT).show();
        }
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void showProgressDialog(String content) {
        hideDialog();
        mMaterialDialog = DialogUtils.showProgressDialog(this,content,false);
    }

    @Override
    public void showProgressDialog(int content) {
        showProgressDialog(getString(content));
    }

    @Override
    public void showDialog(MaterialDialog.Builder builder) {
        if (builder != null)
            mMaterialDialog = DialogUtils.showDialog(builder);
    }

    @Override
    public void hideDialog() {
        if (mMaterialDialog != null && mMaterialDialog.isShowing())
            mMaterialDialog.dismiss();
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
