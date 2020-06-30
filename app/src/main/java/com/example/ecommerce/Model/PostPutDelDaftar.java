package com.example.ecommerce.Model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class PostPutDelDaftar {

    @SerializedName("status")
    String status;
    @SerializedName("result")
    Daftar mDaftar;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public Daftar getDaftar() {
        return mDaftar;
    }

    public void setDaftar(Daftar Daftar) {
        mDaftar = Daftar;
    }

}
