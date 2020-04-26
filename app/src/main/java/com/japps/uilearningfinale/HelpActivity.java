package com.japps.uilearningfinale;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HelpActivity extends AppCompatActivity {
    NavController controller;
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        // get hold of controller for Host Navigation Fragment
        controller = Navigation.findNavController(this, R.id.activity_help_mainNavHost);
        // get reference of views
        bottomNavigationView = findViewById(R.id.activity_help_bottom_navigation);
        toolbar = findViewById(R.id.activity_help_toolbar);
        // setup toolbar
        setSupportActionBar(toolbar);
        AppBarConfiguration barConfiguration = new AppBarConfiguration.Builder(controller.getGraph()).build();
        NavigationUI.setupWithNavController(toolbar, controller, barConfiguration);
        // setup bottom navigation view
        NavigationUI.setupWithNavController(bottomNavigationView, controller);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_help_toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.e("Menu clicked: ", "" + item.getTitle());
        return NavigationUI.onNavDestinationSelected(item, controller) || super.onOptionsItemSelected(item);
    }
}
