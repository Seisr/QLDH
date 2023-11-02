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
import java.util.ArrayList;

/**
 *
 * @author A715-42G
 */
public class KhachHangDAO {

    public static KhachHang insert(KhachHang kh) throws SQLException {
        try (Connection connection = JDBC.getConnection()) {
            String sql = "INSERT INTO KHACHHANG OUTPUT Inserted.* VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, kh.getTenDN());
            ps.setString(2, kh.getVaiTro());
            ps.setString(3, kh.getHoTen());
            ps.setString(4, kh.getMatKhau());
            ps.setString(5, kh.getSoDT());
            ps.setString(6, kh.getEmail());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang newkh = new KhachHang();
                newkh.setMaKH(Integer.parseInt(rs.getString("MAKH")));
                newkh.setEmail(rs.getString("EMAIL"));
                newkh.setHoTen(rs.getString("HOTEN"));
                newkh.setSoDT(rs.getString("SODT"));
                newkh.setTenDN(rs.getString("TENDN"));
                newkh.setVaiTro(rs.getString("VAITRO"));
                newkh.setMatKhau(rs.getString("MATKHAU"));
                return newkh;
            }
        }
        return null;
    }

    public static KhachHang update(KhachHang kh) throws SQLException {
        try (Connection connection = JDBC.getConnection()) {
            String sql = "UPDATE KHACHHANG SET TENDN=?, VAITRO=?, HOTEN=?, SODT=?, EMAIL=? OUTPUT Inserted.* WHERE MAKH=?";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, kh.getTenDN());
            ps.setString(2, kh.getVaiTro());
            ps.setString(3, kh.getHoTen());
            ps.setString(5, kh.getSoDT());
            ps.setString(6, kh.getEmail());
            ps.setString(7, Integer.toString(kh.getMaKH()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang newkh = new KhachHang();
                newkh.setMaKH(Integer.parseInt(rs.getString("MAKH")));
                newkh.setEmail(rs.getString("EMAIL"));
                newkh.setHoTen(rs.getString("HOTEN"));
                newkh.setSoDT(rs.getString("SODT"));
                newkh.setTenDN(rs.getString("TENDN"));
                newkh.setVaiTro(rs.getString("VAITRO"));
                newkh.setMatKhau(rs.getString("MATKHAU"));
                return newkh;
            }
        }
        return null;
    }

    public static void update1(KhachHang kh) throws SQLException {
        try (Connection connection = JDBC.getConnection()) {
            String sql = "UPDATE KHACHHANG SET TENDN=?, VAITRO=?, HOTEN=?, MATKHAU=?, SODT=?, EMAIL=? OUTPUT Inserted.* WHERE MAKH=?";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, kh.getTenDN());
            ps.setString(2, kh.getVaiTro());
            ps.setString(3, kh.getHoTen());
            ps.setString(4, kh.getMatKhau());
            ps.setString(5, kh.getSoDT());
            ps.setString(6, kh.getEmail());
            ps.setString(7, String.valueOf(kh.getMaKH()));
            ps.executeQuery();
        }
    }

    public static KhachHang delete(KhachHang kh) throws SQLException {
        try (Connection connection = JDBC.getConnection()) {
            String sql = "DELETE FROM KHACHHANG OUTPUT Deleted.* WHERE MAKH=?";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, Integer.toString(kh.getMaKH()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang newkh = new KhachHang();
                newkh.setMaKH(Integer.parseInt(rs.getString("MAKH")));
                newkh.setEmail(rs.getString("EMAIL"));
                newkh.setHoTen(rs.getString("HOTEN"));
                newkh.setSoDT(rs.getString("SODT"));
                newkh.setTenDN(rs.getString("TENDN"));
                newkh.setVaiTro(rs.getString("VAITRO"));
                newkh.setMatKhau(rs.getString("MATKHAU"));
                return newkh;
            }
        }
        return null;
    }

    public static void delete(int MAKH) throws SQLException {
        try (Connection connection = JDBC.getConnection()) {
            String sql = "DELETE FROM KHACHHANG OUTPUT Deleted.* WHERE MAKH=?";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, Integer.toString(MAKH));
            ResultSet rs = ps.executeQuery();
        }
    }

    public static ArrayList<KhachHang> selectAll1() throws SQLException {
        JDBC db = new JDBC();
        ResultSet rs = db.executeQuery("SELECT * FROM KHACHHANG");
        ArrayList<KhachHang> list_kh = new ArrayList<>();
        while (rs.next()) {
            KhachHang newkh = new KhachHang();
            newkh.setMaKH(Integer.parseInt(rs.getString("MAKH")));
            newkh.setEmail(rs.getString("EMAIL"));
            newkh.setHoTen(rs.getString("HOTEN"));
            newkh.setSoDT(rs.getString("SODT"));
            newkh.setTenDN(rs.getString("TENDN"));
            newkh.setVaiTro(rs.getString("VAITRO"));
            newkh.setMatKhau(rs.getString("MATKHAU"));
            list_kh.add(newkh);
        }
        System.out.println(list_kh);
        return list_kh;
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
            kh.setHoTen(rs.getString("HOTEN"));
            kh.setSoDT(rs.getString("SODT"));
            kh.setTenDN(rs.getString("TENDN"));
            kh.setVaiTro(rs.getString("VAITRO"));
            kh.setMatKhau(rs.getString("MATKHAU"));
            return kh;
        }
        return null;
    }

    public static String countKH() throws SQLException {
        JDBC db = new JDBC();
        ResultSet rs = db.executeQuery("SELECT COUNT(MAKH) AS COUNTKH FROM KHACHHANG");
        String count;
        while (rs.next()) {
            count = rs.getString("COUNTKH");
            return count;
        }
        return null;
    }

}
