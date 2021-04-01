/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectquanlynhanvien.vuviec;

import com.mycompany.projectquanlynhanvien.HanhDong;
import java.util.List;

/**
 *
 * @author admin
 */
public interface VuViecDao extends HanhDong<VuViec, Integer> {
    int getMaVVMax();
    boolean InsertNhanVien_VuViec(int MaVV, int MaNV);
    List<VuViec> layDanhSach(int mNV, String strSapXep, String strTinhTrang);
    List<VuViec> layDanhSachGiao(String strSapXep, String strTinhTrang, int MaNV);
    boolean xoaNV_VV (int id);
    
}
