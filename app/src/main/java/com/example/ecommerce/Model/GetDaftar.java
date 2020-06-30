package com.example.ecommerce.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetDaftar {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Daftar> listDataDaftar;
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

    public List<Daftar> getListDataDaftar() {
        return listDataDaftar;
    }

    public void setListDataDaftar(List<Daftar> listDataDaftar) {
        this.listDataDaftar = listDataDaftar;
    }



}
