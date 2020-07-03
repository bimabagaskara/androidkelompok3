package com.example.ecommerce.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerce.Model.Daftar;
import com.example.ecommerce.R;

import java.text.BreakIterator;
import java.util.List;

public class DaftarAdapter extends RecyclerView.Adapter<DaftarAdapter.MyViewHolder> {
    List<Daftar> mDaftarlist;
    private Context context;


    public DaftarAdapter(List <Daftar> Daftarlist){
        mDaftarlist = Daftarlist;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.daftar_list, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder,final int position){
        holder.mTextViewFullname.setText("Fullname = " + mDaftarlist.get(position).getFullname());
        holder.mTextViewEmail.setText("Email = " + mDaftarlist.get(position).getEmail());
        holder.mTextViewPassword.setText("Password = " + mDaftarlist.get(position).getPassword());
        holder.mTextViewGender.setText("Gender = " + mDaftarlist.get(position).getGender());
        holder.mTextViewAddress.setText("Address = " + mDaftarlist.get(position).getAddress());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mDaftarlist.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView  mTextViewFullname, mTextViewEmail, mTextViewPassword,mTextViewGender, mTextViewAddress  ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewFullname = (TextView) itemView.findViewById(R.id.tvNama);
            mTextViewEmail = (TextView) itemView.findViewById(R.id.tvEmail);
            mTextViewPassword = (TextView) itemView.findViewById(R.id.tvPassword);
            mTextViewGender = (TextView) itemView.findViewById(R.id.tvGender);
            mTextViewAddress = (TextView) itemView.findViewById(R.id.tvAddress);
        }
    }
}
