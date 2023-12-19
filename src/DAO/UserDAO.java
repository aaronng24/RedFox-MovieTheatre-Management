
package DAO;

import Controller.XJdbc;
import Model.NhanVien;
import Model.User;
import Model.UserClone;

import java.awt.Color;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author ttc
 */
public class UserDAO extends RedFoxCinema<User, Object>{
    List<User> list = new ArrayList<>();
    String tk ="";
    String mk ="";
    
    @Override
    public void insert(User model){
        String sql="INSERT INTO Acc_Login (Username, pass, role_nv) VALUES (?, ?, ?)";
        XJdbc.update(sql, 
                model.getId(), 
                model.getPass(), 
                model.getRole()
                );
    }
    public void insertRmb(User model){
        InetAddress inetAddress;
        try {
            inetAddress = InetAddress.getLocalHost();
            String sql= "INSERT INTO Remember_Login(username,password,count,IP_computer) VALUES (? , ? , ? ,?)";
            XJdbc.update(sql, model.getId(),model.getPass(),0, inetAddress.getHostName());
        } catch (UnknownHostException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void update(User model){
        String sql= "Update Acc_Login set pass = ? , role_nv = ? where Username = ? ";
        XJdbc.update(sql,
                    model.getPass(),
                    model.getRole(),
                    model.getId()
                );
        
    }
    public void updateRmb(User model){
        String sql= "Update Remember_Login set password = ? count = 0 where username = ? ";
        XJdbc.update(sql,
                    model.getPass(),
                    model.getId()
                );
        
    }
    public String selectRole(String manv){
        String sql = "Select chucvu_nv from NhanVien where ID_nv = ?";
        ResultSet rs = XJdbc.query(sql, manv);
        String chucvu = "";
        try {  
            while(rs.next()){
                chucvu = rs.getString("chucvu_nv");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chucvu;
    }
    @Override
    public User selectById(Object id) {
        String sql = "select * from Acc_Login where Username=?";
        List<User> list = selectBySql(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }
    public int selectID(String manv){
        String sql = "Select Username from Acc_Login where Username = ?";
        ResultSet rs = XJdbc.query(sql, manv);
        String chucvu = "";
        int count = 0;
        try {  
            while(rs.next()){
                rs.getString("Username");
                count++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    @Override
    public List<User> selectAll() {
        String sql = "Select * from Acc_Login";
        return this.selectBySql(sql);
    }
    
        public boolean validateForm(String userName , String passWord) {
        //Check mã nv
        if (userName.length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập mã nhân viên");
            return false;
        } else {
            //Check định dạng
            Pattern pMaNV = Pattern.compile("PS[0-9]{5}");
            Matcher mMaNV = pMaNV.matcher(userName);
            if (!mMaNV.matches()) {
                JOptionPane.showMessageDialog(null, "Mã nhân viên nhập sai định dạng");
                return false;
            } else {
                //Check trùng
                for (User us : list) {
                    if (userName.equals(us.getId())) {
                        JOptionPane.showMessageDialog(null, "Đã tồn tại mã nhân viên này");
                        return false;
                    }
                }
            }
        }
        //Check pass
        if (passWord.length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập mật khẩu");
            
            return false;
        } else {
            //Check định dạng
            Pattern pp = Pattern.compile("^[a-zA-Z0-9]+$", Pattern.CASE_INSENSITIVE);
            Matcher mp = pp.matcher(passWord);
            if (!mp.matches()) {
                JOptionPane.showMessageDialog(null, "Mật khẩu nhập sai định dạng");
                return false;
            } else {
            }
        }
        return true;
    }


    @Override
    public void delete(Object id) {
    }


     @Override
    protected List<User> selectBySql(String sql, Object... args) {
        List<User> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    User u = new User();
                    u.setId(rs.getString("Username"));
                    u.setPass(rs.getString("Pass"));
                    u.setRole(rs.getString("role_nv"));
                    list.add(u);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    String idtam = "";
    String emailtam = "";

    public int resultmail(String email){
        int count = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = null;
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/DA1_RedFox_cinema", "root", "Phat123456");
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select email_nv from NhanVien where email_nv like '" + email + "'");
            while(rs.next()){
                count++;
               
            }
            return count;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Email không khớp với tài khoản bạn đã đăng ký!");
        }
       return count;
           
}
    public String returntk(String tk){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = null;
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/DA1_RedFox_cinema", "root", "Phat123456");
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select ID_nv from NhanVien where email_nv like '" + UI.ForgotPassFrame.txtEmail.getText() + "'");
            while(rs.next()){
                tk = rs.getString("ID_nv");
            }
            
        } catch (Exception ex) {
            
        }
        return tk;
    }
    public String returnmk(String mk){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = null;
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/DA1_RedFox_cinema", "root", "Phat123456");
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select Pass from Acc_login where Username like '" + returntk(tk) + "'");
            while(rs.next()){
                mk = rs.getString("Pass");
            }
            
        } catch (Exception ex) {
            
        }
        return mk;
    }

}
