/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectquanlynhanvien;

import java.util.List;

/**
 *
 * @author admin
 */
public interface HanhDong <T, idT>{
    List <T> layDanhSach();
    T layChiTiet(idT id);
    boolean themMoi(T id);
    boolean capNhat (T id);
    boolean xoa (idT id);
    
}
