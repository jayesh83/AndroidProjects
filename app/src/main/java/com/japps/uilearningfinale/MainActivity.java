package com.japps.uilearningfinale;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    NavController controller;
    AppBarConfiguration barConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        controller = Navigation.findNavController(this, R.id.mainNavHost);
        drawerLayout = findViewById(R.id.mainDrawerLayout);
        navigationView = findViewById(R.id.side_nav_view);
        // listenNowFragment and musicLibrary, are top-level destination
        barConfiguration = new AppBarConfiguration.Builder(R.id.listenNowFragment, R.id.musicLibraryFragment)
                .setDrawerLayout(drawerLayout).build();

        NavigationUI.setupWithNavController(toolbar, controller, barConfiguration);

        NavigationUI.setupWithNavController(navigationView, controller);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(controller, barConfiguration) || super.onSupportNavigateUp();
    }
}
