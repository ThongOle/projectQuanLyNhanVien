/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectquanlynhanvien.NhanVien;

import com.mycompany.projectquanlynhanvien.PhongBan.PhongBan;
import com.mycompany.projectquanlynhanvien.PhongBan.PhongBanDao;
import com.mycompany.projectquanlynhanvien.PhongBan.PhongBanImpl;
import com.mycompany.projectquanlynhanvien.PhongBan.PhongBanRender;
import com.mycompany.projectquanlynhanvien.chucvu.ChucVu;
import com.mycompany.projectquanlynhanvien.chucvu.ChucVuDao;
import com.mycompany.projectquanlynhanvien.chucvu.ChucVuImpl;
import com.mycompany.projectquanlynhanvien.vuviec.VuViecDao;
import com.mycompany.projectquanlynhanvien.vuviec.VuViecImpl;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class JplDanhSachNhanVien extends javax.swing.JPanel {

    /**
     * Creates new form JplDanhSachNhanVien
     */
    static NhanVienDao nhanVienDao = new NhanVienImpl();
   

    public int soTrang() {
        int dem = 0, soTrang = 0;
       
        String tuKhoa = txtTuKhoa.getText().trim();
        String maPhong = "";
        PhongBan objPB = (PhongBan) cboPhongBan.getSelectedItem();

        if(!objPB.getTenPhong().equals("---Chọn Phòng---")){
              maPhong = objPB.getMaPhong();
        }
        dem = nhanVienDao.Count(tuKhoa, maPhong);
        if (dem % 15 == 0) {
            soTrang = dem / 15;
        } else {
            soTrang = dem / 15 + 1;
        }
        return soTrang;
    }

    public JplDanhSachNhanVien() {
        initComponents();

        hienThiDanhSachPhong();
        lblSoTrang2.setText("1/" + soTrang());
        hienThiDanhSach(1);

    }

    private void hienThiDanhSachPhong() {
        PhongBanDao phongBanDao = new PhongBanImpl();

        //lấy danh sách phòng
        List<PhongBan> lstPB = phongBanDao.layDanhSach();

        PhongBan root = new PhongBan();
        root.setMaPhong("");
        root.setTenPhong("---Chọn Phòng---");
        lstPB.add(0, root);

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        //Duyệt từng thông tin để đưa vào model 
        for (PhongBan objPB : lstPB) {
            model.addElement(objPB);
        }
        cboPhongBan.setModel(model);

        //chỉnh sửa lại trước khi lên model
        cboPhongBan.setRenderer(new PhongBanRender());
    }

    
    public static void hienThiDanhSach(int soTrang) {
    // đêm số nhân viên để thực hiện phân trang;
        String tuKhoa = txtTuKhoa.getText().trim();
        String maPhong = "";
        PhongBan objPB = (PhongBan) cboPhongBan.getSelectedItem();

        if(!objPB.getTenPhong().equals("---Chọn Phòng---")){
              maPhong = objPB.getMaPhong();
        }

        //Khai báo các cột tiêu đề
        String tieuDe[] = new String[]{"Mã Nhân Viên", "Họ tên", "Điện thoại", "Email", "Địa chỉ", "Ngày Sinh", "Phòng Ban", "Chức Vụ"};
        //Khai báo 1 đối tượng để phục vụ hiển thị lên table
        DefaultTableModel model = new DefaultTableModel(tieuDe, 0);

        //Lấy danh sách sinh viên trong hệ thống
        List<NhanVien> lstNhanVien;

        if (tuKhoa.isEmpty() && maPhong.isEmpty()) {
            lstNhanVien = nhanVienDao.layDanhSach(soTrang,15);
        } else {
            lstNhanVien = nhanVienDao.timKiemNhanVien(tuKhoa, maPhong, soTrang,15);
        }

        //Khai báo đối tượng để chứa dòng dữ liệu đưa vào model
        Object row[];
        //Duyệt từng dòng để đưa vào model
        for (NhanVien nv : lstNhanVien) {
            row = new Object[8];
            //Lấy giá trị từ đối tượng
            row[0] = nv.getMaNV();
            row[1] = nv.getHoTen();
            row[2] = nv.getDienThoai();
            row[3] = nv.getEmail();
            row[4] = nv.getDiaChi();
            row[5] = nv.getNgaySinh();
            row[6] = hienThiTenPhong(nv.getMaPhong());
            row[7] = hienThiChucVu(nv.getMaChucVu());
            //Thêm vào model
            model.addRow(row);
        }
        //Thêm model vào table
        tblDanhSach.setModel(model);
    }

    public static String hienThiTenPhong(String maPhong) {
        String tenPhong = "";
        PhongBanDao phongBanDao = new PhongBanImpl();
        PhongBan objPB = phongBanDao.layChiTiet(maPhong);

        tenPhong = objPB.getTenPhong();
        return tenPhong;
    }

    public static String hienThiChucVu(int maChucVu) {
        String tenChucVu = "";
        ChucVuDao chucVuDao = new ChucVuImpl();
        ChucVu objCV = chucVuDao.layChiTiet(maChucVu);

        tenChucVu = objCV.getTenChucVu();
        return tenChucVu;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTuKhoa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboPhongBan = new javax.swing.JComboBox<>();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSach = new javax.swing.JTable();
        btnThemMoi = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTrangDau = new javax.swing.JButton();
        btnLui = new javax.swing.JButton();
        lblsoTrang = new javax.swing.JLabel();
        btnTien = new javax.swing.JButton();
        lblSoTrang2 = new javax.swing.JLabel();
        btnTrangCuoi = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1280, 577));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhập thông tin tìm kiếm"));

        jLabel1.setText("Từ khóa:");

        txtTuKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTuKhoaActionPerformed(evt);
            }
        });

        jLabel2.setText("Mã Phòng:");

        cboPhongBan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ZoomHS.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTuKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(btnTimKiem)
                .addGap(73, 73, 73))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTuKhoa)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        tblDanhSach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblDanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblDanhSach);

        btnThemMoi.setText("Thêm mới");
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnTrangDau.setText("<<");
        btnTrangDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrangDauActionPerformed(evt);
            }
        });

        btnLui.setText("<");
        btnLui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuiActionPerformed(evt);
            }
        });

        lblsoTrang.setText("1");

        btnTien.setText(">");
        btnTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTienActionPerformed(evt);
            }
        });

        lblSoTrang2.setText("1/5");

        btnTrangCuoi.setText(">>");
        btnTrangCuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrangCuoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThemMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnTrangDau))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnLui)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblsoTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTrangCuoi)
                        .addGap(15, 15, 15)
                        .addComponent(lblSoTrang2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTrangDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLui, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblsoTrang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTrangCuoi)
                    .addComponent(lblSoTrang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnThemMoi))
                .addGap(53, 53, 53))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        hienThiDanhSach(1);
        lblsoTrang.setText("1");
        lblSoTrang2.setText("1/"+ soTrang());

    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        // TODO add your handling code here:
        frmChiTietNhanVien frmNhanVien = new frmChiTietNhanVien();
        frmNhanVien.setTrangThai("Thêm mới");
        frmNhanVien.setVisible(true);
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        //Khai báo biến
        int maNV = 0;

        int dongChon = 0;

        //Lấy thông tin mã sinh viên chọn trên jTable
        dongChon = tblDanhSach.getSelectedRow();

        maNV = Integer.parseInt("" + tblDanhSach.getValueAt(dongChon, 0));

        //Khai báo 1 đối tượng
        frmChiTietNhanVien frmSua = new frmChiTietNhanVien();
        //Gửi giá trị mã sinh viên lên form sửa

        frmSua.setMaNV(maNV);
        frmSua.setTrangThai("Sửa");
        //Hiển thị form
        frmSua.setVisible(true);
    }//GEN-LAST:event_btnSuaActionPerformed
    
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int maNV = 0;

        int dongChon = 0;

        //Lấy thông tin mã sinh viên chọn trên jTable
        dongChon = tblDanhSach.getSelectedRow();

        maNV = Integer.parseInt(""+ tblDanhSach.getValueAt(dongChon, 0));
        
        //Xóa MaNV trong bảng NhanVien_vuViec do 
        VuViecDao vuViecDao = new VuViecImpl();
        vuViecDao.xoaNV_VV(maNV);
        
        NhanVienDao nhanVienDao = new NhanVienImpl();
        nhanVienDao.xoa(maNV);
        hienThiDanhSach(1);

    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtTuKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTuKhoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTuKhoaActionPerformed

    private void btnTrangDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangDauActionPerformed
        // TODO add your handling code here:
        // đêm số nhân viên để thực hiện phân trang;
        hienThiDanhSach(1);
        lblsoTrang.setText("1");
        lblSoTrang2.setText("1/" + soTrang());

    }//GEN-LAST:event_btnTrangDauActionPerformed

    private void btnTrangCuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangCuoiActionPerformed
        // TODO add your handling code here:
        int soTrang = soTrang();
        hienThiDanhSach(soTrang);
        lblsoTrang.setText(soTrang + "");
        lblSoTrang2.setText(soTrang + "/" + soTrang);
    }//GEN-LAST:event_btnTrangCuoiActionPerformed

    private void btnTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTienActionPerformed
        // TODO add your handling code here:
        int trang = 0;
        trang = Integer.parseInt(lblsoTrang.getText());
        if (trang < soTrang()) {
            trang += 1;
            hienThiDanhSach(trang);
            lblsoTrang.setText(trang + "");
            lblSoTrang2.setText(trang + "/" + soTrang());
        }

    }//GEN-LAST:event_btnTienActionPerformed

    private void btnLuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuiActionPerformed
        // TODO add your handling code here:
        int trang = 0;
        trang = Integer.parseInt(lblsoTrang.getText());
        if (trang > 1) {
            trang -= 1;
            hienThiDanhSach(trang);
            lblsoTrang.setText(trang + "");
            lblSoTrang2.setText(trang + "/" + soTrang());
        }
    }//GEN-LAST:event_btnLuiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLui;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThemMoi;
    private javax.swing.JButton btnTien;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTrangCuoi;
    private javax.swing.JButton btnTrangDau;
    private javax.swing.JButton btnXoa;
    private static javax.swing.JComboBox<String> cboPhongBan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSoTrang2;
    private javax.swing.JLabel lblsoTrang;
    private static javax.swing.JTable tblDanhSach;
    private static javax.swing.JTextField txtTuKhoa;
    // End of variables declaration//GEN-END:variables

}
