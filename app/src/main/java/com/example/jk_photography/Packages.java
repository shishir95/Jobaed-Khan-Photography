package com.example.jk_photography;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import static android.webkit.WebSettings.LayoutAlgorithm.NARROW_COLUMNS;

public class Packages extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private AppBarConfiguration mAppBarConfiguration;

    //Group item1 = findViewById(R.id.nav_cinematography);

    private WebView webview;
    private DrawerLayout drawer;
    //Cinematography cinematography;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //checkPermission();
        webview = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webview.getSettings().setCacheMode(webSettings.LOAD_CACHE_ELSE_NETWORK);
        webview.getSettings().setAppCacheEnabled(true);
        webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webview.getSettings().setDomStorageEnabled(true);
        webview.getSettings().setLayoutAlgorithm(NARROW_COLUMNS);
        webview.getSettings().setUseWideViewPort(true);
        webview.getSettings().setSavePassword(true);
        webview.getSettings().setSaveFormData(true);
        webview.getSettings().setEnableSmoothTransition(true);
        webview.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                webview.loadUrl("javascript:(function() { " +
                        "var head = document.getElementsByTagName('header')[0].style.display='none'; " +
                        "})()");
            }
        });
        webview.loadUrl("https://jobaedkhan.com/packages/");


        setNavigationViewListener();

        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //FloatingActionButton fab = findViewById(R.id.fab);
        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        // NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        //NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /*@Override
    public boolean onSupportNavigateUp() {
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                //|| super.onSupportNavigateUp();
    }*/
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.nav_home) {
            //do somthing
            Intent intent = new Intent(Packages.this,
                    MainActivity.class);
            startActivity(intent);
            return false;
        }
        else if (id == R.id.nav_album){

            Intent intent = new Intent(Packages.this,
                    Album.class);
            startActivity(intent);
            return false;

        }
        else if (id == R.id.nav_story){

            Intent intent = new Intent(Packages.this,
                    Story.class);
            startActivity(intent);
            return false;

        }
        else if (id == R.id.nav_cinematography){

            Intent intent = new Intent(Packages.this,
                    Cinematography.class);
            startActivity(intent);
            return false;

        }
        else if (id == R.id.nav_packages){

            Intent intent = new Intent(Packages.this,
                    Packages.class);
            startActivity(intent);
            return false;
        }
        else if (id == R.id.nav_gallery){

            Intent intent = new Intent(Packages.this,
                    Gallery.class);
            startActivity(intent);
            return false;

        }
        //close navigation drawer
        return super.onOptionsItemSelected(item);
    }

    private void setNavigationViewListener() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    public void onBackPressed(){
        super.onBackPressed();
    }
}
