/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigInteger;

/**
 *
 * @author A715-42G
 */
public class KhachHang {

    private BigInteger maKH;
    private String tenKH;
    private String tenDN;
    private String matKhau;
    private String vaiTro = "user";
    private String soDT;
    private String email;

//    hoTen,tenDN,pass,vaiTro,soDT,email
    public KhachHang(String tenDN, String tenKH, String matKhau , String soDT, String email) {
        this.tenKH = tenKH;
        this.tenDN = tenDN;
//        this.vaiTro = vaiTro;
        this.matKhau = matKhau;
        this.soDT = soDT;
        this.email = email;
    }

    public BigInteger getMaKH() {
        return maKH;
    }

    public void setMaKH(BigInteger maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String hoTen) {
        this.tenKH = tenKH;
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
