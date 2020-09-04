package com.example.hair.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Tho implements Serializable {

    @SerializedName("IdTho")
    @Expose
    private String idTho;
    @SerializedName("TenTho")
    @Expose
    private String tenTho;
    @SerializedName("SoDienThoaiTho")
    @Expose
    private String soDienThoaiTho;
    @SerializedName("DiaChiTho")
    @Expose
    private String diaChiTho;
    @SerializedName("GioiTinhTho")
    @Expose
    private String gioiTinhTho;
    @SerializedName("MoTaTho")
    @Expose
    private String moTaTho;
    @SerializedName("HinhAnhTho")
    @Expose
    private String hinhAnhTho;

    public String getIdTho() {
        return idTho;
    }

    public void setIdTho(String idTho) {
        this.idTho = idTho;
    }

    public String getTenTho() {
        return tenTho;
    }

    public void setTenTho(String tenTho) {
        this.tenTho = tenTho;
    }

    public String getSoDienThoaiTho() {
        return soDienThoaiTho;
    }

    public void setSoDienThoaiTho(String soDienThoaiTho) {
        this.soDienThoaiTho = soDienThoaiTho;
    }

    public String getDiaChiTho() {
        return diaChiTho;
    }

    public void setDiaChiTho(String diaChiTho) {
        this.diaChiTho = diaChiTho;
    }

    public String getGioiTinhTho() {
        return gioiTinhTho;
    }

    public void setGioiTinhTho(String gioiTinhTho) {
        this.gioiTinhTho = gioiTinhTho;
    }

    public String getMoTaTho() {
        return moTaTho;
    }

    public void setMoTaTho(String moTaTho) {
        this.moTaTho = moTaTho;
    }

    public String getHinhAnhTho() {
        return hinhAnhTho;
    }

    public void setHinhAnhTho(String hinhAnhTho) {
        this.hinhAnhTho = hinhAnhTho;
    }

}