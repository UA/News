package com.ua.news.ui.main.feed;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ua.news.R;
import com.ua.news.ui.base.BaseFragment;
import com.ua.news.ui.base.IBaseView;
import com.ua.news.ui.registration.login.LoginFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends BaseFragment implements IFeedView {

    @Inject
    IFeedPresenter<IFeedView> mPresenter;

    public FeedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feed, container, false);
        getBaseActivity().getActivityComponent().inject(this);
        mPresenter.onAttach(FeedFragment.this);
        setUnBinder(ButterKnife.bind(this,view));
        return view;
    }

    @Override
    protected void setUp(View view) {

    }
}
