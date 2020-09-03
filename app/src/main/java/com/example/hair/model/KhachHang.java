package com.example.hair.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class KhachHang implements Serializable {

    @SerializedName("IdKH")
    @Expose
    private String idKH;
    @SerializedName("TenKH")
    @Expose
    private String tenKH;
    @SerializedName("SoDienThoaiKH")
    @Expose
    private String soDienThoaiKH;
    @SerializedName("GioiTinhKH")
    @Expose
    private String gioiTinhKH;
    @SerializedName("MoTaKH")
    @Expose
    private String moTaKH;

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSoDienThoaiKH() {
        return soDienThoaiKH;
    }

    public void setSoDienThoaiKH(String soDienThoaiKH) {
        this.soDienThoaiKH = soDienThoaiKH;
    }

    public String getGioiTinhKH() {
        return gioiTinhKH;
    }

    public void setGioiTinhKH(String gioiTinhKH) {
        this.gioiTinhKH = gioiTinhKH;
    }

    public String getMoTaKH() {
        return moTaKH;
    }

    public void setMoTaKH(String moTaKH) {
        this.moTaKH = moTaKH;
    }

}