package com.example.jcmilena.jdainventario;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class ControllerActivity extends AppCompatActivity implements AddEquipoFragment.OnAddEquipoListener, InventarioFragment.OnInventarioFragmentListener, SearchFragment.OnSearchFragmentListener {

    List<EquipoInformatico> inventario = new ArrayList<>();
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controller);

        db = new MiBBDD_Helper(this).getWritableDatabase();

        Fragment fragment = new WelcomeFragment();
        cargar_fragment(fragment);
    }

    private void cargar_fragment(Fragment fragment) {

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.textView, fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.jdainventario_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public void writeSQLite(EquipoInformatico equipo) {

        Fragment fragment = new WelcomeFragment();
        cargar_fragment(fragment);

    }

    @Override
    public List<EquipoInformatico> getEquiposList() {

        return inventario;
    }

    @Override
    public void searchSQLite(String columna, String valor) {


        Fragment fragment = new InventarioFragment();
        cargar_fragment(fragment);

    }
}
