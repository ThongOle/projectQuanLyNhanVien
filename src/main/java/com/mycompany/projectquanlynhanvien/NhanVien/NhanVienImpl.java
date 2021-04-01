/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectquanlynhanvien.NhanVien;

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
public class NhanVienImpl implements NhanVienDao {

    Connection conn = null;

    @Override
    public List<NhanVien> layDanhSach() {
        List<NhanVien> lstNhanVien = new ArrayList();

        //Lấy thông tin kết nối
        conn = DataProvider.ketNoi();
        try {
            //Tạo một công việc
            Statement comm = conn.createStatement();
            String strSQL = "Select * from NhanVien;";

            //Lấy kết quả trả về
            ResultSet rs = comm.executeQuery(strSQL);

            //xử lý từng dòng và đưa ra kết quả
            NhanVien objNV;
            while (rs.next()) {
                //Khởi tạo một đối tượng 
                objNV = new NhanVien();

                objNV.setMaNV(rs.getInt("MaNV"));
                objNV.setHoTen(rs.getString("HoTen"));
                objNV.setEmail(rs.getString("Email"));
                objNV.setDienThoai(rs.getString("DienThoai"));
                objNV.setDiaChi(rs.getString("DiaChi"));
                objNV.setNgaySinh(rs.getDate("NgaySinh"));
                objNV.setTrinhDo(rs.getString("TrinhDo"));
                objNV.setGioiTinh(rs.getInt("GioiTinh"));
                objNV.setNgayVaoCongTy(rs.getDate("NgayVaoCongTy"));
                objNV.setMatKhau(rs.getString("MatKhau"));
                objNV.setNoiCapGTCN(rs.getString("NoiCapGTCN"));
                objNV.setNgayCapGTCN(rs.getDate("NgayCapGTCN"));
                objNV.setMaQuyen(rs.getString("MaQuyen"));
                objNV.setMaPhong(rs.getString("MaPhong"));
                objNV.setMaChucVu(rs.getInt("MaChucVu"));
                objNV.setLoaiGTCN(rs.getString("LoaiGTCN"));

                lstNhanVien.add(objNV);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lstNhanVien;
    }

    @Override
    public NhanVien layChiTiet(Integer id) {
        conn = DataProvider.ketNoi();
        NhanVien objNV = null;

        try {
            //Khởi tạo để lấy giá trị
            Statement comm = conn.createStatement();

            String strSQL = "Select * from NhanVien where MaNV= " + id + ";";
            //lấy kết quả trả về
            ResultSet rs = comm.executeQuery(strSQL);
            while (rs.next()) {
                objNV = new NhanVien();
                objNV.setMaNV(id);
                objNV.setHoTen(rs.getString("HoTen"));
                objNV.setEmail(rs.getString("Email"));
                objNV.setDienThoai(rs.getString("DienThoai"));
                objNV.setDiaChi(rs.getString("DiaChi"));
                objNV.setNgaySinh(rs.getDate("NgaySinh"));
                objNV.setTrinhDo(rs.getString("TrinhDo"));
                objNV.setGioiTinh(rs.getInt("GioiTinh"));
                objNV.setNgayVaoCongTy(rs.getDate("NgayVaoCongTy"));
                objNV.setMatKhau(rs.getString("MatKhau"));
                objNV.setNoiCapGTCN(rs.getString("NoiCapGTCN"));
                objNV.setNgayCapGTCN(rs.getDate("NgayCapGTCN"));
                objNV.setMaQuyen(rs.getString("MaQuyen"));
                objNV.setMaPhong(rs.getString("MaPhong"));
                objNV.setMaChucVu(rs.getInt("MaChucVu"));
                objNV.setLoaiGTCN(rs.getString("LoaiGTCN"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally//Nếu thực hiện xong hoặc có lỗi thì luôn cần đóng kết nối với db nếu có
        {
            if (conn != null) {
                try {
                    //Đóng kết nối
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return objNV;
    }

    @Override
    public boolean themMoi(NhanVien objNV) {
        conn = DataProvider.ketNoi();
        String strInsert = "Insert into NhanVien (HoTen, DienThoai, Email,NgayVaoCongTy, MatKhau, GioiTinh, NgayCapGTCN, NoiCapGTCN, DiaChi, NgaySinh, TrinhDo, MaQuyen, MaPhong, MaChucVu, LoaiGTCN) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {

            PreparedStatement comm;
            comm = conn.prepareStatement(strInsert);
            comm.setString(1, objNV.getHoTen());
            comm.setString(2, objNV.getDienThoai());
            comm.setString(3, objNV.getEmail());
            if (objNV.getNgayVaoCongTy() != null){
                comm.setDate(4, new Date (objNV.getNgayVaoCongTy().getTime()));
            }else {
                comm.setDate(4, null);
            }
            comm.setString(5, objNV.getMatKhau());
            comm.setInt(6, objNV.getGioiTinh());
            if (objNV.getNgayCapGTCN() != null){
                comm.setDate(7, new Date(objNV.getNgayCapGTCN().getTime()));
            }else{
                comm.setDate(7, null);
            }
            comm.setString(8, objNV.getNoiCapGTCN());
            comm.setString(9, objNV.getDiaChi());
            if (objNV.getNgaySinh() != null){
                comm.setDate(10, new Date(objNV.getNgaySinh().getTime()));
            }else{
                comm.setDate(10, null);
            }
            
            comm.setString(11, objNV.getTrinhDo());
            comm.setString(12, objNV.getMaQuyen());
            comm.setString(13, objNV.getMaPhong());
            comm.setInt(14, objNV.getMaChucVu());
            comm.setString(15, objNV.getLoaiGTCN());

            return comm.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(NhanVienImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally//Nếu thực hiện xong hoặc có lỗi thì luôn cần đóng kết nối với db nếu có
        {
            if (conn != null) {
                try {
                    //Đóng kết nối
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    @Override
    public boolean capNhat(NhanVien objNV) {
        conn = DataProvider.ketNoi();

        String strUpdate = "Update NhanVien set HoTen = ?, DienThoai =?, Email = ?, NgayVaoCongTy =?, MatKhau =?, GioiTinh = ?, NgayCapGTCN = ?, NoiCapGTCN =?, DiaChi=?, NgaySinh =?, TrinhDo=?, MaQuyen=?, MaPhong=?, MaChucVu=?, LoaiGTCN=? where MaNV=?";

        try {
            PreparedStatement comm = conn.prepareStatement(strUpdate);
            comm.setString(1, objNV.getHoTen());
            comm.setString(2, objNV.getDienThoai());
            comm.setString(3, objNV.getEmail());
            comm.setDate(4, new Date(objNV.getNgayVaoCongTy().getTime()));
            comm.setString(5, objNV.getMatKhau());
            comm.setInt(6, objNV.getGioiTinh());
            comm.setDate(7, new Date(objNV.getNgayCapGTCN().getTime()));
            comm.setString(8, objNV.getNoiCapGTCN());
            comm.setString(9, objNV.getDiaChi());
            comm.setDate(10, new Date(objNV.getNgaySinh().getTime()));
            comm.setString(11, objNV.getTrinhDo());
            comm.setString(12, objNV.getMaQuyen());
            comm.setString(13, objNV.getMaPhong());
            comm.setInt(14, objNV.getMaChucVu());
            comm.setString(15, objNV.getLoaiGTCN());
            comm.setInt(16, objNV.getMaNV());

            return comm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;

    }

    @Override
    public boolean xoa(Integer id) {
        conn = DataProvider.ketNoi();
        String strDelete = "SP_DeleteEmployee ?";
        try {
            PreparedStatement comm = conn.prepareStatement(strDelete);
            comm.setInt(1, id);
            return comm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    @Override
    public List<NhanVien> timKiemNhanVien(String tuKhoa, String maPhong, int soTrang, int soBanGhi) {

        List<NhanVien> lstNV = new ArrayList();

        NhanVien objNV = null;
        conn = DataProvider.ketNoi();
        String strTimKiem= "";
        if (soTrang==0 && soBanGhi==0){
            strTimKiem = "Select * from NhanVien where MaPhong = '" +maPhong+ "'";
        }else{
            strTimKiem = "Select ROW_NUMBER() over (order by MaNV) as STT, MaNV, HoTen, Email, DienThoai, DiaChi, NgaySinh, TrinhDo, GioiTinh, NgayVaoCongTy, MaPhong, MaChucVu, MaQuyen, MatKhau, LoaiGTCN, NoiCapGTCN, NgayCapGTCN from NhanVien where 1=1";

        if (!tuKhoa.isEmpty()) {
            strTimKiem += " and HoTen like N'%" + tuKhoa + "%'";
        }
        if (!maPhong.isEmpty()) {
            strTimKiem += " and MaPhong ='" + maPhong + "'";
        }
        strTimKiem = "Select * from (" + strTimKiem + ") NV where STT between " + (soBanGhi * (soTrang - 1) + 1) + " and " + (soTrang * soBanGhi);
        }
        
        try {
            Statement comm = conn.createStatement();
            ResultSet rs = comm.executeQuery(strTimKiem);
            while (rs.next()) {
                //Khởi tạo một đối tượng 
                objNV = new NhanVien();

                objNV.setMaNV(rs.getInt("MaNV"));
                objNV.setHoTen(rs.getString("HoTen"));
                objNV.setEmail(rs.getString("Email"));
                objNV.setDienThoai(rs.getString("DienThoai"));
                objNV.setDiaChi(rs.getString("DiaChi"));
                objNV.setNgaySinh(rs.getDate("NgaySinh"));
                objNV.setTrinhDo(rs.getString("TrinhDo"));
                objNV.setGioiTinh(rs.getInt("GioiTinh"));
                objNV.setNgayVaoCongTy(rs.getDate("NgayVaoCongTy"));
                objNV.setMatKhau(rs.getString("MatKhau"));
                objNV.setNoiCapGTCN(rs.getString("NoiCapGTCN"));
                objNV.setNgayCapGTCN(rs.getDate("NgayCapGTCN"));
                objNV.setMaQuyen(rs.getString("MaQuyen"));
                objNV.setMaPhong(rs.getString("MaPhong"));
                objNV.setMaChucVu(rs.getInt("MaChucVu"));
                objNV.setLoaiGTCN(rs.getString("LoaiGTCN"));

                lstNV.add(objNV);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstNV;
    }

    @Override
    public NhanVien thongTinDangNhap(String email) {
        conn = DataProvider.ketNoi();

        NhanVien objNV = null;

        try {
            //Khởi tạo để lấy giá trị
            Statement comm = conn.createStatement();

            String strSQL = "exec SP_ThongTinDangNhap '" + email + "';";
            //lấy kết quả trả về
            ResultSet rs = comm.executeQuery(strSQL);
            while (rs.next()) {
                objNV = new NhanVien();
                objNV.setMaNV(rs.getInt("MaNV"));
                objNV.setMatKhau(rs.getString("MatKhau"));
                objNV.setMaQuyen(rs.getString("MaQuyen"));
                objNV.setHoTen(rs.getString("HoTen"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(NhanVienImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally//Nếu thực hiện xong hoặc có lỗi thì luôn cần đóng kết nối với db nếu có
        {
            if (conn != null) {
                try {
                    //Đóng kết nối
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return objNV;
    }

    @Override
    public int Count(String tuKhoa, String maPhong) {
        conn = DataProvider.ketNoi();
        int dem = 0;

        try {
            //Khởi tạo để lấy giá trị
            Statement comm = conn.createStatement();

            String strSQL = "Select count (*) from NhanVien where 1=1 ";

            if (!tuKhoa.isEmpty()) {
                strSQL += " and HoTen like N'%" + tuKhoa + "%'";
            }
            if (!maPhong.isEmpty()) {
                strSQL += " and MaPhong ='" + maPhong + "'";
            }
            //lấy kết quả trả về
            ResultSet rs = comm.executeQuery(strSQL);
            while (rs.next()) {
                dem = rs.getInt(1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally//Nếu thực hiện xong hoặc có lỗi thì luôn cần đóng kết nối với db nếu có
        {
            if (conn != null) {
                try {
                    //Đóng kết nối
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return dem;
    }

    @Override
    public List<NhanVien> layDanhSach(int soTrang, int soBanGhi) {
        List<NhanVien> lstNhanVien = new ArrayList();

        //Lấy thông tin kết nối
        conn = DataProvider.ketNoi();
        try {
            //Tạo một công việc
            Statement comm = conn.createStatement();
            String strSQL = "exec SP_PhanTrang "+ soBanGhi + ", " + soTrang;

            //Lấy kết quả trả về
            ResultSet rs = comm.executeQuery(strSQL);

            //xử lý từng dòng và đưa ra kết quả
            NhanVien objNV;
            while (rs.next()) {
                //Khởi tạo một đối tượng 
                objNV = new NhanVien();

                objNV.setMaNV(rs.getInt("MaNV"));
                objNV.setHoTen(rs.getString("HoTen"));
                objNV.setEmail(rs.getString("Email"));
                objNV.setDienThoai(rs.getString("DienThoai"));
                objNV.setDiaChi(rs.getString("DiaChi"));
                objNV.setNgaySinh(rs.getDate("NgaySinh"));
                objNV.setTrinhDo(rs.getString("TrinhDo"));
                objNV.setGioiTinh(rs.getInt("GioiTinh"));
                objNV.setNgayVaoCongTy(rs.getDate("NgayVaoCongTy"));
                objNV.setMatKhau(rs.getString("MatKhau"));
                objNV.setNoiCapGTCN(rs.getString("NoiCapGTCN"));
                objNV.setNgayCapGTCN(rs.getDate("NgayCapGTCN"));
                objNV.setMaQuyen(rs.getString("MaQuyen"));
                objNV.setMaPhong(rs.getString("MaPhong"));
                objNV.setMaChucVu(rs.getInt("MaChucVu"));
                objNV.setLoaiGTCN(rs.getString("LoaiGTCN"));

                lstNhanVien.add(objNV);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lstNhanVien;
    }

}
