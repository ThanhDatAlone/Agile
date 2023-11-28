
package poly.edu.quanlykhachhang;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class KhachHangService {
    private List<KhachHang> listKH = new ArrayList<>();
    
    public List<KhachHang> fakeData(){
         listKH.add(new KhachHang("1", "Đào Vũ Trà My ", "0969957885", "Tuyên Quang"));
         listKH.add(new KhachHang("KH02", "hà Thị Mỹ Linh ", "0369957865", "Hà Giang"));
         listKH.add(new KhachHang("KH03", "Lê Vũ Thảo Nguyên ", "0469957333", "Phú Thọ"));
         listKH.add(new KhachHang("KH04", "Nguyễn Thị Thanh Trà", "0569957885", "Yên Bái"));
         listKH.add(new KhachHang("Kh05", "Vũ Lê Tường Vy", "06698465754", "lạng Sơn"));
        return listKH;
    }
    
    public String addKhachHang(KhachHang kh) {
        if (kh != null && listKH.add(kh)) {
            return "Thêm thành công ";
        } else {
            return "Thêm thất bại ";
        }
    }

    public String deleteKhachHang(int viTri) {
        if (viTri >= 0 && listKH.remove(viTri) != null) {
            return "Xóa thành công ";
        } else {
            return "Xóa thất bại ";
        }
    }

    public String updateKhachHang(int viTri, KhachHang kh) {
        if (viTri >= 0) {
            if (kh != null) {
                listKH.set(viTri, kh);
                return "Sửa thành công";
            }
        }

        return "Sửa thất bại ";
    }

    public Integer find(String ma) {
        int i = 0;
        for (KhachHang kh : listKH) {
            if (kh.getMaKH().equals(ma)) {
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
                for (KhachHang kh : listKH) {
                    oos.writeObject(kh);
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
                    listKH.add((KhachHang) ois.readObject());
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
