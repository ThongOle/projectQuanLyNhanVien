/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectquanlynhanvien.chucvu;

import com.mycompany.projectquanlynhanvien.DataProvider;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class ChucVuImpl implements ChucVuDao {

    Connection conn = null;

    @Override
    public ChucVu layChiTiet(Integer id) {
        conn = DataProvider.ketNoi();
        ChucVu objCV = null;

        try {
            //Khởi tạo để lấy giá trị
            Statement comm = conn.createStatement();

            String strSQL = "Select * from ChucVu where MaCV =" + id + ";";
            //lấy kết quả trả về
            ResultSet rs = comm.executeQuery(strSQL);
            while (rs.next()) {
                objCV = new ChucVu();
                objCV.setMaChucVu(id);
                objCV.setTenChucVu(rs.getString("TenChucVu"));
                objCV.setMaPhong(rs.getString("MaPhong"));
                objCV.setNgayBatDau(rs.getDate("NgayBatDau"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChucVuImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally//Nếu thực hiện xong hoặc có lỗi thì luôn cần đóng kết nối với db nếu có
        {
            if (conn != null) {
                try {
                    //Đóng kết nối
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucVuImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return objCV;
    }

    @Override
    public List<ChucVu> layDanhSach() {
        List<ChucVu> lstChucVu = new ArrayList();

        //Lấy thông tin kết nối
        conn = DataProvider.ketNoi();
        try {
            //Tạo một công việc
            Statement comm = conn.createStatement();
            String strSQL = "Select * from ChucVu;";

            //Lấy kết quả trả về
            ResultSet rs = comm.executeQuery(strSQL);

            //xử lý từng dòng và đưa ra kết quả
            ChucVu objCV;
            while (rs.next()) {
                //Khởi tạo một đối tượng 
                objCV = new ChucVu();

                objCV.setMaChucVu(rs.getInt("MaCV"));
                objCV.setTenChucVu(rs.getString("TenChucVu"));
                objCV.setMaPhong(rs.getString("MaPhong"));
                objCV.setNgayBatDau(rs.getDate("NgayBatDau"));

                lstChucVu.add(objCV);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChucVuImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucVuImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lstChucVu;
    }

    @Override
    public boolean themMoi(ChucVu objCV) {
        conn = DataProvider.ketNoi();
        String strInsert = "Insert into ChucVu (TenChucVu, MaCV, NgayBatDau) values (?,?,?);";
        try {

            PreparedStatement comm;
            comm = conn.prepareStatement(strInsert);
            comm.setString(1, objCV.getTenChucVu());
            comm.setString(2, objCV.getMaPhong());
            comm.setDate(3, new Date(objCV.getNgayBatDau().getTime()));

            return comm.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(ChucVuImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally//Nếu thực hiện xong hoặc có lỗi thì luôn cần đóng kết nối với db nếu có
        {
            if (conn != null) {
                try {
                    //Đóng kết nối
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucVuImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    @Override
    public boolean capNhat(ChucVu objCV) {
        conn = DataProvider.ketNoi();

        String strUpdate = "Update ChucVu set TenChucVu = ?, MaPhong = ?, NgayBatDau = ? where MaCV = ?;";

        try {
            PreparedStatement comm = conn.prepareStatement(strUpdate);
            comm.setString(1, objCV.getTenChucVu());
            comm.setString(2, objCV.getMaPhong());
            comm.setDate(3, new Date(objCV.getNgayBatDau().getTime()));
            comm.setInt(4, objCV.getMaChucVu());

            return comm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ChucVuImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucVuImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    @Override
    public boolean xoa(Integer id) {
        conn = DataProvider.ketNoi();
        String strDelete = "Delete from ChucVu where MaCV = ?";
        try {
            PreparedStatement comm = conn.prepareStatement(strDelete);
            comm.setInt(1, id);
            return comm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ChucVuImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucVuImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

}
