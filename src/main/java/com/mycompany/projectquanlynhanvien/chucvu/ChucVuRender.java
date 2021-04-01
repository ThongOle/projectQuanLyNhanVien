/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectquanlynhanvien.chucvu;

import com.mycompany.projectquanlynhanvien.PhongBan.PhongBan;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/**
 *
 * @author admin
 */
public class ChucVuRender extends  BasicComboBoxRenderer{
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (value != null){
            //Lấy đối tượng khoa
            ChucVu objCV = (ChucVu) value;
            setText(objCV.getTenChucVu());
        }
        return this;
    }
}
