package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import com.example.ecommerce.ui.adapter.CartAdapter;
import com.example.ecommerce.ui.model.CartModel;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    SwipeRefreshLayout swipe;
    RecyclerView recyclerView;
    ArrayList<CartModel> carts;
    CartAdapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        carts = new ArrayList<>();
        setCart();

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                carts.clear(); recyclerView.setAdapter(null);
                setCart();
            }
        });

        getSupportActionBar().setTitle("Keranjang");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish(); // menutup activity
        return true;
    }

    private void setCart(){
        for (int i = 0; i < 3; i++) {
            CartModel model = new CartModel();
            carts.add(model);
        }

        cartAdapter = new CartAdapter(CartActivity.this, carts);
        recyclerView.setAdapter(cartAdapter);

        swipe.setRefreshing(false);

    }
}