package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class NotifActivity extends AppCompatActivity {

    ListView lstNotif;
    SimpleAdapter simpleAdapter;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif);

        lstNotif = (ListView) findViewById(R.id.lstNotif);
        setNotif();

        getSupportActionBar().setTitle("Notifikasi");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish(); // menutup activity
        return true;
    }

    private void setNotif() {
        for (int i = 1; i <= 10; i++) {
            HashMap<String, String> map = new HashMap<>();
            map.put("title", "Pesanan di konfirmasi");
            arrayList.add(map);

        }

        simpleAdapter = new SimpleAdapter(NotifActivity.this, arrayList, R.layout.adapter_notif,
                new String[]{"title"},
                new int[] {R.id.txtTitle});
        lstNotif.setAdapter(simpleAdapter);
        lstNotif.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String title= ((TextView) view.findViewById(R.id.txtTitle)).getText().toString();
                Toast.makeText(getApplicationContext(), title, Toast.LENGTH_LONG).show();

               TextView txtDesc = ((TextView) view.findViewById(R.id.txtDesc));
               if ( txtDesc.getVisibility() == View.GONE) {
                   txtDesc.setVisibility(View.VISIBLE);
               }else {
                   txtDesc.setVisibility(View.GONE);
               }

            }
        });
    }
}