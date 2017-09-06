package com.example.app.datamanager;

import com.example.app.callbacks.DataResponse;
import com.example.app.model.Source;
import com.example.app.model.SourceModel;
import com.example.app.model.UrlsToLogos;
import com.example.app.model.realm.SortByAvailable;
import com.example.app.model.realm.SourceRealm;
import com.example.app.model.realm.UrlsToLogosRealm;
import com.example.app.rest.NewsApiInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.app.base.NewsApp.getApp;

/**
 * Created by Nasrudeen on 6/9/17.
 */

public class SourceManager {
    private NewsApiInterface newsApiInterface;

    public SourceManager() {
        newsApiInterface = getApp().getRetrofitInterface();
    }

    public void getAvailableSourceList(final DataResponse<SourceModel> dataResponse) {
        Call<SourceModel> bodyCall = newsApiInterface.getAvailableSources();

        bodyCall.enqueue(new Callback<SourceModel>() {
            @Override
            public void onResponse(Call<SourceModel> call, Response<SourceModel> response) {
                if (response.isSuccessful()) {
                    SourceModel sourceModel = response.body();
                    dataResponse.onSuccess(sourceModel, "sources fetched successfully");
                } else {
                    try {
                        dataResponse.onFailure(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<SourceModel> call, Throwable t) {
                dataResponse.onFailure(t.getMessage());
            }
        });
    }

    public List<SourceRealm> parseSourceList(SourceModel sourceModel) {
        List<SourceRealm> sourceRealmList = new RealmList<>();

        List<Source> sources = sourceModel.getSources();
        if(sources!=null) {
            for(Source source: sources) {
                SourceRealm sourceRealm = new SourceRealm();
                sourceRealm.setCountry(source.getCountry());
                sourceRealm.setName(source.getName());
                sourceRealm.setCategory(source.getCategory());
                sourceRealm.setDescription(source.getDescription());
                sourceRealm.setId(source.getId());
                sourceRealm.setLanguage(source.getLanguage());
                sourceRealm.setUrl(source.getUrl());
                RealmList<SortByAvailable> sortByAvailables = new RealmList<>();

                List<String> sortByAvailable = source.getSortBysAvailable();
                if(sortByAvailable!=null) {
                    for(String strSortByAvailable : sortByAvailable) {
                        SortByAvailable sortByAvailableRealm = new SortByAvailable();
                        sortByAvailableRealm.setSortBysAvailable(strSortByAvailable);
                        sortByAvailables.add(sortByAvailableRealm);
                    }
                }
                sourceRealm.setSortBysAvailable(sortByAvailables);

                UrlsToLogosRealm urlsToLogosRealm = new UrlsToLogosRealm();
                urlsToLogosRealm.setSmall(source.getUrlsToLogos().getSmall());
                urlsToLogosRealm.setMedium(source.getUrlsToLogos().getMedium());
                urlsToLogosRealm.setLarge(source.getUrlsToLogos().getLarge());

                sourceRealm.setUrlsToLogos(urlsToLogosRealm);
                sourceRealmList.add(sourceRealm);
            }
        }

        return sourceRealmList;
    }

    public List<Source> parseSourceRealmList(List<SourceRealm> sourceRealmList) {

        List<Source> sources = new ArrayList<>();
        if(sourceRealmList!=null) {
            for(SourceRealm sourceRealm: sourceRealmList) {
                Source source = new Source();
                source.setCountry(sourceRealm.getCountry());
                source.setName(sourceRealm.getName());
                source.setCategory(sourceRealm.getCategory());
                source.setDescription(sourceRealm.getDescription());
                source.setId(sourceRealm.getId());
                source.setLanguage(sourceRealm.getLanguage());
                source.setUrl(sourceRealm.getUrl());
                RealmList<SortByAvailable> sortByAvailables = sourceRealm.getSortBysAvailable();

                ArrayList<String> sortByAvailable = new ArrayList<>();
                if(sortByAvailables!=null) {
                    for(SortByAvailable sortByAvailableRealm : sortByAvailables) {
                        sortByAvailable.add(sortByAvailableRealm.getSortBysAvailable());
                    }
                }
                source.setSortBysAvailable(sortByAvailable);

                UrlsToLogos urlsToLogos = new UrlsToLogos();
                urlsToLogos.setSmall(sourceRealm.getUrlsToLogos().getSmall());
                urlsToLogos.setMedium(sourceRealm.getUrlsToLogos().getMedium());
                urlsToLogos.setLarge(sourceRealm.getUrlsToLogos().getLarge());

                source.setUrlsToLogos(urlsToLogos);
                sources.add(source);
            }
        }

        return sources;
    }
}
