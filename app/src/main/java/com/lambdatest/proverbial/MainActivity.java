package com.lambdatest.proverbial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.lambdatest);
        actionBar.setTitle("\t\t\t\t\tProverbial");

        NavigationBarView navigationBarView = findViewById(R.id.navigationBar);
        navigationBarView.setOnItemSelectedListener(bottomNav);
        navigationBarView.setSelectedItemId(R.id.buttonPage);
    }

    NavigationBarView.OnItemSelectedListener bottomNav = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()){
                case R.id.webview:
                    fragment = new BrowserFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment)
                            .addToBackStack("browser").commit();
                    break;
                case R.id.buttonPage:
                    fragment = new ButtonFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment)
                        .addToBackStack("ButtonPage").commit();
                    break;
            }
            return true;
        }
    };

}