package com.example.ecommerce;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerce.Adapter.DaftarAdapter;
import com.example.ecommerce.Model.Daftar;
import com.example.ecommerce.Model.GetDaftar;
import com.example.ecommerce.Rest.ApiClient;
import com.example.ecommerce.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static LoginActivity ma;
    TextView txtSingup;
    Button btnLogin;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtSingup = (TextView) findViewById(R.id.txtSingup);
        txtSingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,SignupActivity.class));
            }
        });
        pref = getApplicationContext().getSharedPreferences("Users", 0); // untuk manggil data
        editor = pref.edit();
        boolean isLogin = pref.getBoolean("isLogin", false);
        if (isLogin){
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
        }

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                editor.putBoolean("isLogin", true);
                editor.apply();
            }
        });

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=this;
        refresh();

        getSupportActionBar().setTitle("Daftar");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish(); // menutup activity
        return true;
    }


    public void refresh() {
        Call<GetDaftar> daftarCall = mApiInterface.getDaftar();
        daftarCall.enqueue(new Callback<GetDaftar>() {
            @Override
            public void onResponse(Call<GetDaftar> call, Response<GetDaftar>
                    response) {
                List<Daftar> DaftarList = response.body().getListDataDaftar();
                Log.d("Retrofit Get", "Jumlah data Yang Daftar: " +
                        String.valueOf(DaftarList.size()));
                mAdapter = new DaftarAdapter(DaftarList);
            }

            @Override
            public void onFailure(Call<GetDaftar> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());

            }
        });
    }
}