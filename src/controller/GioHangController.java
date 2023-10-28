/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.GioHangController.myCellRenderer;
import dao.GioHangDAO;
import dao.SanPhamDAO;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import model.GioHang;
import model.SanPham;
import view.GioHangChiTietView;

/**
 *
 * @author khoa5
 */
public class GioHangController {
    public ArrayList<Integer> getMaDH(int maKH) {
        try {
            ArrayList<Integer> res = new ArrayList();
            ArrayList<GioHang> list_gh = GioHangDAO.selectAll(maKH);
            for (GioHang gioHang : list_gh) {
                res.add(gioHang.getMaGH());
            }
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(GioHangController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Integer loadData(JList list, int maKH) {
        ArrayList<GioHangChiTietView> res = new ArrayList<GioHangChiTietView>();
        // Thay đổi đường dẫn tương đối của máy tính bạn đến chương trình JAVA ở đây
        String path = "src\\";
//        String path = "C:\\Users\\A715-42G\\Documents\\NetBeansProjects\\QLDH\\src\\";
        Integer total_ = 0;
        try {
            ArrayList<GioHang> list_gh = GioHangDAO.selectAll(maKH);
            for (GioHang gh : list_gh) {
                int maSP = gh.getMaSP();
                SanPham sp = SanPhamDAO.selectByMaSP(maSP);
                String tenSP = sp.getTenSP();
                String moTa = sp.getMoTa();
                Integer donGia = sp.getDonGia();
                Integer soLuongTonKho = sp.getSoLuongTonKho();
                Integer total = donGia * gh.getSoLuong();
                String loai = sp.getLoai();
                String hinhAnh = sp.getHinhAnh();
                GioHangChiTietView chitietPanel = new GioHangChiTietView();
                String hinhAnh2 = path + hinhAnh; //+ ".jpg";
                ImageIcon icon = new ImageIcon(hinhAnh2);

                chitietPanel.imageLabel.setIcon(icon);
                chitietPanel.nameLabel.setText(tenSP);
                chitietPanel.priceLabel.setText(donGia.toString());
                chitietPanel.qtyLabel.setText(gh.getSoLuong().toString());
                chitietPanel.totalLabel.setText(total.toString());

                total_ += total;
                res.add(chitietPanel);
            }
            list.setListData(res.toArray());
            list.setCellRenderer(new myCellRenderer());
            return total_;
        } catch (SQLException e) {
        }
        return 0;
    }

    class myCellRenderer implements ListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            return (GioHangChiTietView) value;
        };


    }
}
