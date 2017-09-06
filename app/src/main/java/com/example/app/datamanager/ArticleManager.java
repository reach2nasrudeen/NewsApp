package com.example.app.datamanager;

import com.example.app.base.AppConstants;
import com.example.app.callbacks.DataResponse;
import com.example.app.model.Article;
import com.example.app.model.ArticleModel;
import com.example.app.rest.NewsApiInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.app.base.NewsApp.getApp;

/**
 * Created by nasrudeen on 6/9/17.
 */

public class ArticleManager {
    private NewsApiInterface newsApiInterface;

    public ArticleManager() {
        newsApiInterface = getApp().getRetrofitInterface();
    }

    public void getArticleBySource(String sourceId, final DataResponse<ArticleModel> dataResponse) {
        Map<String,String> param = new HashMap<>();
        param.put("source",sourceId);
        param.put("apiKey", AppConstants.NEWS_API_KEY);

        Call<ArticleModel> articleCall = newsApiInterface.getArticlesBySource(param);

        articleCall.enqueue(new Callback<ArticleModel>() {
            @Override
            public void onResponse(Call<ArticleModel> call, Response<ArticleModel> response) {
                if (response.isSuccessful()) {
                    ArticleModel articleModel = response.body();
                    dataResponse.onSuccess(articleModel, "articles fetched successfully");
                } else {
                    try {
                        dataResponse.onFailure(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ArticleModel> call, Throwable t) {
                dataResponse.onFailure(t.getMessage());
            }
        });
    }

//    public List<Article> parseArticle(ArticleModel articleModel) {
//        List<Article> articles = new ArrayList<>();
//
//        if(articleModel.getArticles()!=null) {
//
//        }
//    }
}
