package poly.edu.quanlynhanvien;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NhanVienPartTimeView extends javax.swing.JFrame {

    private List<NhanVienPartTime> listNhanVienP = new ArrayList<>();
    private DefaultTableModel model = new DefaultTableModel();
    private NhanVienPartTimeService servicePart = new NhanVienPartTimeService();
    private String path = "NhanVienPart.txt";

    public NhanVienPartTimeView() {
        initComponents();
        model = (DefaultTableModel) tblNhanVienPartTime.getModel();
        listNhanVienP = (List<NhanVienPartTime>) servicePart.fakeData();
        showDaTa(listNhanVienP);
        if (model.getRowCount() > 0) {
            tblNhanVienPartTime.setRowSelectionInterval(0, 0);
            NhanVienPartTime nv = listNhanVienP.get(0);
            fillToTable(nv);

        }

    }

    public void showDaTa(List<NhanVienPartTime> listNhanVienP) {
        model.setRowCount(0);
        for (NhanVienPartTime nvp : listNhanVienP) {
            model.addRow(new Object[]{
                nvp.getMaNv(),
                nvp.getTenNv(),
                nvp.getSDT(),
                nvp.getDiaChi(),
                nvp.getSoGioLV(),
                nvp.getLuongNV1gio(),
                nvp.LuongNhanVienPastTime(nvp.getSoGioLV(), nvp.getLuongNV1gio())

            });
        }
    }

    public void fillToTable(NhanVienPartTime nvp) {
        txtMaNhanVien.setText(nvp.getMaNv());
        txtTenNhanVien.setText(nvp.getTenNv());
        txtSoDienThoai.setText(nvp.getSDT());
        txtDiaChi.setText(nvp.getDiaChi());
        txtSoGioLam.setText(nvp.getSoGioLV() + "");
        txtLuong1Gio.setText(nvp.getLuongNV1gio() + "");
    }

    public void resetFrom() {
        txtMaNhanVien.setText("");
        txtTenNhanVien.setText("");
        txtSoDienThoai.setText("");
        txtDiaChi.setText("");
        txtSoGioLam.setText("");
        txtLuong1Gio.setText("");
    }

    public NhanVienPartTime getFrom() {
        String maNv = txtMaNhanVien.getText().trim();
        String tenNv = txtTenNhanVien.getText().trim();
        String soDienThoai = txtSoDienThoai.getText().trim();
        int soDienThoaiINT;
        String diaChi = txtDiaChi.getText().trim();
        String soGioLV = txtSoGioLam.getText().trim();
        double soGioLVDB;
        String luong1Gio = txtLuong1Gio.getText().trim();
        double luong1GioDB;

        if (maNv.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên không được để trống !");
            txtMaNhanVien.requestFocus();
            return null;
        }

        if (tenNv.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên nhân viên không được để trống !");
            txtTenNhanVien.requestFocus();
            return null;
        }

        if (soDienThoai.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại nhân viên không được để trống !");
            txtSoDienThoai.requestFocus();
            return null;
        }
        if (soDienThoai.length() <5 || soDienThoai.length()>15) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải trong khoảng 5 - 15 kí tự");
            txtSoDienThoai.requestFocus();
            return null;
        }

        try {
            soDienThoaiINT = Integer.parseInt(soDienThoai);
            if (soDienThoaiINT<0) {
                JOptionPane.showMessageDialog(this, "Số điện thoại phải lớn hơn không");
                txtSoDienThoai.requestFocus();
                return null;

            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải là số nguyên!");
            txtSoDienThoai.requestFocus();
            return null;
        }

        if (diaChi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống !");
            txtDiaChi.requestFocus();
            return null;
        }

        if (soGioLV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số giờ làm việc không được để trống !");
            txtSoGioLam.requestFocus();
            return null;
        }

        try {
            soGioLVDB = Double.parseDouble(soGioLV);
            if (soGioLVDB <= 0) {
                JOptionPane.showMessageDialog(this, "Số giờ làm việc phải lớn hơn 0");
                txtSoGioLam.requestFocus();
                return null;

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số giờ làm việc phải là số !");
            txtSoGioLam.requestFocus();
            return null;
        }

        if (luong1Gio.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lương 1 giờ không được để trống");
            txtLuong1Gio.requestFocus();
            return null;
        }

        try {
            luong1GioDB = Double.parseDouble(luong1Gio);
            if (luong1GioDB <= 10) {
                JOptionPane.showMessageDialog(this, "Lương 1 giờ phải lớn hơn 10");
                txtLuong1Gio.requestFocus();
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lương 1 giờ phải là số !");
            txtLuong1Gio.requestFocus();
            return null;
        }

        NhanVienPartTime nvp = new NhanVienPartTime(maNv, tenNv, soDienThoai, diaChi, soGioLVDB, luong1GioDB);
        return nvp;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtSoGioLam = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtLuong1Gio = new javax.swing.JTextField();
        txtTenNhanVien = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        txtMaNhanVien = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnGhi = new javax.swing.JButton();
        btnDoc = new javax.swing.JButton();
        btnTinhLuong = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVienPartTime = new javax.swing.JTable();
        btnTim = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhân viên past time"));

        jLabel6.setText("Số giờ làm việc");

        jLabel8.setText("Lương nhân viên 1 giờ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSoGioLam, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(txtLuong1Gio))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSoGioLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtLuong1Gio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel1.setText("Mã nhân viên ");

        jLabel2.setText("Số điện thoại ");

        jLabel3.setText("Tên nhân viên ");

        jLabel4.setText("Địa chỉ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("NHÂN VIÊN PAST TIME");

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnGhi.setText("Ghi dữ liệu");
        btnGhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhiActionPerformed(evt);
            }
        });

        btnDoc.setText("Đọc dữ liệu");
        btnDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocActionPerformed(evt);
            }
        });

        btnTinhLuong.setText("Thêm và Tính lương");
        btnTinhLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTinhLuongActionPerformed(evt);
            }
        });

        tblNhanVienPartTime.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Số điện thoại", "Địa chỉ", "Số giờ làm việc", "Lương 1 giờ", "Lương"
            }
        ));
        tblNhanVienPartTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienPartTimeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVienPartTime);

        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addComponent(btnGhi)
                                .addGap(43, 43, 43)
                                .addComponent(btnDoc)
                                .addGap(40, 40, 40)
                                .addComponent(btnTinhLuong))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(270, 270, 270)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnReset)
                                    .addComponent(btnSua)
                                    .addComponent(btnXoa)
                                    .addComponent(btnTim))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDoc, btnGhi, btnReset, btnSua, btnTim, btnTinhLuong, btnXoa});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel1)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(20, 20, 20)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3)
                                            .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btnTim)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGhi)
                    .addComponent(btnDoc)
                    .addComponent(btnTinhLuong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDoc, btnGhi, btnReset, btnSua, btnTim, btnTinhLuong, btnXoa});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn tìm kiếm hay không ?", "tim", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }
        int row = servicePart.findNhanVienP(txtMaNhanVien.getText());
        if (row != -1) {
            tblNhanVienPartTime.setRowSelectionInterval(row, row);
            NhanVienPartTime nvp = listNhanVienP.get(row);
            fillToTable(nvp);
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy mã cần tìm kiếm");
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnTinhLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTinhLuongActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm và tính lương nhân viên không ?", "them", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }
        String maNhanVien = txtMaNhanVien.getText().trim();
        boolean maTonTai = false;
        for (NhanVienPartTime nvp : listNhanVienP) {
            if (nvp.getMaNv().equals(maNhanVien)) {
                maTonTai = true;
                break;
            }

        }

        String soDT = txtSoDienThoai.getText().trim();
        boolean SDTTonTai = false;
        for (NhanVienPartTime nvp : listNhanVienP) {
            if (nvp.getSDT().equals(soDT)) {
                SDTTonTai = true;
                break;
            }

        }
        if (maTonTai) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên part time đã tồn tại !");
        } else if (SDTTonTai) {
            JOptionPane.showMessageDialog(this, "Số điện thoại này đã tồn tại , vui lòng nhập số khác");
        } else {
            JOptionPane.showMessageDialog(this, servicePart.addNhanVienP(getFrom()));
            showDaTa(listNhanVienP);
        }

    }//GEN-LAST:event_btnTinhLuongActionPerformed

    private void tblNhanVienPartTimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienPartTimeMouseClicked
        int row = tblNhanVienPartTime.getSelectedRow();
        NhanVienPartTime nvp = listNhanVienP.get(row);
        fillToTable(nvp);
    }//GEN-LAST:event_tblNhanVienPartTimeMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn Reset From không ?", "reset", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }
        resetFrom();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa không ?", "sua", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }
        int row = tblNhanVienPartTime.getSelectedRow();
        JOptionPane.showMessageDialog(this, servicePart.updateNhanVienP(row, getFrom()));
        showDaTa(listNhanVienP);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không ?", "xoa", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }
        int row = tblNhanVienPartTime.getSelectedRow();
        JOptionPane.showMessageDialog(this, servicePart.deleteNhanVienP(row));
        showDaTa(listNhanVienP);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnGhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhiActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn ghi File không ?", "ghi", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }
        JOptionPane.showMessageDialog(this, servicePart.ghiFile(path));

    }//GEN-LAST:event_btnGhiActionPerformed

    private void btnDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocActionPerformed
        listNhanVienP.clear();
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn đọc File không ?", "doc", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }
        model.setRowCount(0);
        JOptionPane.showMessageDialog(this, servicePart.docFile(path));
        showDaTa(listNhanVienP);

    }//GEN-LAST:event_btnDocActionPerformed

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
            java.util.logging.Logger.getLogger(NhanVienPartTimeView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVienPartTimeView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVienPartTimeView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVienPartTimeView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhanVienPartTimeView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoc;
    private javax.swing.JButton btnGhi;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnTinhLuong;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblNhanVienPartTime;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtLuong1Gio;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtSoGioLam;
    private javax.swing.JTextField txtTenNhanVien;
    // End of variables declaration//GEN-END:variables
}
