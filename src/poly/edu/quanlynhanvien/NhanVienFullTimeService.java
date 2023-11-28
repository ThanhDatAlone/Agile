
package poly.edu.quanlynhanvien;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class NhanVienFullTimeService {

    private List<NhanVienFullTime> listNv = new ArrayList<>();

    public List<NhanVienFullTime> fakeData() {
        listNv.add(new NhanVienFullTime("F01", "Ngô Hồng Phúc", "0374441985", "Nghệ An ", "Quản lý", 30, 350, 0.0));
        listNv.add(new NhanVienFullTime("F02", "Đỗ Thị Ánh Ngọc", "0969957785", "Hà Nội", "Đầu bếp", 29, 350, 0.0));
        listNv.add(new NhanVienFullTime("F03", "Nguyễn Tuấn Anh ", "0377719008", "Tuyên Quang", "Phục vụ",30, 350, 0.0));
        listNv.add(new NhanVienFullTime("F04", "Nguyễn Tuấn Thuật", "0339649183", "Hồ Chí Minh", "Phục vụ",28,350, 0.0));
        listNv.add(new NhanVienFullTime("F05", "Nguyễn Thành Đạt", "0969957785", "Khánh Hòa", "Phục vụ",30,350, 0.0));
        return listNv;
    }

    public String addNhanVien(NhanVienFullTime nv) {
        if (nv != null && listNv.add(nv)) {
            return "Thêm thành công ";
        } else {
            return "Thêm thất bại ";
        }
    }

    public String deleteNhanVien(int viTri) {
        if (viTri >= 0 && listNv.remove(viTri) != null) {
            return "Xóa thành công ";
        } else {
            return "Xóa thất bại ";
        }
    }

    public String updateNhanVien(int viTri, NhanVienFullTime nv) {
        if (viTri >= 0) {
            if (nv != null) {
                listNv.set(viTri, nv);
                return "Sửa thành công";
            }
        }

        return "Sửa thất bại ";
    }

    public Integer find(String ma) {
        int i = 0;
        for (NhanVienFullTime nhanVien : listNv) {
            if (nhanVien.getMaNv().equals(ma)) {
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
                for (NhanVienFullTime nhanVien : listNv) {
                    oos.writeObject(nhanVien);
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
                    listNv.add((NhanVienFullTime) ois.readObject());
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
