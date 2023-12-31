/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.GioHangDAO;
import dao.SanPhamDAO;
import java.awt.Component;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public void loadData(JTable tblSanPham, String vaitro, String loaisp, String filter) {
        // Thay đổi đường dẫn tương đối của máy tính bạn đến chương trình JAVA ở đây
        String path = "src\\";
        DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
        Object[] column = new Object[]{"Mã SP", "Tên SP", "Mô tả", "Đơn giá", "Số lượng tồn kho", "Hình ảnh", "Loại"};
        model.setColumnIdentifiers(column);
        try {
            ArrayList<SanPham> list_sp = SanPhamDAO.selectAll(loaisp);
            if (!filter.isBlank()) {
                ArrayList<SanPham> list_sp_filter = new ArrayList();
                for (SanPham sanPham : list_sp) {
                    String ten = sanPham.getTenSP().toLowerCase();
                    String mt = sanPham.getMoTa().toLowerCase();
                    String ft = filter.toLowerCase();
                    if (ten.contains(ft) || mt.contains(ft)) {
                        list_sp_filter.add(sanPham);
                    }
                }
                list_sp = (ArrayList) list_sp_filter.clone();
            }
            model.setRowCount(0);
            for (SanPham sp : list_sp) {
                int maSP = sp.getMaSP();
                String tenSP = sp.getTenSP();
                String moTa = sp.getMoTa();
                int donGia = sp.getDonGia();
                int soLuongTonKho = sp.getSoLuongTonKho();
                String loai = sp.getLoai();
                String hinhAnh = sp.getHinhAnh();
                JLabel imageLabel = new JLabel();
                String hinhAnh2 = path + hinhAnh;
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
            if (! sp.getTenSP().isBlank()){ 
                SanPhamDAO.insert(sp);
                JOptionPane.showMessageDialog(null, "Thêm Sản Phẩm thành công");
            } else {
            JOptionPane.showMessageDialog(null, "Thêm sản phẩm thất bại");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Thêm sản phẩm thất bại");
        }
    }

    public void editSanPham(SanPham sp) {
        try {
            if (! sp.getTenSP().isBlank()){
            SanPhamDAO.update(sp);
            JOptionPane.showMessageDialog(null, "Sửa Sản Phẩm thành công");
            } else {
            JOptionPane.showMessageDialog(null, "Sửa sản phẩm thất bại");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Sửa sản phẩm thất bại");
        }
    }

    public void deleteSanPham(int maSP) {
        try {
            SanPhamDAO.delete(maSP);
            JOptionPane.showMessageDialog(null, "Đã xóa sản phẩm");

        } catch (SQLException ex) {
            Logger.getLogger(SanPhamView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void toCartSanPham(int maSP, int qty, int donGia, int maKH) {

        try {
            SanPham sp = SanPhamDAO.selectByMaSP(maSP);
            if (sp.getSoLuongTonKho() - qty < 0) {
                JOptionPane.showMessageDialog(null, "Vượt quá số lượng tồn kho! Không thể thêm sản phẩm vào giỏ hàng");
                return;
            }
            GioHangDAO.insert(maKH, maSP, qty, donGia);
            JOptionPane.showMessageDialog(null, "Đã thêm sản phẩm vào giỏ hàng");
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    class myTableCellRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return (Component) value;
        }

    }

}
