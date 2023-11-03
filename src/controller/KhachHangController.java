/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.KhachHangDAO;
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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import view.KhachHangView;

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

    public void xuatKhachHang(String txtLuuFile) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet spreadsheet = workbook.createSheet("Khách hàng");
        HSSFRow row = null;
        Cell cell = null;
        row = spreadsheet.createRow((short) 0);
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("MAKH");
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("TENDN");
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("VAITRO");
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("HOTEN");
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("MATKHAU");
        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("SODT");
        cell = row.createCell(6, CellType.STRING);
        cell.setCellValue("EMAIL");
        ArrayList<KhachHang> kh_list = new ArrayList<>();
        try {
            kh_list = KhachHangDAO.selectAll1();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangView.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < kh_list.size(); i++) {
            KhachHang kh = kh_list.get(i);
            row = spreadsheet.createRow(1 + i);
            row.createCell(0).setCellValue(i);
            row.createCell(1).setCellValue(kh.getTenDN());
            row.createCell(2).setCellValue(kh.getVaiTro());
            row.createCell(3).setCellValue(kh.getHoTen());
            row.createCell(4).setCellValue(kh.getMatKhau());
            row.createCell(5).setCellValue(kh.getSoDT());
            row.createCell(6).setCellValue(kh.getEmail());
        }
        try {
            String txtLuuFile1 = txtLuuFile + "\\kh_list.xls";
            FileOutputStream out = new FileOutputStream(new File(txtLuuFile1)); //"C:\\Users\\A715-42G\\Desktop\\xuat_file\\kh_list.xls"
            workbook.write(out);
            out.close();
            JOptionPane.showMessageDialog(null, "Xuất file thành công");
        } catch (IOException e) {

        }
    }
}
