/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectquanlynhanvien.NhanVien;

import com.mycompany.projectquanlynhanvien.HanhDong;
import java.util.List;

/**
 *
 * @author admin
 */
public interface NhanVienDao extends HanhDong <NhanVien,Integer>{
    //Bổ sung thuộc tính tìm kiếm cho NhanVienDao
    List <NhanVien> timKiemNhanVien(String tuKhoa, String maPhong, int SoTrang, int soBanGhi);
    
    NhanVien thongTinDangNhap(String email);
    int Count(String tuKhoa, String maPhong);
    List <NhanVien> layDanhSach(int soTrang, int soBanGhi);
    
}
