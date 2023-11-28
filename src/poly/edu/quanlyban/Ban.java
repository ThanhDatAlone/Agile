
package poly.edu.quanlyban;

import java.io.Serializable;

public class Ban implements Serializable{
    private String maBan;
    private int soBan;
    private int soGhe;

    public Ban() {
    }

    public Ban(String maBan) {
        this.maBan = maBan;
    }

    public Ban(String maBan, int soBan, int soGhe) {
        this.maBan = maBan;
        this.soBan = soBan;
        this.soGhe = soGhe;
    }

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public int getSoBan() {
        return soBan;
    }

    public void setSoBan(int soBan) {
        this.soBan = soBan;
    }

    public int getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }
    
    
    
    
}
