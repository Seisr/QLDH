/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.SanPham;
import java.util.*;

/**
 *
 * @author A715-42G
 */
public class SanPhamDAO  {
    private static ArrayList<SanPham> parse_obj (ResultSet rs) throws SQLException{
        ArrayList<SanPham> list_sp = new ArrayList();
        while (rs.next()) {
            list_sp.add(
                new SanPham(
                    Integer.valueOf(rs.getString("MASP")),
                    rs.getString("TENSP"),
                    rs.getString("MOTA"),
                    Integer.valueOf(rs.getString("DONGIA")),
                    Integer.parseInt(rs.getString("SLTONKHO")),
                    rs.getString("HINHANH"),
                    rs.getString("LOAI")
                )
            );
        }
        return  list_sp;
    }

    public static SanPham insert(SanPham sp) throws SQLException {
        try (Connection connection = JDBC.getConnection()) {
            String sql = "INSERT INTO SANPHAM OUTPUT Inserted.* VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, sp.getTenSP());
            ps.setString(2, sp.getMoTa());
            ps.setInt(3,sp.getDonGia());
            ps.setInt(4,sp.getSoLuongTonKho());
            ps.setString(5, sp.getHinhAnh());
            ps.setString(6, sp.getLoai());
            ResultSet rs = ps.executeQuery();
            return parse_obj(rs).get(0);
        }
    }

    public static SanPham update(SanPham sp) throws SQLException {
        try (Connection connection = JDBC.getConnection()) {
            String sql = "UPDATE SANPHAM SET TENSP=?, MOTA=?, DONGIA=?, SLTONKHO=?, HINHANH=?, LOAI=? OUTPUT Inserted.* WHERE MASP=?";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, sp.getTenSP());
            ps.setString(2, sp.getMoTa());
            ps.setInt(3,sp.getDonGia());
            ps.setInt(4,sp.getSoLuongTonKho());
            ps.setString(5, sp.getHinhAnh());
            ps.setString(6, sp.getLoai());
            ps.setString(7, String.valueOf(sp.getMaSP()));
            ResultSet rs = ps.executeQuery();
            return parse_obj(rs).get(0);
        }
    }

    public static SanPham delete(int MASP) throws SQLException {
        try (Connection connection = JDBC.getConnection()) {
            String sql = "DELETE FROM SANPHAM OUTPUT Deleted.* WHERE MASP=?";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, Integer.toString(MASP));
            ResultSet rs = ps.executeQuery();
            return parse_obj(rs).get(0);
        }
    }

    public static ArrayList<SanPham> selectAll(String loai) throws SQLException {
        try (Connection connection = JDBC.getConnection()) {
            String sql = "SELECT * FROM SANPHAM WHERE 1=1";
            if (!loai.isBlank()) {
                sql += " AND LOAI=N'" + loai + "'";
            }
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            return parse_obj(rs);
        }
    }

    public static SanPham selectByMaSP(int MASP) throws SQLException {
        try (Connection connection = JDBC.getConnection()) {
            String sql = "SELECT * FROM SANPHAM WHERE MASP=?";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, MASP);
            ResultSet rs = ps.executeQuery();
            return parse_obj(rs).get(0);
        }
    }
    
    public static void truTonKhoSP(int MASP, int soluongTonkho) throws SQLException {
        try (Connection connection = JDBC.getConnection()) {
            String sql = "UPDATE SANPHAM SET SLTONKHO = ? WHERE MASP=?";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, soluongTonkho);
            ps.setInt(2, MASP);
            ps.executeUpdate();
        }
    }
}
