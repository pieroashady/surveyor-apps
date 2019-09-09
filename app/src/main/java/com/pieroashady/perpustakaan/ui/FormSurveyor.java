package com.pieroashady.perpustakaan.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.pieroashady.perpustakaan.R;
import com.pieroashady.perpustakaan.model.Customers;
import com.pieroashady.perpustakaan.utils.Tools;

public class FormSurveyor extends AppCompatActivity {

    EditText editNama, editAlamat, editPob, editDob, editUmur, editKeterangan, editPekerjaan, editTelp, editGender;
    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_profile_data);
        editNama = findViewById(R.id.editNama);
        editAlamat = findViewById(R.id.editAlamat);
        editPob = findViewById(R.id.editPob);
        editDob = findViewById(R.id.editDob);
        editUmur = findViewById(R.id.editUmur);
        editKeterangan = findViewById(R.id.editKet);
        editPekerjaan = findViewById(R.id.editPekerjaan);
        editTelp = findViewById(R.id.editTelp);
        editGender = findViewById(R.id.editGender);
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener((s) -> {
            Customers cust = new Customers();
            cust.setNamaCust(editNama.getText().toString());
            cust.setAlamat(editAlamat.getText().toString());
            cust.setDob(editDob.getText().toString());
            cust.setPob(editPob.getText().toString());
            cust.setGender(editGender.getText().toString());
            cust.setKeterangan(editKeterangan.getText().toString());
            cust.setNoTelpCust(Long.parseLong(editTelp.getText().toString()));
            cust.setPekerjaan(editPekerjaan.getText().toString());
            cust.setUmurCust(Integer.parseInt(editUmur.getText().toString()));
            cust.save();
            if(cust.save()) {
                Toast.makeText(FormSurveyor.this, "Data Tersimpan", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(FormSurveyor.this, "Gagal Tersimpan", Toast.LENGTH_LONG).show();
            }
            Intent intentForm = new Intent(FormSurveyor.this, UserMenu.class);
            startActivity(intentForm);
            finish();
        });
        initToolbar();
        //initComponent();

    }

    /*private void initComponent() {
        ((Button) findViewById(R.id.spn_state)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStateChoiceDialog((Button) v);
            }
        });

    }*/

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Input Data Customer");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Tools.setSystemBarColor(this, R.color.pink_400);
    }

    /*private void showStateChoiceDialog(final Button bt) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setSingleChoiceItems(array_states, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                bt.setTextColor(Color.BLACK);
                bt.setText(array_states[which]);
            }
        });
        builder.show();
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_done, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else {
            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }



}
