/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DonHangDAO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.SanPhamView;

/**
 *
 * @author A715-42G
 */
public class DonHangUserController {
    private int maKH;
    
    public void loadData(JTable tblDonHang) throws SQLException {
        try (BufferedReader reader = new BufferedReader(new FileReader("mydata.ser"))) {
            maKH = Integer.parseInt(reader.readLine());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SanPhamView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SanPhamView.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model1 = (DefaultTableModel) tblDonHang.getModel();
        Object[] column = new Object[]{"Mã đơn hàng", "Số điện thoại", "Địa chỉ", "Trạng thái", "Tổng tiền"};
        model1.setColumnIdentifiers(column);
        ResultSet rs = DonHangDAO.selectByMaKH(maKH);
        model1.setRowCount(0);
        while (rs.next()) {
            String maDH = rs.getString("MADONHANG");
            String Sdt = rs.getString("SODT");
            String diaChi = rs.getString("DIACHI");
            String trangThai = rs.getString("TRANGTHAI");
            String tongTien = rs.getString("TONGTIEN");
            Object[] row = {maDH, Sdt, diaChi, trangThai, tongTien};
            model1.addRow(row);
        }
    }
}
