package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommerce.Model.PostPutDelDaftar;
import com.example.ecommerce.Rest.ApiClient;
import com.example.ecommerce.Rest.ApiInterface;
import com.xwray.passwordview.PasswordView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    EditText edtnama, edtemail, edtgen, edtalamat;
    PasswordView password;
    Button btnDaftar;
    ApiInterface mApiInterface;
    TextView txtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        edtnama = (EditText) findViewById(R.id.edtnama);
        edtemail = (EditText) findViewById(R.id.edtemail);
        edtgen = (EditText) findViewById(R.id.edtgen);
        edtalamat = (EditText) findViewById(R.id.edtalamat);
        password = (PasswordView) findViewById(R.id.password);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btnDaftar = (Button) findViewById(R.id.btnDaftar);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelDaftar> postKontakCall = mApiInterface.postDaftar(edtnama.getText().toString(), edtemail.getText().toString(),
                        edtgen.getText().toString(), edtalamat.getText().toString());
                postKontakCall.enqueue(new Callback<PostPutDelDaftar>() {
                    @Override
                    public void onResponse(Call<PostPutDelDaftar> call, Response<PostPutDelDaftar> response) {
                        LoginActivity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelDaftar> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }


                });
                txtLogin = (TextView) findViewById(R.id.txtLogin);
                txtLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish(); //menutup activity
                    }
                });

                getSupportActionBar().setTitle("Daftar");
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }

            public boolean onSupportNavigateUp() {
                finish(); // menutup activity
                return true;
            }

        });
}

    }