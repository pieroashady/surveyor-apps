package com.pieroashady.perpustakaan.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.pieroashady.perpustakaan.R;
import com.pieroashady.perpustakaan.adapter.SurveyorAdapter;
import com.pieroashady.perpustakaan.appcontroller.AppController;
import com.pieroashady.perpustakaan.model.Surveyor;
import com.pieroashady.perpustakaan.model.Surveyor_Table;
import com.pieroashady.perpustakaan.service.APIClient;
import com.pieroashady.perpustakaan.service.APIInterfacesRest;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.queriable.StringQuery;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class  LoginActivity extends AppCompatActivity {

    TextInputEditText surveyorId, password;
    FloatingActionButton submit;
    Surveyor objSurveyor;
    Context mContext;
    APIInterfacesRest apiInterface;
    ProgressDialog progressDialog;
    List<Surveyor> surveyor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_image_teal);
        surveyorId = findViewById(R.id.editUsername);
        password = findViewById(R.id.editPassword);
        submit = findViewById(R.id.fabLogin);
        //Surveyor surveyor = new Surveyor();
        submit.setOnClickListener((c)-> {
            requestLogin();
            //callSurveyors();
//            if(requestLogin()) {
//                finish();
//            }
        });
        }

//    APIInterfacesRest apiInterface;
//    ProgressDialog progressDialog;

    public void offlineLogin(){
        Surveyor surveyor = SQLite.select()
                .from(Surveyor.class)
                .where(Surveyor_Table.surveyorId.eq(Integer.parseInt(surveyorId.getText().toString()))).querySingle();
        if(surveyor == null){
            Toast.makeText(LoginActivity.this, "Data Kosong", Toast.LENGTH_LONG).show();
        } else {
            Intent login = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(login);
        }
//        if(String.valueOf(surveyorId.getText()).equals(objSurveyor.getNamaSurveyor().toString())){
//            Intent login = new Intent(LoginActivity.this, UserMenu.class);
//            startActivity(login);
//            Toast.makeText(LoginActivity.this, "Login Berhasil", Toast.LENGTH_LONG).show();
//        } else {
//            Toast.makeText(LoginActivity.this, "Username not found", Toast.LENGTH_LONG).show();
//        }
    }

    public void requestLogin(){
        progressDialog = new ProgressDialog(LoginActivity.this);
        apiInterface = APIClient.getClient().create(APIInterfacesRest.class);
        apiInterface.loginRequest(String.valueOf(surveyorId.getText()), password.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            //progressDialog.dismiss();
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                if (jsonRESULTS.getString("error").equals("false")) {
                                    // Jika login berhasil maka data nama yang ada di response API
                                    // akan diparsing ke activity selanjutnya.
                                    progressDialog.show();
                                    //String nama = jsonRESULTS.getJSONObject("surveyors").getString("surveyorId");
                                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                    startActivity(intent);
                                    Toast.makeText(LoginActivity.this, "BERHASIL LOGIN", Toast.LENGTH_SHORT).show();
                                    //intent.putExtra("result_nama", nama);
                                    //savedb();
                                    finish();
                                } else {
                                    //String error_message = jsonRESULTS.getString("error_msg");
                                    Toast.makeText(LoginActivity.this, "error", Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            //Toast.makeText(LoginActivity.this, "Invalid Username", Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                            Toast.makeText(LoginActivity.this, "Invalid Username", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        //Log.e("debug", "onFailure: ERROR >" + t.toString());
                        offlineLogin();
                        //Toast.makeText(LoginActivity.this, "Koneksi Gagal", Toast.LENGTH_LONG).show();
                        //progressDialog.dismiss();
                    }
                });
    }

    public void callSurveyors(){
        apiInterface = APIClient.getClient().create(APIInterfacesRest.class);
        progressDialog = new ProgressDialog(LoginActivity.this);
        //rogressDialog.show();
        Call<List<Surveyor>> request = apiInterface.getUser();
            request.enqueue(new Callback<List<Surveyor>>() {
                @Override
                public void onResponse(Call<List<Surveyor>> call, Response<List<Surveyor>> response) {
                    progressDialog.dismiss();
                    surveyor = response.body();
                    if (surveyor != null){
                        savedb();
        //                offlineLogin();
                    } else {
                        try {
                            requestLogin();
                            JSONObject jObjError = new JSONObject(response.errorBody().string());
                            Toast.makeText(LoginActivity.this, jObjError.getString("message"), Toast.LENGTH_LONG).show();
                        } catch (Exception e) {
                            Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<Surveyor>> call, Throwable t) {

                    progressDialog.dismiss();
                    //offlineLogin();
                    sqlQueryList();
                    //Toast.makeText(getApplicationContext(),"Maaf koneksi bermasalah",Toast.LENGTH_LONG).show();
                    //call.cancel();
                }
            });
    }

    public void savedb(){

        FlowManager.getDatabase(AppController.class)
                .beginTransactionAsync(new ProcessModelTransaction.Builder<>(
                        new ProcessModelTransaction.ProcessModel<Surveyor>() {
                            @Override
                            public void processModel(Surveyor surveyor, DatabaseWrapper wrapper) {
                                surveyor.save();
                            }

                        }).addAll(surveyor).build())  // add elements (can also handle multiple)
                .error(new Transaction.Error() {
                    @Override
                    public void onError(Transaction transaction, Throwable error) {
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                })
                .success(new Transaction.Success() {
                    @Override
                    public void onSuccess(Transaction transaction) {
                        Toast.makeText(getApplicationContext(),"Data Tersimpan",Toast.LENGTH_LONG).show();
                        sqlQueryList();
                    }
                }).build().execute();
    }

    public void sqlQueryList(){

        String rawQuery = "SELECT * FROM `Surveyor`";
        StringQuery<Surveyor> stringQuery = new StringQuery<>(Surveyor.class, rawQuery);
        stringQuery.execute();
//                .async()
//                .queryListResultCallback(new QueryTransaction.QueryResultListCallback<Surveyor>() {
//                                             @Override
//                                             public void onListQueryResult(QueryTransaction transaction, @NonNull List<Surveyor> models) {
//                                                 setupAdapterList(models);
//                                             }
//                                         }
//                )
                //.execute();
    }


    public void setupAdapterList(List<Surveyor> model){
        SurveyorAdapter toadapter = new SurveyorAdapter (LoginActivity.this,model);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(LoginActivity.this, LinearLayoutManager.VERTICAL, false);
//        lstView.setLayoutManager(linearLayoutManager);
//
//        lstView.setAdapter(toadapter);
    }
}
