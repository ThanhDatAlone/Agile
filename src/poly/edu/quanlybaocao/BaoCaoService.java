package poly.edu.quanlybaocao;

import poly.edu.quanlyhoadon.HoaDon;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaoCaoService {

    private List<BaoCao> listBC = new ArrayList<>();

 
   // Các thành viên và phương thức của lớp BaoCao

    public List<BaoCao> fakeData() {
        List<BaoCao> listBC = new ArrayList<>();

        HoaDon hd1 = new HoaDon();
        hd1.setNgay("11/09/2004");
        listBC.add(new BaoCao(hd1, 9999));

        HoaDon hd12 = new HoaDon();
        hd12.setNgay("11/09/2004");
        listBC.add(new BaoCao(hd12, 665));

        HoaDon hd122 = new HoaDon();
        hd122.setNgay("11/09/2014");
        listBC.add(new BaoCao(hd122, 95676));

        // Tính tổng doanh thu theo ngày
        Map<String, Integer> doanhThuTheoNgay = new HashMap<>();
        for (BaoCao baoCao : listBC) {
            String ngay = baoCao.getHoaDon().getNgay(); 
            int doanhThu = (int) baoCao.getDoanhThu(); 

          
            doanhThuTheoNgay.put(ngay, doanhThuTheoNgay.getOrDefault(ngay, 0) + doanhThu);
        }

 
        List<BaoCao> listBCWithTotal = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : doanhThuTheoNgay.entrySet()) {
            HoaDon hoaDon = new HoaDon();
            hoaDon.setNgay(entry.getKey()); 

            int doanhThu = entry.getValue(); 

            listBCWithTotal.add(new BaoCao(hoaDon, doanhThu));
        }

        return listBCWithTotal;
    }

    public String addBaoCao(BaoCao bc) {
        if (bc != null && listBC.add(bc)) {
            return "Thêm thành công ";
        } else {
            return "Thêm thất bại ";
        }
    }

    public String deleteBaoCao(int viTri) {
        if (viTri >= 0 && listBC.remove(viTri) != null) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại ";
        }
    }

    public String updateBaoCao(int viTri, BaoCao bc) {
        if (viTri >= 0) {
            if (bc != null) {
                listBC.set(viTri, bc);
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
                for (BaoCao bc : listBC) {
                    oos.writeObject(bc);
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
                    listBC.add((BaoCao) ois.readObject());

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
