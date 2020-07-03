package com.example.ecommerce.Rest;

import com.example.ecommerce.Model.Daftar;
import com.example.ecommerce.Model.GetDaftar;
import com.example.ecommerce.Model.PostPutDelDaftar;

import java.util.Date;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @GET("daftar")
    Call<GetDaftar> getDaftar();

    @FormUrlEncoded
    @POST("daftar")
    Call<Daftar> postDaftar2(@Field("fullname") String fullname,
                             @Field("email") String email,
                             @Field("password") String password,
                             @Field("gender") String gender,
                             @Field("address") String address);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "daftar", hasBody = true)
    Call<PostPutDelDaftar> deleteDaftar(@Field("id_user") String id_user);


    Call<PostPutDelDaftar> putDaftar(String toString, String toString1, String toString2, String toString3, String toString4);
}
