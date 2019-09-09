package com.pieroashady.perpustakaan.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pieroashady.perpustakaan.R;
import com.pieroashady.perpustakaan.model.Customers;
import com.pieroashady.perpustakaan.ui.UserMenu;

import java.util.List;

public class CustomersDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    Context context;
    List<Customers> lstCust;

    public CustomersDetailAdapter(Context context , List<Customers> lstCust ) {

        this.context = context;
        this.lstCust = lstCust;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.customers_detail, parent, false);
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
            view.txtAlamat.setText(cust.getAlamat());
            view.txtPob.setText(cust.getPob());
            view.txtPhone.setText(String.valueOf(cust.getNoTelpCust()));
            view.txtPekerjaan.setText(cust.getPekerjaan());
            view.txtUmur.setText(String.valueOf(cust.getUmurCust()));
            view.txtGender.setText(cust.getGender());
            view.btnDelete.setOnClickListener((c)->{
                cust.delete();
                Toast.makeText(context, "Data Terhapus", Toast.LENGTH_LONG).show();
                Intent detail = new Intent(context, UserMenu.class);
                context.startActivity(detail);
            });
        }
    }

    @Override
    public int getItemCount() {
        return lstCust.size();
    }


    public class ContohViewHolder  extends RecyclerView.ViewHolder{


        TextView txtCust;
        TextView txtDob;
        TextView txtKet, txtGender, txtUmur, txtPekerjaan, txtPhone, txtAlamat, txtPob;
        Button btnDelete;

        public ContohViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCust = (TextView) itemView.findViewById(R.id.txtCust);
            txtDob = (TextView)itemView.findViewById(R.id.txtDob);
            txtKet = itemView.findViewById(R.id.txtKeterangan);
            txtGender = itemView.findViewById(R.id.txtGender);
            txtUmur = itemView.findViewById(R.id.txtUmur);
            txtPekerjaan = itemView.findViewById(R.id.txtPekerjaan);
            txtPhone = itemView.findViewById(R.id.txtPhone);
            txtAlamat = itemView.findViewById(R.id.txtAlamat);
            txtPob = itemView.findViewById(R.id.txtPob);
            btnDelete = itemView.findViewById(R.id.btnDelete);

        }
    }
}
