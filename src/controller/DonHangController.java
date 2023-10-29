/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DonHangDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.DonHang;
import model.TrangThaiDH;
import static model.TrangThaiDH.DANGGIAOHANG;
import static model.TrangThaiDH.DANGXULY;
import view.DonHangView;

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
    
    public void updateStatus(int[] list, JTable tblDonHang){
            for (int i : list) {
            int maDH = Integer.parseInt(tblDonHang.getValueAt(i, 0).toString());
            DonHang dh;
            try {
                dh = DonHangDAO.selectByMaDH(maDH);
                switch (dh.getTrangThai()) {
                    case DANGXULY ->
                        DonHangDAO.updateTrangThai(maDH, TrangThaiDH.DANGGIAOHANG);
                    case DANGGIAOHANG ->
                        DonHangDAO.updateTrangThai(maDH, TrangThaiDH.DAHOANTHANH);
                    default -> {
                    }
                }
                DonHangController dhac = new DonHangController();
                dhac.loadData(tblDonHang);
            } catch (SQLException ex) {
                Logger.getLogger(DonHangView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
