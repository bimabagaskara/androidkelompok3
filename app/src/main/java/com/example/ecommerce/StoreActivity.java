package com.example.ecommerce;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class StoreActivity extends AppCompatActivity {

    GridView grdProduct;
    SimpleAdapter simpleAdapter;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        grdProduct = (GridView) findViewById(R.id.grdProduct);
        setProduct();

        getSupportActionBar().setTitle("Toko");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish(); // menutup activity
        return true;
    }

    private void setProduct() {
        for (int i = 1; i <= 10; i++) {
            HashMap<String, String> map = new HashMap<>();
            map.put("price", String.valueOf(i) + "10.000");
            map.put("seller", "Sumber Rezeki Listrik");
            arrayList.add(map);

        }

        simpleAdapter = new SimpleAdapter(StoreActivity.this, arrayList, R.layout.adapter_product,
                new String[]{"price", "seller"},
                new int[] {R.id.txtPrice, R.id.txtSeller});
        grdProduct.setAdapter(simpleAdapter);
        grdProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String harga = ((TextView) view.findViewById(R.id.txtPrice)).getText().toString();
                Toast.makeText(getApplicationContext(), harga, Toast.LENGTH_LONG).show();

                //Pindah activity
                startActivity(new Intent(
                        StoreActivity.this, DetailActivity.class
                ));
            }
        });
    }
}