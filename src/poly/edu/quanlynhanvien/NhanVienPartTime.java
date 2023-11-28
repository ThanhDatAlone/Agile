/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.quanlynhanvien;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class NhanVienPartTime implements Serializable {

    private String maNv;
    private String tenNv;
    private String SDT;
    private String diaChi;
    private double soGioLV;
    private double luongNV1gio;

    public NhanVienPartTime() {
    }

    public NhanVienPartTime(String maNv, String tenNv, String SDT, String diaChi, double soGioLV, double luongNV1gio) {
        this.maNv = maNv;
        this.tenNv = tenNv;
        this.SDT = SDT;
        this.diaChi = diaChi;
        this.soGioLV = soGioLV;
        this.luongNV1gio = luongNV1gio;
    }

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public String getTenNv() {
        return tenNv;
    }

    public void setTenNv(String tenNv) {
        this.tenNv = tenNv;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public double getSoGioLV() {
        return soGioLV;
    }

    public void setSoGioLV(int soGioLV) {
        this.soGioLV = soGioLV;
    }

    public double getLuongNV1gio() {
        return luongNV1gio;
    }

    public void setLuongNV1gio(double luongNV1gio) {
        this.luongNV1gio = luongNV1gio;
    }

    public double LuongNhanVienPastTime(double soGio, double luong1Gio) {
        return soGio * luong1Gio;
    }
}
