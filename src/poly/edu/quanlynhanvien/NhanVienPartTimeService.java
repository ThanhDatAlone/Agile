/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.quanlynhanvien;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhanVienPartTimeService {

    List<NhanVienPartTime> listPartTime = new ArrayList<>();

    public List<NhanVienPartTime> fakeData() {
        listPartTime.add(new NhanVienPartTime("P01", "Nguyễn Ngọc Lan", "0987654321", "Hải Phòng", 5, 27.0));
        listPartTime.add(new NhanVienPartTime("P02", "Nguyễn Biên Cương", "0909090909", "Sapa", 4, 27.0));
        listPartTime.add(new NhanVienPartTime("P03", "Dương Văn Nam", "0987654321", "Lào Cai", 3, 27.0));
        listPartTime.add(new NhanVienPartTime("P04", "Doãn Chí Bình", "0978123456", "Điện Biên Phủ", 4, 27.0));
        listPartTime.add(new NhanVienPartTime(" P05", "Hoàng Văn Phong", "0845678901", "Đà Nẵng", 2, 27.0));
        return listPartTime;
    }

    public String addNhanVienP(NhanVienPartTime nvp) {
        if (nvp != null && listPartTime.add(nvp)) {
            return "Thêm thành công ";
        }
        return "Thêm thất bại";
    }

    public String deleteNhanVienP(int viTri) {
        if (viTri >= 0 && listPartTime.remove(viTri) != null) {
            return "Xóa thành công";
        }
        return "Xóa thất bại";
    }

    public String updateNhanVienP(int viTri, NhanVienPartTime nvp) {
        if (viTri >= 0) {
            if (nvp != null) {
                listPartTime.set(viTri, nvp);
                return "Sửa thành công";

            }
        }
        return "Sửa thất bại";
    }
    public Integer findNhanVienP(String ma){
        int i=0;
        for (NhanVienPartTime nvp : listPartTime) {
            if(nvp.getMaNv().equals(ma)){
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
                for (NhanVienPartTime nvp : listPartTime) {
                    oos.writeObject(nvp);
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
            } catch (Exception e) {
            }
        }
    }

    public String docFile(String path) {
        File file = new File(path);
        FileInputStream fis = null;
        try {
            if (!file.exists()) {
                return "File không tồn tại";
            }
            fis = new FileInputStream(file);
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                while (fis.available() > 0) {
                    listPartTime.add(((NhanVienPartTime) ois.readObject()));
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
            } catch (Exception e) {
            }
        }
    }
}
