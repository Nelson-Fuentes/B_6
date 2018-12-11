package com.example.nelson.women;

import android.content.Intent;
import android.net.Uri;
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
import android.widget.ImageView;
import android.widget.TextView;

public class Ventas extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ImageView user, product;
    private String [] users = {"Olivia Holt", "Elizabeth Olsen"};
    private String [] usersI = {"@drawable/user3", "@drawable/user_pr"};
    private String [] cloth = {"@drawable/shoe1", "@drawable/shoe5"};
    private String [] cantidades = {"9", "10"};
    private String [] tallas = {"Small", "Medium"};
    private String [] colores = {"Azul", "Rojo"};
    private TextView username, talla, color, cantidad;
    private int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        user = (ImageView) this.findViewById(R.id.user);
        product = (ImageView) this.findViewById(R.id.product);

        username = (TextView) this.findViewById(R.id.username);
        talla = (TextView) this.findViewById(R.id.talla);
        color = (TextView) this.findViewById(R.id.color);
        cantidad = (TextView) this.findViewById(R.id.cantidad);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void next (View view){
        i++;
        i= i%2;
        if (i == 1) {
            user.setImageResource(R.drawable.user_pr);
            product.setImageResource(R.drawable.shoe5);
        } else{
            user.setImageResource(R.drawable.user3);
            product.setImageResource(R.drawable.shoe1);
        }

        username.setText(users[i]);
        talla.setText(tallas[i]);
        color.setText(colores[i]);
        cantidad.setText(cantidades[i]);
    }
    public void prev (View view){
        i--;
        if (i==-1){
            i=1;
        }
        if (i == 1) {
            user.setImageResource(R.drawable.user_pr);
            product.setImageResource(R.drawable.shoe5);
        } else{
            user.setImageResource(R.drawable.user3);
            product.setImageResource(R.drawable.shoe1);
        }

        username.setText(users[i]);
        talla.setText(tallas[i]);
        color.setText(colores[i]);
        cantidad.setText(cantidades[i]);
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
        getMenuInflater().inflate(R.menu.ventas, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
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
}
