package poly.edu.quanlyhoadonchitiet;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import poly.edu.quanlyhoadon.HoaDon;
import poly.edu.quanlysanhsachmonan.MonAn;

public class HoaDonChiTietView extends javax.swing.JFrame {

    private List<HoaDonChiTiet> listHDCT = new ArrayList<>();
    private HoaDonChiTietService serviceHDCT = new HoaDonChiTietService();
    private DefaultTableModel dtm = new DefaultTableModel();
    private String path = "HoaDonCT.txt";

    public HoaDonChiTietView() {
        initComponents();
        listHDCT = (List<HoaDonChiTiet>) serviceHDCT.fakeData();
        dtm = (DefaultTableModel) tblHoaDonChiTiet.getModel();
        showData(listHDCT);
//        btnThem.setEnabled(false);
        if (dtm.getRowCount() > 0) {
            tblHoaDonChiTiet.setRowSelectionInterval(0, 0);
            HoaDonChiTiet hdct = listHDCT.get(0);
            fillTable(hdct);
        }

    }

    public void showData(List<HoaDonChiTiet> listHDCT) {
        dtm.setRowCount(0);
        for (HoaDonChiTiet hdct : listHDCT) {
            dtm.addRow(new Object[]{
                tblHoaDonChiTiet.getRowCount() + 1,
                hdct.getSoLuong(),
                hdct.getMonAn().getGia(),
                hdct.getThanhTien(hdct.getSoLuong(), hdct.getMonAn().getGia()),
                hdct.getMonAn().getTen(),
                hdct.getHoaDon().getMaHD()
            }
            );
        }
    }

    public void fillTable(HoaDonChiTiet hdct) {
        txtSoLuong.setText(hdct.getSoLuong() + "");
        txtDonGia.setText(hdct.getMonAn().getGia() + "");
        txtTenMonAn.setText(hdct.getMonAn().getTen() + "");
        txtMaHoaDon.setText(hdct.getHoaDon().getMaHD() + "");
    }

    public void Reset() {
        txtSoLuong.setText("");
        txtDonGia.setText("");
        txtTenMonAn.setText("");
        txtMaHoaDon.setText("");
    }

    public HoaDonChiTiet getFrom() {
        HoaDonChiTiet hdct = new HoaDonChiTiet();

        String soLuong = txtSoLuong.getText().trim();
        int soLuongINT;
        // Liên kết với món ăn
        String tenMonAn = txtTenMonAn.getText().trim();
        String donGia = txtDonGia.getText().trim();
        double donGiaLK = Double.parseDouble(donGia);
        MonAn ma = new MonAn(tenMonAn, donGiaLK);
        hdct.setMonAn(ma);
        //Liên kết với Hóa đơn
        String maHoaDon = txtMaHoaDon.getText().trim();
       
   

        if (soLuong.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số lượng không được để trống !");
            txtSoLuong.requestFocus();
            return null;
        }

        if (donGia.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Đơn giá không được để trống !");
            txtDonGia.requestFocus();
            return null;
        }

        if (tenMonAn.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên món ăn không được để trống !");
            txtTenMonAn.requestFocus();
            return null;
        }

        if (maHoaDon.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã hóa đơn không được để trống !");
            txtMaHoaDon.requestFocus();
            return null;
        }

        try {
            soLuongINT = Integer.parseInt(txtSoLuong.getText());
            if (soLuongINT <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0 !");
                txtSoLuong.requestFocus();
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là số nguyên !");
            txtSoLuong.requestFocus();
            return null;
        }

        try {
            donGiaLK = Double.parseDouble(donGia);
            if (donGiaLK <= 0) {
                JOptionPane.showMessageDialog(this, "Đơn giá phải lớn hơn 0 !");
                txtDonGia.requestFocus();
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Đơn giá phải là số !");
            txtDonGia.requestFocus();
            return null;
        }

        hdct.setSoLuong(soLuongINT);

        return hdct;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnHDCT = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTenMonAn = new javax.swing.JTextField();
        txtMaHoaDon = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnGhiFIle = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnDoc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDonChiTiet = new javax.swing.JTable();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(650, 500));

        jpnHDCT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Số lượng");

        jLabel4.setText("Đơn giá");

        jLabel5.setText("Mã hóa đơn ");

        jLabel6.setText("Tên món ăn ");

        javax.swing.GroupLayout jpnHDCTLayout = new javax.swing.GroupLayout(jpnHDCT);
        jpnHDCT.setLayout(jpnHDCTLayout);
        jpnHDCTLayout.setHorizontalGroup(
            jpnHDCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHDCTLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jpnHDCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnHDCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jpnHDCTLayout.setVerticalGroup(
            jpnHDCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHDCTLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jpnHDCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnHDCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnHDCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTenMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnHDCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("QUẢN LÝ HÓA ĐƠN CHI TIẾT");

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

        btnGhiFIle.setText("Ghi");
        btnGhiFIle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhiFIleActionPerformed(evt);
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

        tblHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Số lượng", "Đơn giá", "Thành tiền", "Tên món ăn ", "Mã hóa đơn"
            }
        ));
        tblHoaDonChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonChiTietMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDonChiTiet);

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 48, Short.MAX_VALUE)
                .addComponent(jpnHDCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem)
                    .addComponent(btnDoc)
                    .addComponent(btnGhiFIle)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnReset))
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDoc, btnGhiFIle, btnSua, btnThem, btnXoa});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpnHDCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(15, 15, 15)
                        .addComponent(btnSua)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)
                        .addGap(18, 18, 18)
                        .addComponent(btnGhiFIle)
                        .addGap(18, 18, 18)
                        .addComponent(btnDoc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReset)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDoc, btnGhiFIle, btnSua, btnThem, btnXoa});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoaDonChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonChiTietMouseClicked
        int row = tblHoaDonChiTiet.getSelectedRow();
        HoaDonChiTiet hdct = listHDCT.get(row);
        fillTable(hdct);

    }//GEN-LAST:event_tblHoaDonChiTietMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm hay không ?", "xoa", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }
        String maHoaDon = txtMaHoaDon.getText().trim();
        boolean maHDTonTai = true;
        for (HoaDonChiTiet hdct : listHDCT) {
            if (hdct.getHoaDon().getMaHD().equals(maHoaDon)) {
                maHDTonTai = false;
                break;
            }
        }

        String tenMonAn = txtTenMonAn.getText();
        boolean tenMonAnTonTai = true;
        for (HoaDonChiTiet hdct : listHDCT) {
            if (hdct.getMonAn().getTen().equals(tenMonAn)) {
                tenMonAnTonTai = false;
                break;
            }
        }
        if (!maHDTonTai) {
            JOptionPane.showMessageDialog(this, "Mã hóa đơn bàn này đã tồn tại !");
        } else if (tenMonAnTonTai) {
            JOptionPane.showMessageDialog(this, "Tên món ăn này không tồn tại trong Menu nhà hàng");
        } else {
            JOptionPane.showMessageDialog(this, serviceHDCT.addHoaDonCT(getFrom()));
            showData(listHDCT);
        }


    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa hay không ?", "sua", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }
        int viTri = tblHoaDonChiTiet.getSelectedRow();
        JOptionPane.showMessageDialog(this, serviceHDCT.updateHoaDonCT(viTri, getFrom()));
        showData(listHDCT);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa hay không ?", "xoa", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }
        int viTri = tblHoaDonChiTiet.getSelectedRow();
        JOptionPane.showMessageDialog(this, serviceHDCT.deleteHoaDonCT(viTri));
        showData(listHDCT);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnGhiFIleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhiFIleActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn ghi File không ?", "ghi", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }
        JOptionPane.showMessageDialog(this, serviceHDCT.ghiFile(path));
    }//GEN-LAST:event_btnGhiFIleActionPerformed

    private void btnDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocActionPerformed
        listHDCT.clear();
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn đọc File hay không ?", "doc", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }
        dtm.setRowCount(0);
        JOptionPane.showMessageDialog(this, serviceHDCT.DocFile(path));
        showData(listHDCT);
    }//GEN-LAST:event_btnDocActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn Reset from hay không ?", "from", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_NO_OPTION) {
            return;
        }
        Reset();
    }//GEN-LAST:event_btnResetActionPerformed

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
            java.util.logging.Logger.getLogger(HoaDonChiTietView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDonChiTietView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDonChiTietView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonChiTietView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDonChiTietView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoc;
    private javax.swing.JButton btnGhiFIle;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpnHDCT;
    private javax.swing.JTable tblHoaDonChiTiet;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenMonAn;
    // End of variables declaration//GEN-END:variables
}
