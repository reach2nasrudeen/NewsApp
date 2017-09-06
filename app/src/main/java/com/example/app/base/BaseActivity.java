package com.example.app.base;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.app.R;


public class BaseActivity extends AppCompatActivity implements AppConstants {
    private boolean isDoubleTappedToExit;
    private SessionManager mPreference;

    public void onBackPressed(View view) {
        if (isDoubleTappedToExit) {
            super.onBackPressed();
            return;
        }
        this.isDoubleTappedToExit = true;
        Snackbar.make(view, getResources().getString(R.string.press_again_to_exit), Snackbar.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                isDoubleTappedToExit = false;
            }
        }, 5000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public NewsApp getApp() {
        return (NewsApp) getApplication();
    }

    public SessionManager getSessionManager() {
        if (mPreference == null) {
            mPreference = new SessionManager(this);
        }
        return mPreference;
    }

}
