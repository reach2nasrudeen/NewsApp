package com.example.app.mainscreen;

import com.example.app.model.Source;

/**
 * Created by nasrudeen on 6/9/17.
 */

public interface MainViewDelegate {
    void updateData();
    void onSourceSelected(Source source);
}
