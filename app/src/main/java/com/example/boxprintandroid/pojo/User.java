package com.example.boxprintandroid.pojo;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    int id;

    @SerializedName("nama")
    String nama;

    @SerializedName("email")
    String email;

    @SerializedName("alamat")
    String alamat;

    @SerializedName("no_telpon")
    String noTelpon;

    @SerializedName("foto_profil")
    String fotoProfil;

    @SerializedName("foto_sampul")
    String fotoSampul;

    @SerializedName("jam_buka")


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelpon() {
        return noTelpon;
    }

    public void setNoTelpon(String noTelpon) {
        this.noTelpon = noTelpon;
    }

    public String getFotoProfil() {
        return fotoProfil;
    }

    public void setFotoProfil(String fotoProfil) {
        this.fotoProfil = fotoProfil;
    }

    public String getFotoSampul() {
        return fotoSampul;
    }

    public void setFotoSampul(String fotoSampul) {
        this.fotoSampul = fotoSampul;
    }
}
