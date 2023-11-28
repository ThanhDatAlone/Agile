    
package poly.edu.quanlydatban;

import java.io.Serializable;
import poly.edu.quanlyban.Ban;
import poly.edu.quanlykhachhang.KhachHang;

public class BanDat implements Serializable{
    private String maBanDat ;
    private int soLuongKhach;
    private String ngayDat ;
    private String gio;
    private String yeuCauDB;
    private KhachHang kh;
    private Ban b;

    public BanDat() {
    }

    public BanDat(String maBanDat) {
        this.maBanDat = maBanDat;
    }

    public BanDat(String maBanDat, int soLuongKhach, String ngayDat, String gio, String yeuCauDB, KhachHang kh, Ban b) {
        this.maBanDat = maBanDat;
        this.soLuongKhach = soLuongKhach;
        this.ngayDat = ngayDat;
        this.gio = gio;
        this.yeuCauDB = yeuCauDB;
        this.kh = kh;
        this.b = b;
    }

    public String getMaBanDat() {
        return maBanDat;
    }

    public void setMaBanDat(String maBanDat) {
        this.maBanDat = maBanDat;
    }

    public int getSoLuongKhach() {
        return soLuongKhach;
    }

    public void setSoLuongKhach(int soLuongKhach) {
        this.soLuongKhach = soLuongKhach;
    }

    public String getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(String ngayDat) {
        this.ngayDat = ngayDat;
    }

    public String getGio() {
        return gio;
    }

    public void setGio(String gio) {
        this.gio = gio;
    }

    public String getYeuCauDB() {
        return yeuCauDB;
    }

    public void setYeuCauDB(String yeuCauDB) {
        this.yeuCauDB = yeuCauDB;
    }

    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public Ban getB() {
        return b;
    }

    public void setB(Ban b) {
        this.b = b;
    }


    
}
