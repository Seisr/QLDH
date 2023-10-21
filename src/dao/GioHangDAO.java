/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.SanPham;

/**
 *
 * @author A715-42G
 */
public class GioHangDAO {
      public static int insert(SanPham sp) throws SQLException {

        JDBC db = new JDBC();
        String insertSQL = "INSERT INTO GIOHANG VALUES('"
//                + sp.getMaSP() + "',N'"
                + sp.getTenSP() + "',N'"
                + sp.getMoTa() + "','"
                + sp.getDonGia() + "','"
                + sp.getSoLuongTonKho() + "',N'"
                + sp.getHinhAnh() + "',N'"
                + sp.getLoai() + "') ";
                System.out.println(insertSQL);
        int kq = db.executeUpdate(insertSQL);
//        db.close();
        return kq;
    }

    public static int update(SanPham sp) throws SQLException {
        JDBC db = new JDBC();
        String updateSQL = "UPDATE SANPHAM"
//                + " SET MASP=N'" + sp.getMaSP() + "'"
                + " SET TENSP=N'" + sp.getTenSP() + "'"
                + ",MOTA=N'" + sp.getMoTa() + "'"
                + ",DONGIA='" + sp.getDonGia() + "'"
                + ",SLTONKHO='" + sp.getSoLuongTonKho() + "'"
                + ",HINHANH=N'" + sp.getHinhAnh() + "'"
                + ",LOAI=N'" + sp.getHinhAnh() + "'"
                + "WHERE MASP='" + sp.getMaSP() + "'";
        System.out.println(updateSQL);
        int kq = db.executeUpdate(updateSQL);
//        db.close();
        return kq;
    }

    public static int delete(int MASP) throws SQLException {
        JDBC db = new JDBC();
        String deleteSQL = "DELETE FROM SANPHAM"
                + " WHERE MASP='" + MASP + "'";
        int kq = db.executeUpdate(deleteSQL);
//        db.close();
        return kq;
    }

    public static ResultSet selectAll() throws SQLException {
        JDBC db = new JDBC();
        ResultSet rs = db.executeQuery("SELECT * FROM SANPHAM");
//        db.close();
        return rs;
    }

    public static ResultSet selectByMSSV(int MASP) throws SQLException {
        JDBC db = new JDBC();
        ResultSet rs = db.executeQuery("SELECT * FROM SANPHAM WHERE MASP='"+MASP+"'");
        db.close();
        return rs;
    }

    
}
