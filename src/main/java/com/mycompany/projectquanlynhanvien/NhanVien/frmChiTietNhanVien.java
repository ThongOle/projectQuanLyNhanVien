/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectquanlynhanvien.NhanVien;

import com.mycompany.projectquanlynhanvien.PhongBan.PhongBanRender;
import com.mycompany.projectquanlynhanvien.PhongBan.PhongBanDao;
import com.mycompany.projectquanlynhanvien.PhongBan.PhongBanImpl;
import com.mycompany.projectquanlynhanvien.PhongBan.PhongBan;
import com.mycompany.projectquanlynhanvien.chucvu.ChucVu;
import com.mycompany.projectquanlynhanvien.chucvu.ChucVuDao;
import com.mycompany.projectquanlynhanvien.chucvu.ChucVuImpl;
import com.mycompany.projectquanlynhanvien.chucvu.ChucVuRender;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author admin
 */
public class frmChiTietNhanVien extends javax.swing.JFrame {

    /**
     * Creates new form frmChiTietNhanVien
     */
    public frmChiTietNhanVien() {
        initComponents();
        

    }
    private int maNV = 0;
    private String trangThai = "";

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }
    NhanVienDao nhanVienDao = new NhanVienImpl();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jplThongTinNhanVien = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooserNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rbtnNam = new javax.swing.JRadioButton();
        rbtnNu = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jDateChooserNgayCap = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        txtNoiCap = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cboPhongBan = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cboChucVu = new javax.swing.JComboBox<>();
        txtHoTen = new javax.swing.JTextField();
        txtDienThoai = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtBangCap = new javax.swing.JTextField();
        btnXacNhan = new javax.swing.JButton();
        btnHuyBo = new javax.swing.JButton();
        txtGTCN = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jplThongTinNhanVien.setBorder(javax.swing.BorderFactory.createTitledBorder("Th??ng tin nh??n vi??n"));
        jplThongTinNhanVien.setPreferredSize(new java.awt.Dimension(1280, 577));

        jLabel2.setText("H??? T??n:");

        jLabel3.setText("Gi???i T??nh:");

        jLabel4.setText("Ng??y Sinh:");

        jDateChooserNgaySinh.setDateFormatString("dd/MM/yyyy");

        jLabel5.setText("??i???n Tho???i:");

        jLabel6.setText("Email:");

        jLabel7.setText("?????a ch???:");

        jLabel8.setText("B???ng c???p:");

        jLabel9.setText("Lo???i gi???y t??? ch???ng th???c c?? nh??n");

        buttonGroup1.add(rbtnNam);
        rbtnNam.setText("Nam");

        buttonGroup1.add(rbtnNu);
        rbtnNu.setText("N???");

        jLabel10.setText("Ng??y c???p:");

        jDateChooserNgayCap.setDateFormatString("dd/MM/yyyy");

        jLabel11.setText("N??i c???p");

        jLabel12.setText("Ph??ng/Ban:(*)");

        cboPhongBan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setText("Ch???c v???:(*)");

        cboChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnXacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/action_settings.gif"))); // NOI18N
        btnXacNhan.setText("X??c nh???n");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        btnHuyBo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel.gif"))); // NOI18N
        btnHuyBo.setText("H???y b???");
        btnHuyBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyBoActionPerformed(evt);
            }
        });

        txtGTCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGTCNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jplThongTinNhanVienLayout = new javax.swing.GroupLayout(jplThongTinNhanVien);
        jplThongTinNhanVien.setLayout(jplThongTinNhanVienLayout);
        jplThongTinNhanVienLayout.setHorizontalGroup(
            jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplThongTinNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jplThongTinNhanVienLayout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHuyBo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplThongTinNhanVienLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboChucVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboPhongBan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jplThongTinNhanVienLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooserNgayCap, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNoiCap, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jplThongTinNhanVienLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtGTCN))
                    .addGroup(jplThongTinNhanVienLayout.createSequentialGroup()
                        .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                            .addComponent(txtBangCap)))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jplThongTinNhanVienLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtHoTen))
                            .addGroup(jplThongTinNhanVienLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(189, 189, 189)
                                .addComponent(rbtnNam)
                                .addGap(210, 210, 210)
                                .addComponent(rbtnNu))
                            .addGroup(jplThongTinNhanVienLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooserNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jplThongTinNhanVienLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtDienThoai))))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jplThongTinNhanVienLayout.setVerticalGroup(
            jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplThongTinNhanVienLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jplThongTinNhanVienLayout.createSequentialGroup()
                        .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtnNam)
                            .addComponent(rbtnNu))
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooserNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jplThongTinNhanVienLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBangCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGTCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jDateChooserNgayCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNoiCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(cboChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacNhan)
                    .addComponent(btnHuyBo))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jplThongTinNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jplThongTinNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        int gioiTinh = 0;
        //Khai b??o 1 ?????i t?????ng
        NhanVien objNV = new NhanVien();
        
        
        if (maNV != 0){
            objNV = nhanVienDao.layChiTiet(maNV);
        }

        //L???y th??ng tin ng?????i d??ng nh???p tr??n giao di???n v?? g??n cho c??c thu???c t??nh c???a ?????i t?????ng
        objNV.setHoTen(txtHoTen.getText());
        objNV.setNgaySinh(jDateChooserNgaySinh.getDate());
        objNV.setDienThoai(txtDienThoai.getText());
        objNV.setEmail(txtEmail.getText());
        objNV.setDiaChi(txtDiaChi.getText());
        objNV.setTrinhDo(txtBangCap.getText());
        objNV.setNgayCapGTCN(jDateChooserNgayCap.getDate());
        objNV.setNoiCapGTCN(txtNoiCap.getText());
        objNV.setLoaiGTCN(txtGTCN.getText());
        

        String maPhong = "";
        PhongBan objPhong = (PhongBan) cboPhongBan.getSelectedItem();

        if (objPhong != null) {
            maPhong = objPhong.getMaPhong();
        }

        objNV.setMaPhong(maPhong);
        
        int maChucVu = 0;
        ChucVu objCV = (ChucVu) cboChucVu.getSelectedItem();

        if (objCV != null) {
            maChucVu = objCV.getMaChucVu();
        }

        objNV.setMaChucVu(maChucVu);
        

        //N???u l?? n???
        if (rbtnNu.isSelected()) {
            gioiTinh = 1;
        }

        objNV.setGioiTinh(gioiTinh);

        //Khai b??o 1 tr???ng th??i ch???a k???t qu??? th???c hi???n
        boolean kq;

        //TH s???a
        if (maNV != 0) {
            kq = nhanVienDao.capNhat(objNV);
        } else//TH th??m m???i
        {
            //G???i h??m th??m m???i sinh vi??n v??o h??? th???ng
            kq = nhanVienDao.themMoi(objNV);
        }
        if (kq)//True
        {
            //Reload l???i danh s??ch
            JplDanhSachNhanVien.hienThiDanhSach(1);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        hienThiDanhSachPhong();
        hienThiDanhSachChucVu();

        //TH s???a
        if (trangThai == "S???a") {
            this.setTitle("S???a th??ng tin nh??n vi??n");
            //G???i h??m hi???n th??? chi ti???t sinh vi??n
            hienThiChiTietNhanVien();
        }
        if (trangThai == "Th??m m???i") {
            this.setTitle("Th??m m???i th??ng tin sinh vi??n");
        }
        if (trangThai == "Th??ng tin") {
            this.setTitle("Th??ng tin t??i kho???n");
        }


    }//GEN-LAST:event_formWindowOpened

    private void txtGTCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGTCNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGTCNActionPerformed

    private void btnHuyBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyBoActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnHuyBoActionPerformed
    private void hienThiDanhSachPhong() {
        //Khai b??o 1 ?????i t?????ng ????? l???y danh s??ch khoa
        PhongBanDao phongBanDao = new PhongBanImpl();

        //L???y danh s??ch khoa
        List<PhongBan> lstPhong = phongBanDao.layDanhSach();

        PhongBan root = new PhongBan();
        root.setMaPhong("");
        root.setTenPhong("---Ch???n Ph??ng---");
        lstPhong.add(0, root);

        DefaultComboBoxModel model = new DefaultComboBoxModel();

        //Duy???t t???ng th??ng tin khoa ????? ????a v??o model
        for (PhongBan objPhong : lstPhong) {
            model.addElement(objPhong);
        }

        //Hi???n th??? l??n combobox
        cboPhongBan.setModel(model);

        //Ch???nh s???a l???i hi???n th???
        cboPhongBan.setRenderer(new PhongBanRender());
    }
    
    private void hienThiDanhSachChucVu() {
        //Khai b??o 1 ?????i t?????ng ????? l???y danh s??ch 
        ChucVuDao chucVuDao = new ChucVuImpl();

        //L???y danh s??ch 
        List<ChucVu> lstChucVu = chucVuDao.layDanhSach();

        ChucVu root = new ChucVu();
        root.setMaChucVu(0);
        root.setTenChucVu("---Ch???n Ch???c V???---");
        lstChucVu.add(0, root);

        DefaultComboBoxModel model = new DefaultComboBoxModel();

        //Duy???t t???ng th??ng tin khoa ????? ????a v??o model
        for (ChucVu objCV : lstChucVu) {
            model.addElement(objCV);
        }

        //Hi???n th??? l??n combobox
        cboChucVu.setModel(model);

        //Ch???nh s???a l???i hi???n th???
        cboChucVu.setRenderer(new ChucVuRender());
    }
    private void hienThiChiTietNhanVien() {
        NhanVien objNV = nhanVienDao.layChiTiet(maNV);

        txtHoTen.setText(objNV.getHoTen());
        jDateChooserNgaySinh.setDate(objNV.getNgaySinh());
        txtDienThoai.setText(objNV.getDienThoai());
        txtEmail.setText(objNV.getEmail());
        txtDiaChi.setText(objNV.getDiaChi());
        txtBangCap.setText(objNV.getTrinhDo());
        jDateChooserNgayCap.setDate(objNV.getNgayCapGTCN());
        txtNoiCap.setText(objNV.getNoiCapGTCN());
        txtGTCN.setText(objNV.getLoaiGTCN());
        if (objNV.getGioiTinh() == 0) {
            rbtnNam.setSelected(true);
        } else if (objNV.getGioiTinh() == 1) {
            rbtnNu.setSelected(true);
        }
        PhongBanDao phongBanDao = new PhongBanImpl();

        //L???y ?????i t?????ng ph??ng t??? m?? phong
        PhongBan objPB = phongBanDao.layChiTiet(objNV.getMaPhong());

        if (!objPB.getTenPhong().equals("---Ch???n Ph??ng---")) {
            cboPhongBan.getModel().setSelectedItem(objPB);
        }
        
        ChucVuDao chucVuDao = new ChucVuImpl();
        ChucVu objCV = chucVuDao.layChiTiet(objNV.getMaChucVu());
        
        if (!objCV.getTenChucVu().equals("---Ch???n Ch???c V???---")){
            cboChucVu.getModel().setSelectedItem(objCV);
        }

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
            java.util.logging.Logger.getLogger(frmChiTietNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmChiTietNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmChiTietNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmChiTietNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmChiTietNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyBo;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboChucVu;
    private javax.swing.JComboBox<String> cboPhongBan;
    private com.toedter.calendar.JDateChooser jDateChooserNgayCap;
    private com.toedter.calendar.JDateChooser jDateChooserNgaySinh;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jplThongTinNhanVien;
    private javax.swing.JRadioButton rbtnNam;
    private javax.swing.JRadioButton rbtnNu;
    private javax.swing.JTextField txtBangCap;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDienThoai;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGTCN;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtNoiCap;
    // End of variables declaration//GEN-END:variables
}
