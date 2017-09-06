package com.example.app.News;

import com.example.app.model.Article;

import java.util.List;

/**
 * Created by nasrudeen on 6/9/17.
 */

public class NewsBaseViewModel {
    private String sourceId;
    private List<Article> articles;

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
