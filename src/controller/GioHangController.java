/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.GioHangController.myCellRenderer;
import dao.DonHangDAO;
import dao.GioHangDAO;
import dao.SanPhamDAO;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import model.DonHang;
import model.GioHang;
import model.SanPham;
import view.GioHangChiTietView;
import view.GioHangView;

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
        ArrayList<GioHangChiTietView> res = new ArrayList<>();
        // Thay đổi đường dẫn tương đối của máy tính bạn đến chương trình JAVA ở đây
        String path = "src\\";
        Integer total_ = 0;
        try {
            ArrayList<GioHang> list_gh = GioHangDAO.selectAll(maKH);
            for (GioHang gh : list_gh) {
                int maSP = gh.getMaSP();
                SanPham sp = SanPhamDAO.selectByMaSP(maSP);
                String tenSP = sp.getTenSP();
                Integer donGia = sp.getDonGia();
                Integer total = donGia * gh.getSoLuong();
                String hinhAnh = sp.getHinhAnh();
                GioHangChiTietView chitietPanel = new GioHangChiTietView();
                String hinhAnh2 = path + hinhAnh;
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

    public void taoDonHang(DonHang dh, ArrayList<Integer> maGHs, int maKH, JList listgiohang) {
        try {
            DonHangDAO.insert(dh);
            for (Integer maGH : maGHs) {
                GioHangDAO.updateTrangThai(maKH, maGH, Boolean.TRUE);
                GioHang gh = GioHangDAO.selectByMaGH(maGH);
                SanPham sp = SanPhamDAO.selectByMaSP(gh.getMaSP());
                SanPhamDAO.truTonKhoSP(gh.getMaSP(), gh.getSoLuong() < sp.getSoLuongTonKho() ? sp.getSoLuongTonKho() - gh.getSoLuong() : 0);
            }
            listgiohang.removeAll();
            JOptionPane.showMessageDialog(null, "Tạo đơn hàng thành công");
        } catch (SQLException ex) {
            Logger.getLogger(GioHangView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    class myCellRenderer implements ListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            return (GioHangChiTietView) value;
        }
    ;

}
}
