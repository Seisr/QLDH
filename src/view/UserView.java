/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import model.Bar;
import controller.BarController;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author A715-42G
 */
public class UserView extends javax.swing.JFrame {

    /**
     * Creates new form MainView
     */
    public UserView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Màn hình chính");
        BarController barCon = new BarController(jpnView);
        barCon.setView("SanPhamUser", jpnSanPham, jlbSanPham);
        ArrayList<Bar> listItem = new ArrayList<>();
        listItem.add(new Bar("SanPham", jpnSanPham, jlbSanPham));
        listItem.add(new Bar("GioHang", jpnGioHang, jlbGioHang));
        listItem.add(new Bar("DonHang", jpnDonHang, jlbDonHang));
//        listItem.add(new Bar("KhachHang",jpnKhachHang,jLabel2));

        barCon.setEvent(listItem);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jpnBar = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpnSanPham = new javax.swing.JPanel();
        jlbSanPham = new javax.swing.JLabel();
        jpnGioHang = new javax.swing.JPanel();
        jlbGioHang = new javax.swing.JLabel();
        jpnDonHang = new javax.swing.JPanel();
        jlbDonHang = new javax.swing.JLabel();
        jlbNhom = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        jpnView = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1060, 590));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnRoot.setMaximumSize(new java.awt.Dimension(1050, 554));
        jpnRoot.setMinimumSize(new java.awt.Dimension(1050, 640));
        jpnRoot.setPreferredSize(new java.awt.Dimension(1050, 554));
        jpnRoot.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnBar.setBackground(new java.awt.Color(82, 83, 81));
        jpnBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/order2.jpg"))); // NOI18N
        jLabel1.setText("Quản lý bán hàng");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jpnBar.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jpnSanPham.setPreferredSize(new java.awt.Dimension(158, 74));
        jpnSanPham.setVerifyInputWhenFocusTarget(false);

        jlbSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png"))); // NOI18N
        jlbSanPham.setText("Sản phẩm");

        javax.swing.GroupLayout jpnSanPhamLayout = new javax.swing.GroupLayout(jpnSanPham);
        jpnSanPham.setLayout(jpnSanPhamLayout);
        jpnSanPhamLayout.setHorizontalGroup(
            jpnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSanPhamLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jlbSanPham)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jpnSanPhamLayout.setVerticalGroup(
            jpnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnSanPhamLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jlbSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jpnBar.add(jpnSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 80, 163, -1));

        jpnGioHang.setPreferredSize(new java.awt.Dimension(158, 74));
        jpnGioHang.setVerifyInputWhenFocusTarget(false);

        jlbGioHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cart.png"))); // NOI18N
        jlbGioHang.setText("Giỏ hàng");
        jlbGioHang.setMaximumSize(new java.awt.Dimension(73, 16));
        jlbGioHang.setMinimumSize(new java.awt.Dimension(73, 16));
        jlbGioHang.setPreferredSize(new java.awt.Dimension(73, 16));

        javax.swing.GroupLayout jpnGioHangLayout = new javax.swing.GroupLayout(jpnGioHang);
        jpnGioHang.setLayout(jpnGioHangLayout);
        jpnGioHangLayout.setHorizontalGroup(
            jpnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnGioHangLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jlbGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jpnGioHangLayout.setVerticalGroup(
            jpnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnGioHangLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jlbGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jpnBar.add(jpnGioHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 160, 163, -1));

        jlbDonHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/order-delivery.png"))); // NOI18N
        jlbDonHang.setText("Đơn hàng");
        jlbDonHang.setMaximumSize(new java.awt.Dimension(73, 16));
        jlbDonHang.setMinimumSize(new java.awt.Dimension(73, 16));
        jlbDonHang.setPreferredSize(new java.awt.Dimension(73, 16));

        javax.swing.GroupLayout jpnDonHangLayout = new javax.swing.GroupLayout(jpnDonHang);
        jpnDonHang.setLayout(jpnDonHangLayout);
        jpnDonHangLayout.setHorizontalGroup(
            jpnDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnDonHangLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jlbDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jpnDonHangLayout.setVerticalGroup(
            jpnDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnDonHangLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jlbDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jpnBar.add(jpnDonHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 240, 163, -1));

        jlbNhom.setForeground(new java.awt.Color(255, 255, 255));
        jlbNhom.setText("Nhóm 3 - KhaTrang");
        jpnBar.add(jlbNhom, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 515, -1, -1));

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/log-out244.jpg"))); // NOI18N
        btnExit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExit.setMaximumSize(new java.awt.Dimension(30, 31));
        btnExit.setPreferredSize(new java.awt.Dimension(27, 27));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jpnBar.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 476, -1, -1));

        jpnRoot.add(jpnBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 554));

        jpnView.setBackground(new java.awt.Color(204, 204, 204));
        jpnView.setMaximumSize(new java.awt.Dimension(1070, 612));
        jpnView.setPreferredSize(new java.awt.Dimension(1070, 612));
        jpnView.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jpnRoot.add(jpnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Food20.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        jpnRoot.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 1000, 640));

        getContentPane().add(jpnRoot, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn muốn trở về màn hình đăng nhập?", "Cảnh báo", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            LoginView lv = new LoginView();
            lv.setVisible(true);
            setVisible(false);
        }

    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jlbDonHang;
    private javax.swing.JLabel jlbGioHang;
    private javax.swing.JLabel jlbNhom;
    private javax.swing.JLabel jlbSanPham;
    private javax.swing.JPanel jpnBar;
    private javax.swing.JPanel jpnDonHang;
    private javax.swing.JPanel jpnGioHang;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnSanPham;
    private javax.swing.JPanel jpnView;
    // End of variables declaration//GEN-END:variables

}
