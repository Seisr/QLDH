/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.SanPhamController;
import dao.GioHangDAO;
import dao.SanPhamDAO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.SanPham;

/**
 *
 * @author A715-42G
 */
public class SanPhamView extends javax.swing.JPanel {

    private int maKH = 0;
    private String vaiTro = "";
    private SanPhamController spac = new SanPhamController();

    /**
     * Creates new form SanPhamView
     */
    public SanPhamView() {
        initComponents();
        try (BufferedReader reader = new BufferedReader(new FileReader("mydata.ser"))) {
            maKH = Integer.parseInt(reader.readLine());
            vaiTro = reader.readLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SanPhamView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SanPhamView.class.getName()).log(Level.SEVERE, null, ex);
        }

        spac.loadData(tblSanPham, vaiTro,"","");
        tblSanPham.setRowHeight(90);
        tblSanPham.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblSanPham.getColumnModel().getColumn(1).setPreferredWidth(20);
        tblSanPham.getColumnModel().getColumn(3).setPreferredWidth(20);
        tblSanPham.getColumnModel().getColumn(4).setPreferredWidth(20);
        tblSanPham.getColumnModel().getColumn(6).setPreferredWidth(20);

        switch (vaiTro) {
            case "guest" -> {
                btnSua.setVisible(false);
                btnThem.setVisible(false);
                btnThemGioHang.setEnabled(false);
                txtSoluong.setEnabled(false);
                btnXoa.setVisible(false);

            }
            case "user" -> {
                btnSua.setVisible(false);
                btnThem.setVisible(false);
                btnXoa.setVisible(false);
            }
            default -> //admin
            {
                btnThemGioHang.setVisible(false);
                labelSoluong.setVisible(false);
                txtSoluong.setVisible(false);
            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        txtMoTa = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSoLuongTonKho = new javax.swing.JTextField();
        txtSoluong = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        labelSoluong = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtLoai = new javax.swing.JTextField();
        btnLoad = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThemGioHang = new javax.swing.JButton();
        txtHinhAnh = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        btnDrink = new javax.swing.JButton();
        btnFood = new javax.swing.JButton();
        btnAll = new javax.swing.JButton();
        txtFilter = new javax.swing.JTextField();
        btnFilter = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Danh sách sản phẩm");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSanPham.setGridColor(new java.awt.Color(255, 255, 255));
        tblSanPham.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanPham);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 821, 253));

        jLabel2.setText("Thông tin sản phẩm");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        txtMaSP.setEditable(false);
        add(txtMaSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 368, 36, -1));
        add(txtTenSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 368, 89, -1));
        add(txtMoTa, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 368, 204, -1));
        add(txtDonGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 368, 97, -1));

        jLabel3.setText("Mã sản phẩm");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 340, -1, -1));

        jLabel4.setText("Tên sản phẩm");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 340, -1, -1));

        jLabel5.setText("Mô tả");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 340, -1, -1));

        jLabel6.setText("Đơn giá");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 340, -1, -1));
        add(txtSoLuongTonKho, new org.netbeans.lib.awtextra.AbsoluteConstraints(513, 368, 101, -1));
        add(txtSoluong, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 430, 101, -1));

        jLabel8.setText("Số lượng tồn kho");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(513, 340, -1, -1));

        labelSoluong.setText("Số lượng");
        add(labelSoluong, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 410, -1, -1));

        jLabel10.setText("Loại");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(739, 340, -1, -1));
        add(txtLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(739, 368, 103, -1));

        btnLoad.setText("Tải lại");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });
        add(btnLoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 429, -1, -1));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 429, -1, -1));

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 429, -1, -1));

        btnThemGioHang.setText("Thêm vào giỏ hàng");
        btnThemGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemGioHangActionPerformed(evt);
            }
        });
        add(btnThemGioHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(692, 423, 140, 30));
        add(txtHinhAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(626, 368, 101, -1));

        jLabel11.setText("Hình ảnh");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(626, 340, -1, -1));

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 429, -1, -1));

        btnDrink.setText("Thức Uống");
        btnDrink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDrinkActionPerformed(evt);
            }
        });
        add(btnDrink, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        btnFood.setText("Đồ Ăn");
        btnFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFoodActionPerformed(evt);
            }
        });
        add(btnFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        btnAll.setText("Tất Cả");
        btnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllActionPerformed(evt);
            }
        });
        add(btnAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));
        add(txtFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 160, 20));

        btnFilter.setText("Lọc");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        add(btnFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        // TODO add your handling code here:
        spac.loadData(tblSanPham, vaiTro, "","");
        tblSanPham.setRowHeight(90);
        tblSanPham.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblSanPham.getColumnModel().getColumn(1).setPreferredWidth(20);
        tblSanPham.getColumnModel().getColumn(3).setPreferredWidth(20);
        tblSanPham.getColumnModel().getColumn(4).setPreferredWidth(20);
        tblSanPham.getColumnModel().getColumn(6).setPreferredWidth(20);
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        Integer maSP = Integer.valueOf(txtMaSP.getText());
        String tenSP = txtTenSP.getText();
        String moTa = txtMoTa.getText();
        Integer donGia = Integer.valueOf(txtDonGia.getText());
        int soLuongTonKho = Integer.parseInt(txtSoLuongTonKho.getText());
        String hinhAnh = txtHinhAnh.getText();
        String loai = txtLoai.getText();

        SanPham sp = new SanPham(maSP, tenSP, moTa, donGia, soLuongTonKho, hinhAnh, loai);
        spac.addSanPham(sp);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        Integer maSP = Integer.valueOf(txtMaSP.getText());
        String tenSP = txtTenSP.getText();
        String moTa = txtMoTa.getText();
        Integer donGia = Integer.valueOf(txtDonGia.getText());
        int soLuongTonKho = Integer.parseInt(txtSoLuongTonKho.getText());
        String hinhAnh = txtHinhAnh.getText();
        String loai = txtLoai.getText();

        SanPham sp = new SanPham(maSP, tenSP, moTa, donGia, soLuongTonKho, hinhAnh, loai);
        try {
            SanPhamDAO.update(sp);
            JOptionPane.showMessageDialog(null, "Sửa Sản Phẩm thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemGioHangActionPerformed
        try {
            // TODO add your handling code here:
//        int maSP = Integer.parseInt(txtMaSP.getText());
            int qty = Integer.parseInt(txtSoluong.getText());
            int maSP = Integer.parseInt(txtMaSP.getText());
            Integer donGia = Integer.valueOf(txtDonGia.getText());
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
    }//GEN-LAST:event_btnThemGioHangActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // TODO add your handling code here:
        int i = tblSanPham.getSelectedRow();
        String maSP = tblSanPham.getValueAt(i, 0).toString();
        String tenSP = tblSanPham.getValueAt(i, 1).toString();
        String moTa = tblSanPham.getValueAt(i, 2).toString();
        String donGia = tblSanPham.getValueAt(i, 3).toString();
        String soLuongTonKho = tblSanPham.getValueAt(i, 4).toString();
        String hinhAnh = tblSanPham.getValueAt(i, 5).toString();
        String loai = tblSanPham.getValueAt(i, 6).toString();

        txtMaSP.setText(maSP);
        txtTenSP.setText(tenSP);
        txtMoTa.setText(moTa);
        txtDonGia.setText(donGia);
        txtSoLuongTonKho.setText(soLuongTonKho);
        txtHinhAnh.setText(hinhAnh);
        txtLoai.setText(loai);
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            // TODO add your handling code here:
            SanPhamDAO.delete(Integer.parseInt(txtMaSP.getText()));
            JOptionPane.showMessageDialog(null,"Đã xóa sản phẩm");
            
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnDrinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDrinkActionPerformed
        spac.loadData(tblSanPham, vaiTro,"Thức uống","");
        tblSanPham.setRowHeight(90);
        tblSanPham.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblSanPham.getColumnModel().getColumn(1).setPreferredWidth(20);
        tblSanPham.getColumnModel().getColumn(3).setPreferredWidth(20);
        tblSanPham.getColumnModel().getColumn(4).setPreferredWidth(20);
        tblSanPham.getColumnModel().getColumn(6).setPreferredWidth(20);
    }//GEN-LAST:event_btnDrinkActionPerformed

    private void btnFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFoodActionPerformed
        spac.loadData(tblSanPham, vaiTro,"Đồ ăn","");
        tblSanPham.setRowHeight(90);
        tblSanPham.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblSanPham.getColumnModel().getColumn(1).setPreferredWidth(20);
        tblSanPham.getColumnModel().getColumn(3).setPreferredWidth(20);
        tblSanPham.getColumnModel().getColumn(4).setPreferredWidth(20);
        tblSanPham.getColumnModel().getColumn(6).setPreferredWidth(20);        // TODO add your handling code here:
    }//GEN-LAST:event_btnFoodActionPerformed

    private void btnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllActionPerformed
        spac.loadData(tblSanPham, vaiTro,"","");
        tblSanPham.setRowHeight(90);
        tblSanPham.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblSanPham.getColumnModel().getColumn(1).setPreferredWidth(20);
        tblSanPham.getColumnModel().getColumn(3).setPreferredWidth(20);
        tblSanPham.getColumnModel().getColumn(4).setPreferredWidth(20);
        tblSanPham.getColumnModel().getColumn(6).setPreferredWidth(20);  
    }//GEN-LAST:event_btnAllActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        String filter = txtFilter.getText();
        spac.loadData(tblSanPham, vaiTro,"",filter);
        tblSanPham.setRowHeight(90);
        tblSanPham.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblSanPham.getColumnModel().getColumn(1).setPreferredWidth(20);
        tblSanPham.getColumnModel().getColumn(3).setPreferredWidth(20);
        tblSanPham.getColumnModel().getColumn(4).setPreferredWidth(20);
        tblSanPham.getColumnModel().getColumn(6).setPreferredWidth(20);  
    }//GEN-LAST:event_btnFilterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAll;
    private javax.swing.JButton btnDrink;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnFood;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemGioHang;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelSoluong;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtFilter;
    private javax.swing.JTextField txtHinhAnh;
    private javax.swing.JTextField txtLoai;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtSoLuongTonKho;
    private javax.swing.JTextField txtSoluong;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables

}
