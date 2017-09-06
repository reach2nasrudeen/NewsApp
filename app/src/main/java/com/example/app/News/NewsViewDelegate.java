package com.example.app.News;

import com.example.app.model.Article;

/**
 * Created by nasrudeen on 6/9/17.
 */

public interface NewsViewDelegate {
    void updateData();
    void onArticleSelected(Article article);
}
