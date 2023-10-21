/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.SanPhamDAO;
import java.awt.Component;
import java.math.BigInteger;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import model.SanPham;

/**
 *
 * @author A715-42G
 */
public class SanPhamAdminController {

    public void loadData(JTable tblSanPham) {
        // Thay đổi đường dẫn tương đối của máy tính bạn đến chương trình JAVA ở đây
        String path = "C:\\Users\\A715-42G\\Documents\\NetBeansProjects\\QLDH\\src\\";
        DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
        Object[] column = new Object[]{"Mã SP", "Tên SP", "Mô tả", "Đơn giá", "Số lượng tồn kho", "Hình ảnh", "Loại"};
        model.setColumnIdentifiers(column);
        try {
            ResultSet rs = SanPhamDAO.selectAll();
            model.setRowCount(0);
            while (rs.next()) {
                String maSP = rs.getString("MASP");
                String tenSP = rs.getString("TENSP");
                String moTa = rs.getString("MOTA");
                String donGia = rs.getString("DONGIA");
                String soLuongTonKho = rs.getString("SLTONKHO");
                String loai = rs.getString("LOAI");
                String hinhAnh = rs.getString("HINHANH");
                JLabel imageLabel = new JLabel();
                String hinhAnh2 = path + hinhAnh;
                ImageIcon icon = new ImageIcon(hinhAnh2);
                imageLabel.setIcon(icon);
                Object[] row = {maSP, tenSP, moTa, donGia, soLuongTonKho, imageLabel, loai.trim()};
                model.addRow(row);
                tblSanPham.getColumn("Hình ảnh").setCellRenderer(new myTableCellRenderer());
//                byte[] buffer = new byte[1024];
//                ByteArrayOutputStream bos = new ByteArrayOutputStream();
//                InputStream hinhAnh = rs.getBinaryStream("HINHANH");
//                while (hinhAnh.read(buffer) > 0) {
//                    bos.write(buffer);
//                }
// dtm.addRow(row);

            }
//            tblSanPham.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addSanPham(SanPham sp) {
        try {
            SanPhamDAO.insert(sp);
            JOptionPane.showMessageDialog(null, "Thêm Sản Phẩm thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class myTableCellRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return (Component) value;
        }

    }

}
