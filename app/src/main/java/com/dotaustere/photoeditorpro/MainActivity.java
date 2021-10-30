package com.dotaustere.photoeditorpro;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.dotaustere.photoeditorpro.ui.restart.RestartFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
private NavigationView mNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,R.id.nav_setting, R.id.nav_ratePhoto, R.id.nav_share, R.id.nav_reportbug, R.id.nav_restartApp, R.id.nav_backup, R.id.nav_about_editor)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
  switch (item.getItemId()){

      case R.id.nav_setting:

          Intent intent  = new Intent(MainActivity.this,Preference.class);
          startActivity(intent);
          break;

      case R.id.nav_ratePhoto:

          try {
              startActivity(new Intent(Intent.ACTION_VIEW,

                      Uri.parse("market://details?id="+"com.android.chrome")));

          }catch (ActivityNotFoundException e){

              startActivity(new Intent(Intent.ACTION_VIEW,
                      Uri.parse("http:play.google.com/store/apps/details?id="+getPackageName())));


          }
          break;

      case R.id.nav_share:

          Intent intent2 = new Intent(Intent.ACTION_SEND);
          intent2.setType("text/plain");
          intent2.putExtra(Intent.EXTRA_SUBJECT, "My application name");
          intent2.putExtra(Intent.EXTRA_TEXT, "com.android.facebook");
          startActivity(Intent.createChooser(intent2, "choose one"));
          break;

      case R.id.nav_restartApp:

        Intent a = new Intent(MainActivity.this ,RestartFragment.class);
        startActivity(a);


      default:


  }

                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {

        switch (item.getItemId()){

            case R.id.action_settings:
                Intent intent = new Intent(this,Preference.class);
                startActivity(intent);


        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}