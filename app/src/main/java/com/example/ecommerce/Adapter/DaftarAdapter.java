package com.example.ecommerce.Adapter;

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
        holder.mTextViewId_user.setText("Id_user = " + mDaftarlist.get(position).getId_user());
        holder.mTextViewFullname.setText("Fullname = " + mDaftarlist.get(position).getFullname());
        holder.mTextViewEmail.setText("Email = " + mDaftarlist.get(position).getEmail());
        holder.mTextViewPassword.setText("Password = " + mDaftarlist.get(position).getPassword());
        holder.mTextViewGender.setText("Gender = " + mDaftarlist.get(position).getGender());
        holder.mTextViewAddress.setText("Address = " + mDaftarlist.get(position).getAddress());
        holder.mTextViewIs_active.setText("Is_active = " + mDaftarlist.get(position).getIs_active());
        holder.mTextViewDateCreated.setText("DateCreated = " + mDaftarlist.get(position).getDate_created());
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
        public TextView mTextViewId_user, mTextViewFullname, mTextViewEmail, mTextViewPassword,mTextViewGender, mTextViewAddress, mTextViewIs_active, mTextViewDateCreated   ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewId_user = (TextView) itemView.findViewById(R.id.tvId);
            mTextViewFullname = (TextView) itemView.findViewById(R.id.tvNama);
            mTextViewEmail = (TextView) itemView.findViewById(R.id.tvEmail);
            mTextViewPassword = (TextView) itemView.findViewById(R.id.tvPassword);
            mTextViewGender = (TextView) itemView.findViewById(R.id.tvGender);
            mTextViewAddress = (TextView) itemView.findViewById(R.id.tvAddress);
            mTextViewIs_active = (TextView) itemView.findViewById(R.id.tvIs_active);
            mTextViewDateCreated = (TextView) itemView.findViewById(R.id.tvDate);
        }
    }
}
