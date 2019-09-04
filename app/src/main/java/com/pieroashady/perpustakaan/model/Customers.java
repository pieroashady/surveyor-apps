package com.pieroashady.perpustakaan.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.pieroashady.perpustakaan.appcontroller.AppController;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.io.Serializable;

@Table(database = AppController.class)
public class Customers extends BaseModel implements Serializable, Parcelable {

    @SerializedName("userId")
    @Expose
    @PrimaryKey(autoincrement = true)
    private int userId;
    @SerializedName("nama")
    @Expose
    @Column
    private String namaCust;
    @SerializedName("umur")
    @Expose
    @Column
    private int umurCust;
    @SerializedName("tempat_lahir")
    @Expose
    @Column
    private String pob;
    @SerializedName("tanggal_lahir")
    @Expose
    @Column
    private String dob;
    @SerializedName("alamat")
    @Expose
    @Column
    private String alamat;
    @SerializedName("keterangan")
    @Expose
    @Column
    private String keterangan;
    @SerializedName("no_telp")
    @Expose
    @Column
    private long noTelpCust;
    @SerializedName("pekerjaan")
    @Expose
    @Column
    private String pekerjaan;
    @SerializedName("gender")
    @Expose
    @Column
    private String gender;

    public Customers(){

    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNamaCust() {
        return namaCust;
    }

    public void setNamaCust(String namaCust) {
        this.namaCust = namaCust;
    }

    public int getUmurCust() {
        return umurCust;
    }

    public void setUmurCust(int umurCust) {
        this.umurCust = umurCust;
    }

    public String getPob() {
        return pob;
    }

    public void setPob(String pob) {
        this.pob = pob;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public long getNoTelpCust() {
        return noTelpCust;
    }

    public void setNoTelpCust(long noTelpCust) {
        this.noTelpCust = noTelpCust;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public final static Creator<Customers> CREATOR = new Creator<Customers>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Customers createFromParcel(Parcel in) {
            return new Customers(in);
        }

        public Customers[] newArray(int size) {
            return (new Customers[size]);
        }

    }
            ;
    private final static long serialVersionUID = 5147465255552625620L;

    protected Customers(Parcel in) {
        this.userId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.umurCust = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.namaCust = ((String) in.readValue((String.class.getClassLoader())));
        this.pob = ((String) in.readValue((String.class.getClassLoader())));
        this.alamat = ((String) in.readValue((String.class.getClassLoader())));
        this.dob = ((String) in.readValue((String.class.getClassLoader())));
        this.keterangan = ((String) in.readValue((String.class.getClassLoader())));
        this.pekerjaan = ((String) in.readValue((String.class.getClassLoader())));
        this.noTelpCust = ((Long) in.readValue((String.class.getClassLoader())));
        this.gender = ((String) in.readValue((String.class.getClassLoader())));

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(userId);
        parcel.writeValue(namaCust);
        parcel.writeValue(pob);
        parcel.writeValue(dob);
        parcel.writeValue(alamat);
        parcel.writeValue(umurCust);
        parcel.writeValue(keterangan);
        parcel.writeValue(noTelpCust);
        parcel.writeValue(pekerjaan);
        parcel.writeValue(gender);
    }
}
