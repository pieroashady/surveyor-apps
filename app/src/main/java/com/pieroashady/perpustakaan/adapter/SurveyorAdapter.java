package com.pieroashady.perpustakaan.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pieroashady.perpustakaan.R;
import com.pieroashady.perpustakaan.model.Surveyor;
import com.pieroashady.perpustakaan.ui.CustomersDetail;

import java.util.List;

public class SurveyorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    Context context;
    List<Surveyor> lstSurveyor;

    public SurveyorAdapter(Context context , List<Surveyor> lstSurveyor ) {

        this.context = context;
        this.lstSurveyor = lstSurveyor;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.customers_list, parent, false);
        vh = new ContohViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ContohViewHolder) {
            ContohViewHolder view = (ContohViewHolder) holder;
            final Surveyor surveyor = lstSurveyor.get(position);

            view.txtCust.setText(surveyor.getNamaSurveyor());
            view.txtDob.setText(surveyor.getDob());
            view.txtKet.setText(surveyor.getPerusahaan());
            view.btnDetail.setOnClickListener((c)->{
                Intent detail = new Intent(context, CustomersDetail.class);
                detail.putExtra("customersId", String.valueOf(surveyor.getSurveyorId()));
                context.startActivity(detail);
            });
        }
    }

    @Override
    public int getItemCount() {
        return lstSurveyor.size();
    }


    public class ContohViewHolder  extends RecyclerView.ViewHolder{


        TextView txtCust;
        TextView txtDob;
        TextView txtKet;
        Button btnDetail;

        public ContohViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCust = (TextView) itemView.findViewById(R.id.txtCust);
            txtDob = (TextView)itemView.findViewById(R.id.txtDob);
            txtKet = itemView.findViewById(R.id.txtKeterangan);
            btnDetail = itemView.findViewById(R.id.btnDelete);

        }
    }
}
