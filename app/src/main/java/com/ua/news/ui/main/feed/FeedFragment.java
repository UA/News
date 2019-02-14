package com.ua.news.ui.main.feed;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ua.news.R;
import com.ua.news.data.network.api.model.Article;
import com.ua.news.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends BaseFragment implements IFeedView,FeedAdapter.Callback {

    @Inject
    IFeedPresenter<IFeedView> mPresenter;

    @Inject
    FeedAdapter mFeedAdapter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @BindView(R.id.rvNews)
    RecyclerView mRecyclerView;

    List<Article> articles;

    public FeedFragment() {
        // Required empty public constructor
        articles = new ArrayList<>();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feed, container, false);
        getBaseActivity().getActivityComponent().inject(this);
        mPresenter.onAttach(FeedFragment.this);
        setUnBinder(ButterKnife.bind(this,view));
        mFeedAdapter.setCallback(this);
        return view;
    }

    @Override
    protected void setUp(View view) {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mFeedAdapter);

        mPresenter.onViewPrepared();
    }

    @Override
    public void onFeedEmptyViewRetryClick() {

    }

    @Override
    public void updateArticle(Article article) {
        articles.add(article);
        mFeedAdapter.addItems(articles);

    }
}
