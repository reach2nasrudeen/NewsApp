package com.example.app.mainscreen;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.app.R;
import com.example.app.model.Source;

import java.util.List;

/**
 * Created by nasrudeen on 6/9/17.
 */

class SourceListAdapter extends RecyclerView.Adapter<SourceListAdapter.SourceListViewHolder> {
    private Context mContext;
    private List<Source> sources;
    private MainViewDelegate viewDelegate;

    SourceListAdapter(Context mContext, List<Source> sources, MainViewDelegate viewDelegate) {
        this.sources = sources;
        this.mContext = mContext;
        this.viewDelegate = viewDelegate;
    }

    @Override
    public SourceListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_source_list, parent, false);

        return new SourceListAdapter.SourceListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SourceListViewHolder holder, final int position) {
        Source source = sources.get(position);
        holder.name.setText(source.getName());
        holder.desc.setText(source.getDescription());
        /*Glide.with(mContext)
                .load(source.getUrlsToLogos().getLarge())
                .into(holder.logo);*/

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewDelegate.onSourceSelected(sources.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return sources.size();
    }

    public void updateData(List<Source> sources) {
        this.sources = sources;
        notifyDataSetChanged();
    }
    @Override
    public void setHasStableIds(boolean hasStableIds) {
        super.setHasStableIds(hasStableIds);
    }

    static class SourceListViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView name, desc;
//        private ImageView logo;

        private SourceListViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.name);
            desc = v.findViewById(R.id.desc);
//            logo = v.findViewById(R.id.logo);
        }
    }
}
