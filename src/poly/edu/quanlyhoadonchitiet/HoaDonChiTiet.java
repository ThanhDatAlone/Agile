package poly.edu.quanlyhoadonchitiet;

import poly.edu.quanlyhoadon.HoaDon;
import poly.edu.quanlysanhsachmonan.MonAn;

public class HoaDonChiTiet {

    private int soLuong;
    private double thanhTien;
    private MonAn monAn;
    private HoaDon hoaDon;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int soLuong, double thanhTien, MonAn monAn, HoaDon hoaDon) {
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
        this.monAn = monAn;
        this.hoaDon = hoaDon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public double getThanhTien(int soLuong2, double donGia2) {
        thanhTien = soLuong2 * donGia2;
        return thanhTien;
    }

    public MonAn getMonAn() {
        return monAn;
    }

    public void setMonAn(MonAn monAn) {
        this.monAn = monAn;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public double tongTienTheoMa(String maHDF) {
        thanhTien = 0;
        if (hoaDon.getMaHD().equals(maHDF)) {
            for (int i = 0; i < 10; i++) {
                thanhTien = thanhTien + i;
            }

        }
        return thanhTien;
    }

}
