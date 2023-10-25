/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author A715-42G
 */
public class KhachHang {

    private int maKH;
    private String hoten;
    private String tenDN;
    private String matKhau;
    private String vaiTro = "user";
    private String soDT;
    private String email;

    public KhachHang() {
    }

//    hoTen,tenDN,pass,vaiTro,soDT,email
    public KhachHang(String tenDN, String hoten, String matKhau, String soDT, String email) {
        this.hoten = hoten;
        this.tenDN = tenDN;
//        this.vaiTro = vaiTro;
        this.matKhau = matKhau;
        this.soDT = soDT;
        this.email = email;
    }

    public KhachHang(String tenDN, String hoten, String matKhau, String vaiTro, String soDT, String email) {
        this.hoten = hoten;
        this.tenDN = tenDN;
        this.vaiTro = vaiTro;
        this.matKhau = matKhau;
        this.soDT = soDT;
        this.email = email;
    }

    public KhachHang(int maKH, String tenDN, String hoten, String matKhau, String vaiTro, String soDT, String email) {
        this.maKH = maKH;
        this.hoten = hoten;
        this.tenDN = tenDN;
        this.vaiTro = vaiTro;
        this.matKhau = matKhau;
        this.soDT = soDT;
        this.email = email;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoten;
    }

    public void setHoTen(String hoTen) {
        this.hoten = hoTen;
    }

    public String getTenDN() {
        return tenDN;
    }

    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
