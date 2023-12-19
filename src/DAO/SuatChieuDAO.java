package DAO;

import Controller.DBConnection;
import Controller.XJdbc;
import Model.Phim;
import Model.PhongChieu;
import Model.SuatChieu;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class SuatChieuDAO extends RedFoxCinema<SuatChieu, Object> {

    Connection conn = null;

    @Override
    public void insert(SuatChieu sc) {
        String sql = "insert into suatchieu values(?,?,?,?,?,?,?) ";
        String maPhim = getMaPhim(sc.getTenPhim());
        XJdbc.update(sql,
                sc.getMaSuatChieu(),
                sc.getGioBatDau(),
                sc.getGioKetThuc(),
                sc.getNgayChieu(),
                maPhim,
                sc.getMaphong(),
                sc.getMaDinhDang());
    }

    @Override
    public void update(SuatChieu sc) {
        String sql = "update suatchieu set giobatdau=?,gioketthuc=?,ngaychieu=?,ID_Phim=?,ID_Phongchieu=?,ID_dinhdangphim=? where ID_suatchieu=?";
        String maPhim = getMaPhim(sc.getTenPhim());
        XJdbc.update(sql,
                sc.getGioBatDau(),
                sc.getGioKetThuc(),
                sc.getNgayChieu(),
                maPhim,
                sc.getMaphong(),
                sc.getMaDinhDang(),
                sc.getMaSuatChieu());

    }

    @Override
    public void delete(Object id) {
        String sql = "delete from suatchieu where ID_suatchieu=?";
        XJdbc.update(sql, id);
    }

    @Override
    public SuatChieu selectById(Object id) {
        String sql = "select * from suatchieu where ID_suatchieu=?";
        List<SuatChieu> list = selectBySql(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<SuatChieu> selectAll() {
        String sql = "select sc.ID_suatchieu , sc.giobatdau , sc.gioketthuc ,  sc.ngaychieu ,sc.ID_phongchieu ,sc.ID_dinhdangphim, p.tenphim from suatchieu sc inner join phim p on sc.ID_phim = p.ID_phim";
        return selectBySql(sql);
    }

    @Override
    protected List selectBySql(String sql, Object... args) {
        List<SuatChieu> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {

                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    SuatChieu sc = new SuatChieu();
//                    String tenphim = getTenPhim(rs.getString("ID_Phim"));
                    sc.setMaSuatChieu(rs.getString("ID_suatchieu"));
                    sc.setGioBatDau(rs.getTime("giobatdau"));
                    sc.setGioKetThuc(rs.getTime("gioketthuc"));
                    sc.setNgayChieu(rs.getDate("ngaychieu"));
                    sc.setTenPhim(rs.getString("tenphim"));
                    sc.setMaphong(rs.getInt("ID_phongchieu"));
                    sc.setMaDinhDang(rs.getString("ID_dinhdangphim"));
                    list.add(sc);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;

    }

    public String getTenPhim(String ID_Phim) {
        String tenPhim = "";
        try {
            String sql = "select tenphim from phim where ID_Phim like '%" + ID_Phim + "%'";
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                tenPhim = rs.getString("tenphim");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuatChieuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tenPhim;
    }

    public String getMaPhim(String tenPhim) {
        String maPhim = "";
        try {
            String sql = "select ID_phim from phim where tenphim=N'" + tenPhim + "'";
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                maPhim = rs.getString("ID_Phim");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuatChieuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maPhim;
    }

    public List<SuatChieu> FindTenSuatChieu(String input) {
        List<SuatChieu> list = new ArrayList<>();
        try {
            String sql = "select sc.ID_suatchieu ,  sc.giobatdau , sc.gioketthuc , sc.ngaychieu ,sc.ID_phongchieu ,sc.ID_dinhdangphim, p.tenphim from suatchieu sc inner join phim p on sc.ID_phim = p.ID_phim where p.tenphim like N'%" + input + "%'";
            conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                SuatChieu sc = new SuatChieu();
                sc.setMaSuatChieu(rs.getString("ID_suatchieu"));

                sc.setGioBatDau(rs.getTime("giobatdau"));
                sc.setGioKetThuc(rs.getTime("gioketthuc"));
                sc.setNgayChieu(rs.getDate("ngaychieu"));
                sc.setMaphong(rs.getInt("ID_Phongchieu"));
                sc.setTenPhim(rs.getString("tenphim"));
                sc.setMaDinhDang(rs.getString("ID_dinhdangphim"));
                list.add(sc);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
        return list;
    }

    public List<SuatChieu> FindNgaySuatChieu(String input) {
        List<SuatChieu> list = new ArrayList<>();
        try {
            String sql = "select sc.ID_suatchieu , sc.giobatdau , sc.gioketthuc ,sc.ngaychieu , sc.ID_phongchieu ,sc.ID_dinhdangphim, p.tenphim from suatchieu sc inner join phim p on sc.ID_phim = p.ID_phim where sc.ngaychieu like '%" + input + "%'";
            conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                SuatChieu sc = new SuatChieu();
                sc.setMaSuatChieu(rs.getString("ID_suatchieu"));
                sc.setGioBatDau(rs.getTime("giobatdau"));
                sc.setGioKetThuc(rs.getTime("gioketthuc"));
                sc.setNgayChieu(rs.getDate("ngaychieu"));
                sc.setMaphong(rs.getInt("ID_Phongchieu"));
                sc.setTenPhim(rs.getString("tenphim"));
                sc.setMaDinhDang(rs.getString("ID_dinhdangphim"));
                list.add(sc);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
        return list;
    }

    public List<SuatChieu> FindSuatChieu(String ngay, int phong, String ten) {
        List<SuatChieu> list = new ArrayList<>();
        try {

            String sql = "select sc.ID_suatchieu ,  sc.giobatdau , sc.gioketthuc , sc.ngaychieu ,sc.ID_phongchieu ,sc.ID_dinhdangphim, p.tenphim from suatchieu sc inner join phim p on sc.ID_phim = p.ID_phim where sc.ngaychieu like '" + ngay + "'" + " and sc.ID_phongchieu = " + phong + " and p.tenphim like N'" + ten + "'";

            conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                SuatChieu sc = new SuatChieu();
                sc.setMaSuatChieu(rs.getString("ID_suatchieu"));
                sc.setGioBatDau(rs.getTime("giobatdau"));
                sc.setGioKetThuc(rs.getTime("gioketthuc"));
                sc.setNgayChieu(rs.getDate("ngaychieu"));
                sc.setMaphong(rs.getInt("ID_Phongchieu"));
                sc.setTenPhim(rs.getString("tenphim"));
                sc.setMaDinhDang(rs.getString("ID_dinhdangphim"));
                list.add(sc);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
        return list;
    }

    public List<SuatChieu> FindPhongandTen(int phong, String ten) {
        List<SuatChieu> list = new ArrayList<>();
        try {
            String sql = "select sc.ID_suatchieu ,  sc.giobatdau , sc.gioketthuc , sc.ngaychieu ,sc.ID_phongchieu ,sc.ID_dinhdangphim, p.tenphim from suatchieu sc inner join phim p on sc.ID_phim = p.ID_phim where sc.ID_phongchieu = " + phong + " and p.tenphim like N'" + ten + "'";
            conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                SuatChieu sc = new SuatChieu();
                sc.setMaSuatChieu(rs.getString("ID_suatchieu"));
                sc.setGioBatDau(rs.getTime("giobatdau"));
                sc.setGioKetThuc(rs.getTime("gioketthuc"));
                sc.setNgayChieu(rs.getDate("ngaychieu"));
                sc.setMaphong(rs.getInt("ID_Phongchieu"));
                sc.setTenPhim(rs.getString("tenphim"));
                sc.setMaDinhDang(rs.getString("ID_dinhdangphim"));
                list.add(sc);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
        return list;
    }

    public List<SuatChieu> FindNgayandTen(String ngay, String ten) {
        List<SuatChieu> list = new ArrayList<>();
        try {
            String sql = "select sc.ID_suatchieu , sc.giobatdau , sc.gioketthuc , sc.ngaychieu , sc.ID_phongchieu ,sc.ID_dinhdangphim, p.tenphim from suatchieu sc inner join phim p on sc.ID_phim = p.ID_phim where sc.ngaychieu like '" + ngay + "'" + " and p.tenphim like N'" + ten + "'";
            conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                SuatChieu sc = new SuatChieu();
                sc.setMaSuatChieu(rs.getString("ID_suatchieu"));
                sc.setGioBatDau(rs.getTime("giobatdau"));
                sc.setGioKetThuc(rs.getTime("gioketthuc"));
                sc.setNgayChieu(rs.getDate("ngaychieu"));
                sc.setMaphong(rs.getInt("ID_Phongchieu"));
                sc.setTenPhim(rs.getString("tenphim"));
                sc.setMaDinhDang(rs.getString("ID_dinhdangphim"));
                list.add(sc);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
        return list;
    }

    public List<SuatChieu> FindNgayandPhong(String ngay, int phong) {
        List<SuatChieu> list = new ArrayList<>();
        try {
            String sql = "select sc.ID_suatchieu ,  sc.giobatdau , sc.gioketthuc , sc.ngaychieu ,sc.ID_phongchieu ,sc.ID_dinhdangphim, p.tenphim from suatchieu sc inner join phim p on sc.ID_phim = p.ID_phim where sc.ngaychieu like '" + ngay + "'" + " and sc.ID_phongchieu = " + phong;
            conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                SuatChieu sc = new SuatChieu();
                sc.setMaSuatChieu(rs.getString("ID_suatchieu"));
                sc.setGioBatDau(rs.getTime("giobatdau"));
                sc.setGioKetThuc(rs.getTime("gioketthuc"));
                sc.setNgayChieu(rs.getDate("ngaychieu"));
                sc.setMaphong(rs.getInt("ID_Phongchieu"));
                sc.setTenPhim(rs.getString("tenphim"));
                sc.setMaDinhDang(rs.getString("ID_dinhdangphim"));
                list.add(sc);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
        return list;
    }

    public List<Phim> SelectTenPhim() {
        List<Phim> list = new ArrayList<>();
        try {
            String sql = "select tenphim from phim";
            conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Phim p = new Phim();
                p.setTenPhim(rs.getString("tenphim"));
                list.add(p);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
        return list;

    }

    public List<PhongChieu> SelectIDPhong() {
        List<PhongChieu> list = new ArrayList<>();
        try {
            String sql = "select ID_phongchieu from phongchieu";
            conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                PhongChieu pc = new PhongChieu();
                pc.setID_PhongChieu(rs.getInt("ID_phongchieu"));
                list.add(pc);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
        return list;
    }

    public List<SuatChieu> FindPhongSuatChieu(String input) {
        List<SuatChieu> list = new ArrayList<>();
        try {
            String sql = "select sc.ID_suatchieu ,  sc.giobatdau , sc.gioketthuc ,sc.ngaychieu , sc.ID_phongchieu ,sc.ID_dinhdangphim, p.tenphim from suatchieu sc inner join phim p on sc.ID_phim = p.ID_phim where sc.ID_phongchieu like '%" + input + "%'";
            conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                SuatChieu sc = new SuatChieu();
                sc.setMaSuatChieu(rs.getString("ID_suatchieu"));
                sc.setGioBatDau(rs.getTime("giobatdau"));
                sc.setGioKetThuc(rs.getTime("gioketthuc"));
                sc.setNgayChieu(rs.getDate("ngaychieu"));
                sc.setMaphong(rs.getInt("ID_Phongchieu"));
                sc.setTenPhim(rs.getString("tenphim"));
                sc.setMaDinhDang(rs.getString("ID_dinhdangphim"));
                list.add(sc);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
        return list;
    }

    public boolean validate(String masuatchieu, String phim, String phongchieu, String ngaychieu, String giobatdau, String gioketthuc) {

        if (masuatchieu.length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập mã");
            return false;
        } else {
            Pattern pmasc = Pattern.compile("SC[0-9]{5}");
            Matcher mmasc = pmasc.matcher(masuatchieu);
            if (!mmasc.matches()) {
                JOptionPane.showMessageDialog(null, "Mã SC nhập sai định dạng");
                return false;
            }
        }
        if (phim.equals("Chọn phim")) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn Phim");
            return false;
        }
        if (phongchieu.equals("Chọn phòng")) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn phòng chiếu");
            return false;
        }
        if (giobatdau.length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập giờ bắt đầu");
            return false;
        } else {
            Pattern pgbd = Pattern.compile("^(?:(?:([01]?\\d|2[0-3]):)?([0-5]?\\d):)?([0-5]?\\d)$");
            Matcher mgbd = pgbd.matcher(giobatdau);
            if (!mgbd.matches()) {
                JOptionPane.showMessageDialog(null, "Giờ bắt đầu nhập sai định dạng");
                return false;
            }
        }
        if (gioketthuc.length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập giờ kết thúc");
            return false;
        } else {
            Pattern pgkt = Pattern.compile("^(?:(?:([01]?\\d|2[0-3]):)?([0-5]?\\d):)?([0-5]?\\d)$");
            Matcher mgkt = pgkt.matcher(gioketthuc);
            if (!mgkt.matches()) {
                JOptionPane.showMessageDialog(null, "Giờ kết thúc nhập sai định dạng");
                return false;
            }

        }

        if (ngaychieu.equals("xx/xx/xxxx")) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn ngày để lưu suất chiếu");
            return false;
        } else {
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date today = new Date();
                String todaysource = format1.format(today);
                Date day = format1.parse(todaysource);
                Date date1 = format1.parse(ngaychieu);
                if (date1.before(day)) {
                    JOptionPane.showMessageDialog(null, "Không được chọn ngày nhỏ hơn ngày hiện tại");
                    return false;
                } else if (date1.equals(day)) {
                    try {
                        SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
                        Date hour = new Date(System.currentTimeMillis());
                        String nowHourStr = format2.format(hour);
                        Date nowHour;
                        nowHour = format2.parse(nowHourStr);
                        Date hourstart = format2.parse(giobatdau);
                        if (hourstart.before(nowHour)) {
                            JOptionPane.showMessageDialog(null, "Không thể thêm suất vào khung giờ này!!!");
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(SuatChieu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (ParseException ex) {
                Logger.getLogger(SuatChieuDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }
}
