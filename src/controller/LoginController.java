/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.KhachHangDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.KhachHang;
import view.AdminView;
import view.LoginView;
import view.UserView;

/**
 *
 * @author A715-42G
 */
public class LoginController {

    private KhachHang model;
    private LoginView view;

    String userDB = "";
    String passDB = "";

    public void login(String user,String pass) {

        try {
            ResultSet rs = KhachHangDAO.selectByMaKH(user);
            while (rs.next()) {
                userDB = rs.getString("TENDN");
                passDB = rs.getString("MATKHAU");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (user.equals("admin") && pass.equals("admin")) {
            JOptionPane.showMessageDialog(null, "Admin đăng nhập thành công", "Admin", JOptionPane.INFORMATION_MESSAGE);
            AdminView h = new AdminView();
            h.setVisible(true);
            view.setVisible(false);
        } else if (user.equals(userDB) && pass.equals(passDB)) {
            JOptionPane.showMessageDialog(null, "User đăng nhập thành công", "User", JOptionPane.INFORMATION_MESSAGE);
            UserView uh = new UserView();
            uh.setVisible(true);
            view.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu", "Thất bại", JOptionPane.ERROR_MESSAGE);
        }
    }
}
