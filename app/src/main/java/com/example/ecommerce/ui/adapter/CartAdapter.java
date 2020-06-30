package com.example.ecommerce.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerce.R;
import com.example.ecommerce.ui.model.CartModel;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private ArrayList<CartModel> cart;
    Context context;

    public CartAdapter(Context context, ArrayList<CartModel> cart) {

        this.cart = cart;
        this.context = context;
    }

    public CartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_cart, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CartAdapter.ViewHolder holder, final int position) {
        holder.btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cart.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, cart.size());
                holder.itemView.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cart.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView btnDel; Spinner spnTotal; Button btnPay;

        public ViewHolder(View itemView ){
            super(itemView);
            spnTotal = (Spinner) itemView.findViewById(R.id.spnTotal);
            btnDel = (ImageView) itemView.findViewById(R.id.btnDel);
            btnPay= (Button) itemView.findViewById(R.id.btnPay);
        }
    }
}
