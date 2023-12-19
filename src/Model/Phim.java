package Model;

import java.util.Date;

public class Phim {

    String ID, TenPhim, NgonNgu, DienVien, QuocGia, NSX, TomTat, TrangThai, gioiHanTuoi, ID_LoaiPhim;
    int thoiLuong;
    Date ngayCongChieu;

    public Phim() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTenPhim() {
        return TenPhim;
    }

    public void setTenPhim(String TenPhim) {
        this.TenPhim = TenPhim;
    }

    public String getNgonNgu() {
        return NgonNgu;
    }

    public void setNgonNgu(String NgonNgu) {
        this.NgonNgu = NgonNgu;
    }

    public String getDienVien() {
        return DienVien;
    }

    public void setDienVien(String DienVien) {
        this.DienVien = DienVien;
    }

    public String getQuocGia() {
        return QuocGia;
    }

    public void setQuocGia(String QuocGia) {
        this.QuocGia = QuocGia;
    }

    public String getNSX() {
        return NSX;
    }

    public void setNSX(String NSX) {
        this.NSX = NSX;
    }

    public String getTomTat() {
        return TomTat;
    }

    public void setTomTat(String TomTat) {
        this.TomTat = TomTat;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public String getGioiHanTuoi() {
        return gioiHanTuoi;
    }

    public void setGioiHanTuoi(String gioiHanTuoi) {
        this.gioiHanTuoi = gioiHanTuoi;
    }

    public String getID_LoaiPhim() {
        return ID_LoaiPhim;
    }

    public void setID_LoaiPhim(String ID_LoaiPhim) {
        this.ID_LoaiPhim = ID_LoaiPhim;
    }

    public Date getNgayCongChieu() {
        return ngayCongChieu;
    }

    public void setNgayCongChieu(Date ngayCongChieu) {
        this.ngayCongChieu = ngayCongChieu;
    }

}
