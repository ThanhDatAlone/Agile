package poly.edu.quanlynhanvien;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NhanVienFullTimeView extends javax.swing.JFrame {

    private List<NhanVienFullTime> listNv = new ArrayList<>();
    private DefaultTableModel dtm = new DefaultTableModel();
    private NhanVienFullTimeService serviceNv = new NhanVienFullTimeService();
    private String path = "NhanVien.txt";

    public NhanVienFullTimeView() {

        initComponents();
        dtm = (DefaultTableModel) tblNhanVien.getModel();
        listNv = (List<NhanVienFullTime>) serviceNv.fakeData();
        showData(listNv);
        if (dtm.getRowCount() > 0) {
            tblNhanVien.setRowSelectionInterval(0, 0);
            NhanVienFullTime nv = listNv.get(0);
            fillToTable(nv);
        }
    }

    public void showData(List<NhanVienFullTime> listNv) {
        dtm.setRowCount(0);
        for (NhanVienFullTime nhanVien : listNv) {
            dtm.addRow(new Object[]{
                nhanVien.getMaNv(),
                nhanVien.getTenNv(),
                nhanVien.getSDT(),
                nhanVien.getDiaChi(),
                nhanVien.getChucVu(),
                nhanVien.getNgayLamViec(),
                nhanVien.getLuong1Ngay(),
                nhanVien.getLuong()

            });
        }
    }

    public void fillToTable(NhanVienFullTime nv) {
        txtMaNhanVien.setText(nv.getMaNv() + "");
        txtTenNhanVien.setText(nv.getTenNv());
        txtSoDienThoai.setText(nv.getSDT());
        txtDiaChi.setText(nv.getDiaChi());
        if (nv.getChucVu().equals("Quản lý")) {
            rdoQuanLy.setSelected(true);
            rdoDauBep.setSelected(false);
            rdoPhucVu.setSelected(false);
        } else if (nv.getChucVu().equals("Đầu bếp")) {
            rdoQuanLy.setSelected(false);
            rdoDauBep.setSelected(true);
            rdoPhucVu.setSelected(false);
        } else {
            rdoQuanLy.setSelected(false);
            rdoDauBep.setSelected(false);
            rdoPhucVu.setSelected(true);
        }
        txtSoNgayLamViec.setText(nv.getNgayLamViec() + "");

        txtLuong1Ngay.setText(nv.getLuong1Ngay() + "");

    }

    public NhanVienFullTime getFrom() {
        String maNv = txtMaNhanVien.getText().trim();
        String tenNv = txtTenNhanVien.getText().trim();
        String soDT = txtSoDienThoai.getText().trim();
        int soDtInt;
        String diaChi = txtDiaChi.getText().trim();
        boolean quanLy = rdoQuanLy.isSelected();
        boolean daubep = rdoDauBep.isSelected();
        boolean phucVu = rdoPhucVu.isSelected();
        boolean chucVu = quanLy || daubep || phucVu;
        String chucVuString;

        if (chucVu == quanLy) {
            chucVuString = "Quản lý";
        } else if (chucVu == daubep) {
            chucVuString = "Đầu bếp";
        } else {
            chucVuString = "Phục vụ";
        }

        String soNgayLamViec = txtSoNgayLamViec.getText().trim();
        int ngayLamViecINT;
        String luong1Ngay = txtLuong1Ngay.getText().trim();
        double luong1NgayDB;

        if (maNv.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã không được để trống !");
            txtMaNhanVien.requestFocus();
            return null;
        }
        if (tenNv.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên không được để trống !");
            txtTenNhanVien.requestFocus();
            return null;
        }
        if (soDT.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống !");
            txtSoDienThoai.requestFocus();
            return null;
        }
        if (soDT.length() < 5 || soDT.length() > 15) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải trong khoảng 5 - 15 kí tự");
            txtSoDienThoai.requestFocus();
            return null;
        }

        try {
            soDtInt = Integer.parseInt(soDT);
            if (soDtInt <= 0) {
                JOptionPane.showMessageDialog(this, "số điện thoại phải lớn hơn 0 !");
                txtSoDienThoai.requestFocus();
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "số điện thoại phải là số nguyên !");
            txtSoDienThoai.requestFocus();
            return null;
        }

        if (diaChi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống !");
            txtDiaChi.requestFocus();
            return null;
        }
        if (soNgayLamViec.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ngày làm việc không được để trống !");
            txtSoNgayLamViec.requestFocus();
            return null;
        }
        try {
            ngayLamViecINT = Integer.parseInt(soNgayLamViec);
            if (ngayLamViecINT <= 0) {
                JOptionPane.showMessageDialog(this, "Ngày làm việc phải lớn hơn 0 ngày");
                txtSoNgayLamViec.requestFocus();
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ngày làm việc phải là số");
            txtSoNgayLamViec.requestFocus();
            return null;
        }

        if (luong1Ngay.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lương 1 ngày không được để trống !");
            txtLuong1Ngay.requestFocus();
            return null;

        }
        try {
            luong1NgayDB = Double.parseDouble(luong1Ngay);
            if (luong1NgayDB <= 0) {
                JOptionPane.showMessageDialog(this, "Lương 1 ngày phải lớn hơn 0!");
                txtLuong1Ngay.requestFocus();
                return null;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lương 1 ngày không được để trống !");
            txtLuong1Ngay.requestFocus();
            return null;
        }

        NhanVienFullTime nv = new NhanVienFullTime(maNv, tenNv, soDT, diaChi, chucVuString, ngayLamViecINT, luong1NgayDB, luong1NgayDB);
        return nv;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgrChucVu = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        txtMaNhanVien = new javax.swing.JTextField();
        txtTenNhanVien = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        rdoQuanLy = new javax.swing.JRadioButton();
        rdoDauBep = new javax.swing.JRadioButton();
        rdoPhucVu = new javax.swing.JRadioButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        btnGhi = new javax.swing.JButton();
        btnDoc = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtSoNgayLamViec = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtLuong1Ngay = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1010, 600));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Mã nhân viên ");

        jLabel2.setText("Số điện thoại ");

        jLabel3.setText("Tên nhân viên ");

        jLabel4.setText("Địa chỉ");

        jLabel5.setText("Chức vụ ");

        btgrChucVu.add(rdoQuanLy);
        rdoQuanLy.setText("Quản lý ");

        btgrChucVu.add(rdoDauBep);
        rdoDauBep.setText("Đầu bếp");

        btgrChucVu.add(rdoPhucVu);
        rdoPhucVu.setSelected(true);
        rdoPhucVu.setText("Phục vụ ");

        btnSua.setText("New");
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

        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        btnGhi.setText("Ghi");
        btnGhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhiActionPerformed(evt);
            }
        });

        btnDoc.setText("Đọc");
        btnDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocActionPerformed(evt);
            }
        });

        jButton1.setText(" Thêm và tính lương");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhân viên full time"));

        jLabel10.setText("Số ngày làm việc");

        jLabel11.setText("Lương 1 ngày");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtSoNgayLamViec, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(txtLuong1Ngay))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtSoNgayLamViec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtLuong1Ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoDauBep, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoPhucVu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSua)
                                    .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addComponent(btnTim, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(btnGhi, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addComponent(btnDoc, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(19, 19, 19))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDoc, btnGhi, btnSua, btnTim, btnXoa, jButton1});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSua)
                .addGap(15, 15, 15)
                .addComponent(btnXoa)
                .addGap(15, 15, 15)
                .addComponent(btnTim)
                .addGap(15, 15, 15)
                .addComponent(btnGhi)
                .addGap(15, 15, 15)
                .addComponent(btnDoc)
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(rdoQuanLy)
                                    .addComponent(rdoPhucVu)
                                    .addComponent(rdoDauBep)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDoc, btnGhi, btnSua, btnTim, btnXoa, jButton1});

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "SDT", "Địa chỉ", "Chức vụ", "Ngày làm việc", "Lương 1 ngày", "Lương"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("NHÂN VIÊN FULL TIME");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(357, 357, 357)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        int row = tblNhanVien.getSelectedRow();
        NhanVienFullTime nv = listNv.get(row);
        fillToTable(nv);


    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa không ?", "sua", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }
        int viTri = tblNhanVien.getSelectedRow();
        JOptionPane.showMessageDialog(this, serviceNv.updateNhanVien(viTri, getFrom()));
        showData(listNv);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?", "xoa", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }
        int viTri = tblNhanVien.getSelectedRow();
        JOptionPane.showMessageDialog(this, serviceNv.deleteNhanVien(viTri));
        showData(listNv);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn tìm kiếm hay không ?", "tim", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }
        int row = serviceNv.find(txtMaNhanVien.getText());
        if (row != -1) {
            tblNhanVien.setRowSelectionInterval(row, row);
            NhanVienFullTime nv = listNv.get(row);
            fillToTable(nv);
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy mã cần tìm kiếm");
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnGhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhiActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn tìm kiếm hay không ?", "ghi", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }
        JOptionPane.showMessageDialog(this, serviceNv.ghiFile(path));
    }//GEN-LAST:event_btnGhiActionPerformed

    private void btnDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocActionPerformed
        listNv.clear();
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn đọc File hay không ?", "doc", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }
        dtm.setRowCount(0);
        JOptionPane.showMessageDialog(this, serviceNv.dociFile(path));
        showData(listNv);
    }//GEN-LAST:event_btnDocActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không ?", "them", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }
        String maNv = txtMaNhanVien.getText().trim();
        boolean maTonTai = false;
        for (NhanVienFullTime nv : listNv) {
            if (String.valueOf(nv.getMaNv()).equals(maNv)) {
                maTonTai = true;
                break;
            }
        }

        String soDT = txtSoDienThoai.getText().trim();
        boolean SDTTonTai = false;
        for (NhanVienFullTime nvf : listNv) {
            if (nvf.getSDT().equals(soDT)) {
                SDTTonTai = true;
                break;
            }
        }
        if (maTonTai) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên này đã tồn tại");
        } else if (SDTTonTai) {
            JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại vui lòng nhập số khác");
        } else {
            JOptionPane.showMessageDialog(this, serviceNv.addNhanVien(getFrom()));
            showData(listNv);

        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(NhanVienFullTimeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVienFullTimeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVienFullTimeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVienFullTimeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhanVienFullTimeView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgrChucVu;
    private javax.swing.JButton btnDoc;
    private javax.swing.JButton btnGhi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JRadioButton rdoDauBep;
    private javax.swing.JRadioButton rdoPhucVu;
    private javax.swing.JRadioButton rdoQuanLy;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtLuong1Ngay;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtSoNgayLamViec;
    private javax.swing.JTextField txtTenNhanVien;
    // End of variables declaration//GEN-END:variables
}
