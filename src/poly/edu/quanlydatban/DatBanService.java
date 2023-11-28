
package poly.edu.quanlydatban;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import poly.edu.quanlyban.Ban;
import poly.edu.quanlykhachhang.KhachHang;

public class DatBanService {

    private List<BanDat> listBanDat = new ArrayList<>();

    public List<BanDat> fakeData() {
        Ban b1 = new Ban();
        KhachHang kh1 = new KhachHang();
        b1.setMaBan("B01");
        kh1.setMaKH("KH01");
        listBanDat.add(new BanDat("BD01", 5, "20/08/2023", "7:00-9:00", "Món âu ", kh1, b1));

        Ban b2 = new Ban();
        KhachHang kh2 = new KhachHang();
        b2.setMaBan("B02");
        kh2.setMaKH("KH02");
        listBanDat.add(new BanDat("BD02", 5, "21/07/2023", "10:00-12:00", "", kh2, b2));

        Ban b3 = new Ban();
        KhachHang kh3 = new KhachHang();
        b3.setMaBan("B03");
        kh3.setMaKH("KH03");
        listBanDat.add(new BanDat("BD03", 4, "13/07/2023", "13:00-15:00", "Bàn VIP", kh3, b3));

        Ban b4 = new Ban();
        KhachHang kh4 = new KhachHang();
        b4.setMaBan("B04");
        kh4.setMaKH("KH04");
        listBanDat.add(new BanDat("BD04", 8, "08/07/2023", "17:00-19:00", "", kh4, b4));

        Ban b5 = new Ban();
        KhachHang kh5 = new KhachHang();
        b5.setMaBan("B05");
        kh5.setMaKH("KH05");
        listBanDat.add(new BanDat("BD05", 16, "03/07/2023", "20:00-22:00", "Bàn VIP", kh5, b5));
        return listBanDat;
    }

    public String addBanDat(BanDat bd) {
        if (bd != null && listBanDat.add(bd)) {
            return "Thêm thành công ";
        } else {
            return "Thêm thất bại ";
        }
    }

    public String deleteBanDat(int viTri) {
        if (viTri >= 0 && listBanDat.remove(viTri) != null) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại ";
        }
    }

    public String updateNhanVien(int viTri, BanDat bd) {
        if (viTri >= 0) {
            if (bd != null) {
                listBanDat.set(viTri, bd);
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
                for (BanDat banDat : listBanDat) {
                    oos.writeObject(banDat);
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
                    listBanDat.add((BanDat) ois.readObject());

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
