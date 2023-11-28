package poly.edu.quanlysanhsachmonan;

import java.io.Serializable;

public class MonAn implements Serializable {

    private String ma;
    private String ten;
    private double gia;
    private String loai;
    private String moTa;

    public MonAn() {
    }

    public MonAn(String ten, double gia) {
        this.ten = ten;
        this.gia = gia;
    }

    

    public MonAn(String ma, String ten, double gia, String loai, String moTa) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.loai = loai;
        this.moTa = moTa;
    }
    

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
    



}
