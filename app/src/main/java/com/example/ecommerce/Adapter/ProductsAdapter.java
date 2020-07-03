package com.example.ecommerce.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerce.Model.Products;
import com.example.ecommerce.R;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.HolderProduct>{
    private Context context;
    private List<Products> listProducts;

    public ProductsAdapter(Context context, List<Products> listProducts) {
        this.context = context;
        this.listProducts = listProducts;
    }

    @NonNull
    @Override
    public HolderProduct onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_product, parent, false);
        HolderProduct holderProduct = new HolderProduct(layout);
        return holderProduct;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderProduct holder, int position) {
        Products mproduct = listProducts.get(position);

        holder.txt_id.setText(String.valueOf(mproduct.getId_products()));
        holder.txtTitle.setText(mproduct.getNama_products());
        holder.txtDesc.setText(mproduct.getDescription());
        holder.txtPrice.setText(String.valueOf(mproduct.getPrice()));
    }

    @Override
    public int getItemCount() {
        return listProducts.size();
    }

    public class HolderProduct extends RecyclerView.ViewHolder{
        ImageView imgProduct;
        TextView txt_id, txtTitle, txtDesc, txtPrice;

        public HolderProduct(@NonNull View itemView) {
            super(itemView);

            txt_id = itemView.findViewById(R.id.txt_id);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDesc = itemView.findViewById(R.id.txtDesc);
            txtPrice = itemView.findViewById(R.id.txtPrice);
        }
    }
}
