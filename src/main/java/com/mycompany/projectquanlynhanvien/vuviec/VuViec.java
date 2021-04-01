/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectquanlynhanvien.vuviec;

import java.util.Date;

/**
 *
 * @author admin
 */
public class VuViec {
    int maVuViec, mucDoId, maNV;
    String moTa, tenVuViec;
    Date dateLine, ngayBatDau;
    int maNguoiGiao, tinhTrang;

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public int getMaNguoiGiao() {
        return maNguoiGiao;
    }

    public void setMaNguoiGiao(int maNguoiGiao) {
        this.maNguoiGiao = maNguoiGiao;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getMaVuViec() {
        return maVuViec;
    }

    public void setMaVuViec(int maVuViec) {
        this.maVuViec = maVuViec;
    }

    public int getMucDoId() {
        return mucDoId;
    }

    public void setMucDoId(int mucDoId) {
        this.mucDoId = mucDoId;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTenVuViec() {
        return tenVuViec;
    }

    public void setTenVuViec(String tenVuViec) {
        this.tenVuViec = tenVuViec;
    }

    public Date getDateLine() {
        return dateLine;
    }

    public void setDateLine(Date dateLine) {
        this.dateLine = dateLine;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }
}
