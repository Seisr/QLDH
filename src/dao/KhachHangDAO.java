/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.KhachHang;
import java.sql.SQLException;

/**
 *
 * @author A715-42G
 */
public class KhachHangDAO implements DAOInterface {

//    hoTen,tenDN,pass,vaiTro,soDT,email
    public static int insert(KhachHang kh) throws SQLException {
        JDBC db = new JDBC();
        String insertSQL = "INSERT INTO KHACHHANG VALUES('"
                + kh.getTenDN() + "',N'"
                + kh.getTenKH() + "',N'"
                + kh.getMatKhau() + "',N'"
                + kh.getVaiTro() + "',"
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

    public KhachHang selectByID(KhachHang kh) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList selectByCond(String cond) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int insert(Object t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int update(Object t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int delete(Object t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object selectByID(Object t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
