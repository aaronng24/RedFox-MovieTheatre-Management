package Model;

public class GheNgoi extends  LoaiGhe{

    int id_ghe;
    String vitriDay;
    int vitriCot;
    int ID_phongchieu;
    String Loaighe;

    @Override
    public String getId_loaighe() {
        return super.getId_loaighe(); 
    }

    
    public GheNgoi() {
    }

    public int getID_phongchieu() {
        return ID_phongchieu;
    }

    public void setID_phongchieu(int ID_phongchieu) {
        this.ID_phongchieu = ID_phongchieu;
    }

    public String getLoaighe() {
        return Loaighe;
    }

    public void setLoaighe(String Loaighe) {
        this.Loaighe = Loaighe;
    }

    public int getId_ghe() {
        return id_ghe;
    }

    public void setId_ghe(int id_ghe) {
        this.id_ghe = id_ghe;
    }

    public String getVitriDay() {
        return vitriDay;
    }

    public void setVitriDay(String vitriDay) {
        this.vitriDay = vitriDay;
    }

    public int getVitriCot() {
        return vitriCot;
    }

    public void setVitriCot(int vitriCot) {
        this.vitriCot = vitriCot;
    }

}
