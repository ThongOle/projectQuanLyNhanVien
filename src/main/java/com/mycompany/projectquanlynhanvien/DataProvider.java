/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectquanlynhanvien;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class DataProvider {
    private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DATABASE_LINK = "jdbc:sqlserver://DESKTOP-81VHF3A\\SQLEXPRESS;databaseName=QLNVKH";
    
    public static Connection ketNoi(){
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DATABASE_LINK, "sa", "thongvip");
        } catch (ClassNotFoundException ex) {
            System.err.println("Lỗi không tìm thấy driver. chiTiet: "+ ex.getMessage());
        }catch (SQLException ex){
            System.err.println("Không kết nối được Database trên SQL server. chi Tiết: "+ ex.getMessage());
        }
        return conn;
    }
}
