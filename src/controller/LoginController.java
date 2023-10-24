/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.KhachHangDAO;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.KhachHang;
import view.HomeAdminView;
import view.LoginView;
import view.HomeView;

/**
 *
 * @author A715-42G
 */
public class LoginController {

    private LoginView view = new LoginView();

    public void login(String user, String pass) throws FileNotFoundException {

        try {
            KhachHang kh = KhachHangDAO.selectByTenDN(user);
            if (kh == null) {
                JOptionPane.showMessageDialog(null, "User không tồn tại", "Thất bại", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!kh.getMatKhau().equals(pass)) {
                JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu", "Thất bại", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try (PrintWriter writer = new PrintWriter("mydata.ser")) {
                writer.println(kh.getMaKH());
                writer.println(kh.getVaiTro());
            }
            if (kh.getVaiTro().trim().equalsIgnoreCase("admin")) {
                JOptionPane.showMessageDialog(null, "Admin đăng nhập thành công", "Admin", JOptionPane.INFORMATION_MESSAGE);
                HomeAdminView h = new HomeAdminView();
                h.setVisible(true);
                view.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "User đăng nhập thành công", "User", JOptionPane.INFORMATION_MESSAGE);
                HomeView uh = new HomeView();
                uh.setVisible(true);
                view.setVisible(false);
            }
//            JOptionPane.showMessageDialog(null, "User đăng nhập thành công", "User", JOptionPane.INFORMATION_MESSAGE);
//            HomeView uh = new HomeView();
//            uh.setVisible(true);
//            view.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
