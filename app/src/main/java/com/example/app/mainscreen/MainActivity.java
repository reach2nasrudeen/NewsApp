package com.example.app.mainscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.app.News.NewsActivity;
import com.example.app.R;
import com.example.app.base.BaseActivity;
import com.example.app.model.Source;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements MainViewDelegate {
    private RecyclerView recyclerView;
    private MainViewModel viewModel;
    private SourceListAdapter sourceListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new MainViewModel(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        setUpRecyclerViewWithAdapter();
        viewModel.onLoad();
    }

    private void setUpRecyclerViewWithAdapter() {
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);

        sourceListAdapter = new SourceListAdapter(this, new ArrayList<Source>(), this);
        recyclerView.setAdapter(sourceListAdapter);
    }

    @Override
    public void updateData() {
        sourceListAdapter.updateData(viewModel.getSources());
    }

    @Override
    public void onSourceSelected(Source source) {
        startActivity(new Intent(this, NewsActivity.class).putExtra("sourceId", source.getId()));
    }
}
