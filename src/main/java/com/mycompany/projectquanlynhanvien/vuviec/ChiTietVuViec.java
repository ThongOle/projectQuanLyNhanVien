/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectquanlynhanvien.vuviec;

import com.mycompany.projectquanlynhanvien.NhanVien.NhanVien;
import com.mycompany.projectquanlynhanvien.NhanVien.NhanVienDao;
import com.mycompany.projectquanlynhanvien.NhanVien.NhanVienImpl;
import com.mycompany.projectquanlynhanvien.PhongBan.PhongBan;
import com.mycompany.projectquanlynhanvien.PhongBan.PhongBanDao;
import com.mycompany.projectquanlynhanvien.PhongBan.PhongBanImpl;
import com.mycompany.projectquanlynhanvien.PhongBan.PhongBanRender;
import static com.mycompany.projectquanlynhanvien.vuviec.JplGiaoViec.lstNhanVien;
import static com.mycompany.projectquanlynhanvien.vuviec.JplGiaoViec.lstPhongBan;
import static com.mycompany.projectquanlynhanvien.vuviec.JplGiaoViec.txtNhanVien;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class ChiTietVuViec extends javax.swing.JFrame {

    /**
     * Creates new form ChiTietVuViec
     */
    static List<PhongBan> lstPhongBan = new ArrayList();
    private String tenPhong = "", maPhong = "", strNhanVien = "";
    private String strPhongBan = "";
    static List<NhanVien> lstNhanVien = new ArrayList();
    int maVuViec = 0;
    String trangThai = "";

    public static List<NhanVien> getLstNhanVien() {
        return lstNhanVien;
    }

    public static void setLstNhanVien(List<NhanVien> lstNhanVien) {
        ChiTietVuViec.lstNhanVien = lstNhanVien;
    }
    

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public void setMaVuViec(int maVuViec) {
        this.maVuViec = maVuViec;
    }

    public ChiTietVuViec() {
        initComponents();

    }

    public void hienThiVuViec() {
        VuViecDao vuViecDao = new VuViecImpl();
        VuViec objVuViec = vuViecDao.layChiTiet(maVuViec);

        txtTieuDe.setText(objVuViec.getTenVuViec());
        txtNguoiGiao.setText(hienThiTenNguoiGiao(objVuViec.getMaNguoiGiao()));
        txtNoiDung.setText(objVuViec.getMoTa());
        int tinhTrang = objVuViec.getTinhTrang();
        switch (tinhTrang) {
            case 1:
                cboTinhTrang.setSelectedItem("Chưa hoàn thành");
                break;
            case 2:
                cboTinhTrang.setSelectedItem("Đã hoàn thành");
                break;
        }
        int mucDo = objVuViec.getMucDoId();
        switch (mucDo) {
            case 1:
                cboMucDo.setSelectedItem("Ít quan trọng");
                break;
            case 2:
                cboMucDo.setSelectedItem("Quan trọng");
                break;
            case 3:
                cboMucDo.setSelectedItem("Rất Quan trọng");
                break;
        }

        jDateChooserGiaoViec.setDate(objVuViec.getNgayBatDau());
        jDateChooserDeadline.setDate(objVuViec.getDateLine());

    }
    

    private String hienThiTenNguoiGiao(int maNV) {
        NhanVienDao nhanVienDao = new NhanVienImpl();
        NhanVien objNV = nhanVienDao.layChiTiet(maNV);
        String tenNV = objNV.getHoTen();
        return tenNV;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTieuDe = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNguoiGiao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jDateChooserDeadline = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jDateChooserGiaoViec = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        cboTinhTrang = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNoiDung = new javax.swing.JTextArea();
        btnDong = new javax.swing.JButton();
        lblPhongBan = new javax.swing.JLabel();
        txtPhongBan = new javax.swing.JTextField();
        cboPhongBan = new javax.swing.JComboBox<>();
        btnXacNhan = new javax.swing.JButton();
        lblNhanVien = new javax.swing.JLabel();
        txtNhanVien = new javax.swing.JTextField();
        btnNhanVien = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cboMucDo = new javax.swing.JComboBox<>();
        btnSuaDoi = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi Tiết Công việc"));

        jLabel1.setText("Tiêu đề:");

        jLabel2.setText("Người giao:");

        jLabel3.setText("Nội dung:");

        jLabel4.setText("Ngày Giao Việc:");

        jLabel5.setText("Deadline");

        jLabel6.setText("Tình Trạng:");

        cboTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã hoàn thành", "Chưa hoàn thành" }));

        txtNoiDung.setColumns(20);
        txtNoiDung.setRows(5);
        jScrollPane2.setViewportView(txtNoiDung);

        btnDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.gif"))); // NOI18N
        btnDong.setText("Đóng");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        lblPhongBan.setText("Phòng Ban tiếp nhận");

        cboPhongBan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboPhongBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboPhongBanMouseClicked(evt);
            }
        });
        cboPhongBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPhongBanActionPerformed(evt);
            }
        });

        btnXacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        lblNhanVien.setText("Người tiếp nhận:");

        txtNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNhanVienActionPerformed(evt);
            }
        });

        btnNhanVien.setText("Chọn nhân viên tiếp nhận");
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });

        jLabel7.setText("Mức độ");

        cboMucDo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ít quan trọng", "Quan trọng", "Rất Quan trọng" }));

        btnSuaDoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accept.png"))); // NOI18N
        btnSuaDoi.setText("Sửa đổi");
        btnSuaDoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDoiActionPerformed(evt);
            }
        });

        btnClean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.gif"))); // NOI18N
        btnClean.setText("Xóa");
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(365, 365, 365)
                            .addComponent(btnSuaDoi, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(lblPhongBan)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(cboPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(lblNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNhanVien)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jDateChooserGiaoViec, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                .addComponent(cboTinhTrang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(44, 44, 44)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jDateChooserDeadline, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                .addComponent(cboMucDo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnClean)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(28, 28, 28)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNguoiGiao, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNguoiGiao, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXacNhan))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNhanVien)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooserGiaoViec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooserDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboMucDo)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDong)
                    .addComponent(btnSuaDoi))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnDongActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        txtPhongBan.setEnabled(false);
        txtNhanVien.setEnabled(false);
        if (!trangThai.equals("Giao")){
            lblPhongBan.setVisible(false);
            txtPhongBan.setVisible(false);
            cboPhongBan.setVisible(false);
            btnXacNhan.setVisible(false);
            txtNhanVien.setVisible(false);
            lblNhanVien.setVisible(false);
            btnNhanVien.setVisible(false);
            btnSuaDoi.setVisible(false);
            btnClean.setVisible(false);
        }
        if(trangThai.equals("Giao")){
            hienThiDanhSachPhong();
        }
        
        hienThiVuViec();
        

    }//GEN-LAST:event_formWindowOpened

    private void cboPhongBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPhongBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPhongBanActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        // TODO add your handling code here:
        String tenPhong = "";
        PhongBan objPhong = (PhongBan) cboPhongBan.getSelectedItem();

        tenPhong = objPhong.getTenPhong();
        if (!tenPhong.equals("---Chọn Phòng---")) {
            strPhongBan += tenPhong + ";";
            txtPhongBan.setText(strPhongBan);
            lstPhongBan.add(objPhong);
        }
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void txtNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNhanVienActionPerformed

    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        // TODO add your handling code here:
        strNhanVien = txtNhanVien.getText();
        frmChonNhanVien frmchonNhanVien = new frmChonNhanVien();
        if (!strNhanVien.isEmpty()) {
            frmchonNhanVien.setStrNhanVien(strNhanVien);
            frmchonNhanVien.setLstNV(lstNhanVien);
        }
        frmchonNhanVien.setTrangThai("Sửa");

        frmchonNhanVien.setVisible(true);
    }//GEN-LAST:event_btnNhanVienActionPerformed

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        // TODO add your handling code here:
        txtPhongBan.setText("");
        strPhongBan = "";
        lstPhongBan.clear();
    }//GEN-LAST:event_btnCleanActionPerformed
    
    
    private void btnSuaDoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDoiActionPerformed
        // TODO add your handling code here:
        String strTieuDe = "", strNoiDung = "", strMucDo = "", strTinhTrang="";
        VuViecDao vuViecDao = new VuViecImpl();
        VuViec objVV = vuViecDao.layChiTiet(maVuViec);
        
        strTieuDe = txtTieuDe.getText();
        strNoiDung = txtNoiDung.getText();
        strPhongBan = txtPhongBan.getText();
        strNhanVien = txtNhanVien.getText();

        if (strTieuDe.isEmpty()) {
            JOptionPane.showMessageDialog(getRootPane(), "Bạn cần phải nhập Tiêu đề");
            txtTieuDe.requestFocus();
            return;
        }
        if (strNoiDung.isEmpty()) {
            JOptionPane.showMessageDialog(getRootPane(), "Bạn cần phải nhập Nội dung công việc");
            txtNoiDung.requestFocus();
            return;
        }
        if (strPhongBan.isEmpty() && strNhanVien.isEmpty()) {
            JOptionPane.showMessageDialog(getRootPane(), "Bạn cần phải nhập Phòng Ban hoặc người tiếp nhận công việc");
            return;
        }
        
        objVV.setTenVuViec(strTieuDe);
        objVV.setMoTa(strNoiDung);
        objVV.setDateLine(jDateChooserDeadline.getDate());
        objVV.setNgayBatDau(jDateChooserGiaoViec.getDate());
        
        strTinhTrang = ""+ cboTinhTrang.getSelectedItem();
        switch (strTinhTrang){
            case "Đã hoàn thành":
                objVV.setTinhTrang(2);
                break;
            case "Chưa hoàn thành":
                objVV.setTinhTrang(1);
                break;
        }
      
        strMucDo = "" + cboMucDo.getSelectedItem();
        switch (strMucDo) {
            case "Ít quan trọng":
                objVV.setMucDoId(1);
                break;
            case "Quan trọng":
                objVV.setMucDoId(2);
                break;
            case "Rất quan trọng":
                objVV.setMucDoId(3);
                break;
        }

        vuViecDao.capNhat(objVV);
        
        NhanVienDao nhanVienDao = new NhanVienImpl();
        
        //Dạo 1 danh sách mã nhân viên
        List<Integer> lstNV = new ArrayList();
        
        //Tạo 1 danh sach lst nhân viên
        List<NhanVien> lstDSNV = new ArrayList();

        for (PhongBan pb : lstPhongBan) {
            lstDSNV = nhanVienDao.timKiemNhanVien("", pb.getMaPhong(), 0, 0);
            for (NhanVien nv : lstDSNV) {
                lstNhanVien.add(nv);
            }
        }
//kiểm tra xem có bị lặp nhân viên trong danh sách không và thêm vào lst mã nhân viên
        for (NhanVien nv : lstNhanVien) {
            int temp = 0;
            for (int i = 0; i < lstNV.size(); i++) {
                if (nv.getMaNV() == lstNV.get(i)) {
                    temp++;
                }
            }
            if (temp == 0) {
                lstNV.add(nv.getMaNV());
            }
        }
        //xóa hết thông tin của trong bảng NhanVien_VuViec where VuViec = maVuViec;
        vuViecDao.xoa(maVuViec);
        
        boolean kq = false;
        //insert thông tin 
        for (int i = 0; i < lstNV.size(); i++) {
            kq = vuViecDao.InsertNhanVien_VuViec(maVuViec, lstNV.get(i));
        }
        if (kq == true){
           JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công"); 
        }
        
        
        
        
    }//GEN-LAST:event_btnSuaDoiActionPerformed

    private void cboPhongBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboPhongBanMouseClicked
        // TODO add your handling code here:
         String tenPhong = "";
        PhongBan objPhong = (PhongBan) cboPhongBan.getSelectedItem();

        tenPhong = objPhong.getTenPhong();
        if (!tenPhong.equals("---Chọn Phòng---")) {
            strPhongBan += tenPhong + ";";
            txtPhongBan.setText(strPhongBan);
            lstPhongBan.add(objPhong);
        }
    }//GEN-LAST:event_cboPhongBanMouseClicked
    private void hienThiDanhSachPhong() {
        //Khai báo 1 đối tượng để lấy danh sách khoa
        PhongBanDao phongBanDao = new PhongBanImpl();

        //Lấy danh sách khoa
        List<PhongBan> lstPhong = phongBanDao.layDanhSach();

        PhongBan root = new PhongBan();
        root.setMaPhong("");
        root.setTenPhong("---Chọn Phòng---");
        lstPhong.add(0, root);

        DefaultComboBoxModel model = new DefaultComboBoxModel();

        //Duyệt từng thông tin khoa để đưa vào model
        for (PhongBan objPhong : lstPhong) {
            model.addElement(objPhong);
        }

        //Hiển thị lên combobox
        cboPhongBan.setModel(model);

        //Chỉnh sửa lại hiển thị
        cboPhongBan.setRenderer(new PhongBanRender());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChiTietVuViec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietVuViec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietVuViec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietVuViec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChiTietVuViec().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnNhanVien;
    private javax.swing.JButton btnSuaDoi;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JComboBox<String> cboMucDo;
    private javax.swing.JComboBox<String> cboPhongBan;
    private javax.swing.JComboBox<String> cboTinhTrang;
    private com.toedter.calendar.JDateChooser jDateChooserDeadline;
    private com.toedter.calendar.JDateChooser jDateChooserGiaoViec;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblPhongBan;
    private javax.swing.JTextField txtNguoiGiao;
    public static javax.swing.JTextField txtNhanVien;
    private javax.swing.JTextArea txtNoiDung;
    private javax.swing.JTextField txtPhongBan;
    private javax.swing.JTextField txtTieuDe;
    // End of variables declaration//GEN-END:variables
}
