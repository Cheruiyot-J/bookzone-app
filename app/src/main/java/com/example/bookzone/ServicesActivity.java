package com.example.bookzone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ServicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        getSupportActionBar().setTitle("Our Services");
    }
}
