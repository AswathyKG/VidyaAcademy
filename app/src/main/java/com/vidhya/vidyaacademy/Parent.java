package com.vidhya.vidyaacademy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class Parent extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}