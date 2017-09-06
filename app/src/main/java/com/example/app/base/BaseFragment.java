package com.example.app.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public class BaseFragment extends Fragment implements AppConstants {
    private ProgressDialog mProgressDialog;
    private SessionManager mPreference;
    private long mLastClickTime = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public NewsApp getApp() {
        return (NewsApp) getActivity().getApplication();
    }

    public SessionManager getSessionManager() {
        if (mPreference == null) {
            mPreference = new SessionManager(getContext());
        }
        return mPreference;
    }
}
