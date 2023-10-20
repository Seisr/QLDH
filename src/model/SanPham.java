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
public class SanPham {

    private BigInteger maSP;
    private String tenSP;
    private String moTa;
    private BigInteger donGia;
    private int soLuongTonKho;
    private String hinhAnh;
    private String loai;

    public SanPham(BigInteger maSP, String tenSP, String moTa, BigInteger donGia, int soLuongTonKho, String hinhAnh, String loai) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.moTa = moTa;
        this.donGia = donGia;
        this.soLuongTonKho = soLuongTonKho;
        this.hinhAnh = hinhAnh;
        this.loai = loai;
    }

    public BigInteger getMaSP() {
        return maSP;
    }

    public void setMaSP(BigInteger maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public BigInteger getDonGia() {
        return donGia;
    }

    public void setDonGia(BigInteger donGia) {
        this.donGia = donGia;
    }

    public int getSoLuongTonKho() {
        return soLuongTonKho;
    }

    public void setSoLuongTonKho(int soLuongTonKho) {
        this.soLuongTonKho = soLuongTonKho;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
    

}
