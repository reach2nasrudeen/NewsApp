package com.example.app.base;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.app.R;
import com.example.app.callbacks.DaoResponse;
import com.example.app.callbacks.DataResponse;
import com.example.app.datamanager.SourceManager;
import com.example.app.datamanager.dao.SourceDao;
import com.example.app.mainscreen.MainActivity;
import com.example.app.model.SourceModel;
import com.example.app.model.realm.SourceRealm;
import com.example.app.util.DeviceHelper;

import java.util.List;


public class SplashActivity extends BaseActivity {
    private SessionManager mSessionManager;
    private Context mContext;
    private SourceManager sourceManager;
    private SourceDao sourceDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mContext = this;
        changeStatusBarColor();
        mSessionManager = new SessionManager(mContext);
        sourceManager = new SourceManager();
        sourceDao = new SourceDao();

        getSourceList();
    }

    private void getSourceList() {
        if (DeviceHelper.isInternetConnected(mContext)) {
            sourceManager.getAvailableSourceList(new DataResponse<SourceModel>() {
                @Override
                public void onSuccess(String message) {
                    // No implementation
                }

                @Override
                public void onSuccess(SourceModel item, String message) {
                    Log.e(SplashActivity.class.getSimpleName(), "Got Source");
                    Log.e(SplashActivity.class.getSimpleName(), item.toString());
                    final List<SourceRealm> sourceRealmList = sourceManager.parseSourceList(item);
                    sourceDao.clearDataIfAvailable(new DaoResponse() {
                        @Override
                        public void onSuccess(String message) {
                            sourceDao.storeOrUpdateSourceList(sourceRealmList, new DaoResponse() {
                                @Override
                                public void onSuccess(String message) {
                                    initActivity(new Intent(mContext, MainActivity.class));
                                }

                                @Override
                                public void onSuccess(Object item, String message) {

                                }

                                @Override
                                public void onFailure(String errorMessage) {

                                }
                            });
                        }

                        @Override
                        public void onSuccess(Object item, String message) {

                        }

                        @Override
                        public void onFailure(String errorMessage) {

                        }
                    });


                }

                @Override
                public void onFailure(String errorMessage) {
                    Log.e(SplashActivity.class.getSimpleName(), errorMessage);
                }

                @Override
                public void onFailure(String errorMessage, String statusCode) {
                    Log.e(SplashActivity.class.getSimpleName(), errorMessage);
                }
            });
        } else {
            Toast.makeText(mContext, "No Internet connection", Toast.LENGTH_SHORT).show();
            finish();
        }

    }

    private void initActivity(Intent intent) {
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
        finish();
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = this.getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }
}

