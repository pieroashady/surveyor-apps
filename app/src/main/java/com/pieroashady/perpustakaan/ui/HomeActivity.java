package com.pieroashady.perpustakaan.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pieroashady.perpustakaan.R;

public class HomeActivity extends AppCompatActivity {

    FloatingActionButton btnAdd, btnView, btnLogOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_grid_fab);

        btnAdd = findViewById(R.id.btnAdd);
        btnView = findViewById(R.id.btnView);
        btnLogOut = findViewById(R.id.btnLogOut);

        btnAdd.setOnClickListener((addCust)->{
            Intent add = new Intent(HomeActivity.this, FormSurveyor.class);
            startActivity(add);
            finish();
        });

        btnView.setOnClickListener((viewCust)->{
            Intent view = new Intent(HomeActivity.this, UserMenu.class);
            startActivity(view);
        });

        btnLogOut.setOnClickListener((out)->{
            Intent logOut = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(logOut);
            finish();
        });
    }

    private void initToolBar(){

    }
}
