/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.DBConnection;
import Model.UserClone;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ttc
 */
public class RememberUserDao {

    List<UserClone> list = new ArrayList<>();

    public void update() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            //        Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = null;
            c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement("update Remember_Login set count = 0 where IP_Computer like '" + inetAddress.getHostName().toString() + "'");
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(RememberUserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<UserClone> selecttkmk() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = null;
            c = DBConnection.getConnection();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select username , password from Remember_Login where count = 1 and IP_Computer like '" + inetAddress.getHostName() + "'");
            while (rs.next()) {
                UserClone uc = new UserClone();
                uc.setUser(rs.getString("username"));
                uc.setPass(rs.getString("password"));
                list.add(uc);
                UI.LoginFrame.checkRemember.setSelected(true);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Xung đột dữ liệu");
        }
        return list;
    }
//    public List<UserClone> selecttk(){
//        try {
//            InetAddress inetAddress = InetAddress.getLocalHost();
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection c = null;
//            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/DA1_RedFox_cinema", "root", "Phat123456");
//            Statement st = c.createStatement();
//            ResultSet rs = st.executeQuery("select username from Remember_Login where count = 1 and IP_Computer like '" + inetAddress.getHostName() + "'");
//            while(rs.next()){
//               UserClone uc = new UserClone();
//               uc.setUser(rs.getString("username"));
//               list.add(uc);
//               UI.LoginFrame.checkRemember.setSelected(true);
//            }
//            
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, "Xung đột dữ liệu");
//        }
//        return list;
//    }

    public boolean remember(String username, String password) {
        update();
        if (UI.LoginFrame.checkRemember.isSelected()) {
            try {
                InetAddress inetAddress = InetAddress.getLocalHost();
                //  Class.forName("com.mysql.cj.jdbc.Driver");
                Connection c = null;
                c = DBConnection.getConnection();
                PreparedStatement ps = c.prepareStatement("update Remember_Login set count = 1 where username like '" + username + "'" + "and IP_Computer = '" + inetAddress.getHostName().toString() + "'");
                ps.executeUpdate();
                //JOptionPane.showMessageDialog(null, "Lưu thành công");
                return true;

            } catch (Exception ex) {
                // JOptionPane.showMessageDialog(null, "Không thể lưu");
                return false;
            }
        }
        System.out.print(this);
        return true;
    }

    public int selectIP(String username, String inetaddress) {
        int count = 0;
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            //    Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = null;
            c = DBConnection.getConnection();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select username from Remember_Login where Username like '" + username + "'" + "and IP_Computer like '" + inetAddress.getHostName() + "'");
            while (rs.next()) {
                count++;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Xung đột dữ liệu");
        }
        return count;
    }

    public void insert(String username, String password) {
        update();
        if (UI.LoginFrame.checkRemember.isSelected()) {
            try {
                InetAddress inetAddress = InetAddress.getLocalHost();
                //      Class.forName("com.mysql.cj.jdbc.Driver");
                Connection c = null;
                c = DBConnection.getConnection();
                PreparedStatement ps = c.prepareStatement("insert into Remember_Login values(?,?,?,?)");
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setInt(3, 1);
                ps.setString(4, inetAddress.getHostName());
                ps.executeUpdate();
                //  JOptionPane.showMessageDialog(null, "Thêm thành công");

            } catch (Exception ex) {
                //   JOptionPane.showMessageDialog(null, "Không thể thêm");
                ex.printStackTrace();
            }
        }
    }
//    public String getpass(String username ,String pass){
//         try {
//            InetAddress inetAddress = InetAddress.getLocalHost();
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection c = null;
//            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/DA1_RedFox_cinema", "root", "Phat123456");
//            Statement st = c.createStatement();
//            ResultSet rs = st.executeQuery("select password from Remember_Login where count = 1 and username like '" + username + "'");
//            while(rs.next()){
//                   pass = rs.getString("password");
//               UI.LoginFrame.checkRemember.setSelected(true);
//            }
//            
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, "Xung đột dữ liệu");
//        }
//        return pass;
//    }

    public List<UserClone> returnTkMk() {
        try {
            //  Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = null;
            c = DBConnection.getConnection();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select username , password from Remember_Login");
            while (rs.next()) {
                UserClone uc = new UserClone();
                uc.setUser(rs.getString("username"));
                uc.setPass(rs.getString("password"));
                list.add(uc);
            }

        } catch (Exception ex) {
            //       JOptionPane.showMessageDialog(null, "Xung đột dữ liệu");
            ex.printStackTrace();
        }
        return list;
    }

}
