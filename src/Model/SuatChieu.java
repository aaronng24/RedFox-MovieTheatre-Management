package Model;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SuatChieu {

    String maSuatChieu;
    Date ngayChieu;
    Time gioBatDau;
    Time gioKetThuc;
    String tenPhim;
    int maphong;
    String maDinhDang;

    public String getMaSuatChieu() {
        return maSuatChieu;
    }

    public void setMaSuatChieu(String maSuatChieu) {
        this.maSuatChieu = maSuatChieu;
    }

    public Date getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(Date ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public Time getGioBatDau() {
        return gioBatDau;
    }

    public void setGioBatDau(Time gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public Time getGioKetThuc() {
        return gioKetThuc;
    }

    public void setGioKetThuc(Time gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public int getMaphong() {
        return maphong;
    }

    public void setMaphong(int maphong) {
        this.maphong = maphong;
    }

    public String getMaDinhDang() {
        return maDinhDang;
    }

    public void setMaDinhDang(String maDinhDang) {
        this.maDinhDang = maDinhDang;
    }

    public String getTinhTrang() throws ParseException {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        String todaysource = format1.format(today);
        Date day = format1.parse(todaysource);
        String tinhtrang = "";
        if (getNgayChieu().before(day)) {
            tinhtrang = "Đã chiếu";
        } else if (getNgayChieu().after(day)) {
            tinhtrang = "Sắp chiếu";
        } else if (getNgayChieu().equals(day)) {
            try {
                SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
                Date hour = new Date(System.currentTimeMillis());
                String nowHourStr = format2.format(hour);
                Date nowHour;
                nowHour = format2.parse(nowHourStr);
                if (getGioKetThuc().before(nowHour)) {
                    tinhtrang = "Đã chiếu";
                } else if (getGioBatDau().before(nowHour) && getGioKetThuc().after(nowHour)) {
                    tinhtrang = "Đang chiếu";
                } else if (getGioBatDau().after(nowHour)) {
                    tinhtrang = "Sắp Chiếu";
                }
            } catch (ParseException ex) {
                Logger.getLogger(SuatChieu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
        }
        return tinhtrang;
    }

}
