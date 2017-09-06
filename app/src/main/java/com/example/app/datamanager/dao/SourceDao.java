package com.example.app.datamanager.dao;

import android.util.Log;

import com.example.app.callbacks.DaoResponse;
import com.example.app.model.realm.SourceRealm;

import java.util.List;

import io.realm.Realm;

/**
 * Created by nasrudeen on 6/9/17.
 */

public class SourceDao {
    private final String TAG = SourceDao.class.getSimpleName();

    public void storeOrUpdateSourceList(final List<SourceRealm> athleteList, final DaoResponse callback) {
        final Realm realm = Realm.getDefaultInstance();

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                // As primary key is involved, use copy to realm or update as it will create or
                //  update based on object availability.
                realm.copyToRealmOrUpdate(athleteList);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                callback.onSuccess("Athlete list saved successfully!");
                realm.close();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Log.d(TAG, error.getMessage());
                callback.onFailure("Athlete list save failed!");
                realm.close();
            }
        });
    }

    public void clearDataIfAvailable(final DaoResponse callback) {
        final Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(SourceRealm.class);
            }
        },new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                callback.onSuccess("Ref data list deleted successfully!");
                realm.close();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Log.e(TAG, error.getMessage());
                callback.onFailure("Ref data list deletion failed!");
                realm.close();
            }
        });
    }

    public List<SourceRealm> getSourceList() {
        Realm realm = Realm.getDefaultInstance();

        List<SourceRealm> sourceRealmList = realm.where(SourceRealm.class)
                .findAll();

        if (sourceRealmList != null) {
            sourceRealmList = realm.copyFromRealm(sourceRealmList);
        }

        realm.close();

        return sourceRealmList;
    }
}
