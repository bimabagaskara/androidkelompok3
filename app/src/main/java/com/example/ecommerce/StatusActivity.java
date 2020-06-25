package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.ecommerce.ui.status.Address;
import com.example.ecommerce.ui.status.Invoice;
import com.example.ecommerce.ui.trans.Purchase;
import com.example.ecommerce.ui.trans.Sales;
import com.google.android.material.tabs.TabLayout;

public class StatusActivity extends AppCompatActivity {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);


        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        getSupportActionBar().setTitle("Detail Transaksi");
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
                case 0 : return new Invoice();
                case 1 : return new Address();
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
                case 0 : return "STATUS";
                case 1  : return "DETAIL";
                default: return null;
            }

        }

    }

}