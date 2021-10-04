package com.example.anaraadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class web extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
    }
    public void navigate_kontak(View v){
        Intent inent = new Intent(this, kontak.class);
        startActivity(inent);
    }
}