package com.example.ecommerce.ui.trans;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommerce.R;
import com.example.ecommerce.StatusActivity;
import com.example.ecommerce.ui.adapter.SalesAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Sales extends Fragment {

    ListView lstSales;
    SalesAdapter salesAdapter;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

    public Sales() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sales, container, false);
        lstSales = (ListView) view.findViewById(R.id.lstSales);
        setSales();

        return view;
    }

    private void setSales() {

        String [] product = {"product2", "product4"};
        String [] title = {"Rice Cooker",  "Blender"};
        String [] date = {"Januari, 12 2019 - 10pm", "Januari, 13 2019"};

        //status
        String [] shipment = {"Dikirim", "dikirim"};
        String [] drop      = {"diterima", "ditolak" };
        String [] finish    = {"selesai", "pengembalian"};


        for (int i = 0; i < title.length; i++) {
            HashMap<String, String> map = new HashMap<>();
            map.put("product",  product[i]);
            map.put("title",  title[i]);
            map.put("date",  date[i]);
            map.put("shipment",  shipment[i]);
            map.put("drop",  drop[i]);
            map.put("finish",  finish[i]);
            arrayList.add(map);

        }

        salesAdapter = new SalesAdapter(getActivity(), arrayList, R.layout.adapter_trans,
                new String[]{"product", "title", "date", "shipment", "drop", "finish"},
                new int[] {R.id.imgProduct, R.id.txtTitle,R.id.txtDesc,R.id.imgCar,R.id.imgDrop,R.id.imgFinish, });
       lstSales.setAdapter(salesAdapter);
        lstSales.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String harga = ((TextView) view.findViewById(R.id.txtDesc)).getText().toString();
                Toast.makeText(getActivity(), harga, Toast.LENGTH_LONG).show();

                startActivity(new Intent(getActivity(), StatusActivity.class));
            }
        });
    }
}