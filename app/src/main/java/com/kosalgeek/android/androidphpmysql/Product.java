package com.kosalgeek.android.androidphpmysql;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Product implements Serializable {

    @SerializedName("id_berita")
    public int id_berita;

    @SerializedName("post")
    public String post;

    @SerializedName("status")
    public String status;

    @SerializedName("image_url")
    public String image_url;

    @SerializedName("kategori")
    public String kategori;

    @SerializedName("deskrip")
    public String deskrip;
}
