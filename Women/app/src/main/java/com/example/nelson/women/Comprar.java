package com.example.nelson.women;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Comprar extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
Spinner spinner,spinner2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        spinner=(Spinner)findViewById(R.id.spinner2);
        spinner2=(Spinner)findViewById(R.id.spinner3);
        String [] sarr = {"s", "l", "m", "xl"};
        ArrayAdapter<String> arrs = new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item, sarr);
        spinner2.setAdapter(arrs);
        String [] colores = {"rojo", "azul", "amarillo", "verde"};
        ArrayAdapter<String> col = new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item, colores);
        spinner.setAdapter(col);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.comprar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_ventas) {
            Intent inte = new Intent(this, Ventas.class);
            this.startActivity(inte);
        } else if (id == R.id.nav_vender) {
            Intent inte = new Intent(this, Vender.class);
            this.startActivity(inte);

        } else if (id == R.id.nav_sended) {
            Intent inte = new Intent(this, Sended.class);
            this.startActivity(inte);
        } else if (id == R.id.nav_received) {
            Intent inte = new Intent(this, Received.class);
            this.startActivity(inte);

        } else if (id == R.id.nav_mypro) {
            Intent inte = new Intent(this, MisProd.class);
            this.startActivity(inte);

        }
        else if (id == R.id.nav_miscompras) {
            Intent inte = new Intent(this, MisCompras.class);
            this.startActivity(inte);

        }
        else if (id == R.id.nav_prod) {
            Intent inte = new Intent(this, Productos.class);
            this.startActivity(inte);
        }
        else if (id == R.id.nav_productospendientes) {
            Intent inte = new Intent(this, ProductosPendientes.class);
            this.startActivity(inte);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void MisCompras(View view){
        Intent i= new Intent(this,MisCompras.class);
        startActivity(i);
    }
    public void EnviarMensaje(View view){
        Intent i= new Intent(this,Sended.class);
        startActivity(i);
    }

}
