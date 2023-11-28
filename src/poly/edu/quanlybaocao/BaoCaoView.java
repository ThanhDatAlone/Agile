
package poly.edu.quanlybaocao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import poly.edu.quanlyhoadon.HoaDon;
import poly.edu.quanlyhoadon.HoaDonService;

public class BaoCaoView extends javax.swing.JFrame {

    private List<BaoCao> listBC = new ArrayList<>();
    private DefaultTableModel dtm = new DefaultTableModel();
    private BaoCaoService serviceBC = new BaoCaoService();
    private String path = "BaoCao.txt";
      HoaDon hd = new HoaDon();
      HoaDonService qlHD = new HoaDonService();

    public BaoCaoView() {
        initComponents();
        listBC = (List<BaoCao>) serviceBC.fakeData();
        dtm = (DefaultTableModel) tblBaoCao.getModel();
        showData(listBC);
        if (dtm.getRowCount() > 0) {
            tblBaoCao.setRowSelectionInterval(0, 0);
            BaoCao bc = listBC.get(0);
            fillTable(bc);
        }
        txtDoanhThu.setEnabled(false);

    }

    public void showData(List<BaoCao> listBC) {
        dtm.setRowCount(0);
        for (BaoCao bc : listBC) {
            dtm.addRow(new Object[]{
                bc.getHoaDon().getNgay(),
                bc.getDoanhThu()
            });

        }
    }

    public void fillTable(BaoCao bc) {
        txtNgayBaoCao.setText(bc.getHoaDon().getNgay());
        txtDoanhThu.setText(bc.getDoanhThu() + "");
    }

    public BaoCao getFrom() {
        
        String ngayBC = txtNgayBaoCao.getText().trim();
        hd.setNgay(ngayBC);
        String doanhThu = txtDoanhThu.getText().trim();
        double doanhThuDB;

        if (ngayBC.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ngày báo cáo không được để trống !");
            txtNgayBaoCao.requestFocus();
            return null;
        }

        if (doanhThu.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Doanh thu không được để trống !");
            txtDoanhThu.requestFocus();
            return null;
        }
        try {
            doanhThuDB = Double.parseDouble(doanhThu);
            if (doanhThuDB <= 0) {
                JOptionPane.showMessageDialog(this, "Doanh thu phải lớn hơn 0 !");
                txtDoanhThu.requestFocus();
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Doanh thu phải là số !");
            txtDoanhThu.requestFocus();
            return null;
        }
        BaoCao bc = new BaoCao(hd, doanhThuDB);
        return bc;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jpnBaoCao = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNgayBaoCao = new javax.swing.JTextField();
        txtDoanhThu = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBaoCao = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("QUẢN LÝ BÁO CÁO HÀNG NGÀY");

        jpnBaoCao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Ngày báo cáo");

        jLabel5.setText("Doanh thu");

        javax.swing.GroupLayout jpnBaoCaoLayout = new javax.swing.GroupLayout(jpnBaoCao);
        jpnBaoCao.setLayout(jpnBaoCaoLayout);
        jpnBaoCaoLayout.setHorizontalGroup(
            jpnBaoCaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBaoCaoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jpnBaoCaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(jpnBaoCaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayBaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jpnBaoCaoLayout.setVerticalGroup(
            jpnBaoCaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBaoCaoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jpnBaoCaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNgayBaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnBaoCaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        tblBaoCao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ngày báo cáo ", "Doanh thu"
            }
        ));
        tblBaoCao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBaoCaoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBaoCao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 216, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(202, 202, 202))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpnBaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnBaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblBaoCaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBaoCaoMouseClicked
        int row = tblBaoCao.getSelectedRow();
        BaoCao bc = listBC.get(row);
        fillTable(bc);
    }//GEN-LAST:event_tblBaoCaoMouseClicked

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
            java.util.logging.Logger.getLogger(BaoCaoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BaoCaoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BaoCaoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BaoCaoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BaoCaoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel jpnBaoCao;
    private javax.swing.JTable tblBaoCao;
    private javax.swing.JTextField txtDoanhThu;
    private javax.swing.JTextField txtNgayBaoCao;
    // End of variables declaration//GEN-END:variables
}
