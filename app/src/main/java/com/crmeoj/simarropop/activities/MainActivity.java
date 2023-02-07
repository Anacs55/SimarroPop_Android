package com.crmeoj.simarropop.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.crmeoj.simarropop.R;
import com.crmeoj.simarropop.fragments.FavoriteFragment;
import com.crmeoj.simarropop.fragments.MessageFragment;
import com.crmeoj.simarropop.fragments.UpFragment;
import com.crmeoj.simarropop.fragments.WelcomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = (BottomNavigationView) findViewById(R.id.menu_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().add(R.id.contenedor, new WelcomeFragment()).commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment f = null;

        switch (item.getItemId()) {

            case R.id.navigation_welcome:
                f = new WelcomeFragment();
                break;

            case R.id.navigation_favorite:
                f = new FavoriteFragment();
                break;

            case R.id.navigation_up:
                f = new UpFragment();
                break;

            case R.id.navigation_message:
                f = new MessageFragment();
                break;

        }

        if (f!=null) {

            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, f).commit();

        }

        return true;
    }
}