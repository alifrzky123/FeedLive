package com.project.feedlive.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.project.feedlive.R;
import com.project.feedlive.fragment.AddFragment;
import com.project.feedlive.fragment.HomeFragment;
import com.project.feedlive.fragment.LikeFragment;
import com.project.feedlive.fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_nav_bar);
        getFragmentPage(new HomeFragment());
        bottomNavbar();
    }
    private void bottomNavbar(){
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()){
                    case R.id.nav_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.nav_add :
                        fragment = new AddFragment();
                        break;
                    case R.id.nav_profil :
                        fragment = new ProfileFragment();
                        break;
                    case R.id.nav_liked_post :
                        fragment = new LikeFragment();
                        break;
                    default:
                        break;
                }
                return getFragmentPage(fragment);
            }
        });
    }
    private boolean getFragmentPage(Fragment fragment){
        if (fragment!=null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.rv_container,fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
