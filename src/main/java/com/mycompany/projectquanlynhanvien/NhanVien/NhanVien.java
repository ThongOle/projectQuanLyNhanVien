/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectquanlynhanvien.NhanVien;

import java.util.Date;

/**
 *
 * @author admin
 */
public class NhanVien {
    private String hoTen, email, dienThoai, diaChi, trinhDo, matKhau, noiCapGTCN ,maQuyen, maPhong, loaiGTCN;
    private Date ngaySinh, ngayVaoCongTy, ngayCapGTCN;
    private int gioiTinh, maChucVu;
    private Integer maNV;
    
    public String getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(String maQuyen) {
        this.maQuyen = maQuyen;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public int getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(int maChucVu) {
        this.maChucVu = maChucVu;
    }

    public String getLoaiGTCN() {
        return loaiGTCN;
    }

    public void setLoaiGTCN(String loaiGTCN) {
        this.loaiGTCN = loaiGTCN;
    }
 

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getNoiCapGTCN() {
        return noiCapGTCN;
    }

    public void setNoiCapGTCN(String noiCapGTCN) {
        this.noiCapGTCN = noiCapGTCN;
    }

    public Date getNgayCapGTCN() {
        return ngayCapGTCN;
    }

    public void setNgayCapGTCN(Date ngayCapGTCN) {
        this.ngayCapGTCN = ngayCapGTCN;
    }
    

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(Integer maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Date getNgayVaoCongTy() {
        return ngayVaoCongTy;
    }

    public void setNgayVaoCongTy(Date ngayVaoCongTy) {
        this.ngayVaoCongTy = ngayVaoCongTy;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}
