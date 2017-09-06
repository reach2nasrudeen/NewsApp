package com.example.app.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by nasrudeen on 6/9/17.
 */

public class SourceModel implements Serializable {
    private String status;
    private List<Source> sources;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }
}
