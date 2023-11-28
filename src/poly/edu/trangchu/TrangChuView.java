package poly.edu.trangchu;

import poly.edu.quanlyban.BanView;
import poly.edu.quanlybaocao.BaoCaoView;
import poly.edu.quanlydatban.DatBanView;
import poly.edu.quanlyhoadon.HoaDonView;
import poly.edu.quanlyhoadonchitiet.HoaDonChiTietView;
import poly.edu.quanlykhachhang.KhachHangView;
import poly.edu.quanlynhanvien.QuanLyNhanVienMain;
import poly.edu.quanlysanhsachmonan.MonAnView;

public class TrangChuView extends javax.swing.JFrame {

    public TrangChuView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnQuanLyMonAN = new javax.swing.JButton();
        btnQuanLyBan = new javax.swing.JButton();
        btnQuanLyNhanVien = new javax.swing.JButton();
        btnQuanLyKhachHang = new javax.swing.JButton();
        btnQuanLyBanDat = new javax.swing.JButton();
        btnQuanLyHoaDonChiTiet = new javax.swing.JButton();
        btnQuanLyHoaDon = new javax.swing.JButton();
        btnQuanLyBaoCao = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TỶang chu quan ly nha hang");
        setPreferredSize(new java.awt.Dimension(1000, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("QUẢN LÝ NHÀ HÀNG ");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Menu");

        btnQuanLyMonAN.setText("Quản Lý Món Ăn ");
        btnQuanLyMonAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyMonANActionPerformed(evt);
            }
        });

        btnQuanLyBan.setText("Quản Lý Bàn");
        btnQuanLyBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyBanActionPerformed(evt);
            }
        });

        btnQuanLyNhanVien.setText("Quản Lý Nhân Viên ");
        btnQuanLyNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyNhanVienActionPerformed(evt);
            }
        });

        btnQuanLyKhachHang.setText("Quản Lý Khách Hàng");
        btnQuanLyKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyKhachHangActionPerformed(evt);
            }
        });

        btnQuanLyBanDat.setText("Quản Lý Đặt Bàn ");
        btnQuanLyBanDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyBanDatActionPerformed(evt);
            }
        });

        btnQuanLyHoaDonChiTiet.setText("Quản Lý Hóa Đơn Chi Tiết");
        btnQuanLyHoaDonChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyHoaDonChiTietActionPerformed(evt);
            }
        });

        btnQuanLyHoaDon.setText("Quản Lý Hóa Đơn ");
        btnQuanLyHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyHoaDonActionPerformed(evt);
            }
        });

        btnQuanLyBaoCao.setText("Quản Lý Báo Cáo ");
        btnQuanLyBaoCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyBaoCaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnQuanLyMonAN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuanLyBan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(btnQuanLyNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(btnQuanLyBanDat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(btnQuanLyKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(btnQuanLyHoaDonChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(btnQuanLyBaoCao, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(btnQuanLyHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnQuanLyMonAN)
                .addGap(20, 20, 20)
                .addComponent(btnQuanLyBan)
                .addGap(20, 20, 20)
                .addComponent(btnQuanLyNhanVien)
                .addGap(20, 20, 20)
                .addComponent(btnQuanLyKhachHang)
                .addGap(20, 20, 20)
                .addComponent(btnQuanLyBanDat)
                .addGap(20, 20, 20)
                .addComponent(btnQuanLyHoaDon)
                .addGap(20, 20, 20)
                .addComponent(btnQuanLyHoaDonChiTiet)
                .addGap(20, 20, 20)
                .addComponent(btnQuanLyBaoCao)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Banner.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jLabel4))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(342, 342, 342))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuanLyMonANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyMonANActionPerformed
        new MonAnView().setVisible(true);
    }//GEN-LAST:event_btnQuanLyMonANActionPerformed

    private void btnQuanLyBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyBanActionPerformed
        new BanView().setVisible(true);
    }//GEN-LAST:event_btnQuanLyBanActionPerformed

    private void btnQuanLyNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyNhanVienActionPerformed
        new QuanLyNhanVienMain().setVisible(true);
    }//GEN-LAST:event_btnQuanLyNhanVienActionPerformed

    private void btnQuanLyKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyKhachHangActionPerformed
        new KhachHangView().setVisible(true);
    }//GEN-LAST:event_btnQuanLyKhachHangActionPerformed

    private void btnQuanLyBanDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyBanDatActionPerformed
        new DatBanView().setVisible(true);
    }//GEN-LAST:event_btnQuanLyBanDatActionPerformed

    private void btnQuanLyHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyHoaDonActionPerformed
        new HoaDonView().setVisible(true);
    }//GEN-LAST:event_btnQuanLyHoaDonActionPerformed

    private void btnQuanLyHoaDonChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyHoaDonChiTietActionPerformed
        new HoaDonChiTietView().setVisible(true);
    }//GEN-LAST:event_btnQuanLyHoaDonChiTietActionPerformed

    private void btnQuanLyBaoCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyBaoCaoActionPerformed
        new BaoCaoView().setVisible(true);
    }//GEN-LAST:event_btnQuanLyBaoCaoActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuanLyBan;
    private javax.swing.JButton btnQuanLyBanDat;
    private javax.swing.JButton btnQuanLyBaoCao;
    private javax.swing.JButton btnQuanLyHoaDon;
    private javax.swing.JButton btnQuanLyHoaDonChiTiet;
    private javax.swing.JButton btnQuanLyKhachHang;
    private javax.swing.JButton btnQuanLyMonAN;
    private javax.swing.JButton btnQuanLyNhanVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
