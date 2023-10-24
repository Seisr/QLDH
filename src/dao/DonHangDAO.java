/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import model.DonHang;
import model.KhachHang;
import model.SanPham;
import model.TrangThaiDH;

/**
 *
 * @author A715-42G
 */
public class DonHangDAO {

    private static ArrayList<DonHang> parse_obj(ResultSet rs) throws SQLException {
        ArrayList<DonHang> list_dh = new ArrayList();
        while (rs.next()) {
            String[] parts = rs.getString("MAGIOHANG").split(",");
            ArrayList<Integer> magh = new ArrayList();
            for (String i : parts) {
                magh.add(Integer.valueOf(i.trim()));
            }
            TrangThaiDH tt = switch (rs.getString("TRANGTHAI")) {
                case ("Ðã hoàn thành") ->
                    TrangThaiDH.DAHOANTHANH;
                case ("Đang xử lý") ->
                    TrangThaiDH.DANGXULY;
                default ->
                    TrangThaiDH.DANGGIAOHANG;
            };
            list_dh.add(
                    new DonHang(
                            Integer.valueOf(rs.getString("MADONHANG")),
                            Integer.valueOf(rs.getString("MAKH")),
                            magh,
                            rs.getString("SODT"),
                            rs.getString("DIACHI"),
                            tt,
                            Double.parseDouble(rs.getString("TONGTIEN"))
                    )
            );
        }
        return list_dh;
    }

    public static DonHang insert(DonHang dh) throws SQLException {
        try (Connection connection = JDBC.getConnection()) {
            String sql = "INSERT INTO DONHANG OUTPUT Inserted.* VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareCall(sql);
            String magh = Arrays.toString(dh.getMaGH().toArray());
            String tt = switch (dh.getTrangThai()) {
                case DAHOANTHANH ->
                    "Ðã hoàn thành";
                case DANGXULY ->
                    "Đang xử lý";
                default ->
                    "Đang giao hàng";
            };
            ps.setString(1, String.valueOf(magh.substring(1, magh.length() - 1)));
            ps.setInt(2, dh.getMaKH());
            ps.setString(3, dh.getSdt().trim());
            ps.setString(4, dh.getDiachi().trim());
            ps.setString(5, tt);
            ps.setDouble(6, dh.getTongTien());

            ResultSet rs = ps.executeQuery();

            return parse_obj(rs).get(0);
        }
    }

    public static DonHang updateTrangThai(Integer maKH, Integer maDH, TrangThaiDH trangThai) throws SQLException {
        try (Connection connection = JDBC.getConnection()) {
            String sql = "UPDATE DONHANG SET TRANGTHAI=? OUTPUT Inserted.* WHERE MADONHANG=?, MAKH=?";
            PreparedStatement ps = connection.prepareCall(sql);
            String tt = switch (trangThai) {
                case DAHOANTHANH ->
                    "Ðã hoàn thành";
                case DANGXULY ->
                    "Đang xử lý";
                default ->
                    "Đang giao hàng";
            };
            ps.setString(1, tt);
            ps.setInt(2, maDH);
            ps.setInt(3, maKH);
            ResultSet rs = ps.executeQuery();
            return parse_obj(rs).get(0);
        }
    }
//    public static ArrayList<DonHang> selectAll() throws SQLException {
//        try (Connection connection = JDBC.getConnection()) {
//            String sql = "SELECT * FROM DONHANG WHERE 1=1";
////            if (!loai.isBlank()) {
////                sql += " AND LOAI='" + loai + "'";
////            }
//            PreparedStatement ps = connection.prepareCall(sql);
//            ResultSet rs = ps.executeQuery();
//            return parse_obj(rs);
//        }
//    }

//    public static ResultSet selectAll() throws SQLException {
////        JDBC db = new JDBC();
//        try (Connection connection = JDBC.getConnection()) {
//            String sql = "SELECT * FROM DONHANG";
//            PreparedStatement ps = connection.prepareCall(sql);
//            ResultSet rs = ps.executeQuery();
////        ResultSet rs = db.executeQuery("SELECT * FROM SANPHAM");
////        db.close();
//            System.out.println(rs);
//
//            return rs;
//        }
//
//    }
    public static ArrayList<DonHang> selectAll1() throws SQLException {
        JDBC db = new JDBC();
        ResultSet rs = db.executeQuery("SELECT * FROM DONHANG");
        ArrayList<DonHang> list_dh = new ArrayList<>();
        DonHang newdh = new DonHang();
        while (rs.next()) {
            newdh.setMaDH(Integer.parseInt(rs.getString("MADONHANG")));
            newdh.setMaKH(Integer.parseInt(rs.getString("MAKH")));
            newdh.setSdt(rs.getString("SODT"));
            newdh.setDiachi(rs.getString("DIACHI"));
            newdh.setTongTien(Double.parseDouble(rs.getString("TONGTIEN")));

            list_dh.add(newdh);
        }
        return list_dh;

    }

    public static ResultSet selectAll() throws SQLException {
        JDBC db = new JDBC();
        ResultSet rs = db.executeQuery("SELECT * FROM DONHANG ");
        return rs;
    }
    
    
    public static ResultSet selectByMaKH(int maKH) throws SQLException {
        JDBC db = new JDBC();
        ResultSet rs = db.executeQuery("SELECT * FROM DONHANG WHERE MAKH="+maKH);
        return rs;
    }

    public static ArrayList<DonHang> selectByMaKH(Integer maKH, TrangThaiDH trangThai) throws SQLException {
        try (Connection connection = JDBC.getConnection()) {
            ArrayList args = new ArrayList();
            String sql = "SELECT * FROM DONHANG WHERE 1=1";
            if (maKH != 0) {
                sql += " AND MAKH= ?";
                args.add(maKH);
            }
            if (trangThai != TrangThaiDH.NONE) {
                sql += " AND TRANGTHAI= ?";
                String tt = switch (trangThai) {
                    case DAHOANTHANH ->
                        "Ðã hoàn thành";
                    case DANGXULY ->
                        "Đang xử lý";
                    default ->
                        "Đang giao hàng";
                };
                args.add(tt);
            }

            PreparedStatement ps = connection.prepareCall(sql);
            for (int i = 0; i < args.size(); i++) {
                ps.setObject(i + 1, args.get(i));
            }
            ResultSet rs = ps.executeQuery();
            return parse_obj(rs);
        }
    }
}
