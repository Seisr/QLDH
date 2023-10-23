/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.GioHang;

/**
 *
 * @author A715-42G
 */
public class GioHangDAO {
    private static ArrayList<GioHang> parse_obj (ResultSet rs) throws SQLException{
        ArrayList<GioHang> list_gh = new ArrayList();
        while (rs.next()) {
            list_gh.add(
                new GioHang(
                    Integer.valueOf(rs.getString("MAGIOHANG")),
                    Integer.valueOf(rs.getString("DONGIA")),
                    Integer.valueOf(rs.getString("SL")),
                    Integer.valueOf(rs.getString("DAHOANTHANH")),
                    Integer.parseInt(rs.getString("MASP")),
                    Integer.valueOf(rs.getString("MAKH"))
                )
            );
        }
        return  list_gh;
    }

    public static GioHang insert(Integer maKH, Integer maSP,Integer soLuong, Integer donGia) throws SQLException {
        try (Connection connection = JDBC.getConnection()) {
            String sql = "INSERT INTO GIOHANG OUTPUT Inserted.* VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, donGia);
            ps.setInt(2, soLuong);
            ps.setInt(3, 0);
            ps.setInt(4, maSP);
            ps.setInt(5, maKH);
            ResultSet rs = ps.executeQuery();
            return parse_obj(rs).get(0);
        }
    }

    public static GioHang updateSoluong(Integer maKH, Integer maSP,Integer soLuong) throws SQLException {
        try (Connection connection = JDBC.getConnection()) {
            String sql = "UPDATE GIOHANG SET SL=? OUTPUT Inserted.* WHERE MASP=?, MAKH=?";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, soLuong);
            ps.setInt(2, maSP);
            ps.setInt(3, maKH);
            ResultSet rs = ps.executeQuery();
            return parse_obj(rs).get(0);
        }
    }
    
    public static GioHang updateTrangThai(Integer maKH, Integer maGH,Boolean daHoanThanh) throws SQLException {
        try (Connection connection = JDBC.getConnection()) {
            String sql = "UPDATE GIOHANG SET DAHOANTHANH=? OUTPUT Inserted.* WHERE MAGIOHANG=? AND MAKH=?";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setBoolean(1, daHoanThanh);
            ps.setInt(2, maGH);
            ps.setInt(3, maKH);
            ResultSet rs = ps.executeQuery();
            return parse_obj(rs).get(0);
        }
    }

    public static GioHang delete(int MAGH) throws SQLException {
        try (Connection connection = JDBC.getConnection()) {
            String sql = "DELETE FROM GIOHANG OUTPUT Deleted.* WHERE MAGH=?";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, MAGH);
            ResultSet rs = ps.executeQuery();
            return parse_obj(rs).get(0);
        }
    }

    public static ArrayList<GioHang> selectAll(int maKH) throws SQLException {
        try (Connection connection = JDBC.getConnection()) {
            String sql = "SELECT * FROM GIOHANG WHERE DAHOANTHANH=0 AND MAKH=" + maKH;
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            return parse_obj(rs);
        }
    }

    public static GioHang selectByMaGH(int MAGH) throws SQLException {
        try (Connection connection = JDBC.getConnection()) {
            String sql = "SELECT * FROM GIOHANG WHERE MAGH=?";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, MAGH);
            ResultSet rs = ps.executeQuery();
            return parse_obj(rs).get(0);
        }
    }    
}
