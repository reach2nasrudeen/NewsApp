package com.example.app.model.realm;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by nasrudeen on 6/9/17.
 */

public class ArticleRealmModel extends RealmObject {
    private String status;
    private String source;
    private String sortBy;
    private RealmList<ArticleRealm> articles;

    public RealmList<ArticleRealm> getArticles() {
        return articles;
    }

    public void setArticles(RealmList<ArticleRealm> articles) {
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
}
