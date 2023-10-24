/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.SanPhamDAO;
import java.awt.Component;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import model.SanPham;
import view.SanPhamView;

/**
 *
 * @author A715-42G
 */
public class SanPhamController {
    
    public void loadData(JTable tblSanPham, String vaitro) {
        // Thay đổi đường dẫn tương đối của máy tính bạn đến chương trình JAVA ở đây
        String path = "C:\\Users\\A715-42G\\Documents\\NetBeansProjects\\QLDH\\src\\";
        DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
        Object[] column = new Object[]{"Mã SP", "Tên SP", "Mô tả", "Đơn giá", "Số lượng tồn kho", "Hình ảnh", "Loại"};
        model.setColumnIdentifiers(column);
        try {
            ArrayList<SanPham> list_sp = SanPhamDAO.selectAll("");
            model.setRowCount(0);
            for (SanPham sp: list_sp) {
                int maSP = sp.getMaSP();
                String tenSP = sp.getTenSP();
                String moTa = sp.getMoTa();
                int donGia = sp.getDonGia();
                int soLuongTonKho = sp.getSoLuongTonKho();
                String loai = sp.getLoai();
                String hinhAnh = sp.getHinhAnh();
                JLabel imageLabel = new JLabel();
                String hinhAnh2 = path + hinhAnh;// + ".jpg";
                ImageIcon icon = new ImageIcon(hinhAnh2);
                imageLabel.setIcon(icon);
                Object[] row = {maSP, tenSP, moTa, donGia, soLuongTonKho, imageLabel, loai.trim()};
                model.addRow(row);
                tblSanPham.getColumn("Hình ảnh").setCellRenderer(new myTableCellRenderer());

            }
        } catch (SQLException e) {
        }
    }

    public void addSanPham(SanPham sp) {
        try {
            SanPhamDAO.insert(sp);
            JOptionPane.showMessageDialog(null, "Thêm Sản Phẩm thành công");
        } catch (HeadlessException | SQLException e) {
        }
    }

    class myTableCellRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return (Component) value;
        }

    }

}
