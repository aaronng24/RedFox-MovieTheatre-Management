package DAO;

import Controller.DBConnection;
import Model.KhachHang;

import Model.Phim;
import Model.PhongChieu;
import Model.RankKH;
import Model.SuatChieu;
import UI.BanVe.DialogThongTinVeBan;
import UI.MainJFrameNV;
import UI.MainJFrameQL;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class BanVeDAO {

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    public List<Phim> getPhimList() {
        List<Phim> list = new ArrayList<>();
        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from phim");
            while (rs.next()) {
                Phim p = new Phim();
                p.setID(rs.getString(1));
                p.setTenPhim(rs.getString(2));
                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BanVeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<SuatChieu> getSuatChieuList(String id) {
        List<SuatChieu> list = new ArrayList<>();
        try {

            con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from suatchieu where id_phim=N'" + id + "'");
            while (rs.next()) {
                SuatChieu sc = new SuatChieu();
                sc.setMaSuatChieu(rs.getString("ID_SuatChieu"));
                sc.setNgayChieu(rs.getDate("NgayChieu"));
                sc.setGioBatDau(rs.getTime("giobatdau"));
                sc.setGioKetThuc(rs.getTime("gioketthuc"));
                sc.setMaDinhDang(rs.getString("id_dinhdangphim"));
                sc.setMaphong(rs.getInt("id_phongchieu"));
                list.add(sc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanVeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<SuatChieu> getSuatChieu(String id_suatchieu) {
        List<SuatChieu> list = new ArrayList<>();
        try {

            con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from suatchieu where id_suatchieu=N'" + id_suatchieu + "'");
            while (rs.next()) {
                SuatChieu sc = new SuatChieu();
                sc.setMaSuatChieu(rs.getString("ID_SuatChieu"));
                sc.setNgayChieu(rs.getDate("NgayChieu"));
                sc.setGioBatDau(rs.getTime("giobatdau"));
                sc.setGioKetThuc(rs.getTime("gioketthuc"));
                sc.setMaDinhDang(rs.getString("id_dinhdangphim"));
                sc.setMaphong(rs.getInt("id_phongchieu"));
                list.add(sc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanVeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public String getNgonNgu(String id) {
        String ngonngu = "";
        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select ngonngu from phim where id_phim='" + id + "'");
            if (rs.next()) {
                ngonngu = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanVeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ngonngu;
    }

    public PhongChieu getPhongChieu(int phongchieu) {
        PhongChieu pc = new PhongChieu();
        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from phongchieu where id_phongchieu=" + phongchieu);
            while (rs.next()) {
                pc.setID_PhongChieu(rs.getInt(1));
                pc.setSoluongDay(rs.getInt(2));
                pc.setSoluongCot(rs.getInt(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanVeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pc;
    }

    public int getGiaVe(String tenloaive) {
        int giave = 0;

        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select dongia from giave where tenloaive=N'" + tenloaive + "'");
            if (rs.next()) {
                giave = rs.getInt("dongia");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanVeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return giave;
    }

    public int getGiaLoaiPhim(String loaiphim) {
        int gialoaiphim = 0;
        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from dinhdangphim where id_dinhdangphim=N'" + loaiphim + "'");
            if (rs.next()) {
                gialoaiphim = rs.getInt(3);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanVeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gialoaiphim;
    }

    public int getMaxRow() {
        int row = 0;
        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select max(id_ve) from ve");
            while (rs.next()) {
                row = Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanVeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row + 1;
    }

    public List<KhachHang> getKH(String sdt_KH) {
        List<KhachHang> list = new ArrayList<>();
        KhachHang kh = new KhachHang();
        String hangkh = "";
        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select hoten_kh,rank_kh from khachhang,rank_kh where khachhang.id_kh=rank_kh.id_kh and khachhang.sdt_kh=N'" + sdt_KH + "'");
            if (rs.next()) {
                kh.setHoten(rs.getString(1));
                kh.setRankKHtoString(rs.getString(2));
                list.add(kh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanVeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void insertVe(String ngayban, int tongtien, String id_suatchieu, String id_giave, int id_ghe, String id_nv, String id_kh) {
        try {
            con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into ve values(?,?,?,?,?,?,?)");
            ps.setDate(1, Date.valueOf(ngayban));
            ps.setInt(2, tongtien);
            ps.setString(3, id_suatchieu);
            ps.setString(4, id_giave);
            ps.setInt(5, id_ghe);
            ps.setString(6, id_nv);
            if(id_kh.isEmpty()){
                ps.setNull(7, Types.NULL);
            }else{
                ps.setString(7, id_kh);
            }
            ps.executeUpdate();         
        } catch (SQLException ex) {
            Logger.getLogger(BanVeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getId_giave(String tenloaive) {
        String id_giave = "";
        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select id_giave from giave where tenloaive=N'" + tenloaive + "'");
            if (rs.next()) {
                id_giave = rs.getString("id_giave");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanVeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_giave;
    }

    public String getID_KH(String sdt) {
        String idkh = "";
        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select id_kh from khachhang where sdt_kh='" + sdt + "'");
            if (rs.next()) {
                idkh = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanVeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idkh;
    }

    public void getTenNV(String id_nv) {
        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from nhanvien where id_nv=N'" + id_nv + "'");
            if (rs.next()) {
                if (rs.getString("chucvu_nv").equalsIgnoreCase("Nhân viên")) {
                    MainJFrameNV.jlbTenNV.setText(rs.getString("hoten_nv"));
                } else {
                    MainJFrameQL.jlbTenNV.setText(rs.getString("hoten_nv"));                   
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanVeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public int getPhuThuDinhDangPhim(String id_suatchieu){
         int ptDinhDang=0;
         try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from dinhdangphim dd,suatchieu sc where dd.id_dinhdangphim=sc.id_dinhdangphim and id_suatchieu=N'" + id_suatchieu + "'");
            if (rs.next()) {
                ptDinhDang=rs.getInt("phuthu_dinhdang");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanVeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return ptDinhDang;
     }
     
 
}
