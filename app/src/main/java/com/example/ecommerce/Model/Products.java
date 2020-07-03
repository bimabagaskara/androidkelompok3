package com.example.ecommerce.Model;

public class Products {
    private int id_products, id_categoris, price, discount, price_total, stock, weight;
    private String nama_products, description, image, code_products;

    public int getId_products() {
        return id_products;
    }

    public void setId_products(int id_products) {
        this.id_products = id_products;
    }

    public int getId_categoris() {
        return id_categoris;
    }

    public void setId_categoris(int id_categoris) {
        this.id_categoris = id_categoris;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getPrice_total() {
        return price_total;
    }

    public void setPrice_total(int price_total) {
        this.price_total = price_total;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getNama_products() {
        return nama_products;
    }

    public void setNama_products(String nama_products) {
        this.nama_products = nama_products;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCode_products() {
        return code_products;
    }

    public void setCode_products(String code_products) {
        this.code_products = code_products;
    }
}
