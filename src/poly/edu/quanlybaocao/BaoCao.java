
package poly.edu.quanlybaocao;

import java.io.Serializable;
import poly.edu.quanlyhoadon.HoaDon;

public class BaoCao implements Serializable{
    private HoaDon hoaDon;
    private double doanhThu;

    public BaoCao() {
    }

    public BaoCao(HoaDon hoaDon, double doanhThu) {
        this.hoaDon = hoaDon;
        this.doanhThu = doanhThu;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public double getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(double doanhThu) {
        this.doanhThu = doanhThu;
    }


    
    
    
 
    
    
    
}
