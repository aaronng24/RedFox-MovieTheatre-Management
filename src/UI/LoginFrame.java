package UI;

import Controller.DBConnection;
import DAO.BanVeDAO;
import DAO.RememberUserDao;
import DAO.UserDAO;
import Model.NhanVien;
import Model.UserClone;
import UI.BanVe.DialogChonVe;
import UI.BanVe.DialogThongTinVeBan;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Nguyen Dung
 */
public class LoginFrame extends javax.swing.JFrame {

    RememberUserDao rud = new RememberUserDao();
    UserClone ul = new UserClone();
    UserDAO ud = new UserDAO();

    public LoginFrame() {
        initComponents();
        setTitle("Đăng nhập");
        setLocationRelativeTo(this);
        if (!rud.selecttkmk().isEmpty()) {
            for (UserClone ul : rud.selecttkmk()) {
                txtUsername.setText(ul.getUser());
                txtPassword.setText(ul.getPass());

            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        checkRemember = new javax.swing.JCheckBox();
        btnDangNhap = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        lblQuenMK = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(72, 72, 72));
        jPanel1.setPreferredSize(new java.awt.Dimension(110, 35));

        jPanel3.setPreferredSize(new java.awt.Dimension(350, 350));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo 350x350.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel2.setBackground(new java.awt.Color(255, 30, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 30, 0));
        jLabel2.setText("Đăng nhập");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Username:");

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtUsername.setPreferredSize(new java.awt.Dimension(200, 30));
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsernameKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password:");

        checkRemember.setBackground(new java.awt.Color(72, 72, 72));
        checkRemember.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkRemember.setForeground(new java.awt.Color(255, 255, 255));
        checkRemember.setText("Remember?");
        checkRemember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkRememberActionPerformed(evt);
            }
        });

        btnDangNhap.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.setPreferredSize(new java.awt.Dimension(100, 35));
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        btnHuy.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.setPreferredSize(new java.awt.Dimension(100, 35));
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        lblQuenMK.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        lblQuenMK.setForeground(new java.awt.Color(255, 255, 255));
        lblQuenMK.setText("Quên mật khẩu?");
        lblQuenMK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblQuenMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuenMKMouseClicked(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/facebook.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/google.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(checkRemember)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3)
                                .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblQuenMK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(checkRemember)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblQuenMK)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkRememberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkRememberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkRememberActionPerformed

    private void lblQuenMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMKMouseClicked
        // TODO add your handling code here:
        ForgotPassFrame forgotPassFrame = new ForgotPassFrame();
        forgotPassFrame.setVisible(true);
    }//GEN-LAST:event_lblQuenMKMouseClicked

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        // TODO add your handling code here:
        InetAddress inetAddress;
        try {
            inetAddress = InetAddress.getLocalHost();
        if (validateForm()) {
            Login();
            if(checkRemember.isSelected()){
                if(rud.selectIP(txtUsername.getText(), inetAddress.getHostName()) == 0){
                    rud.insert(txtUsername.getText(), txtPassword.getText());
                }else{
                    rud.remember(txtUsername.getText(), txtPassword.getText());
                }
            }else{
                rud.update();
            }
        }
        } catch (UnknownHostException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        int ret = JOptionPane.showConfirmDialog(this, "Bạn muốn thoát?", "Xác nhận",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (ret == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnHuyActionPerformed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (validateForm()) {
                Login();
            }
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void txtUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (validateForm()) {
                Login();
            }
        }
    }//GEN-LAST:event_txtUsernameKeyPressed

    public boolean validateForm() {
        if (txtUsername.getText().isEmpty()) {
            txtUsername.setBackground(Color.YELLOW);
            JOptionPane.showMessageDialog(this, "Username không được để trống!");
            txtUsername.requestFocus();
            return false;
        } else {
            Pattern pMaNV = Pattern.compile("PS[0-9]{5}");
            Matcher mMaNV = pMaNV.matcher(txtUsername.getText());
            if (!mMaNV.matches()) {
                JOptionPane.showMessageDialog(this, "Username nhập sai định dạng");
                txtUsername.requestFocus();
                txtUsername.setBackground(Color.pink);
                return false;
            } else {
                txtUsername.setBackground(Color.WHITE);
            }
        }

        if (txtPassword.getText().isEmpty()) {
            txtPassword.setBackground(Color.YELLOW);
            JOptionPane.showMessageDialog(this, "Password không được để trống!");
            txtPassword.requestFocus();
            return false;
        } else {
            txtPassword.setBackground(Color.WHITE);
        }
        return true;
    }

    public static List<NhanVien> list = new ArrayList<>();

    void Login() {
        PreparedStatement ps = null;
        Connection con = null;
        BanVeDAO bvDao = new BanVeDAO();
        NhanVien nv = new NhanVien();
        try {
            con = DBConnection.getConnection();
            String sql = "Select * from Acc_Login, NhanVien where ID_nv = Username and Username = ? and Pass = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, txtUsername.getText());
            ps.setString(2, txtPassword.getText());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String roleNV = rs.getString("role_nv");
                String tenNV = rs.getString("hoten_nv");
                String id_nv = rs.getString("id_nv");
                if (txtUsername.getText().equals(rs.getString(1)) && txtPassword.getText().equals(rs.getString(2))) {
                    if (roleNV.equalsIgnoreCase("Quản lý")) {
                        JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
                        MainJFrameQL mainQL = new MainJFrameQL();
                        mainQL.gettenQL(tenNV);
                        mainQL.setVisible(true);
                        nv.setMaNV(id_nv);
                        list.add(nv);
                        this.dispose();
                    } else if (roleNV.equalsIgnoreCase("Nhân viên")) {
                        JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
                        MainJFrameNV mainNV = new MainJFrameNV();
                        mainNV.gettenQL(tenNV);
                        mainNV.setVisible(true);
                        nv.setMaNV(id_nv);
                        list.add(nv);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Đăng nhập thất bại!");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Đăng nhập thất bại!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Đăng nhập thất bại!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton btnHuy;
    public static javax.swing.JCheckBox checkRemember;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblQuenMK;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
