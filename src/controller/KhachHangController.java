/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.JDBC;
import dao.KhachHangDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;

/**
 *
 * @author A715-42G
 */
public class KhachHangController {
//        JDBC db = new JDBC();
//        ResultSet rs = db.executeQuery("SELECT * FROM KHACHHANG");
//    public void loadData(JTable tblKhachHang, String vaitro) {
//        // Thay đổi đường dẫn tương đối của máy tính bạn đến chương trình JAVA ở đây
//        String path = "src\\assets\\";
//        DefaultTableModel model = (DefaultTableModel) tblKhachHang.getModel();
////        Object[] column = new Object[]{"Mã SP", "Tên SP", "Mô tả", "Đơn giá", "Số lượng tồn kho", "Hình ảnh", "Loại"};
//        Object[] column = new Object[]{"Mã Khách hàng", "Tên đăng nhập", "Vai trò", "Họ tên", "Số điện thoại", "Email"};
//        model.setColumnIdentifiers(column);
//        try {
//            ArrayList<KhachHang> list_kh = KhachHangDAO.selectAll();
//            model.setRowCount(0);
//            for (KhachHang kh : list_kh) {
//                int maSP = sp.getMaSP();
//                String tenSP = sp.getTenSP();
//                String moTa = sp.getMoTa();
//                int donGia = sp.getDonGia();
//                int soLuongTonKho = sp.getSoLuongTonKho();
//                String loai = sp.getLoai();
//                String hinhAnh = sp.getHinhAnh();
////                Object[] row = {maSP, tenSP, moTa, donGia, soLuongTonKho, imageLabel, loai.trim()};
//                Object[] row = {maKH, tenDN, vaiTro, hoTen, soDT, email};
//                model.addRow(row);
//            }
//        } catch (SQLException e) {
//        }
//    }
}
