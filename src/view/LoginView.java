/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author A715-42G
 */
public class LoginView extends javax.swing.JFrame {

    /**
     * Creates new form LoginView
     */
    public LoginView() {
        initComponents();
        setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon(this.getClass().getResource("/img/iconTitle.png"));
        this.setIconImage(img.getImage()); 
        Border emptyBorder = BorderFactory.createEmptyBorder(btnLogin.getBorder().getBorderInsets(btnLogin).top, btnLogin.getBorder().getBorderInsets(btnLogin).left, btnLogin.getBorder().getBorderInsets(btnLogin).bottom, btnLogin.getBorder().getBorderInsets(btnLogin).right);


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        txtAccount = new javax.swing.JTextField();
        pasPass = new javax.swing.JPasswordField();
        btnRegister = new javax.swing.JButton();
        checkShow = new javax.swing.JCheckBox();
        lblWall = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LoginV");
        setMinimumSize(new java.awt.Dimension(723, 466));
        setPreferredSize(new java.awt.Dimension(723, 466));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tên đăng nhập");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 90, 30));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mật khẩu");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 60, 20));

        btnLogin.setText("Đăng nhập");
        btnLogin.setFocusPainted(false);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 110, -1));
        getContentPane().add(txtAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 100, 30));
        getContentPane().add(pasPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 100, 30));

        btnRegister.setText("Đăng ký");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 110, -1));

        checkShow.setForeground(new java.awt.Color(255, 255, 255));
        checkShow.setText("Hiện mật khẩu");
        checkShow.setContentAreaFilled(false);
        checkShow.setFocusPainted(false);
        checkShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkShowActionPerformed(evt);
            }
        });
        getContentPane().add(checkShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, -1, -1));

        lblWall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/8.jpg"))); // NOI18N
        getContentPane().add(lblWall, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -620, 1090, 1680));

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String user = txtAccount.getText();
        String pass = pasPass.getText();
        if (user.equals("admin") && pass.equals("admin")) {
            JOptionPane.showMessageDialog(null, "Admin đăng nhập thành công","Admin",JOptionPane.INFORMATION_MESSAGE);
            AdminView h = new AdminView();
            h.setVisible(true);
            setVisible(false);
        } else if (user.equals("user") && pass.equals("user")) {
            JOptionPane.showMessageDialog(null, "User đăng nhập thành công","User",JOptionPane.INFORMATION_MESSAGE);
            UserView uh = new UserView();
            uh.setVisible(true);
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Đăng nhập thất bại","Fail",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        RegisterView r = new RegisterView();
        r.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void checkShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkShowActionPerformed
        // TODO add your handling code here:
        if(checkShow.isSelected() == true){
            pasPass.setEchoChar((char)0);
        }else{
            pasPass.setEchoChar('*');
        }
    }//GEN-LAST:event_checkShowActionPerformed

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
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JCheckBox checkShow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblWall;
    private javax.swing.JPasswordField pasPass;
    private javax.swing.JTextField txtAccount;
    // End of variables declaration//GEN-END:variables
}
