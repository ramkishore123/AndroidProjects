package com.example.navigationretrofit;

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

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private static final String TAG ="MainActivity" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            //get the toolbar
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //we need to get the drawer

        drawer=findViewById(R.id.drawer_layout);
        //add toggle to actionBar

        ActionBarDrawerToggle drawerToggle= new ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close);
        drawer.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        //get the navigation

        NavigationView navigationView=findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(MainActivity.this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public void replaceFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.cv_fragment,fragment).commit();

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Log.d(TAG, "onNavigationItemSelected: items selected");
        if(menuItem.getItemId()==R.id.nav_singleUser){
            singleUserFragment singleuserFragment=new singleUserFragment();
            replaceFragment(singleuserFragment);
            return true;
        }

        else  if(menuItem.getItemId()==R.id.nav_userList){
            userListFragment userlistFragment= new userListFragment();
            replaceFragment(userlistFragment);
            return  true;

        }



        else  if(menuItem.getItemId()==R.id.nav_singleResource){
            singleResourceFragment singleresourceFragment= new singleResourceFragment();
            replaceFragment(singleresourceFragment);
            return  true;

        }


        else  if(menuItem.getItemId()==R.id.nav_ResourceList){
            resouceListFragment resourcelistFragment= new resouceListFragment();
            replaceFragment(resourcelistFragment);
            return  true;

        }
        else{
            return false;
        }
    }

}
