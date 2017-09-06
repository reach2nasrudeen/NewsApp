package com.example.app.mainscreen;

import com.example.app.model.Source;

import java.util.List;

/**
 * Created by nasrudeen on 6/9/17.
 */

public class MainBaseViewModel {
    private List<Source> sources;

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }
}
