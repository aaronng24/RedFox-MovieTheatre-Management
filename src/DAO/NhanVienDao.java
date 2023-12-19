/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.XJdbc;

import Model.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author ttc
 */
public class NhanVienDao extends RedFoxCinema<NhanVien, Object> {

    @Override
    public void insert(NhanVien model) {
        String sql = "insert into NhanVien(ID_nv, hoten_nv, gioitinh_NV, sdt_NV, namsinh_NV,email_nv, chucvu_NV,tinhtrang_NV) values(?,?,?,?,?,?,?,?)";
        XJdbc.update(sql, model.getMaNV(), model.getTenNV(), model.getGioiTinh(), model.getSdt(), model.getNamSinh(), model.getEmail(), model.getChucVu(), model.getTinhTrang());
    }

    @Override
    public void update(NhanVien model) {
        String sql = "UPDATE NhanVien SET hoten_nv = ?, gioitinh_NV =?, sdt_NV =? ,namsinh_NV = ? ,email_nv=?, chucvu_NV = ? , tinhtrang_NV = ?  WHERE ID_nv=?";
        XJdbc.update(sql, model.getTenNV(), model.getGioiTinh(), model.getSdt(), model.getNamSinh(), model.getEmail(), model.getChucVu(), model.getTinhTrang(), model.getMaNV());
    }

    @Override
    public void delete(Object id) {
        String sql = "delete from NhanVien WHERE ID_nv=?";
        XJdbc.update(sql, id);
    }

    public List<NhanVien> findNhanVien(String input) {
        List<NhanVien> list = new ArrayList<>();
        try {
            String sql = "select * from NhanVien where ID_nv like '%" + input + "%' or hoten_nv like N'%" + input + "%'";
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("ID_nv"));
                nv.setTenNV(rs.getString("hoten_nv"));
                nv.setGioiTinh(rs.getString("gioitinh_nv"));
                nv.setSdt(rs.getString("sdt_nv"));
                nv.setNamSinh(rs.getString("namsinh_nv"));
                nv.setEmail(rs.getString("email_nv"));
                nv.setChucVu(rs.getString("chucvu_nv"));
                nv.setTinhTrang(rs.getString("tinhtrang_nv"));
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public String returnID(String manv) {
        String sql = "select count(*) from NhanVien where ID_nv=?";
        XJdbc.query(sql, manv);
        return manv;
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    NhanVien entity = new NhanVien();
                    entity.setMaNV(rs.getString("ID_nv"));
                    entity.setTenNV(rs.getString("hoten_nv"));
                    entity.setGioiTinh(rs.getString("gioitinh_nv"));
                    entity.setSdt(rs.getString("sdt_nv"));
                    entity.setNamSinh(rs.getString("namsinh_nv"));
                    entity.setEmail(rs.getString("email_nv"));
                    entity.setChucVu(rs.getString("chucvu_nv"));
                    entity.setTinhTrang(rs.getString("tinhtrang_nv"));
                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    @Override
    public NhanVien selectById(Object id) {
        String sql = "select * from Nhanvien where ID_nv=?";
        List<NhanVien> list = selectBySql(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<NhanVien> selectAll() {
        String sql = "Select * from NhanVien";
        return this.selectBySql(sql);
    }

    public boolean validate(String manv, String hoten, String sdt, String namsinh, String email, String chucvu) {
        if (manv.length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập mã");
            return false;
        } else {
            Pattern pmanv = Pattern.compile("PS[0-9]{5}");
            Matcher mmanv = pmanv.matcher(manv);
            if (!mmanv.matches()) {
                JOptionPane.showMessageDialog(null, "Mã NV nhập sai định dạng");
            }
        }
        if (hoten.length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập họ tên");
            return false;
        }
        if (sdt.length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập sđt");
            return false;
        } else {
            Pattern psdt = Pattern.compile("[0-9]{10}");
            Matcher msdt = psdt.matcher(sdt);
            if (!msdt.matches()) {
                JOptionPane.showMessageDialog(null, "Sdt nhập sai định dạng");
                return false;
            }
        }
        if (namsinh.length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập năm sinh");
            return false;
        } else {
            if (Integer.parseInt(namsinh) > 2023) {
                JOptionPane.showMessageDialog(null, "Năm sinh không được lớn hơn năm hiện tại");
                return false;
            } else if (Integer.parseInt(namsinh) < 0) {
                JOptionPane.showMessageDialog(null, "Năm sinh không được bé hơn 0");
            }
        }
        if (email.length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập Email");
            return false;
        } else {
            //Check định dạng
            Pattern pEmail = Pattern.compile("^(.+)@(.+)$");
            Matcher mEmail = pEmail.matcher(email);
            if (!mEmail.matches()) {
                JOptionPane.showMessageDialog(null, "Email sai định dạng");
                return false;

            }
//            if (chucvu.length() == 0) {
//                JOptionPane.showMessageDialog(null, "Chưa nhập chức vụ");
//                return false;
//            } else {
//                if (chucvu.trim().equals("Quản Lý") || chucvu.trim().equalsIgnoreCase("Nhân Viên")) {
//                    return true;
//                } else {
//                    JOptionPane.showMessageDialog(null, "Chức vụ chỉ được là Nhân Viên hoặc Quản Lý");
//                    return false;
//                }
//            }

//            try{
//                int boo = namsinh;
//                return true;
//            }catch(Exception E){
//                JOptionPane.showMessageDialog(null, "Năm sinh không đúng kiểu dữ liệu");
//                return false;
//            }
        }
        return true;
    }
}
