package com.example.ecommerce.ui.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommerce.DetailActivity;
import com.example.ecommerce.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class Product extends Fragment {

    GridView grdProduct;
    SimpleAdapter simpleAdapter;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

    public Product() {

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        grdProduct = (GridView) view.findViewById(R.id.grdProduct);
        setProduct();

        return view;
    }

    private void setProduct() {
        for (int i = 1; i <= 10; i++) {
            HashMap<String, String> map = new HashMap<>();
            map.put("price", String.valueOf(i) + "10.000");
            map.put("seller", "Sumber Rezeki Listrik");
            arrayList.add(map);

        }

        simpleAdapter = new SimpleAdapter(getActivity(), arrayList, R.layout.adapter_product,
                new String[]{"price", "seller"},
                new int[] {R.id.txtPrice, R.id.txtSeller});
        grdProduct.setAdapter(simpleAdapter);
        grdProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String harga = ((TextView) view.findViewById(R.id.txtPrice)).getText().toString();
                Toast.makeText(getActivity(), harga, Toast.LENGTH_LONG).show();

                //Pindah activity
                startActivity(new Intent(
                        getActivity(), DetailActivity.class
                ));
            }
        });
    }
}