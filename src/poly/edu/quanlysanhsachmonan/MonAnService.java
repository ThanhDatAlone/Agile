package poly.edu.quanlysanhsachmonan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MonAnService {

    private List<MonAn> listMonAn = new ArrayList<>();

    public List<MonAn> fakeData() {

        listMonAn.add(new MonAn("M01", "Súp rau củ kiểu Ý", 60000, "Món khai vị", "Đến từ Ý"));
        listMonAn.add(new MonAn("M02", "Súp cua bể hải sâm", 100000, "Món khai vị", "Hải sản tươi ngon"));
        listMonAn.add(new MonAn("M03", "Súp nghêu kem sữa", 50000, "Món khai vị", "Hải sản tươi ngon"));
        listMonAn.add(new MonAn("M04", "Salad hoàng đế", 70000, "Món khai vị", "Khai vị độc đáo Việt Nam"));
        listMonAn.add(new MonAn("M05", "Càng cua bách hoa", 50000, "Món khai vị", "Món ăn biển độc đáo"));
        listMonAn.add(new MonAn("M06", "Sushi thập cẩm", 100000, "Món chính", "Món ăn Nhật Bản"));
        listMonAn.add(new MonAn("M07", "Cá hồi nướng mè", 400000, "Món chính", " chế biến từ cá hồi tươi ngon"));
        listMonAn.add(new MonAn("M08", "Sườn non chiên Trung Hoa", 100000, "Món chính", "Ẩm thực Trung Hoa"));
        listMonAn.add(new MonAn("M09", "Bò áp chảo sốt tiêu đen", 1000000, "Món chính", "Bò Kobe"));
        listMonAn.add(new MonAn("M10", "Vịt quay Bắc Kinh", 400000, "Món chính", "Đặc sản China"));
        listMonAn.add(new MonAn("M11", "Thịt trâu gác bếp", 500000, "Món chính", "Đặc sản Tây Bắc"));
        listMonAn.add(new MonAn("M12", "Tôm sốt chanh dây", 460000, "Món chính", "Hương vị đặc biệt"));
        listMonAn.add(new MonAn("M13", "Tôm càng nướng wasabi", 990000, "Món chính", "Ẩm thực Nhật Bản"));
        listMonAn.add(new MonAn("M14", "Ghẹ rang muối kiểu Âu", 500000, "Món chính", "Đặc sản ẩm thực Châu Âu"));
        listMonAn.add(new MonAn("M15", "Nem nướng cuốn cá hồi và trứng cá đen", 800000, "Món chính", "Việt Nam"));
        listMonAn.add(new MonAn("M16", "Tôm hùm đút lò kiểu Pháp", 800000, "Món chính", "Ẩm thực Paris"));
        listMonAn.add(new MonAn("M17", "Bánh Su Kem", 30000, "Món tráng miệng", "100% kem tươi"));
        listMonAn.add(new MonAn("M18", "Bánh tiramisu", 30000, "Món tráng miệng", "Tráng miệng kiểu Ý"));
        listMonAn.add(new MonAn("M19", "Bánh mochi", 30000, "Món tráng miệng", "Món ăn truyền thống Nhật Bản"));
        listMonAn.add(new MonAn("M20", "Trái vải hạnh nhân lạnh", 30000, "Món tráng miệng", "Món ăn thanh mát"));

        return listMonAn;
    }

    public String addMonAn(MonAn ma) {
        if (ma != null && listMonAn.add(ma)) {
            return "Thêm thành công ";
        } else {
            return "Thêm thất bại ";
        }
    }

    public String deleteMonAn(int viTri) {
        if (viTri >= 0 && listMonAn.remove(viTri) != null) {
            return "Xóa thành công ";
        } else {
            return "Xóa thất bại ";
        }
    }

    public String updateMonAn(int viTri, MonAn ma) {
        if (viTri >= 0) {
            if (ma != null) {
                listMonAn.set(viTri, ma);
                return "Sửa thành công ";
            }
        }
        return "Sửa thất bại";
    }

    public Integer findMonAn(String ma) {
        int i = 0;
        for (MonAn monAn : listMonAn) {
            if (monAn.getMa().equals(ma)) {
                return i;
            }
            i++;
        }
        return -1;
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
                for (MonAn monAn : listMonAn) {
                    oos.writeObject(monAn);
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

    public String dociFile(String path) {
        File file = new File(path);
        FileInputStream fis = null;
        try {
            if (!file.exists()) {
                return " File không tồn tại";
            }
            fis = new FileInputStream(file);
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                while (fis.available() > 0) {
                    listMonAn.add((MonAn) ois.readObject());
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
