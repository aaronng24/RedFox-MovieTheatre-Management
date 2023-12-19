package Model;


public class PhongChieu {
    int ID_PhongChieu;
    int SoluongDay;
    int SoluongCot;

    public PhongChieu() {
    }

    public PhongChieu(int ID_PhongChieu, int SoluongDay, int SoluongCot) {
        this.ID_PhongChieu = ID_PhongChieu;
        this.SoluongDay = SoluongDay;
        this.SoluongCot = SoluongCot;
    }

    
    public int getID_PhongChieu() {
        return ID_PhongChieu;
    }

    public void setID_PhongChieu(int ID_PhongChieu) {
        this.ID_PhongChieu = ID_PhongChieu;
    }

    public int getSoluongDay() {
        return SoluongDay;
    }

    public void setSoluongDay(int SoluongDay) {
        this.SoluongDay = SoluongDay;
    }

    public int getSoluongCot() {
        return SoluongCot;
    }

    public void setSoluongCot(int SoluongCot) {
        this.SoluongCot = SoluongCot;
    }
    
}
