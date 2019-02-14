package com.ua.news.ui.main.feed;

import com.ua.news.data.IDataManager;
import com.ua.news.data.network.api.model.Article;
import com.ua.news.ui.base.BasePresenter;
import com.ua.news.utils.rx.ISchedulerProvider;
import com.ua.news.utils.rx.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class FeedPresenter<V extends IFeedView> extends BasePresenter<V> implements IFeedPresenter<V> {

    private final IDataManager mDataManager;
    private final ISchedulerProvider mSchedulerProvider;
    private final CompositeDisposable mCompositeDisposable;

    @Inject
    public FeedPresenter(IDataManager dataManager,
                         ISchedulerProvider mSchedulerProvider,
                         CompositeDisposable mCompositeDisposable) {
        super(dataManager, mSchedulerProvider, mCompositeDisposable);
        this.mDataManager = dataManager;
        this.mSchedulerProvider = mSchedulerProvider;
        this.mCompositeDisposable = mCompositeDisposable;
    }

    @Override
    public void onViewPrepared() {
        getBaseView().showLoading();
        getCompositeDisposable()
                .add(getDataManager()
                        .getArticles()
                        .subscribeOn(getSchedulerProvider().io())
                         .observeOn(getSchedulerProvider().ui())
                         .subscribe(article -> {
                             if (article != null)
                                 getBaseView().updateArticle(article);

                             getBaseView().hideDialog();
                         }));


//        getCompositeDisposable().add(getDataManager()
//                .getArticles()
//                .subscribeOn(getSchedulerProvider().io())
//                .observeOn(getSchedulerProvider().ui())
//                .subscribe(new Consumer<BlogResponse>() {
//                    @Override
//                    public void accept(@NonNull BlogResponse blogResponse)
//                            throws Exception {
//                        if (blogResponse != null && blogResponse.getData() != null) {
//                            getMvpView().updateBlog(blogResponse.getData());
//                        }
//                        getMvpView().hideLoading();
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(@NonNull Throwable throwable)
//                            throws Exception {
//                        if (!isViewAttached()) {
//                            return;
//                        }
//
//                        getMvpView().hideLoading();
//
//                        // handle the error here
//                        if (throwable instanceof ANError) {
//                            ANError anError = (ANError) throwable;
//                            handleApiError(anError);
//                        }
//                    }
//                }));
    }
}
