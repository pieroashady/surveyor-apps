package com.pieroashady.perpustakaan.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pieroashady.perpustakaan.R;
import com.pieroashady.perpustakaan.adapter.CustomersDetailAdapter;
import com.pieroashady.perpustakaan.model.Customers;
import com.pieroashady.perpustakaan.utils.Tools;
import com.raizlabs.android.dbflow.sql.queriable.StringQuery;
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;

import java.util.List;

public class CustomersDetail extends AppCompatActivity {

    String customersId;
    Toolbar toolbar;
    ActionBar actionBar;
    RecyclerView custDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers_detail);
        custDetail = findViewById(R.id.custDetail);
        customersId = getIntent().getStringExtra("customersId");
        initToolbar();
        sqlQueryList();
    }

    private void sqlQueryList() {
        String rawQuery = "SELECT * FROM `Customers` WHERE userId = " +customersId ;
        StringQuery<Customers> stringQuery = new StringQuery<>(Customers.class, rawQuery);
        stringQuery
                .async()
                .queryListResultCallback(new QueryTransaction.QueryResultListCallback<Customers>() {
                                             @Override
                                             public void onListQueryResult(QueryTransaction transaction, @NonNull List<Customers> models) {

                                                 if (models.size() > 0) {
                                                     setupAdapterList(models);
                                                 }
                                             }
                                         }
                )
                .execute();
    }

    private void setupAdapterList(List<Customers> model) {
        CustomersDetailAdapter detailAdapter = new CustomersDetailAdapter(CustomersDetail.this, model);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CustomersDetail.this, LinearLayoutManager.VERTICAL, false);
        custDetail.setLayoutManager(linearLayoutManager);
        custDetail.setAdapter(detailAdapter);
    }


    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.pink_600));
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle("Detail Customers");
        Tools.setSystemBarColor(this, R.color.pink_700);
    }
}
