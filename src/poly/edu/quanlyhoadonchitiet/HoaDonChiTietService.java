package poly.edu.quanlyhoadonchitiet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import poly.edu.quanlyhoadon.HoaDon;
import poly.edu.quanlysanhsachmonan.MonAn;

public class HoaDonChiTietService {

    private List<HoaDonChiTiet> listHDCT = new ArrayList<>();

    public List<HoaDonChiTiet> fakeData() {
        MonAn monAn1 = new MonAn();
        monAn1.setMa("M01");
        monAn1.setTen("Vịt quay Bắc Kinh");
        monAn1.setGia(400000);
        HoaDon hd1 = new HoaDon();
        hd1.setMaHD("HD01");
        HoaDonChiTiet hdct1 = new HoaDonChiTiet( 7, 0, monAn1, hd1);
        listHDCT.add(hdct1);

        MonAn monAn2 = new MonAn();
        monAn2.setMa("M02");
        monAn2.setTen("Thịt trâu gác bếp");
        monAn2.setGia(500000);
        HoaDon hd2 = new HoaDon();
        hd2.setMaHD("HD02");
        HoaDonChiTiet hdct2 = new HoaDonChiTiet( 5, 0, monAn2, hd2);
        listHDCT.add(hdct2);

        MonAn monAn3 = new MonAn();
        monAn3.setMa("M03");
        monAn3.setTen("Cơm lam");
        monAn3.setGia(50000);
        HoaDon hd3 = new HoaDon();
        hd3.setMaHD("HD03");
        HoaDonChiTiet hdct3 = new HoaDonChiTiet(10, 0, monAn3,hd3);
        listHDCT.add(hdct3);
        
        MonAn monAn4= new MonAn();
        monAn4.setMa("M04");
        monAn4.setTen("Bánh mochi");
        monAn4.setGia(50000);
        HoaDon hd4 = new HoaDon();
        hd4.setMaHD("HD04");
        HoaDonChiTiet hdct4 = new HoaDonChiTiet(2, 0, monAn4,hd4);
        listHDCT.add(hdct4);
        
        MonAn monAn5 = new MonAn();
        monAn5.setMa("M05");
        monAn5.setTen("Sushi thập cẩm");
        monAn5.setGia(50000);
        HoaDon hd5 = new HoaDon();
        hd5.setMaHD("HD05");
        HoaDonChiTiet hdct5 = new HoaDonChiTiet(5, 0, monAn5,hd5);
        listHDCT.add(hdct5);

        return listHDCT;
    }

    public String addHoaDonCT(HoaDonChiTiet hdct) {
        if (hdct != null && listHDCT.add(hdct)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    public String deleteHoaDonCT(int viTri) {
        if (viTri >= 0 && listHDCT.remove(viTri) != null) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại ";
        }
    }

    public String updateHoaDonCT(int viTri, HoaDonChiTiet hdct) {
        if (viTri >= 0) {
            if (hdct != null) {
                listHDCT.set(viTri, hdct);
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
                for (HoaDonChiTiet hdct : listHDCT) {
                    oos.writeObject(hdct);
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
                    listHDCT.add((HoaDonChiTiet) ois.readObject());

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
