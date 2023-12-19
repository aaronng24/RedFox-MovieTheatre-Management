package DAO;

import Controller.DBConnection;
import Controller.XJdbc;
import Model.Ve;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class VeDAO extends RedFoxCinema<Ve, Object>{

    @Override
    public void insert(Ve entity) {
    }

    @Override
    public void update(Ve entity) {
    }

    @Override
    public void delete(Object id) {
    }

    @Override
    public List<Ve> selectAll() {
        String sql = "select * from Ve";
        return selectBySql(sql);

    }

    @Override
    protected List<Ve> selectBySql(String sql, Object... args) {
        List<Ve> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    Ve ve = new Ve();
                    ve.setMaVe(rs.getString("ID_ve"));
                    ve.setMaSuat(rs.getString("ID_suatchieu"));
                    ve.setViTriGhe(rs.getInt("ID_ghe"));
                    ve.setNgayBan(rs.getString("ngayban"));
                    ve.setGiaVe(rs.getString("tongtien"));
                    ve.setKhachHang(rs.getString("ID_kh"));
                    ve.setNhanVien(rs.getString("ID_nv"));
                    list.add(ve);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Ve> findVeByID(int input) {
        List<Ve> list = new ArrayList<>();
        try {
            String sql = "select * from ve where ID_ve = '" + input + "'";
            Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Ve ve = new Ve();
                ve.setMaVe(rs.getString("ID_ve"));
                ve.setMaSuat(rs.getString("ID_suatchieu"));
                ve.setViTriGhe(rs.getInt("ID_ghe"));
                ve.setNgayBan(rs.getString("ngayban"));
                ve.setGiaVe(rs.getString("tongtien"));
                ve.setKhachHang(rs.getString("ID_kh"));
                ve.setNhanVien(rs.getString("ID_nv"));
                list.add(ve);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Ve> findVeByDate(String input) {
        List<Ve> list = new ArrayList<>();
        try {
            String sql = "select * from ve where ngayban = '" + input + "'";
            Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Ve ve = new Ve();
                ve.setMaVe(rs.getString("ID_ve"));
                ve.setMaSuat(rs.getString("ID_suatchieu"));
                ve.setViTriGhe(rs.getInt("ID_ghe"));
                ve.setNgayBan(rs.getString("ngayban"));
                ve.setGiaVe(rs.getString("tongtien"));
                ve.setKhachHang(rs.getString("ID_kh"));
                ve.setNhanVien(rs.getString("ID_nv"));
                list.add(ve);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Ve selectById(Object id) {
        return null;
    }
    
}
