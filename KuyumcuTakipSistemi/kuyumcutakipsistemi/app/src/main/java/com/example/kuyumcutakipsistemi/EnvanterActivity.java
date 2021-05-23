package com.example.kuyumcutakipsistemi;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class EnvanterActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    private DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout_envanter);
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envanter);

        toolbar =(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer=(DrawerLayout)findViewById(R.id.drawer_layout_envanter);
        navigationView=(NavigationView)findViewById(R.id.nav_view_envanter);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState==null){
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new FragmentKategoriEnvanter() ).commit();
                navigationView.setCheckedItem(R.id.nav_kategori);
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch ((item.getItemId())){
            case R.id.nav_kategori:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new FragmentKategoriEnvanter() ).commit();
                break;
            case R.id.nav_marka:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new FragmentMarkaEnvanter()).commit();
                break;
            case R.id.nav_altin:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new FragmentAltinEnvanter()).commit();
                break;
            case R.id.nav_ziynet:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new FragmentZiynetEnvanter()).commit();
                break;
            case R.id.nav_doviz:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new FragmentDovizEnvanter()).commit();
                break;
            case R.id.nav_pirlanta:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new FragmentPirlantaEnvanter()).commit();
                break;
            case R.id.nav_saat:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new FragmentSaatEnvanter()).commit();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public DrawerLayout getDrawer() {
        return drawer;
    }

    public void setDrawer(DrawerLayout drawer) {
        this.drawer = drawer;
    }
}