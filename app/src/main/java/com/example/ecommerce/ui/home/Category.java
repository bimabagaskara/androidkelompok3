package com.example.ecommerce.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommerce.MainActivity;
import com.example.ecommerce.R;

import java.util.ArrayList;
import java.util.HashMap;

public class Category extends Fragment {

    ListView lstKat;
    SimpleAdapter simpleAdapter;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    public Category() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        lstKat = (ListView) view.findViewById(R.id.lstKat);
        setCategory();

        return view;
    }

    private void setCategory() {
        for (int i = 1; i <= 10; i++) {
            HashMap<String, String> map = new HashMap<>();
            map.put("title", "CATEGORY - " + String.valueOf(i));
            arrayList.add(map);

        }

        simpleAdapter = new SimpleAdapter(getActivity(), arrayList, R.layout.adapter_category,
                new String[]{"title"},
                new int[] {R.id.txtTitle});
        lstKat.setAdapter(simpleAdapter);
        lstKat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String kategori = ((TextView) view.findViewById(R.id.txtTitle)).getText().toString();
                Toast.makeText(getActivity(), kategori, Toast.LENGTH_LONG).show();

                MainActivity.tabLayout.setupWithViewPager(MainActivity.viewPager);
                MainActivity.viewPager.setCurrentItem(0);
            }
        });
    }
}