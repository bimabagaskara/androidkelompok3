package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.ecommerce.ui.home.Category;
import com.example.ecommerce.ui.home.Product;
import com.example.ecommerce.ui.trans.Purchase;
import com.example.ecommerce.ui.trans.Sales;
import com.google.android.material.tabs.TabLayout;

public class TransActivity extends AppCompatActivity {

    private final String[] PAGE_TITLES = new String[] {
            "Pembelian", "Penjualan"
    };

    private final Fragment[] PAGES = new Fragment[] {
            new Purchase(), new Sales()
    };

    public static TabLayout tabLayout;
    public static ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new MainActivity.MyPagerAdapter(getSupportFragmentManager()));
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        getSupportActionBar().setTitle("Transaksi");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish(); // menutup activity
        return true;
    }


    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0 : return new Purchase();
                case 1 : return new Sales();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0 : return "Produk";
                case 1  : return "Kategori";
                default: return null;
            }

        }

    }
}