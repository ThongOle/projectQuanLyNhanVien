/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectquanlynhanvien.PhongBan;

import com.mycompany.projectquanlynhanvien.DataProvider;
import java.sql.Connection;
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
public class PhongBanImpl implements PhongBanDao{
    Connection conn = null;

    @Override
    public List<PhongBan> layDanhSach() {
        List<PhongBan> lstPhongBan = new ArrayList();

        //Lấy thông tin kết nối
        conn = DataProvider.ketNoi();
        try {
            //Tạo một công việc
            Statement comm = conn.createStatement();
            String strSQL = "Select MaPhong, TenPhong, Email, DienThoai, MaTruongPhong from PhongBan";

            //Lấy kết quả trả về
            ResultSet rs = comm.executeQuery(strSQL);

            //xử lý từng dòng và đưa ra kết quả
            PhongBan objPB;
            while (rs.next()) {
                //Khởi tạo một đối tượng 
                objPB = new PhongBan();

                objPB.setMaPhong(rs.getString("MaPhong"));
                objPB.setTenPhong(rs.getString("TenPhong"));
                objPB.setEmail(rs.getString("Email"));
                objPB.setDienThoai(rs.getString("DienThoai"));
                objPB.setMaTruongPhong(rs.getInt("MaTruongPhong"));
              

                lstPhongBan.add(objPB);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongBanImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhongBanImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lstPhongBan;
    }

    @Override
    public PhongBan layChiTiet(String id) {
        conn = DataProvider.ketNoi();
        PhongBan objPB = null;
        
        try {
            //Khởi tạo để lấy giá trị
            Statement comm = conn.createStatement();

            String strSQL = "Select TenPhong, Email, DienThoai, MaTruongPhong from PhongBan where MaPhong ='" + id + "'";
            //lấy kết quả trả về
            ResultSet rs = comm.executeQuery(strSQL);
            while (rs.next()) {
                objPB = new PhongBan();
                objPB.setMaPhong(id);
                objPB.setTenPhong(rs.getString("TenPhong"));
                objPB.setEmail(rs.getString("Email"));
                objPB.setDienThoai(rs.getString("DienThoai"));
                objPB.setMaTruongPhong(rs.getInt("MaTruongPhong"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongBanImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally//Nếu thực hiện xong hoặc có lỗi thì luôn cần đóng kết nối với db nếu có
        {
            if (conn != null) {
                try {
                    //Đóng kết nối
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhongBan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return objPB;
    }

    @Override
    public boolean themMoi(PhongBan objPB) {
        conn = DataProvider.ketNoi();
        String strInsert = "Insert into PhongBan (MaPhong, TenPhong, Email, DienThoai, MaTruongPhong) values (?,?,?,?,?)";
        try {

            PreparedStatement comm;
            comm = conn.prepareStatement(strInsert);
            comm.setString(1, objPB.getMaPhong());
            comm.setString(2, objPB.getTenPhong());
            comm.setString(3, objPB.getEmail());
            comm.setString(4, objPB.getDienThoai());
            comm.setInt(5, objPB.getMaTruongPhong());

            return comm.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(PhongBanImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally//Nếu thực hiện xong hoặc có lỗi thì luôn cần đóng kết nối với db nếu có
        {
            if (conn != null) {
                try {
                    //Đóng kết nối
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhongBanImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    @Override
    public boolean capNhat(PhongBan objPB) {
        conn = DataProvider.ketNoi();

        String strUpdate = "Update PhongBan set MaPhong = ?, TenPhong = ?, Email = ?, DienThoai = ?, MaTruongPhong= ? where MaPhong = ?";

        try {
            PreparedStatement comm = conn.prepareStatement(strUpdate);
            
            comm.setString(1, objPB.getTenPhong());
            comm.setString(2, objPB.getEmail());
            comm.setString(3, objPB.getDienThoai());
            comm.setInt(4, objPB.getMaTruongPhong());
            comm.setString(5,objPB.getMaPhong());
            return comm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PhongBanImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhongBanImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;

    }

    @Override
    public boolean xoa(String id) {
        conn = DataProvider.ketNoi();
        String strDelete = "Delete from PhongBan where MaPhong = ?";
        try {
            PreparedStatement comm = conn.prepareStatement(strDelete);
            comm.setString(1, id);
            return comm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PhongBanImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhongBanImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

}
