package com.example.sarkaribook.AllActivities;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.sarkaribook.R;
import com.example.sarkaribook.ui.home.DownloadFragment;
import com.example.sarkaribook.ui.home.HomeFragment;
import com.example.sarkaribook.ui.home.PayFragment;
import com.example.sarkaribook.ui.home.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sarkaribook.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    Fragment fragment = null;
    FragmentTransaction fragmentTransaction;
    ImageView menuimageView;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        menuimageView = findViewById(R.id.menuIcon);


        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        navigationView.setItemIconTintList(ColorStateList.valueOf(R.color.white));

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottomNavView);
        navigation.setOnItemSelectedListener(mOnItemSelectedListener);
        fragment = new HomeFragment();
        switchFragment(fragment);

        menuimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drawer.isOpen()){
                    drawer.close();
                }else{
                    drawer.open();
                }
            }
        });
    }

    private BottomNavigationView.OnItemSelectedListener mOnItemSelectedListener
            = new BottomNavigationView.OnItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment ft;
            switch (item.getItemId()) {
                case R.id.bottom_nav_home:
                    fragment = new HomeFragment();
                    switchFragment(fragment);
                    return true;
                case R.id.bottom_nav_pay:
                    fragment = new PayFragment();
                    switchFragment(fragment);
                    return true;
                case R.id.bottom_nav_download:
                    fragment = new DownloadFragment();
                    switchFragment(fragment);
                    return true;
                case R.id.bottom_nav_people:
                    fragment = new UserFragment();
                    switchFragment(fragment);

                    return true;
            }
            return false;
        }

    };
    private void switchFragment(Fragment fragment) {
         fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment_content_main, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}