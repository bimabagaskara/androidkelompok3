package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommerce.Model.Daftar;
import com.example.ecommerce.Model.PostPutDelDaftar;
import com.example.ecommerce.Rest.ApiClient;
import com.example.ecommerce.Rest.ApiInterface;
import com.xwray.passwordview.PasswordView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    EditText fullname, email, gender, address, password;
    Button btnDaftar;
    ApiInterface mApiInterface;
    TextView txtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        fullname = (EditText) findViewById(R.id.edtnama);
        email = (EditText) findViewById(R.id.edtemail);
        gender= (EditText) findViewById(R.id.edtgen);
        address = (EditText) findViewById(R.id.edtalamat);
        password = (EditText) findViewById(R.id.password);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btnDaftar = (Button) findViewById(R.id.btnDaftar);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Daftar> postDaftar = mApiInterface.postDaftar2(fullname.getText().toString(),email.getText().toString(),gender.getText().toString(),address.getText().toString(),password.getText().toString());
                postDaftar.enqueue(new Callback<Daftar>() {
                    @Override
                    public void onResponse(Call<Daftar> call, Response<Daftar> response) {
                        Toast.makeText(SignupActivity.this,"Berhasil",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Daftar> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }

                });


                getSupportActionBar().setTitle("Daftar");
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

