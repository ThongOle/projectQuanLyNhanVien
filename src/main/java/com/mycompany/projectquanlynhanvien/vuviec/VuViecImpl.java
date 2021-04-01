/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectquanlynhanvien.vuviec;

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
public class VuViecImpl implements VuViecDao{
    
    
    Connection conn = null;

    @Override
    public List<VuViec> layDanhSachGiao(String strSapXep, String strTinhTrang, int maNV) {
        List<VuViec> lstVuViec = new ArrayList();

        //Lấy thông tin kết nối
        conn = DataProvider.ketNoi();
        try {
            //Tạo một công việc
            Statement comm = conn.createStatement();
            String strSQL = "Select MaVuViec, TenVuViec, MoTa, TinhTrang, NguoiGiao, NgayBatDau, Deadline, MucDoId from VuViec where NguoiGiao = "+maNV; 
    
            
            
            if(!strTinhTrang.isEmpty()){
                strSQL +=" and TinhTrang = "+strTinhTrang;   
            }
            strSQL += " order by "+ strSapXep;
 

            //Lấy kết quả trả về
            ResultSet rs = comm.executeQuery(strSQL);

            //xử lý từng dòng và đưa ra kết quả
            VuViec objVV;
            while (rs.next()) {
                //Khởi tạo một đối tượng 
                objVV = new VuViec();

                objVV.setMaVuViec(rs.getInt("MaVuViec"));
                objVV.setMucDoId(rs.getInt("MucDoId"));
                objVV.setDateLine(rs.getDate("Deadline"));
                objVV.setMoTa(rs.getString("MoTa"));
                objVV.setTenVuViec(rs.getString("TenVuViec"));
                objVV.setNgayBatDau(rs.getDate("NgayBatDau"));
                objVV.setMaNguoiGiao(rs.getInt("NguoiGiao"));
                objVV.setTinhTrang(rs.getInt("TinhTrang"));

                lstVuViec.add(objVV);
        }
        } catch (SQLException ex) {
            Logger.getLogger(VuViecImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VuViecImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lstVuViec; 
    }
    
    @Override
    public List<VuViec> layDanhSach(int maNV, String strSapXep, String strTinhTrang) {
        List<VuViec> lstVuViec = new ArrayList();

        //Lấy thông tin kết nối
        conn = DataProvider.ketNoi();
        try {
            //Tạo một công việc
            Statement comm = conn.createStatement();
            String strSQL = "Select VuViecId, NhanvienId, TenVuViec, MoTa, TinhTrang, NguoiGiao, NgayBatDau, Deadline, MucDoId from NhanVien_VuViec, VuViec where VuViecId = MaVuViec and NhanVienId = "+maNV; 
    
            
            
            if(!strTinhTrang.isEmpty()){
                strSQL +=" and TinhTrang = "+strTinhTrang;   
            }
            strSQL += " order by "+ strSapXep;
 

            //Lấy kết quả trả về
            ResultSet rs = comm.executeQuery(strSQL);

            //xử lý từng dòng và đưa ra kết quả
            VuViec objVV;
            while (rs.next()) {
                //Khởi tạo một đối tượng 
                objVV = new VuViec();

                objVV.setMaVuViec(rs.getInt("VuViecId"));
                objVV.setMucDoId(rs.getInt("MucDoId"));
                objVV.setDateLine(rs.getDate("Deadline"));
                objVV.setMoTa(rs.getString("MoTa"));
                objVV.setTenVuViec(rs.getString("TenVuViec"));
                objVV.setNgayBatDau(rs.getDate("NgayBatDau"));
                objVV.setMaNguoiGiao(rs.getInt("NguoiGiao"));
                objVV.setTinhTrang(rs.getInt("TinhTrang"));

                lstVuViec.add(objVV);
        }
        } catch (SQLException ex) {
            Logger.getLogger(VuViecImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VuViecImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lstVuViec; 
    }
    
    
    @Override
    public List<VuViec> layDanhSach() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
    }

    @Override
    public VuViec layChiTiet(Integer id) {
        conn = DataProvider.ketNoi();
        VuViec objVV = null;

        try {
            //Khởi tạo để lấy giá trị
            Statement comm = conn.createStatement();

            String strSQL = "Select * from VuViec where MaVuViec =" + id + ";";
            //lấy kết quả trả về
            ResultSet rs = comm.executeQuery(strSQL);
            while (rs.next()) {
                objVV = new VuViec();
                objVV.setMaVuViec(id);
                objVV.setMucDoId(rs.getInt("MucDoId"));
                objVV.setDateLine(rs.getDate("Deadline"));
                objVV.setMoTa(rs.getString("MoTa"));
                objVV.setTenVuViec(rs.getString("TenVuViec"));
                objVV.setNgayBatDau(rs.getDate("NgayBatDau"));
                objVV.setMaNguoiGiao(rs.getInt("NguoiGiao"));
                objVV.setTinhTrang(rs.getInt("TinhTrang"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VuViecImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally//Nếu thực hiện xong hoặc có lỗi thì luôn cần đóng kết nối với db nếu có
        {
            if (conn != null) {
                try {
                    //Đóng kết nối
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VuViecImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return objVV;
    }

    @Override
    public boolean capNhat(VuViec objVV) {
        conn = DataProvider.ketNoi();

        String strUpdate = "Update VuViec set TenVuViec = ?, MoTa = ?, Deadline = ?, MucDoId = ?, NgayBatDau = ?, NguoiGiao= ?, TinhTrang = ? where MaVuViec = ?;";

        try {
            PreparedStatement comm = conn.prepareStatement(strUpdate);
            comm.setString(1, objVV.getTenVuViec());
            comm.setString(2, objVV.getMoTa());
            comm.setDate(3,new Date (objVV.getDateLine().getTime()));
            comm.setInt(4, objVV.getMucDoId());
            comm.setDate(5, new Date (objVV.getNgayBatDau().getTime()));
            comm.setInt(6, objVV.getMaNguoiGiao());
            comm.setInt(7, objVV.getTinhTrang());
            comm.setInt(8, objVV.getMaVuViec());
            
            return comm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(VuViecImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VuViecImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    @Override
    public boolean themMoi(VuViec objVV) {
        conn = DataProvider.ketNoi();
        String strInsert = "Insert into VuViec (TenVuViec, MoTa, Deadline, MucDoId, NgayBatDau, NguoiGiao, TinhTrang) values (?,?,?,?,?,?,?);";
        try {

            PreparedStatement comm;
            comm = conn.prepareStatement(strInsert);
            
            comm.setString(1, objVV.getTenVuViec());
            comm.setString(2, objVV.getMoTa());
            comm.setDate(3,new Date (objVV.getDateLine().getTime()));
            comm.setInt(4, objVV.getMucDoId());
            comm.setDate(5, new Date (objVV.getNgayBatDau().getTime()));
            comm.setInt(6, objVV.getMaNguoiGiao());
            comm.setInt(7, objVV.getTinhTrang());
            
            return comm.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(VuViecImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally//Nếu thực hiện xong hoặc có lỗi thì luôn cần đóng kết nối với db nếu có
        {
            if (conn != null) {
                try {
                    //Đóng kết nối
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VuViecImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    @Override
    public boolean xoaNV_VV(int id) {
        conn = DataProvider.ketNoi();
        String strDelete = "Delete from NhanVien_VuViec where NhanVienId = ?";
        try {
            PreparedStatement comm = conn.prepareStatement(strDelete);
            comm.setInt(1, id);
            return comm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(VuViecImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VuViecImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    
    @Override
    public boolean xoa(Integer id) {
        conn = DataProvider.ketNoi();
        String strDelete = "Delete from NhanVien_VuViec where VuViecId = ?";
        try {
            PreparedStatement comm = conn.prepareStatement(strDelete);
            comm.setInt(1, id);
            return comm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(VuViecImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VuViecImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    @Override
    public int getMaVVMax() {
        conn = DataProvider.ketNoi();
        int maVV = 0;

        try {
            //Khởi tạo để lấy giá trị
            Statement comm = conn.createStatement();

            String strSQL = "Select max(MaVuViec) from VuViec;";
            //lấy kết quả trả về
            ResultSet rs = comm.executeQuery(strSQL);
            while (rs.next()) {
               maVV= rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VuViecImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally//Nếu thực hiện xong hoặc có lỗi thì luôn cần đóng kết nối với db nếu có
        {
            if (conn != null) {
                try {
                    //Đóng kết nối
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VuViecImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return maVV;
    }

    @Override
    public boolean InsertNhanVien_VuViec(int maVV, int maNV) {
        conn = DataProvider.ketNoi();
        String strInsert = "Insert into NhanVien_VuViec (NhanVienId, VuViecId) values (?,?);";
        try {

            PreparedStatement comm;
            comm = conn.prepareStatement(strInsert);
            
            comm.setInt(1, maNV);
            comm.setInt(2, maVV);
            
            return comm.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(VuViecImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally//Nếu thực hiện xong hoặc có lỗi thì luôn cần đóng kết nối với db nếu có
        {
            if (conn != null) {
                try {
                    //Đóng kết nối
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VuViecImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
    
    
    
    
}
