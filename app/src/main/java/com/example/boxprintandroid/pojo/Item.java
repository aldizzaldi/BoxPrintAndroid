package com.example.boxprintandroid.pojo;

import com.google.gson.annotations.SerializedName;

public class Item {
    @SerializedName("id")
    int id;

    @SerializedName("id_user")
    int idUser;

    @SerializedName("id_kategori")
    int idKategori;

    @SerializedName("nama_item")
    String namaItem;

    @SerializedName("harga_item")
    Double hargaItem;

    @SerializedName("deskripsi_item")
    String deskripsiItem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(int idKategori) {
        this.idKategori = idKategori;
    }

    public String getNamaItem() {
        return namaItem;
    }

    public void setNamaItem(String namaItem) {
        this.namaItem = namaItem;
    }

    public Double getHargaItem() {
        return hargaItem;
    }

    public void setHargaItem(Double hargaItem) {
        this.hargaItem = hargaItem;
    }

    public String getDeskripsiItem() {
        return deskripsiItem;
    }

    public void setDeskripsiItem(String deskripsiItem) {
        this.deskripsiItem = deskripsiItem;
    }
}
