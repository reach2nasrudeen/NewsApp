package com.example.app.mainscreen;

import com.example.app.datamanager.SourceManager;
import com.example.app.datamanager.dao.SourceDao;
import com.example.app.model.realm.SourceRealm;

import java.util.List;

/**
 * Created by nasrudeen on 6/9/17.
 */

public class MainViewModel extends MainBaseViewModel implements MainDelegate{
    private MainViewDelegate viewDelegate;
    private SourceDao sourceDao;
    private SourceManager sourceManager;
    public MainViewModel(MainViewDelegate viewDelegate) {
        this.viewDelegate = viewDelegate;
        this.sourceDao = new SourceDao();
        this.sourceManager = new SourceManager();
    }

    @Override
    public void onLoad() {

        List<SourceRealm> sourceRealmList = sourceDao.getSourceList();
        if(sourceRealmList!=null) {
            setSources(sourceManager.parseSourceRealmList(sourceRealmList));
            viewDelegate.updateData();
        }
    }
}
