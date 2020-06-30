package com.example.ecommerce.Rest;

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
    @GET("daftar_android")
    Call<GetDaftar> getDaftar();
    @FormUrlEncoded
    @POST("daftar_android")
    Call<PostPutDelDaftar> postDaftar(@Field("fullname") String nama,
                                      @Field("email") String email,
                                      @Field("password") String password,
                                      @Field("gender") String gender);
    @FormUrlEncoded
    @PUT("daftar_android")
    Call<PostPutDelDaftar> putDaftar(@Field("id_user") String id_user,
                                     @Field("fullname") String nama,
                                     @Field("email") String email,
                                     @Field("password") String password,
                                     @Field("gender") String gender,
                                     @Field("address") String address,
                                     @Field("1") String is_active,
                                     @Field("date_created") String date_created);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "daftar", hasBody = true)
    Call<PostPutDelDaftar> deleteDaftar(@Field("id_user") String id_user);
}
