package com.example.app.base;

import android.app.Application;
import android.content.Context;

import com.example.app.rest.NewsApiClient;
import com.example.app.rest.NewsApiInterface;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

public class NewsApp extends Application {
    public static Context mContext;
    protected static NewsApp mInstance;
    private SessionManager mSharedPreferences;
    private NewsApiClient newsApiClient;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mContext = getApplicationContext();
        mSharedPreferences = new SessionManager(this);
        newsApiClient = new NewsApiClient();

        Realm.init(this);

        // The Realm file will be located in Context.getFilesDir() with name "default.realm"
        RealmConfiguration realmConfiguration = new RealmConfiguration
                .Builder()
                .schemaVersion(0)
                .migration(new RealmMigration() {
                    @Override
                    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {

                        // DynamicRealm exposes an editable schema
                        RealmSchema schema = realm.getSchema();

                        // No major migration during development phase.
                        if (oldVersion == 0) {

                        }
                    }
                })
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);

    }

    public static synchronized Context getContext() {
        return mContext;
    }

    public static NewsApp getApp() {
        if (mInstance != null && mInstance instanceof NewsApp) {
            return mInstance;
        } else {
            mInstance = new NewsApp();
            mInstance.onCreate();
            return mInstance;
        }
    }

    public SessionManager getUserPreference() {
        return mSharedPreferences;
    }

    public NewsApiInterface getRetrofitInterface() {
        return newsApiClient.getClientInterface();
    }
}