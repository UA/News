package com.ua.news.ui.base;

public interface IBasePresenter<V extends IBaseView> {

    void onAttach(V baseView);

    void onDetach();

}
