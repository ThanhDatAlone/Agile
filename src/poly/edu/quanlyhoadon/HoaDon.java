package poly.edu.quanlyhoadon;

import java.io.Serializable;
import poly.edu.quanlydatban.BanDat;
import poly.edu.quanlykhachhang.KhachHang;
import poly.edu.quanlynhanvien.NhanVienFullTime;

public class HoaDon implements Serializable {

    private String maHD;
    private String ngay;
    private double tongTien;
    private String phuongThucTT;
    private KhachHang khachHang;
    private BanDat banDat;
    private NhanVienFullTime nhanVienF;
    private String trangThai;

    public HoaDon() {
    }

    public HoaDon(String maHD, String ngay, double tongTien, String phuongThucTT, KhachHang khachHang, BanDat banDat, NhanVienFullTime nhanVienF, String trangThai) {
        this.maHD = maHD;
        this.ngay = ngay;
        this.tongTien = tongTien;
        this.phuongThucTT = phuongThucTT;
        this.khachHang = khachHang;
        this.banDat = banDat;
        this.nhanVienF = nhanVienF;
        this.trangThai = trangThai;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getPhuongThucTT() {
        return phuongThucTT;
    }

    public void setPhuongThucTT(String phuongThucTT) {
        this.phuongThucTT = phuongThucTT;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public BanDat getBanDat() {
        return banDat;
    }

    public void setBanDat(BanDat banDat) {
        this.banDat = banDat;
    }

    public NhanVienFullTime getNhanVienF() {
        return nhanVienF;
    }

    public void setNhanVienF(NhanVienFullTime nhanVienF) {
        this.nhanVienF = nhanVienF;
    }

    public String getTrangThai() {
        if (getPhuongThucTT().equals("")) {
            setTrangThai("Chưa thanh toán");
        } else {
            setTrangThai("đã Thanh Toán");
        }
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
