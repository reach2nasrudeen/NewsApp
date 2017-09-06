package com.example.app.model.realm;

import io.realm.RealmObject;

/**
 * Created by nasrudeen on 6/9/17.
 */

public class SortByAvailable extends RealmObject {
    private String sortBysAvailable;

    public String getSortBysAvailable() {
        return sortBysAvailable;
    }

    public void setSortBysAvailable(String sortBysAvailable) {
        this.sortBysAvailable = sortBysAvailable;
    }
}
