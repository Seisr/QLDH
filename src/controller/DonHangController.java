/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DonHangDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author A715-42G
 */
public class DonHangController {

    public void loadData(JTable tblDonHang) throws SQLException {
        DefaultTableModel model1 = (DefaultTableModel) tblDonHang.getModel();
        Object[] column = new Object[]{"Mã đơn hàng", "Mã khách hàng", "Số điện thoại", "Địa chỉ", "Trạng thái", "Tổng tiền"};
        model1.setColumnIdentifiers(column);
        ResultSet rs = DonHangDAO.selectAll();
        model1.setRowCount(0);
        while (rs.next()) {
            String maDH = rs.getString("MADONHANG");
            String maKH = rs.getString("MAKH");
            String Sdt = rs.getString("SODT");
            String diaChi = rs.getString("DIACHI");
            String trangThai = rs.getString("TRANGTHAI");
            String tongTien = rs.getString("TONGTIEN");
            Object[] row = {maDH, maKH, Sdt, diaChi, trangThai, tongTien};
            model1.addRow(row);
        }
    }
}
