/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectquanlynhanvien.vuviec;


import com.mycompany.projectquanlynhanvien.NhanVien.NhanVien;
import com.mycompany.projectquanlynhanvien.NhanVien.NhanVienDao;
import com.mycompany.projectquanlynhanvien.NhanVien.NhanVienImpl;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class JplDanhSachVuViec extends javax.swing.JPanel {

    /**
     * Creates new form JplDanhSachVuViec
     */

    int maNV=0; 
    String trangThai = "";
    

    public JplDanhSachVuViec(int maNV, String trangThai) {
        initComponents();
        
        hienThiDanhSach(maNV, trangThai);
        this.maNV= maNV;
        this.trangThai= trangThai;

    }

    public void hienThiDanhSach(int maNV, String trangThai) {
        // đêm số nhân viên để thực hiện phân trang;
        String strSapXep = "", strTinhTrang = "";
        strSapXep = "" + cboSapXep.getSelectedItem();
        strTinhTrang = "" + cboTinhTrang.getSelectedItem();
        VuViecDao vuViecDao = new VuViecImpl();
        //Khai báo các cột tiêu đề
        String tieuDe[] = new String[]{"Mã Vụ Việc", "Tên Vụ Việc", "Người Giao", "Tình Trạng", "Deadline", "Mức độ"};
        
        //Khai báo 1 đối tượng để phục vụ hiển thị lên table
        DefaultTableModel model = new DefaultTableModel(tieuDe, 0);

        //Lấy danh sách sinh viên trong hệ thống
        List<VuViec> lstVuViec = null;

        switch (strSapXep) {
            case "Ngày Giao Việc":
                strSapXep = "NgayBatDau";
                break;
            case "Deadline":
                strSapXep = "Deadline";
                break;
            case "Mức độ quan trọng":
                strSapXep = "MucDoId";
                break;
        }
        switch (strTinhTrang){
            case "--Chọn Tình Trạng--":
                strTinhTrang = "";
                break;
            case "Đã hoàn thành":
                strTinhTrang = "2";
                break;
            case "Chưa hoàn thành":
                strTinhTrang = "1";
                break;
        }
     
        if (trangThai.equals("Được Giao")){
            lstVuViec = vuViecDao.layDanhSach(maNV,strSapXep, strTinhTrang);
        }
        if (trangThai.equals("Giao")){
            lstVuViec = vuViecDao.layDanhSachGiao(strSapXep, strTinhTrang, maNV);
        }
        

        //Khai báo đối tượng để chứa dòng dữ liệu đưa vào model
        Object row[];
        //Duyệt từng dòng để đưa vào model
        for (VuViec vv : lstVuViec) {
            row = new Object[6];
            //Lấy giá trị từ đối tượng

            row[0] = vv.getMaVuViec();
            row[1] = vv.getTenVuViec();
            row[2] = hienThiTenNguoiGiao(vv.getMaNguoiGiao());
            if(vv.getTinhTrang()==1){
                row[3]= "Chưa hoàn thành";
            }else{
                row[3]= "Đã hoàn thành";
            }
            row[4] = vv.getDateLine();
            if(vv.getMucDoId()==1){
                row[5] = "Ít quan trọng";
            } else {
                if(vv.getMucDoId()==2){
                    row[5] = "Quan trọng";
                }else{
                    row[5] = "Rất quan trọng";
                }
            }
            //Thêm vào model
            model.addRow(row);
        }
        //Thêm model vào table
        tblDanhSach.setModel(model);
    }
    private String hienThiTenNguoiGiao(int maNV){
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboTinhTrang = new javax.swing.JComboBox<>();
        btnTimKiem = new javax.swing.JButton();
        cboSapXep = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSach = new javax.swing.JTable();
        btnXem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1280, 577));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhập thông tin tìm kiếm"));

        jLabel1.setText("Sắp xếp: ");

        jLabel2.setText("Tình trạng");

        cboTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Chọn Tình Trạng--", "Đã hoàn thành", "Chưa hoàn thành" }));

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ZoomHS.png"))); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        cboSapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày Giao Việc", "Deadline", "Mức độ quan trọng" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(cboSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(btnTimKiem)
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboSapXep)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        btnXem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ZoomHS.png"))); // NOI18N
        btnXem.setText("Xem");
        btnXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/settings_16.png"))); // NOI18N
        btnSua.setText("Sửa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSua)
                .addGap(64, 64, 64)
                .addComponent(btnXem)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXem)
                    .addComponent(btnSua))
                .addGap(36, 36, 36))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        hienThiDanhSach(maNV, trangThai);
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemActionPerformed
        // TODO add your handling code here:
        int maVV = 0;

        int dongChon = 0;

        //Lấy thông tin mã sinh viên chọn trên jTable
        dongChon = tblDanhSach.getSelectedRow();

        maVV = Integer.parseInt("" + tblDanhSach.getValueAt(dongChon, 0));
        
        ChiTietVuViec chiTietVuViec = new ChiTietVuViec();
        
        chiTietVuViec.setMaVuViec(maVV);
        chiTietVuViec.setTrangThai(trangThai);
        chiTietVuViec.setVisible(true);
        
    }//GEN-LAST:event_btnXemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXem;
    private javax.swing.JComboBox<String> cboSapXep;
    private javax.swing.JComboBox<String> cboTinhTrang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable tblDanhSach;
    // End of variables declaration//GEN-END:variables

}
