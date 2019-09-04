package com.pieroashady.perpustakaan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pieroashady.perpustakaan.R;
import com.pieroashady.perpustakaan.model.Customers;

import java.util.List;

public class CustomersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    Context context;
    List<Customers> lstCust;

    public CustomersAdapter(Context context , List<Customers> lstCust ) {

        this.context = context;
        this.lstCust = lstCust;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.include_drawer_content, parent, false);
        vh = new ContohViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ContohViewHolder) {
            ContohViewHolder view = (ContohViewHolder) holder;
            final Customers cust = lstCust.get(position);

            view.txtCust.setText(cust.getNamaCust());
            view.txtDob.setText(cust.getDob());
            view.txtKet.setText(cust.getKeterangan());
        }
    }

    @Override
    public int getItemCount() {
        return lstCust.size();
    }


    public class ContohViewHolder  extends RecyclerView.ViewHolder{


        TextView txtCust;
        TextView txtDob;
        TextView txtKet;


        public ContohViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCust = (TextView) itemView.findViewById(R.id.txtCust);
            txtDob = (TextView)itemView.findViewById(R.id.txtDob);
            txtKet = itemView.findViewById(R.id.txtKeterangan);


        }
    }
}
