package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ecommerce.Model.PostPutDelDaftar;
import com.example.ecommerce.Rest.ApiClient;
import com.example.ecommerce.Rest.ApiInterface;
import com.xwray.passwordview.PasswordView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditActivity extends AppCompatActivity {

    EditText edtId, edtnama, edtemail, edtgen, edtalamat, edtpassword;
    Button btUpdate, btBackGo;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        edtId = (EditText) findViewById(R.id.edtId);
        edtnama = (EditText) findViewById(R.id.edtnama);
        edtemail = (EditText) findViewById(R.id.edtemail);
        edtgen = (EditText) findViewById(R.id.edtgen);
        edtalamat = (EditText) findViewById(R.id.edtalamat);
        edtpassword = (EditText) findViewById(R.id.edtpassword);
        Intent mIntent = getIntent();
        edtId.setText(mIntent.getStringExtra("Id"));
        edtId.setTag(edtId.getKeyListener());
        edtId.setKeyListener(null);
        edtnama.setText(mIntent.getStringExtra("Nama"));
        edtemail.setText(mIntent.getStringExtra("Email"));
        edtgen.setText(mIntent.getStringExtra("Jenis Kelamin"));
        edtalamat.setText(mIntent.getStringExtra("Alamat"));
        edtpassword.setText(mIntent.getStringExtra("Password"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        btUpdate = (Button) findViewById(R.id.btUpdate);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelDaftar> updateDaftarCall = mApiInterface.putDaftar(
                        edtId.getText().toString(),
                        edtnama.getText().toString(),
                        edtemail.getText().toString(),
                        edtgen.getText().toString(),
                        edtalamat.getText().toString());
                updateDaftarCall.enqueue(new Callback<PostPutDelDaftar>() {
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
            }

        });
    }
}

