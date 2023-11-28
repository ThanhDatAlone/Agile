
package poly.edu.quanlyban;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class BanService {

    List<Ban> listBan = new ArrayList<>();

    public List<Ban> fakeData() {
        
        listBan.add(new Ban("B01", 4, 4));
        listBan.add(new Ban("B02", 5, 5));
        listBan.add(new Ban("B03", 10, 10));
        listBan.add(new Ban("B04", 7, 7));
        
        return listBan;
    }
    
    public String addBan(Ban b) {
        if (b != null && listBan.add(b)) {
            return "Thêm thành công ";
        } else {
            return "Thêm thất bại ";
        }
    }

    public String deleteBan(int viTri) {
        if (viTri >= 0 && listBan.remove(viTri) != null) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại ";
        }
    }

    public String updateBan(int viTri, Ban b) {
        if (viTri >= 0) {
            if (b != null) {
                listBan.set(viTri, b);
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
                for (Ban b : listBan) {
                    oos.writeObject(b);
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
            fis  = new FileInputStream(file);
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                while (fis.available()>0) {
                    listBan.add((Ban) ois.readObject());
                    
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
