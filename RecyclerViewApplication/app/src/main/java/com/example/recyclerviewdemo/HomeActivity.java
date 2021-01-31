package com.example.recyclerviewdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        //step 1 create tool bar for title  and set the obj inside the setsupportactionbar()
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//create drawer layout obj
          drawer=findViewById(R.id.drawer);
          //drawertoggle for open close animation and state management
        ActionBarDrawerToggle drawerToggle=new ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close);
        //we are setting the drawertoggle to drawe layout listener
        drawer.addDrawerListener(drawerToggle);
        //to mainatain open close sync
        drawerToggle.syncState();

        //creating navigation view obj and setting the listenr to tha activity
        //by setting the listener to the activity we have to implement NavigationView.OnNavigationItemClickListene interface
        // then we get the onNavigationItemClickListener() overrided
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        //this will show us the home button on the toolbar
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);

    }





    //we are replaceing the framgent based on the object param
    public void replaceFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
    }

    @Override
    public void onBackPressed() {
         if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //when item is clicked in the navigation view it will call this method
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        //TODO how to close navigation drawer when itemclicked 
        Log.d("TAG", "onNavigationItemSelected: ");
        if (menuItem.getItemId()==R.id.nav_home){
            //TODO replace  home fragment
            HomeFragment homeFragment=new HomeFragment();
            replaceFragment(homeFragment);
            return true;
        }else if (menuItem.getItemId()==R.id.nav_gallery){
            //TODO replace Gallery fragment
            GalleryFragment galleryFragment=new GalleryFragment();
            replaceFragment(galleryFragment);
            return true;
        }else {
            return false;
        }    }
}
