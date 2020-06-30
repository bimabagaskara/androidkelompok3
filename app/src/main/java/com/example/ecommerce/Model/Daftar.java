package com.example.ecommerce.Model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Daftar {
    @SerializedName("id_user")
    private String id_user;
    @SerializedName("fullname")
    private String fullname;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("gender")
    private String gender;
    @SerializedName("address")
    private String address;
    @SerializedName("1")
    private String is_active;
    @SerializedName("date_created")
    private String date_created;

    public Daftar() {}

    public Daftar(String id_user, String fullname, String email, String password,
                  String gender, String address, String is_active, String date_created) {

        this.id_user       = id_user;
        this.fullname      = fullname;
        this.email         = email;
        this.password      = password;
        this.gender        = gender;
        this.address       = address;
        this.is_active     = is_active;
        this.date_created  = date_created;
    }

    public String getId_user(){
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender){
        this.gender = password;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getIs_active(){
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public String getDate_created(){
        return  date_created;
    }

    public void setDate_created(String date_created){
        this.date_created = date_created;
    }





}
