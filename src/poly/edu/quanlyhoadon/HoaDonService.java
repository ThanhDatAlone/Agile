package poly.edu.quanlyhoadon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import poly.edu.quanlydatban.BanDat;
import poly.edu.quanlykhachhang.KhachHang;
import poly.edu.quanlynhanvien.NhanVienFullTime;

public class HoaDonService {

    private List<HoaDon> listHD = new ArrayList<>();

    public List<HoaDon> fakeData() {
        KhachHang kh1 = new KhachHang();
        kh1.setMaKH("KH01");
        NhanVienFullTime nv1 = new NhanVienFullTime();
        nv1.setMaNv("F01");
        BanDat maBD1 = new BanDat();
        maBD1.setMaBanDat("BD01");
        maBD1.setNgayDat("11/09/2004");
        listHD.add(new HoaDon("HD001", maBD1.getNgayDat(), 0222, "ATM", kh1, maBD1, nv1, "Đã thanh toán"));

        return listHD;
    }

        public String addHoaDon(HoaDon hd) {
        if (hd != null && listHD.add(hd)) {
            return "Thêm thành công";
        } else {
            return " Thêm thất bại";
        }
    }

    public String deleteHoaDon(int viTri) {
        if (viTri >= 0 && listHD.remove(viTri) != null) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại ";
        }
    }

    public String updateHoaDon(int viTri, HoaDon hd) {
        if (viTri >= 0) {
            if (hd != null) {
                listHD.set(viTri, hd);
                return "Sửa thành công";
            }
        }
        return "Sửa thất bại ";
    }

    public String ghiFile(String path) {
        File file = new File(path);
        FileOutputStream fos = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                for (HoaDon hd : listHD) {
                    oos.writeObject(hd);
                }
            }
            return "Ghi File thành công";
        } catch (Exception e) {
            return "Ghi File thất bại";
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
            }
        }
    }

    public String DocFile(String path) {
        File file = new File(path);
        FileInputStream fis = null;
        try {
            if (!file.exists()) {
                return " File không tồn tại";
            }
            fis = new FileInputStream(file);
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                while (fis.available() > 0) {
                    listHD.add((HoaDon) ois.readObject());

                }
            }
            return "Đọc File thành công";
        } catch (Exception e) {
            return "Đọc File thất bại";
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
            }
        }
    }
}
