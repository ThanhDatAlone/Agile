package poly.edu.quanlynhanvien;

import java.io.Serializable;

public class NhanVienFullTime implements Serializable {

    private String maNv;
    private String tenNv;
    private String SDT;
    private String diaChi;
    private String chucVu;
    private int ngayLamViec;
    private double luong1Ngay;
    private double luong;

    public NhanVienFullTime() {
    }

    public NhanVienFullTime(String maNv) {
        this.maNv = maNv;
    }

    public NhanVienFullTime(String maNv, String tenNv, String SDT, String diaChi, String chucVu, int ngayLamViec, double luong1Ngay, double luong) {
        this.maNv = maNv;
        this.tenNv = tenNv;
        this.SDT = SDT;
        this.diaChi = diaChi;
        this.chucVu = chucVu;
        this.ngayLamViec = ngayLamViec;
        this.luong1Ngay = luong1Ngay;
        this.luong = luong;
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

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public int getNgayLamViec() {
        return ngayLamViec;
    }

    public void setNgayLamViec(int ngayLamViec) {
        this.ngayLamViec = ngayLamViec;
    }

    public double getLuong1Ngay() {
        return luong1Ngay;
    }

    public void setLuong1Ngay(double luong1Ngay) {
        this.luong1Ngay = luong1Ngay;
    }

    public double getLuong() {
        double luong = 0;
        if (chucVu.equals("Quản lý")) {
            luong = ngayLamViec * luong1Ngay + 1000.0; // Thêm 1000000.0 vào lương nếu là Quản lý
        } else if (chucVu.equals("Đầu bếp")) {
            luong = ngayLamViec * luong1Ngay + 500.0; // Thêm 500000.0 vào lương nếu là Đầu bếp
        } else {
            luong = ngayLamViec * luong1Ngay; // Sử dụng mức lương mỗi ngày cho các trường hợp còn lại
        }
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }
}
