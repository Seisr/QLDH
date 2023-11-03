/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DonHangDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.DonHang;
import model.KhachHang;
import model.TrangThaiDH;
import static model.TrangThaiDH.DANGGIAOHANG;
import static model.TrangThaiDH.DANGXULY;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
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

    public void updateStatus(int[] list, JTable tblDonHang) {
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

    public void xuatDonHang(String txtLuuFile) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet spreadsheet = workbook.createSheet("Đơn hàng");
        HSSFRow row = null;
        Cell cell = null;
        row = spreadsheet.createRow((short) 0);
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("MADONHANG");
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("MAKH");
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("SODT");
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("DIACHI");
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("TRANGTHAI");
        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("TONGTIEN");
        ArrayList<DonHang> dh_list = new ArrayList<>();
        try {
            dh_list = DonHangDAO.selectAll1();
        } catch (SQLException ex) {
        }

        for (int i = 0; i < dh_list.size(); i++) {
            DonHang dh = dh_list.get(i);
            row = spreadsheet.createRow(1 + i);
            row.createCell(0).setCellValue(i);
            row.createCell(1).setCellValue(dh.getMaDH().toString());
            row.createCell(2).setCellValue(dh.getMaKH().toString());
            row.createCell(3).setCellValue(dh.getSdt());
            row.createCell(4).setCellValue(dh.getTrangThai().toString());
            row.createCell(5).setCellValue(dh.getTongTien());
        }
        try {
            String txtLuuFile1 = txtLuuFile + "\\dh_list.xls";
            FileOutputStream out = new FileOutputStream(new File(txtLuuFile1)); //"C:\\Users\\A715-42G\\Desktop\\xuat_file\\kh_list.xls"
            workbook.write(out);
            out.close();
            JOptionPane.showMessageDialog(null, "Xuất file thành công");
        } catch (IOException e) {
        }
    }
}