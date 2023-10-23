/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author A715-42G
 */
public class GioHang {
    private Integer maGH;
    private Integer donGia;
    private Integer soLuong;
    private Boolean daHoanThanh;
    private Integer maSP;
    private Integer maKH;

    public GioHang(Integer maGH, Integer donGia, Integer soLuong, Integer daHoanThanh, int maSP, Integer maKH) {
        this.maGH = maGH;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.daHoanThanh = (daHoanThanh != 0);
        this.maSP = maSP;
        this.maKH = maKH;
    }

    public void setMaGH(Integer maGH) {
        this.maGH = maGH;
    }

    public void setDonGia(Integer donGia) {
        this.donGia = donGia;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public void setDaHoanThanh(Integer daHoanThanh) {
        this.daHoanThanh = daHoanThanh != 0;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public void setMaKH(Integer maKH) {
        this.maKH = maKH;
    }

    public Integer getMaGH() {
        return maGH;
    }

    public Integer getDonGia() {
        return donGia;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public Boolean getDaHoanThanh() {
        return daHoanThanh;
    }

    public Integer getMaSP() {
        return maSP;
    }

    public Integer getMaKH() {
        return maKH;
    }

}
