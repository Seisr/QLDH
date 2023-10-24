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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.KhachHang;
import view.RegisterView;
import view.LoginView;

/**
 *
 * @author A715-42G
 */
public class RegisterController {

    private final KhachHang model;
    private final RegisterView view;
    
    private final String cMatKhau;
    
    private final JLabel jlbName;
    private final JLabel jlbEmail;
    private final JLabel jlbPhone;
    private final JLabel jlbPass;
    private final JLabel jlbCPass;

    public RegisterController(KhachHang model, RegisterView view, String cMatKhau, JLabel jlbName, JLabel jlbEmail, JLabel jlbPhone, JLabel jlbPass, JLabel jlbCPass) {
        this.model = model;
        this.view = view;
        this.cMatKhau = cMatKhau;
        this.jlbName = jlbName;
        this.jlbEmail = jlbEmail;
        this.jlbPhone = jlbPhone;
        this.jlbPass = jlbPass;
        this.jlbCPass = jlbCPass;
    }

    public void register() {

        String regexEmail = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
        String regexPass = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,12}$";
        String regexPhone = "^[0-9]+$";
        String regexName = "[a-zA-Z]+\\.?";
        String regexCPass = model.getMatKhau();

        Pattern ptEmail = Pattern.compile(regexEmail, Pattern.CASE_INSENSITIVE);
        Pattern ptPass = Pattern.compile(regexPass, Pattern.CASE_INSENSITIVE);
        Pattern ptPhone = Pattern.compile(regexPhone, Pattern.CASE_INSENSITIVE);
        Pattern ptName = Pattern.compile(regexName, Pattern.CASE_INSENSITIVE);
        Pattern ptCPass = Pattern.compile(regexCPass);

        Matcher mtcEmail = ptEmail.matcher(model.getEmail());
        Matcher mtcPass = ptPass.matcher(model.getMatKhau());
        Matcher mtcPhone = ptPhone.matcher(model.getSoDT());
        Matcher mtcName = ptName.matcher(model.getHoTen());
        Matcher mtcCPass = ptCPass.matcher(cMatKhau);

        boolean valName = mtcName.find();
        boolean valEmail = mtcEmail.find();
        boolean valPhone = mtcPhone.find();
        boolean valPass = mtcPass.find();
        boolean valCPass = mtcCPass.find();

        boolean valid = valEmail && valPass && valPhone && valName && valCPass;
        System.out.println(valid);
//        try {
        if (valName) {
            jlbName.setText("");
        } else {
            jlbName.setText("Tên không được có số");
        }
        if (valEmail) {
            jlbEmail.setText("");
        } else {
            jlbEmail.setText("Email không hợp lệ");
        }
        if (valPhone && (model.getSoDT().length() == 10 || model.getSoDT().length() == 11)) {
            jlbPhone.setText("");
        } else {
            jlbPhone.setText("Chỉ gồm số và có từ 10-11 chữ số ");
        }
        if (valPass) {
            jlbPass.setText("");
        } else {
            jlbPass.setText("ít nhất 1 ký tự Hoa, 1 ký tự thường và 1 chữ số");
        }
        if (valCPass) {
            jlbCPass.setText("");
        } else {
            jlbCPass.setText("Mật khẩu xác nhận không trùng khớp");
        }
        if (!valid) {
            System.out.println("Input ko hợp lệ");
        } else {
            try {
                KhachHang kh = KhachHangDAO.insert(model);
                try (PrintWriter writer = new PrintWriter("mydata.ser")) {
                    writer.println(kh.getMaKH());
                    writer.println(kh.getVaiTro());
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "Đăng ký thành công", "Đăng ký thành công", JOptionPane.PLAIN_MESSAGE);
                LoginView l = new LoginView();
                l.setVisible(true);
                view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(RegisterView.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
