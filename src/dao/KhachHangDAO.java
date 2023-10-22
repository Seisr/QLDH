/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.KhachHang;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author A715-42G
 */
public class KhachHangDAO {

//    hoTen,tenDN,pass,vaiTro,soDT,email
    public static int insert(KhachHang kh) throws SQLException {
        try (Connection connection = JDBC.getConnection()) {
            String sql = "INSERT INTO KHACHHANG OUTPUT Inserted.MAKH VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, kh.getTenKH());
            ps.setString(2, kh.getVaiTro());
            ps.setString(3, kh.getTenKH());
            ps.setString(4, kh.getMatKhau());
            ps.setString(5, kh.getSoDT());
            ps.setString(6, kh.getEmail());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return Integer.parseInt(rs.getString("MAKH"));
            }
        }
        return 0;
    }

    public static int update(KhachHang kh) throws SQLException {
        JDBC db = new JDBC();
        String updateSQL = "UPDATE KHACHHANG"
                + "SET TENKH =N'" + kh.getTenKH() + "'"
                + ",TENDN=N'" + kh.getTenDN() + "'"
                + ",MATKHAU=N'" + kh.getMatKhau() + "'"
                + ",VAITRO=N'" + kh.getVaiTro() + "'"
                + ",SODT='" + kh.getSoDT() + "'"
                + ",EMAIL=N'" + kh.getEmail() + "'"
                + "WHERE MAKH='" + kh.getMaKH() + "'";
        System.out.println(updateSQL);
        int kq = db.executeUpdate(updateSQL);
        return kq;

    }

    public static int delete(KhachHang kh) throws SQLException {
        JDBC db = new JDBC();
        String deleteSQL = "DELETE FROM KHACHHANG"
                + "WHERE MAKH='" + kh.getMaKH() + "'";
        System.out.println(deleteSQL);
        int kq = db.executeUpdate(deleteSQL);
        return kq;
    }

    public static ResultSet selectAll() throws SQLException {
        JDBC db = new JDBC();
        ResultSet rs = db.executeQuery("SELECT * FROM KHACHHANG");
        return rs;
    }

    public static KhachHang selectByTenDN(String tendn) throws SQLException {
        Connection connection = JDBC.getConnection();
        String sql = "SELECT TOP 1 * FROM KHACHHANG WHERE TENDN=?";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setString(1, tendn);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            KhachHang kh = new KhachHang();
            kh.setMaKH(Integer.parseInt(rs.getString("MAKH")));
            kh.setEmail(rs.getString("EMAIL"));
            kh.setTenKH(rs.getString("HOTEN"));
            kh.setSoDT(rs.getString("SODT"));
            kh.setTenDN(rs.getString("TENDN"));
            kh.setVaiTro(rs.getString("VAITRO"));
            kh.setMatKhau(rs.getString("MATKHAU"));
            return kh;
        }
        return null;
    }
}
