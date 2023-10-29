/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.KhachHangDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;

/**
 *
 * @author A715-42G
 */
public class KhachHangController {

    public void loadData(JTable tblKhachHang) throws SQLException {

        DefaultTableModel model1 = (DefaultTableModel) tblKhachHang.getModel();
        Object[] column = new Object[]{"Mã Khách hàng", "Tên đăng nhập", "Vai trò", "Họ tên", "Mật khẩu", "Số điện thoại", "Email"};
        model1.setColumnIdentifiers(column);
        ResultSet rs = KhachHangDAO.selectAll();
        model1.setRowCount(0);
        while (rs.next()) {
            String maKH = rs.getString("MAKH");
            String tenDN = rs.getString("TENDN");
            String vaiTro = rs.getString("VAITRO");
            String hoTen = rs.getString("HOTEN");
            String matKhau = rs.getString("MATKHAU");
            String soDT = rs.getString("SODT");
            String email = rs.getString("EMAIL");
            Object[] row = {maKH, tenDN, vaiTro, hoTen, matKhau, soDT, email};
            model1.addRow(row);
        }
    }

    public void addKhachHang(KhachHang kh) {
        try {
            KhachHangDAO.insert(kh);
            JOptionPane.showMessageDialog(null, "Thêm người dùng thành công");
        } catch (SQLException ex) {
        }
    }

    public void updateKhachHang(KhachHang kh) {
        try {
            KhachHangDAO.update1(kh);
            JOptionPane.showMessageDialog(null, "Sửa người dùng thành công");
        } catch (SQLException ex) {
        }
    }

    public void deleteKhachHang(int maKH) {
        try {
            KhachHangDAO.delete(maKH);
            JOptionPane.showMessageDialog(null, "Xóa người dùng thành công");
        } catch (SQLException ex) {
        }
    }
}
