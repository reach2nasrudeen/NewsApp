package com.example.app.category;

import android.os.Bundle;

import com.example.app.R;
import com.example.app.base.BaseActivity;


public class CategoryActivity extends BaseActivity implements CategoryViewDelegate {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
    }
}
