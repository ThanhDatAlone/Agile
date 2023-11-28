/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package poly.edu.quanlyhoadon;

import java.time.LocalDate;
import java.time.chrono.HijrahEra;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import poly.edu.quanlydatban.BanDat;
import poly.edu.quanlydatban.DatBanService;
import poly.edu.quanlykhachhang.KhachHang;
import poly.edu.quanlykhachhang.KhachHangService;
import poly.edu.quanlynhanvien.NhanVienFullTime;
import poly.edu.quanlynhanvien.NhanVienFullTimeService;

/**
 *
 * @author Admin
 */
public class HoaDonView extends javax.swing.JFrame {

    private List<HoaDon> listHD = new ArrayList<>();
    private DefaultTableModel dtm = new DefaultTableModel();
    private HoaDonService serviceHD = new HoaDonService();
    private DatBanService datt = new DatBanService();
    private NhanVienFullTimeService nvv = new NhanVienFullTimeService();
    private KhachHangService KH = new KhachHangService();
    private String path = "HoaDon.txt";

    public HoaDonView() {
        initComponents();

        listHD = (List<HoaDon>) serviceHD.fakeData();
        dtm = (DefaultTableModel) tblHoaDon.getModel();
        showData(listHD);
        if (dtm.getRowCount() > 0) {
            tblHoaDon.setRowSelectionInterval(0, 0);
            HoaDon hd = listHD.get(0);
            fillTable(hd);
        }
    }

    public void showData(List<HoaDon> listHD) {
        dtm.setRowCount(0);
        for (HoaDon hd : listHD) {
            dtm.addRow(new Object[]{
                hd.getMaHD(),
                hd.getNgay(),
                hd.getTongTien(),
                hd.getPhuongThucTT(),
                hd.getKhachHang().getMaKH(),
                hd.getBanDat().getMaBanDat(),
                hd.getNhanVienF().getMaNv(),
                hd.getTrangThai()
            });
        }
    }

    public void fillTable(HoaDon hd) {
        txtMaHoaDon.setText(hd.getMaHD() + "");
        txtNgayDat.setText(hd.getBanDat().getNgayDat());
        txtTongTien.setText(hd.getTongTien() + "");
        cboPhuongThucTT.setSelectedItem(hd.getPhuongThucTT());
        txtMaKhacHang.setText(hd.getKhachHang().getMaKH() + "");
        txtMaDatBan.setText(hd.getBanDat().getMaBanDat() + "");
        txtMaNhanVien.setText(hd.getNhanVienF().getMaNv() + "");
    }

    public HoaDon getFrom() {
        HoaDon hd = new HoaDon();
        String maHD = txtMaHoaDon.getText().trim();
        String ngaydat = txtNgayDat.getText().trim();
        String tongTien = txtTongTien.getText().trim();
        double tongTienDB;
        String phuongThucTT = cboPhuongThucTT.getSelectedItem().toString();
        String maKH = txtMaKhacHang.getText().trim();

        String maDatBan = txtMaDatBan.getText().trim();

        String maNV = txtMaNhanVien.getText().trim();

        if (maHD.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã hóa đơn không được để trống !");
            txtMaHoaDon.requestFocus();
            return null;
        }
//
      

    if (ngaydat.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ngày đặt không được để trống !");
        txtNgayDat.requestFocus();
        return null;
    }


    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    try {
      
        LocalDate date = LocalDate.parse(ngaydat, dateFormatter);
      
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Ngày đặt không hợp lệ. Vui lòng nhập đúng định dạng ngày (dd/MM/yyyy).");
        txtNgayDat.requestFocus();
        return null;
    }

//
        if (tongTien.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tổng tiền không được để trống !");
            txtTongTien.requestFocus();
            return null;
        }

        if (maKH.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã khách hàng không được để trống !");
            txtMaKhacHang.requestFocus();
            return null;
        }

        if (maDatBan.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã đặt bàn không được để trống !");
            txtMaDatBan.requestFocus();
            return null;
        }

        if (maNV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên không được để trống !");
            txtMaNhanVien.requestFocus();
            return null;
        }

        try {
            tongTienDB = Double.parseDouble(tongTien);
            if (tongTienDB <= 0) {
                JOptionPane.showMessageDialog(this, "Tổng tiền phải lớn hơn 0");
                txtTongTien.requestFocus();
                return null;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Tổng tiền phải là số");
            txtTongTien.requestFocus();
            return null;
        }

        BanDat bd1 = new BanDat(maDatBan);
        hd.setBanDat(bd1);

        KhachHang kh = new KhachHang(maKH);
        hd.setKhachHang(kh);
        NhanVienFullTime nv = new NhanVienFullTime(maNV);
        hd.setNhanVienF(nv);
        hd.setMaHD(maHD);
        hd.setNgay(ngaydat);

        hd.setTongTien(tongTienDB);/*
      
    }
        
         */
        hd.setPhuongThucTT(phuongThucTT);

        return hd;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        txtNgayDat = new javax.swing.JTextField();
        txtMaDatBan = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        txtMaKhacHang = new javax.swing.JTextField();
        txtMaNhanVien = new javax.swing.JTextField();
        cboPhuongThucTT = new javax.swing.JComboBox<>();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnDoc = new javax.swing.JButton();
        btnGhi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnThanhToan = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 392, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(750, 800));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("QUẢN LÝ THANH TOÁN");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Mã hóa đơn");

        jLabel3.setText("Ngày đặt");

        jLabel4.setText("Tổng tiền");

        jLabel5.setText("Phương thức TT");

        jLabel6.setText("Mã KH");

        jLabel7.setText("Mã đặt bàn");

        jLabel8.setText("Mã nhân viên");

        cboPhuongThucTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ATM", "Ví điện tử", "Tiền mặt" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaDatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKhacHang, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayDat, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboPhuongThucTT, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNgayDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboPhuongThucTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaKhacHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtMaDatBan, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

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

        btnDoc.setText("Đọc");
        btnDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocActionPerformed(evt);
            }
        });

        btnGhi.setText("Ghi");
        btnGhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhiActionPerformed(evt);
            }
        });

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Ngày đặt", "Tổng tiền", "Phương thức TT", "Mã KH", "Mã bàn đặt", "Mã nhân viên", "Trạg thái"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ma-qr-thuthuatmaytinh-vn.png"))); // NOI18N

        jLabel10.setText("QR COD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnXoa)
                            .addComponent(btnDoc)
                            .addComponent(btnGhi)
                            .addComponent(btnThanhToan)
                            .addComponent(btnSua)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(324, 324, 324)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDoc, btnGhi, btnSua, btnThanhToan, btnXoa});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThanhToan)
                        .addGap(44, 44, 44)
                        .addComponent(btnSua)
                        .addGap(40, 40, 40)
                        .addComponent(btnXoa)
                        .addGap(43, 43, 43)
                        .addComponent(btnDoc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGhi))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDoc, btnGhi, btnSua, btnThanhToan, btnXoa});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int row = tblHoaDon.getSelectedRow();
        HoaDon hd = listHD.get(row);
        fillTable(hd);
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa không ?", "sua", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }
        int viTri = tblHoaDon.getSelectedRow();
        JOptionPane.showMessageDialog(this, serviceHD.updateHoaDon(viTri, getFrom()));
        showData(listHD);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?", "xoa", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }
        int viTri = tblHoaDon.getSelectedRow();
        JOptionPane.showMessageDialog(this, serviceHD.deleteHoaDon(viTri));
        showData(listHD);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnGhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhiActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn ghi File hay không ?", "ghi", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }
        JOptionPane.showMessageDialog(this, serviceHD.ghiFile(path));
    }//GEN-LAST:event_btnGhiActionPerformed

    private void btnDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocActionPerformed
        listHD.clear();
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn đọc File hay không ?", "doc", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }
        dtm.setRowCount(0);
        JOptionPane.showMessageDialog(this, serviceHD.DocFile(path));
        showData(listHD);
    }//GEN-LAST:event_btnDocActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm hay không ?", "thêm", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }
        String maHoaDon = txtMaHoaDon.getText().trim();
        boolean maHoaDonTonTai = false;
        for (HoaDon hoaDon : listHD) {
            if (hoaDon.getMaHD().equals(maHoaDon)) {
                maHoaDonTonTai = true;
                break;

            }
        }

        String ngayDat = txtNgayDat.getText().trim();
        boolean ngayDatTonTai = false;
        for (HoaDon hoaDon : listHD) {
            if (hoaDon.getBanDat().getNgayDat().equals(ngayDat)) {
                ngayDatTonTai = true;
                break;

            }
        }

        String maKH = txtMaKhacHang.getText().trim();
        boolean maKHTonTai = false;
        for (HoaDon hoaDon : listHD) {
            if (hoaDon.getKhachHang().getMaKH().equals(maKH)) {
                maKHTonTai = true;
                break;

            }
        }

        String maDatBan = txtMaDatBan.getText().trim();
        boolean maDatBanTonTai = false;
        for (HoaDon hoaDon : listHD) {
            if (hoaDon.getBanDat().getMaBanDat().equals(maDatBan)) {
                maDatBanTonTai = true;
                break;

            }
        }

        String maNhanVien = txtMaNhanVien.getText().trim();
        boolean maNhanVienTonTai = false;
        for (HoaDon hoaDon : listHD) {
            if (hoaDon.getNhanVienF().getMaNv().equals(maNhanVien)) {
                maNhanVienTonTai = true;
                break;

            }
        }

        if (maHoaDonTonTai) {
            JOptionPane.showMessageDialog(this, "Mã hóa đơn này đã tồn tại");
        } else if (!ngayDatTonTai) {
            JOptionPane.showMessageDialog(this, "Ngày đặt này không tồn tại");
        } else if (!maKHTonTai) {
            JOptionPane.showMessageDialog(this, "Mã khách hàng không tồn tại");
        } else if (!maDatBanTonTai) {
            JOptionPane.showMessageDialog(this, "Mã bàn đặt này không tồn tại");
        } else if (!maNhanVienTonTai) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên không tồn tại ");
        } else {
            JOptionPane.showMessageDialog(this, serviceHD.addHoaDon(getFrom()));
            showData(listHD);
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

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
            java.util.logging.Logger.getLogger(HoaDonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDonView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoc;
    private javax.swing.JButton btnGhi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboPhuongThucTT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtMaDatBan;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtMaKhacHang;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtNgayDat;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
