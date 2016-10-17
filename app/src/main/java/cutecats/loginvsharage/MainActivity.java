package cutecats.loginvsharage;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import cutecats.loginvsharage.Fragments.FragmentProfile;
import cutecats.loginvsharage.Fragments.FragmentAbout;
import cutecats.loginvsharage.Fragments.FragmentMessages;
import cutecats.loginvsharage.Fragments.FragmentSettings;
import cutecats.loginvsharage.Fragments.FragmentTaskTable;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentMessages fmessages;    /** Объявление переменных для пунктов меню Navigation Drawer */
    FragmentProfile fprofile;
    FragmentSettings fsettings;
    FragmentTaskTable ftasktable;
    FragmentAbout fabout;


    static{    /** Статический метод для автоматической смены темы */
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fmessages = new FragmentMessages(); /** Инициализация переменных для пунктов меню Navigation Drawer */
        fprofile = new FragmentProfile();
        fsettings = new FragmentSettings();
        ftasktable = new FragmentTaskTable();
        fabout = new FragmentAbout();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        /** Методом FragmentTransaction реализуем переходы в меню Navigation Drawer */

        FragmentTransaction ftrans = getFragmentManager().beginTransaction();

        if (id == R.id.activity_profile) {
            ftrans.replace(R.id.container, fprofile);

        } else if (id == R.id.activity_messages) {

            ftrans.replace(R.id.container, fmessages);

        } else if (id == R.id.activity_task_table) {

            ftrans.replace(R.id.container, ftasktable);

        } else if (id == R.id.activity_settings) {

            ftrans.replace(R.id.container, fsettings);

        } else if (id == R.id.activity_about) {

            ftrans.replace(R.id.container, fabout);

        }ftrans.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
