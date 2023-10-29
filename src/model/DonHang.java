/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import  java.util.ArrayList;
/**
 *
 * @author A715-42G
 */
public class DonHang {
    private Integer maDH;
    private Integer maKH;
    private ArrayList<Integer> maGH;
    private String sdt;
    private String diachi;
    private Double tongTien;
    private TrangThaiDH trangThai;

    public DonHang() {
    }
    
    

    public DonHang(Integer maDH, Integer maKH, ArrayList<Integer> maGH, String sdt, String diachi, Double tongTien) {
        this.maDH = maDH;
        this.maKH = maKH;
        this.maGH = maGH;
        this.sdt = sdt;
        this.diachi = diachi;
        this.tongTien = tongTien;
        this.trangThai = TrangThaiDH.DANGXULY;
    }

    public DonHang(Integer maDH, Integer maKH, ArrayList<Integer> maGH, String sdt, String diachi, TrangThaiDH trangThai, double tongTien) {
        this.maDH = maDH;
        this.maKH = maKH;
        this.maGH = maGH;
        this.sdt = sdt;
        this.diachi = diachi;
        this.trangThai = trangThai;
        this.tongTien = tongTien;
    }

    public Integer getMaDH() {
        return maDH;
    }

    public Integer getMaKH() {
        return maKH;
    }

    public ArrayList<Integer> getMaGH() {
        return maGH;
    }

    public String getSdt() {
        return sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public TrangThaiDH getTrangThai() {
        return trangThai;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setMaDH(Integer maDH) {
        this.maDH = maDH;
    }

    public void setMaKH(Integer maKH) {
        this.maKH = maKH;
    }

    public void setMaGH(ArrayList<Integer> maGH) {
        this.maGH = maGH;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setTrangThai(TrangThaiDH trangThai) {
        this.trangThai = trangThai;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
}
