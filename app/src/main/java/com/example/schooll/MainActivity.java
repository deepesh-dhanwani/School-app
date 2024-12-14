package com.example.schooll;

import static com.example.schooll.R.color.purple;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(purple));
        // Setup toolbar
        setSupportActionBar(toolbar);

        // Setup Drawer Toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.OpenDrawer, R.string.CloseDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(android.R.color.white));
        toggle.syncState();


        // Load default fragment
        if (savedInstanceState == null) {
            loadFragment(new HomeFragment(), false);
        }

        // Handle Navigation Item Clicks
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.home) {
                loadFragment(new HomeFragment(), false);
                Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.about) {
                loadFragment(new aboutFragment(), false);
                Toast.makeText(MainActivity.this, "About Us", Toast.LENGTH_SHORT).show();
            } else if (R.id.contact_us == id) {
                loadFragment(new ContactUsFragment(), true);
                Toast.makeText(MainActivity.this, "Contact Us", Toast.LENGTH_SHORT).show();
            }else if (R.id.contact_list == id) {
                loadFragment(new ContactListFragment(), true);
                Toast.makeText(MainActivity.this, "Contact List", Toast.LENGTH_SHORT).show();
            }else if (R.id.getintouch == id) {
                loadFragment(new getintouchFragment(), true);
                Toast.makeText(MainActivity.this, "Contact List", Toast.LENGTH_SHORT).show();
            }
            else if (R.id.payment == id) {
                loadFragment(new paymentFragment(), true);
                Toast.makeText(MainActivity.this, "Contact List", Toast.LENGTH_SHORT).show();
            }
            // Close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    private void loadFragment(Fragment fragment, boolean addToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}
