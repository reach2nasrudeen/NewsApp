package com.example.app.News;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.app.R;
import com.example.app.base.BaseActivity;
import com.example.app.model.Article;

import java.util.ArrayList;


public class NewsActivity extends BaseActivity implements NewsViewDelegate {
    private NewsViewModel viewModel;
    private RecyclerView recyclerView;
    private NewsListAdapter newsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        viewModel = new NewsViewModel(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        setUpRecyclerViewWithAdapter();

        if (getIntent().hasExtra("sourceId")) {
            viewModel.setSourceId(getIntent().getStringExtra("sourceId"));
            viewModel.onLoad();
        }
    }

    private void setUpRecyclerViewWithAdapter() {
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);

        newsListAdapter = new NewsListAdapter(this, new ArrayList<Article>(), this);
        recyclerView.setAdapter(newsListAdapter);
    }

    @Override
    public void updateData() {
        newsListAdapter.updateData(viewModel.getArticles());
    }

    @Override
    public void onArticleSelected(Article article) {
        startActivity(new Intent(this,NewsMoreActivity.class).putExtra("url",article.getUrl()));
    }
}
