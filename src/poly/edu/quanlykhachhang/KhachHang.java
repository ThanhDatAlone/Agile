
package poly.edu.quanlykhachhang;

import java.io.Serializable;

public class KhachHang implements Serializable{
    private String maKH;
    private String TenKH;
    private String soDT;
    private String diaChi;

    public KhachHang() {
    }

    public KhachHang(String maKH) {
        this.maKH = maKH;
    }

    public KhachHang(String maKH, String TenKH, String soDT, String diaChi) {
        this.maKH = maKH;
        this.TenKH = TenKH;
        this.soDT = soDT;
        this.diaChi = diaChi;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
  
}
