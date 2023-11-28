/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package poly.edu.quanlydatban;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import poly.edu.quanlyban.Ban;
import poly.edu.quanlykhachhang.KhachHang;

/**
 *
 * @author Admin
 */
public class DatBanView extends javax.swing.JFrame {

    private List<BanDat> listBanDat = new ArrayList<>();
    private DefaultTableModel dtm = new DefaultTableModel();
    private DatBanService serviceBan = new DatBanService();
    private String path = "BanDat.dat";

    public DatBanView() {
        initComponents();
        dtm = (DefaultTableModel) tblBanDat.getModel();
        listBanDat = (List<BanDat>) serviceBan.fakeData();
        ShowData(listBanDat);
        if (dtm.getRowCount() > 0) {
            tblBanDat.setColumnSelectionInterval(0, 0);
            BanDat bd = listBanDat.get(0);
            fillTable(bd);
        }

    }

    public boolean kiemTraNgayHopLe(String ngayStr) {
        try {
            // Chuyển đổi chuỗi ngày thành LocalDate
            LocalDate ngayNhap = LocalDate.parse(ngayStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            // Lấy ngày hiện tại
            LocalDate ngayHienTai = LocalDate.now();
            // So sánh ngày nhập với ngày hiện tại
            if (ngayNhap.isAfter(ngayHienTai)) {
                return true; // Ngày hợp lệ và lớn hơn ngày hiện tại
            } else {
                JOptionPane.showMessageDialog(this, " Ngày không hợp lệ hoặc nhỏ hơn ngày hiện tại");
                return false;
            }
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Ngày sai định dạng");
            return false;
        }
    }

    private boolean datTruocTonTai(String ngay, String gio) {
//        boolean gioDatTonTai = false;
        for (BanDat bd : listBanDat) {
            if (bd.getGio().equals(gio) && bd.getNgayDat().equals(ngay)) {
                return true;

            }

        }
        return false;
    }

    public void ShowData(List<BanDat> listBanDat) {
        dtm.setRowCount(0);
        for (BanDat banDat : listBanDat) {
            dtm.addRow(new Object[]{
                banDat.getMaBanDat(),
                banDat.getSoLuongKhach(),
                banDat.getNgayDat(),
                banDat.getGio(),
                banDat.getYeuCauDB(),
                banDat.getKh().getMaKH(),
                banDat.getB().getMaBan()

            });
        }
    }

    public void fillTable(BanDat bd) {
        txtMaBanDat.setText(bd.getMaBanDat() + "");
        txtSoLuongKhach.setText(bd.getSoLuongKhach() + "");
        txtNgay.setText(bd.getNgayDat());
        cboGio.setSelectedItem(bd.getGio());
        txtYeuCau.setText(bd.getYeuCauDB());
        txtMaKh.setText(bd.getKh().getMaKH() + "");
        txtMaBan.setText(bd.getB().getMaBan() + "");

    }

    public BanDat getFrom() {
        BanDat bd = new BanDat();
        String maBanDat = txtMaBanDat.getText().trim();
        String soKhach = txtSoLuongKhach.getText().trim();
        String ngay = txtNgay.getText().trim();
        String gio = cboGio.getSelectedItem().toString();
        String yeuCauDB = txtYeuCau.getText().trim();
        String maKh = txtMaKh.getText().trim();
        String maBan = txtMaBan.getText().trim();
        int soKhachInt;

        if (ngay.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ngày không được để trống");
            txtNgay.requestFocus();
            return null;
        }

        if (maBanDat.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã bàn đặt không được để trống");
            txtMaBanDat.requestFocus();
            return null;
        }

        if (soKhach.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số khách không được để trống");
            txtSoLuongKhach.requestFocus();
            return null;
        }
        if (maKh.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã khách hàng không được để trống");
            txtMaKh.requestFocus();
            return null;
        }
        if (maBan.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã bàn không được để trống");
            txtMaBan.requestFocus();
            return null;
        }

        try {
            soKhachInt = Integer.parseInt(txtSoLuongKhach.getText());
            if (soKhachInt <= 0 || soKhachInt > 20) {
                JOptionPane.showMessageDialog(this, "Số lượng khách phải >0 và <=20");
                txtSoLuongKhach.requestFocus();
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số lượng khách phải là số");
            txtSoLuongKhach.requestFocus();
            return null;
        }
        bd.setMaBanDat(maBanDat);
        bd.setSoLuongKhach(soKhachInt);
        bd.setNgayDat(ngay);
        bd.setGio(gio);
        bd.setYeuCauDB(yeuCauDB);

        KhachHang kh = new KhachHang(txtMaKh.getText().trim());
        bd.setKh(kh);

        Ban b = new Ban(txtMaBan.getText().trim());
        bd.setB(b);

        return bd;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtYeuCau = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNgay = new javax.swing.JTextField();
        cboGio = new javax.swing.JComboBox<>();
        txtSoLuongKhach = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtMaBanDat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMaKh = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMaBan = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnGhi = new javax.swing.JButton();
        btnDoc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBanDat = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(750, 700));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("QUẢN LÝ BÀN ĐẶT ");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtYeuCau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtYeuCauActionPerformed(evt);
            }
        });

        jLabel8.setText("Số lượng khách");

        jLabel9.setText("Ngày");

        jLabel10.setText("Giờ");

        jLabel11.setText("Yêu cầu đặc biệt ");

        txtNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayActionPerformed(evt);
            }
        });

        cboGio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7:00-9:00", "10:00-12:00", "13:00-15:00", "17:00-19:00", "20:00-22:00" }));

        txtSoLuongKhach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongKhachActionPerformed(evt);
            }
        });

        jLabel12.setText("Mã bàn đặt");

        jLabel3.setText("Mã KH");

        txtMaKh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKhActionPerformed(evt);
            }
        });

        jLabel4.setText("Mã bàn");

        txtMaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaBanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtSoLuongKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(71, 71, 71)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtMaKh, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboGio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaBanDat)
                                    .addComponent(txtYeuCau, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtMaBanDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboGio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtYeuCau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
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

        btnGhi.setText("Ghi");
        btnGhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhiActionPerformed(evt);
            }
        });

        btnDoc.setText("Đọc ");
        btnDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocActionPerformed(evt);
            }
        });

        tblBanDat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã bàn đặt", "Số lượng khách", "Ngày", "Giờ ", "Yêu cầu đặc biệt", "Mã KH", "Mã bàn"
            }
        ));
        tblBanDat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBanDatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBanDat);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Thông tin đặt bàn ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnDoc)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnThem)
                            .addGap(32, 32, 32)
                            .addComponent(btnSua)
                            .addGap(32, 32, 32)
                            .addComponent(btnXoa)
                            .addGap(27, 27, 27)
                            .addComponent(btnGhi)
                            .addGap(101, 101, 101)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(133, 133, 133))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDoc, btnGhi, btnSua, btnThem, btnXoa});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnGhi)
                    .addComponent(btnDoc))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDoc, btnGhi, btnSua, btnThem, btnXoa});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtYeuCauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtYeuCauActionPerformed

    }//GEN-LAST:event_txtYeuCauActionPerformed

    private void tblBanDatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBanDatMouseClicked
        int row = tblBanDat.getSelectedRow();
        BanDat bd = listBanDat.get(row);
        fillTable(bd);
    }//GEN-LAST:event_tblBanDatMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không?", "Them", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }
        String maBanDat = txtMaBanDat.getText().trim();
        boolean checkmaBanDat = false;
        for (BanDat bd : listBanDat) {
            if (bd.getMaBanDat().equals(maBanDat)) {
                checkmaBanDat = true;
                break;
            }
        }

        String maBan = txtMaBan.getText().trim();
        boolean checkMaBan = false;
        for (BanDat bd : listBanDat) {
            if (bd.getB().getMaBan().equals(maBan)) {
                checkMaBan = true;
                break;
            }
        }

        String maKh = txtMaKh.getText().trim();
        boolean checkKhachHangDaDat = false;
        for (BanDat bd : listBanDat) {
            if (bd.getKh().getMaKH().equals(maKh)) {
                checkKhachHangDaDat = true;
                break;
            }
        }

        String ngay = txtNgay.getText().trim();
        String gioHopLe = cboGio.getSelectedItem().toString();

        if (checkmaBanDat) {
            JOptionPane.showMessageDialog(this, "Mã bàn đặt này đã tồn tại");
        } else if (!kiemTraNgayHopLe(ngay)) {

        } else if (datTruocTonTai(ngay, gioHopLe)) {
            JOptionPane.showMessageDialog(this, "Ngày giờ này đã có người đặt !");
        } else if (checkKhachHangDaDat) {
            JOptionPane.showMessageDialog(this, "Mã khách hàng này đã đặt bàn ");
        } else if (checkMaBan) {
            JOptionPane.showMessageDialog(this, "Bàn này đã có người đặt");
        } else {
            JOptionPane.showMessageDialog(this, serviceBan.addBanDat(getFrom()));
            ShowData(listBanDat);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa không?", "sua", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }

        String maBan = txtMaBan.getText().trim();
        boolean checkMaBan = false;
        for (BanDat bd : listBanDat) {
            if (bd.getB().getMaBan().equals(maBan)) {
                checkMaBan = true;
                break;
            }
        }

        String maKh = txtMaKh.getText().trim();
        boolean checkKhachHangDaDat = false;
        for (BanDat bd : listBanDat) {
            if (bd.getKh().getMaKH().equals(maKh)) {
                checkKhachHangDaDat = true;
                break;
            }
        }
        String ngay = txtNgay.getText().trim();
        kiemTraNgayHopLe(ngay);

        if (!checkKhachHangDaDat) {
            JOptionPane.showMessageDialog(this, "Mã khách hàng không tồn tại ");
        } else if (!kiemTraNgayHopLe(ngay)) {
        } else if (!checkMaBan) {
            JOptionPane.showMessageDialog(this, "Mã bàn này không tồn tại");
        } else {
            int viTri = tblBanDat.getSelectedRow();
            JOptionPane.showMessageDialog(this, serviceBan.updateNhanVien(viTri, getFrom()));
            ShowData(listBanDat);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không?", "xoa", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }
        int viTri = tblBanDat.getSelectedRow();
        JOptionPane.showMessageDialog(this, serviceBan.deleteBanDat(viTri));
        ShowData(listBanDat);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnGhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhiActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn ghi File không?", "ghi", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }
        JOptionPane.showMessageDialog(this, serviceBan.ghiFile(path));
    }//GEN-LAST:event_btnGhiActionPerformed

    private void btnDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocActionPerformed
        listBanDat.clear();
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn đọc File không?", "doc", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }
        dtm.setRowCount(0);
        JOptionPane.showMessageDialog(this, serviceBan.DocFile(path));
        ShowData(listBanDat);


    }//GEN-LAST:event_btnDocActionPerformed

    private void txtNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayActionPerformed

    private void txtSoLuongKhachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongKhachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongKhachActionPerformed

    private void txtMaKhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKhActionPerformed

    private void txtMaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaBanActionPerformed

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
            java.util.logging.Logger.getLogger(DatBanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatBanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatBanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatBanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatBanView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoc;
    private javax.swing.JButton btnGhi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboGio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBanDat;
    private javax.swing.JTextField txtMaBan;
    private javax.swing.JTextField txtMaBanDat;
    private javax.swing.JTextField txtMaKh;
    private javax.swing.JTextField txtNgay;
    private javax.swing.JTextField txtSoLuongKhach;
    private javax.swing.JTextField txtYeuCau;
    // End of variables declaration//GEN-END:variables
}
