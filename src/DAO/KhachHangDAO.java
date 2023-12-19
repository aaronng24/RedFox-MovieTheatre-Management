/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.DBConnection;
import Controller.XJdbc;
import Model.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Nguyen Dinh Dung
 */
public class KhachHangDAO extends RedFoxCinema<KhachHang, Object> {

    Connection conn = null;
    PreparedStatement ps = null;

    @Override
    public List selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    KhachHang kh = new KhachHang();
                    kh.setID(rs.getString("ID_kh"));
                    kh.setHoten(rs.getString("Hoten_kh"));
                    kh.setEmail(rs.getString("Email_kh"));
                    kh.setSdt(rs.getString("Sdt_kh"));
                    kh.setDiachi(rs.getString("Diachi_kh"));
                    kh.setGioitinh(rs.getString("Gioitinh_kh"));
                    kh.setNgaydangky(rs.getString("ngaydangky"));

                    list.add(kh);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<KhachHang> selectAll() {
        String sql = "select * from KhachHang";
        return selectBySql(sql);
    }

    @Override
    public void insert(KhachHang kh) {
        String sql = "insert into khachhang values(?,?,?,?,?,?,?)";
        XJdbc.update(sql,
                kh.getID(),
                kh.getHoten(),
                kh.getDiachi(),
                kh.getSdt(),
                kh.getEmail(),
                kh.getGioitinh(),
                kh.getNgaydangky());
    }

    @Override
    public void update(KhachHang kh) {
        String sql = "update KhachHang set hoten_kh=? , diachi_kh=? , sdt_kh=? , email_kh=? , gioitinh_kh=? , ngaydangky=? where ID_kh=?";
        XJdbc.update(sql,
                kh.getHoten(),
                kh.getDiachi(),
                kh.getSdt(),
                kh.getEmail(),
                kh.getGioitinh(),
                kh.getNgaydangky(),
                kh.getID());
    }

    @Override
    public void delete(Object id) {
        String sql = "delete from KhachHang where ID_kh=?";
        XJdbc.update(sql, id);
    }

    @Override
    public KhachHang selectById(Object id) {
        String sql = "select * from khachhang where ID_kh=?";
        List<KhachHang> list = selectBySql(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<KhachHang> findKH(String input) {
        List<KhachHang> list = new ArrayList<>();
        try {
            String sql = "select * from KhachHang where ID_kh like '%" + input + "%' or Hoten like N'%" + input + "%'";
            conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setID(rs.getString("ID_kh"));
                kh.setHoten(rs.getString("Hoten_kh"));
                kh.setDiachi(rs.getString("Diachi_kh"));
                kh.setGioitinh(rs.getString("Gioitinh_kh"));
                kh.setEmail(rs.getString("Email_kh"));
                kh.setSdt(rs.getString("Sdt_kh"));
                kh.setNgaydangky(rs.getString("ngaydangky"));
                list.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

   public boolean validatekh(String ID, String Hoten, String Diachi, String Sdt, String Email) {
        if (ID.length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập mã");
            return false;
        } else {
            Pattern pID = Pattern.compile("KH[0-9]{4}");
            Matcher mID = pID.matcher(ID);
            if (!mID.matches()) {
                JOptionPane.showMessageDialog(null, "Mã KH nhập sai định dạng");
            }
        }
        if (Hoten.length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập họ tên");
            return false;
        }
        if (Diachi.length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập Địa Chỉ");
            return false;
        }
        if (Sdt.length() == 0) {
            JOptionPane.showMessageDialog(null, " chưa nhập Số Điện Thoại");
        } else {
            Pattern psdt = Pattern.compile("[0-9]{10}");
            Matcher msdt = psdt.matcher(Sdt);
            if (!msdt.matches()) {
                JOptionPane.showMessageDialog(null, "Sdt nhập sai định dạng");
                return false;
            }
        }

        if (Email.length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập Email");
            return false;
        } else {
            //Check định dạng
            Pattern pEmail = Pattern.compile("^(.+)@(.+)$");
            Matcher mEmail = pEmail.matcher(Email);
            if (!mEmail.matches()) {
                JOptionPane.showMessageDialog(null, "Email sai định dạng");
                return false;
            }
        }
//        if (Ngaydangky.length() == 0) {
//            JOptionPane.showMessageDialog(null, "Chưa nhập Ngày Đăng Ký ");
//            return false;
//        } else if (Integer.parseInt(Ngaydangky) > 2023) {
//            JOptionPane.showMessageDialog(null, "Ngày Đăng Ký không được lớn hơn năm hiện tại");
//            return false;
//        } else {
//            JOptionPane.showMessageDialog(null, "Ngày Đăng Ký không được bé hơn 0");
//            return false;
//        }
        return true;
    }
}
