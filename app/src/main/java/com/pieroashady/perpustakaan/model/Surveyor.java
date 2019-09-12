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
public class Surveyor extends BaseModel implements Serializable, Parcelable {

    @SerializedName("surveyorId")
    @Expose
    @PrimaryKey(autoincrement = true)
    private int surveyorId;
    @SerializedName("namaSurv")
    @Expose
    @Column
    private String namaSurveyor;
    @SerializedName("umurSurv")
    @Expose
    @Column
    private int umurSurveyor;
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
    @SerializedName("perusahaan")
    @Expose
    @Column
    private String perusahaan;
    @SerializedName("gender")
    @Expose
    @Column
    private String gender;
    @SerializedName("no_telp")
    @Expose
    @Column
    private long no_telp;
    @SerializedName("password")
    @Expose
    @Column
    private String password;


    public Surveyor(){

    }

    public int getSurveyorId() {
        return surveyorId;
    }

    public void setSurveyorId(int surveyorId) {
        this.surveyorId = surveyorId;
    }

    public String getNamaSurveyor() {
        return namaSurveyor;
    }

    public void setNamaSurveyor(String namaSurveyor) {
        this.namaSurveyor = namaSurveyor;
    }

    public int getUmurSurveyor() {
        return umurSurveyor;
    }

    public void setUmurSurveyor(int umurSurveyor) {
        this.umurSurveyor = umurSurveyor;
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

    public String getPerusahaan() {
        return perusahaan;
    }

    public void setPerusahaan(String perusahaan) {
        this.perusahaan = perusahaan;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(long no_telp) {
        this.no_telp = no_telp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public final static Creator<Surveyor> CREATOR = new Creator<Surveyor>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Surveyor createFromParcel(Parcel in) {
            return new Surveyor(in);
        }

        public Surveyor[] newArray(int size) {
            return (new Surveyor[size]);
        }

    }
            ;
    private final static long serialVersionUID = 5147465255552625620L;

    protected Surveyor(Parcel in) {
        this.surveyorId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.umurSurveyor = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.namaSurveyor = ((String) in.readValue((String.class.getClassLoader())));
        this.dob = ((String) in.readValue((String.class.getClassLoader())));
        this.alamat = ((String) in.readValue((String.class.getClassLoader())));
        this.pob = ((String) in.readValue((String.class.getClassLoader())));
        this.no_telp = ((Long) in.readValue((String.class.getClassLoader())));
        this.gender = ((String) in.readValue((String.class.getClassLoader())));
        this.perusahaan = ((String) in.readValue((String.class.getClassLoader())));
        this.password = ((String) in.readValue((String.class.getClassLoader())));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(surveyorId);
        parcel.writeValue(namaSurveyor);
        parcel.writeValue(pob);
        parcel.writeValue(dob);
        parcel.writeValue(alamat);
        parcel.writeValue(umurSurveyor);
        parcel.writeValue(gender);
        parcel.writeValue(no_telp);
        parcel.writeValue(perusahaan);
        parcel.writeValue(password);
    }
}
