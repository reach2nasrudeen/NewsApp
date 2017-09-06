package com.example.app.News;

import com.example.app.callbacks.DataResponse;
import com.example.app.datamanager.ArticleManager;
import com.example.app.model.Article;
import com.example.app.model.ArticleModel;

import java.util.List;

/**
 * Created by nasrudeen on 6/9/17.
 */

public class NewsViewModel extends NewsBaseViewModel implements NewsDelegate {
    private NewsViewDelegate viewDelegate;
    private ArticleManager articleManager;

    public NewsViewModel(NewsViewDelegate viewDelegate) {
        this.viewDelegate = viewDelegate;
        this.articleManager = new ArticleManager();
    }

    @Override
    public void onLoad() {
        articleManager.getArticleBySource(getSourceId(), new DataResponse<ArticleModel>() {
            @Override
            public void onSuccess(String message) {

            }

            @Override
            public void onSuccess(ArticleModel item, String message) {
                List<Article> articles = item.getArticles();
                if(articles!=null) {
                    setArticles(articles);
                    viewDelegate.updateData();
                }
            }

            @Override
            public void onFailure(String errorMessage) {

            }

            @Override
            public void onFailure(String errorMessage, String statusCode) {

            }
        });
    }
}
