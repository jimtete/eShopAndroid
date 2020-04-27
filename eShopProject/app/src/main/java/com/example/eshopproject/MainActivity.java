package com.example.eshopproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    public static FragmentManager fragmentManager;
    public static EshopDatabase eshopDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(this);

//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                switch (menuItem.getItemId()){
//                    case R.id.profile:
//                        switch (menuItem.getItemId()){
//                            case R.id.profile:
//                                menuItem.setChecked(true);
//                                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new ProfilesQueryFragment()).addToBackStack(null).commit();
//                                drawerLayout.closeDrawers();
//                                return true;
//                            case R.id.past_orders:
//                                menuItem.setChecked(true);
//                                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new ProfilesQueryFragment()).addToBackStack(null).commit();
//                                drawerLayout.closeDrawers();
//                                return true;
//                        }
//                        return false;
//                }
//
//                return false;
//            }
//        });


        fragmentManager = getSupportFragmentManager();
        eshopDatabase = Room.databaseBuilder(getApplicationContext(),EshopDatabase.class,"eshopDB").allowMainThreadQueries().build();


        if (findViewById(R.id.fragment_container)!=null){
            if(savedInstanceState!=null)return;
            fragmentManager.beginTransaction().add(R.id.fragment_container, new HomeFragment()).commit();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id==R.id.profile){
            menuItem.setChecked(true);
            MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new ProfilesQueryFragment()).addToBackStack(null).commit();
            drawerLayout.closeDrawers();
            return true;
        }

        if (id==R.id.past_orders){
            menuItem.setChecked(true);
            MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new SalesQueryFragment()).addToBackStack(null).commit();
            drawerLayout.closeDrawers();
            return true;
        }

        if (id==R.id.adminstrator){
            menuItem.setChecked(true);
            MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new AdminFragment()).addToBackStack(null).commit();
            drawerLayout.closeDrawers();;
            return true;
        }

        if (id==R.id.delete){
            menuItem.setChecked(true);
            MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeleteFragment()).addToBackStack(null).commit();
            drawerLayout.closeDrawers();;
            return true;
        }



        return false;
    }
}
