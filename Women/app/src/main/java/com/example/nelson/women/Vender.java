package com.example.nelson.women;

import android.content.Intent;
import android.graphics.Color;
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
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.EditText;

public class Vender extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Spinner sp;
    private Button img;
    private TextView cantlbl , costlbl , desclbl, tallbl, collbl;
    private EditText cantin, costin, descin, talin, colin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_vender);

        sp = (Spinner)this.findViewById(R.id.spinner);

        cantlbl = (TextView) this.findViewById(R.id.cantlbl);
        costlbl = (TextView) this.findViewById(R.id.costlbl);
        desclbl = (TextView) this.findViewById(R.id.desclbl);
        tallbl = (TextView) this.findViewById(R.id.tallbl);
        collbl = (TextView) this.findViewById(R.id.collbl);

        cantin = (EditText) this.findViewById(R.id.cantin);
        costin = (EditText) this.findViewById(R.id.costin);
        descin = (EditText) this.findViewById(R.id.decin);
        talin = (EditText) this.findViewById(R.id.talin);
        colin = (EditText) this.findViewById(R.id.colin);


        String [] sarr = {"Zapatos", "Vestidos", "Casacas", "Chaquetas", "Jeans", "Pantalones"};
        ArrayAdapter<String> arrs = new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item, sarr);
        sp.setAdapter(arrs);

        img = (Button)this.findViewById(R.id.btimage);


                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
  /*      FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    private static final int FILE_SELECT_CODE = 0;

    public void Validar (View view){
        boolean aceptar = true;
        if (this.cantin.getText().toString().equals("")){
            aceptar = aceptar && false;
            this.cantlbl.setTextColor(Color.parseColor("#f44336"));
        } else{
            this.cantlbl.setTextColor(Color.parseColor("#000000"));
        }

        if (this.costin.getText().toString().equals("")){
            aceptar = aceptar && false;
            this.costlbl.setTextColor(Color.parseColor("#f44336"));
        } else{
            this.costlbl.setTextColor(Color.parseColor("#000000"));
        }

        if (this.descin.getText().toString().equals("")){
            aceptar = aceptar && false;
            this.desclbl.setTextColor(Color.parseColor("#f44336"));
        } else{
            this.desclbl.setTextColor(Color.parseColor("#000000"));
        }

        if (this.talin.getText().toString().equals("")){
            aceptar = aceptar && false;
            this.tallbl.setTextColor(Color.parseColor("#f44336"));
        } else{
            this.tallbl.setTextColor(Color.parseColor("#000000"));
        }

        if (this.colin.getText().toString().equals("")){
            aceptar = aceptar && false;
            this.collbl.setTextColor(Color.parseColor("#f44336"));
        } else{
            this.collbl.setTextColor(Color.parseColor("#000000"));
        }

        if (aceptar) {
            Intent i = new Intent(this, MisProd.class);
            this.startActivity(i);
        } else {
            Toast.makeText(this, "Ingrese todos los campos por favor", Toast.LENGTH_SHORT).show();
        }
    }

    public void upFile(View vie){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        try {
            startActivityForResult(
                    Intent.createChooser(intent, "Select a File to Upload"),
                    FILE_SELECT_CODE);
        } catch (android.content.ActivityNotFoundException ex) {
            // Potentially direct the user to the Market with a Dialog
            Toast.makeText(this, "Please install a File Manager.",  Toast.LENGTH_SHORT).show();
        }
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
        getMenuInflater().inflate(R.menu.vender, menu);
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
