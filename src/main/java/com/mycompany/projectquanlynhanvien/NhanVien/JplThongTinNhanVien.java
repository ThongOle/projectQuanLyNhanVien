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
import com.mycompany.projectquanlynhanvien.chucvu.ChucVuRender;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author admin
 */
public class JplThongTinNhanVien extends javax.swing.JPanel {

    /**
     * Creates new form JplThongTinNhanVien
     */
    public JplThongTinNhanVien(int maNV) {
        initComponents();
        hienThiDanhSachKhoa();
        hienThiDanhSachChucVu();
        hienThiChiTietNhanVien(maNV);  
        
    }
    
    NhanVienDao nhanVienDao = new NhanVienImpl();
    private void hienThiDanhSachKhoa()
    {
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
        for(PhongBan objPhong : lstPhong)
        {
            model.addElement(objPhong);
        }
        
        //Hiển thị lên combobox
        cboPhongBan.setModel(model);
        
        //Chỉnh sửa lại hiển thị
        cboPhongBan.setRenderer(new PhongBanRender());
    }
    private void hienThiDanhSachChucVu() {
        //Khai báo 1 đối tượng để lấy danh sách 
        ChucVuDao chucVuDao = new ChucVuImpl();

        //Lấy danh sách 
        List<ChucVu> lstChucVu = chucVuDao.layDanhSach();

        ChucVu root = new ChucVu();
        root.setMaChucVu(0);
        root.setTenChucVu("---Chọn Chức Vụ---");
        lstChucVu.add(0, root);

        DefaultComboBoxModel model = new DefaultComboBoxModel();

        //Duyệt từng thông tin khoa để đưa vào model
        for (ChucVu objCV : lstChucVu) {
            model.addElement(objCV);
        }

        //Hiển thị lên combobox
        cboChucVu.setModel(model);

        //Chỉnh sửa lại hiển thị
        cboChucVu.setRenderer(new ChucVuRender());
    }
    private void hienThiChiTietNhanVien(int maNV){
        
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
        if(objNV.getGioiTinh()==0){
            rbtnNam.setSelected(true);
        }else if(objNV.getGioiTinh()==1){
            rbtnNu.setSelected(true);
        }
        PhongBanDao phongBanDao = new PhongBanImpl();

        //Lấy đối tượng phòng từ mã phong
        PhongBan objPB = phongBanDao.layChiTiet(objNV.getMaPhong());

        if (!objPB.getTenPhong().equals("---Chọn Phòng---")) {
            cboPhongBan.getModel().setSelectedItem(objPB);
        }
        
        ChucVuDao chucVuDao = new ChucVuImpl();
        ChucVu objCV = chucVuDao.layChiTiet(objNV.getMaChucVu());
        
        if (!objCV.getTenChucVu().equals("---Chọn Chức Vụ---")){
            cboChucVu.getModel().setSelectedItem(objCV);
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        txtGTCN = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(1280, 577));

        jplThongTinNhanVien.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin nhân viên"));
        jplThongTinNhanVien.setPreferredSize(new java.awt.Dimension(1280, 577));

        jLabel2.setText("Họ Tên:");

        jLabel3.setText("Giới Tính:");

        jLabel4.setText("Ngày Sinh:");

        jDateChooserNgaySinh.setDateFormatString("dd/MM/yyyy");

        jLabel5.setText("Điện Thoại:");

        jLabel6.setText("Email:");

        jLabel7.setText("Địa chỉ:");

        jLabel8.setText("Bằng cấp:");

        jLabel9.setText("Loại giấy tờ chứng thức cá nhân");

        rbtnNam.setText("Nam");

        rbtnNu.setText("Nữ");

        jLabel10.setText("Ngày cấp:");

        jDateChooserNgayCap.setDateFormatString("dd/MM/yyyy");

        jLabel11.setText("Nơi cấp");

        jLabel12.setText("Phòng/Ban:");

        cboPhongBan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setText("Chức vụ:");

        cboChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jplThongTinNhanVienLayout = new javax.swing.GroupLayout(jplThongTinNhanVien);
        jplThongTinNhanVien.setLayout(jplThongTinNhanVienLayout);
        jplThongTinNhanVienLayout.setHorizontalGroup(
            jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplThongTinNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jplThongTinNhanVienLayout.createSequentialGroup()
                        .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(138, 138, 138)
                        .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboChucVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboPhongBan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jplThongTinNhanVienLayout.createSequentialGroup()
                        .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jplThongTinNhanVienLayout.createSequentialGroup()
                                .addComponent(jDateChooserNgayCap, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(139, 139, 139)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNoiCap, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtGTCN)))
                    .addGroup(jplThongTinNhanVienLayout.createSequentialGroup()
                        .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(145, 145, 145)
                        .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBangCap)
                            .addComponent(txtDiaChi)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplThongTinNhanVienLayout.createSequentialGroup()
                        .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jplThongTinNhanVienLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jplThongTinNhanVienLayout.createSequentialGroup()
                                        .addComponent(rbtnNam)
                                        .addGap(62, 62, 62)
                                        .addComponent(rbtnNu))
                                    .addComponent(jDateChooserNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
                                    .addComponent(txtHoTen)
                                    .addComponent(txtDienThoai)))
                            .addGroup(jplThongTinNhanVienLayout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(txtEmail)))))
                .addGap(70, 70, 70))
        );
        jplThongTinNhanVienLayout.setVerticalGroup(
            jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplThongTinNhanVienLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                .addGap(18, 18, 18)
                .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
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
                .addGroup(jplThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cboChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jplThongTinNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 1290, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jplThongTinNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
