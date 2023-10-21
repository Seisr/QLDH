/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

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
        JDBC db = new JDBC();
        String insertSQL = "INSERT INTO KHACHHANG VALUES('"
                + kh.getTenDN() + "',N'"
                + kh.getVaiTro() + "','"
                + kh.getTenKH() + "',N'"
                + kh.getMatKhau() + "',"
                + kh.getSoDT() + ",N'"
                + kh.getEmail() + "')";
        System.out.println(insertSQL);
        int kq = db.executeUpdate(insertSQL);
        return kq;
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

    public static ResultSet selectByMaKH(String kh) throws SQLException {
        JDBC db = new JDBC();
        String query = "SELECT TENDN, MATKHAU FROM KHACHHANG WHERE TENDN='"+kh+"'";
        System.out.println(query);
        ResultSet rs = db.executeQuery(query);
        System.out.println(rs);
        return rs;
    }

}
