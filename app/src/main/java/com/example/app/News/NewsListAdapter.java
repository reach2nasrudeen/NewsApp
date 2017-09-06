package com.example.app.News;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.app.R;
import com.example.app.mainscreen.MainViewDelegate;
import com.example.app.model.Article;
import com.example.app.model.Source;

import java.util.List;

/**
 * Created by nasrudeen on 6/9/17.
 */

class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsListViewHolder> {
    private Context mContext;
    private List<Article> articles;
    private NewsViewDelegate viewDelegate;

    NewsListAdapter(Context mContext, List<Article> articles, NewsViewDelegate viewDelegate) {
        this.articles = articles;
        this.mContext = mContext;
        this.viewDelegate = viewDelegate;
    }

    @Override
    public NewsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news_list, parent, false);

        return new NewsListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NewsListViewHolder holder, final int position) {
        Article article = articles.get(position);
        holder.title.setText(article.getTitle());
        holder.desc.setText(article.getDescription());
        holder.author.setText(article.getAuthor());
        holder.dateTime.setText(article.getPublishedAt());
        Glide.with(mContext)
                .load(article.getUrlToImage())
                .into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewDelegate.onArticleSelected(articles.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public void updateData(List<Article> articles) {
        this.articles = articles;
        notifyDataSetChanged();
    }
    @Override
    public void setHasStableIds(boolean hasStableIds) {
        super.setHasStableIds(hasStableIds);
    }

    static class NewsListViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView title, desc,dateTime,author;
        private ImageView image;

        private NewsListViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.title);
            desc = v.findViewById(R.id.desc);
            dateTime = v.findViewById(R.id.dateTime);
            author = v.findViewById(R.id.author);
            image = v.findViewById(R.id.image);
        }
    }
}
