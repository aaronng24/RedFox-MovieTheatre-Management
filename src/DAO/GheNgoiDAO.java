package DAO;

import Controller.DBConnection;
import Model.GheNgoi;
import Model.LoaiGhe;
import Model.PhongChieu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Dung
 */
public class GheNgoiDAO {

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    public List<GheNgoi> getGheNgoiByPhongChieu(int pc) {
        List<GheNgoi> list = new ArrayList<>();
        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from ghengoi where id_phongchieu=" + pc);
            while (rs.next()) {
                GheNgoi gn = new GheNgoi();
                gn.setId_ghe(rs.getInt(1));
                gn.setVitriDay(rs.getString("vitriday"));
                gn.setVitriCot(rs.getInt("vitricot"));
                gn.setID_phongchieu(rs.getInt(4));
                gn.setLoaighe(rs.getString("id_loaighe"));
                list.add(gn);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GheNgoiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<GheNgoi> getGheNgoiBySuatChieu(String id_suatchieu) {
        List<GheNgoi> list = new ArrayList<>();
        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            rs=st.executeQuery("select * from ghengoi gn,ve where gn.id_ghe = ve.ID_ghe and id_suatchieu='"+id_suatchieu+"'");
            while(rs.next()){
                GheNgoi gn= new GheNgoi();
                gn.setId_ghe(rs.getInt("id_ghe"));
                gn.setVitriDay(rs.getString("vitriday"));
                gn.setVitriCot(rs.getInt("vitricot"));
                list.add(gn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GheNgoiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public GheNgoi getGheNgoi(int pc) {
        GheNgoi gn = new GheNgoi();
        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from ghengoi where id_phongchieu=" + pc);
            while (rs.next()) {
                gn.setId_ghe(rs.getInt(1));
                gn.setVitriDay(rs.getString(2));
                gn.setVitriCot(rs.getInt(3));
                gn.setID_phongchieu(rs.getInt(4));
                gn.setLoaighe(rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GheNgoiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return gn;
    }
}
