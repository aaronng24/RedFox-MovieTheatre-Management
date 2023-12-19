package UI.QLPanel;

import DAO.SuatChieuDAO;
import Model.NhanVien;
import Model.Phim;
import Model.PhongChieu;
import Model.SuatChieu;
import static UI.QLPanel.QLSuatChieuPanel.tblDSSuatChieu;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nguyen Dung
 */
public class DialogSuatChieu extends javax.swing.JFrame {
SuatChieuDAO dao = new SuatChieuDAO();
    
    public DialogSuatChieu() {
        initComponents();
        setLocationRelativeTo(this);
        setTitle("Thông tin suất chiếu");
        getTenPhim();
        getPhong();
        
    }
    public void getTenPhim(){
        List<Phim> list = dao.SelectTenPhim();
        for(Phim p : list){
            cboPhim.addItem(p.getTenPhim().toString());
        }  
    }
    public void getPhong(){
        List<PhongChieu> list = dao.SelectIDPhong();
        for(PhongChieu pc : list){
            cboPhong.addItem(pc.getID_PhongChieu()+"");
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Line = new javax.swing.JPanel();
        jpnLeft = new javax.swing.JPanel();
        jpnText = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollSuat = new javax.swing.JScrollPane();
        jdcNgay = new com.toedter.calendar.JDateChooser();
        btnLuu = new javax.swing.JButton();
        jpnRight = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblIcon = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cboDinhDang = new javax.swing.JComboBox<>();
        cboPhim = new javax.swing.JComboBox<>();
        cboPhong = new javax.swing.JComboBox<>();
        txtgiobatdau = new javax.swing.JTextField();
        lblNgay = new javax.swing.JLabel();
        txtgioketthuc = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtsuatchieu = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Line.setBackground(new java.awt.Color(255, 30, 0));

        javax.swing.GroupLayout LineLayout = new javax.swing.GroupLayout(Line);
        Line.setLayout(LineLayout);
        LineLayout.setHorizontalGroup(
            LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        LineLayout.setVerticalGroup(
            LineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jpnLeft.setBackground(new java.awt.Color(255, 255, 255));
        jpnLeft.setPreferredSize(new java.awt.Dimension(320, 538));

        jpnText.setBackground(new java.awt.Color(255, 255, 255));
        jpnText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setBackground(new java.awt.Color(255, 30, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 30, 0));
        jLabel1.setText("DANH SÁCH SUẤT CHIẾU");

        javax.swing.GroupLayout jpnTextLayout = new javax.swing.GroupLayout(jpnText);
        jpnText.setLayout(jpnTextLayout);
        jpnTextLayout.setHorizontalGroup(
            jpnTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTextLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnTextLayout.setVerticalGroup(
            jpnTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTextLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn phòng" }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(200, 30));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Chọn ngày:");

        jScrollSuat.setBackground(new java.awt.Color(255, 255, 255));
        jScrollSuat.setPreferredSize(new java.awt.Dimension(100, 300));

        jdcNgay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jdcNgayMouseClicked(evt);
            }
        });
        jdcNgay.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcNgayPropertyChange(evt);
            }
        });
        jdcNgay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jdcNgayKeyPressed(evt);
            }
        });

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnLeftLayout = new javax.swing.GroupLayout(jpnLeft);
        jpnLeft.setLayout(jpnLeftLayout);
        jpnLeftLayout.setHorizontalGroup(
            jpnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollSuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpnLeftLayout.createSequentialGroup()
                        .addGroup(jpnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpnText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jpnLeftLayout.createSequentialGroup()
                                .addGroup(jpnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(0, 138, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jpnLeftLayout.createSequentialGroup()
                        .addComponent(btnLuu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 74, Short.MAX_VALUE))))
        );
        jpnLeftLayout.setVerticalGroup(
            jpnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdcNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollSuat, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnRight.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel3.setText("Cập nhật suất chiếu");

        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/video-player (1).png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel4.setText("Vui lòng nhập đầy đủ thông tin");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tên phim:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Phòng chiếu:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Định dạng:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Ngày chiếu:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Giờ chiếu:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Giờ kết thúc:");

        cboDinhDang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboDinhDang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2D", "3D", "IMAX" }));
        cboDinhDang.setPreferredSize(new java.awt.Dimension(200, 30));

        cboPhim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboPhim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn phim" }));
        cboPhim.setPreferredSize(new java.awt.Dimension(200, 30));

        cboPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn phòng" }));
        cboPhong.setPreferredSize(new java.awt.Dimension(200, 30));

        txtgiobatdau.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtgiobatdau.setPreferredSize(new java.awt.Dimension(200, 30));

        lblNgay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNgay.setText("xx/xx/xxxx");
        lblNgay.setPreferredSize(new java.awt.Dimension(200, 30));

        txtgioketthuc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtgioketthuc.setPreferredSize(new java.awt.Dimension(200, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Cập nhật");
        jButton1.setPreferredSize(new java.awt.Dimension(100, 35));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Hủy");
        jButton2.setPreferredSize(new java.awt.Dimension(100, 35));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Suất Chiếu:");

        javax.swing.GroupLayout jpnRightLayout = new javax.swing.GroupLayout(jpnRight);
        jpnRight.setLayout(jpnRightLayout);
        jpnRightLayout.setHorizontalGroup(
            jpnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRightLayout.createSequentialGroup()
                .addGroup(jpnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnRightLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jpnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jpnRightLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jpnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnRightLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(cboPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnRightLayout.createSequentialGroup()
                                    .addGroup(jpnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addGroup(jpnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9))
                                        .addComponent(jLabel7))
                                    .addGap(18, 18, 18)
                                    .addGroup(jpnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cboDinhDang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jpnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtgiobatdau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtgioketthuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGroup(jpnRightLayout.createSequentialGroup()
                                    .addGroup(jpnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnRightLayout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(36, 36, 36))
                                        .addGroup(jpnRightLayout.createSequentialGroup()
                                            .addComponent(jLabel11)
                                            .addGap(28, 28, 28)))
                                    .addGroup(jpnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cboPhim, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtsuatchieu)))))))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnRightLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );
        jpnRightLayout.setVerticalGroup(
            jpnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRightLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jpnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnRightLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(jpnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(txtsuatchieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboPhim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jpnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jpnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cboDinhDang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jpnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtgiobatdau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jpnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtgioketthuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jpnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Line, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Line, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnLeft, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
            .addComponent(jpnRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String masuatchieu = txtsuatchieu.getText();
        String giobatdau = txtgiobatdau.getText();
        String gioketthuc = txtgioketthuc.getText();
        String ngaychieu = lblNgay.getText();
        String phim = cboPhim.getSelectedItem().toString();
        String phongchieu = cboPhong.getSelectedItem().toString();
        if(dao.validate(masuatchieu, phim, phongchieu, ngaychieu,giobatdau, gioketthuc)){
            if (dao.selectAll().isEmpty()) {
            this.insert();
        } else {
            for (int i = 0; i < dao.selectAll().size(); i++) {
                if (txtsuatchieu.getText().equals(dao.selectAll().get(i).getMaSuatChieu())) {
                    this.update();
                    return;
                    
                }
            }
            this.insert();
        }   
        }
        
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jdcNgayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdcNgayKeyPressed

    }//GEN-LAST:event_jdcNgayKeyPressed

    private void jdcNgayPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcNgayPropertyChange

    }//GEN-LAST:event_jdcNgayPropertyChange

    private void jdcNgayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jdcNgayMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jdcNgayMouseClicked

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed

                  SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
                String pattern = format.format(jdcNgay.getDate());
                lblNgay.setText(pattern);  
             
            
    }//GEN-LAST:event_btnLuuActionPerformed
    void insert(){
        SuatChieu sc = this.getForm(); 
            try {
                dao.insert(sc);// thêm mới
                this.fillTable();
//                this.clearForm(); // xóa trắng form
                JOptionPane.showMessageDialog(this, "Thêm mới thành công!");
            } 
            catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Thêm mới thất bại!");
            }
    }
    void newDate(){
        jdcNgay.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                  SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
                String pattern = format.format(jdcNgay.getDate());
                lblNgay.setText(pattern);  
             
            }
                }
        );
    }
    int i = 1;
    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) QLSuatChieuPanel.tblDSSuatChieu.getModel();
        model.setRowCount(0);
        try {
            List<SuatChieu> list = dao.selectAll();
            for (SuatChieu sc : list) {
                Object[] row = {
                    i++,sc.getMaSuatChieu(),sc.getTenPhim(),sc.getNgayChieu(),sc.getGioBatDau(),sc.getGioKetThuc(),sc.getMaDinhDang(),sc.getMaphong(),"Đang chiếu"
                };
                
                model.addRow(row);
            }
        } 
        catch (Exception e) {
        }
    }
    void update(){
        SuatChieu sc = this.getForm();
                dao.update(sc);// cập nhật // đổ lại bảng
                this.fillTable();
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            
    }
      SuatChieu getForm(){
        SuatChieu sc = new SuatChieu();
        sc.setMaSuatChieu(txtsuatchieu.getText());
        sc.setTenPhim(cboPhim.getSelectedItem().toString());
        sc.setMaphong(Integer.parseInt(cboPhong.getSelectedItem().toString()));
        sc.setMaDinhDang(cboDinhDang.getSelectedItem().toString());
        sc.setNgayChieu(jdcNgay.getDate());
        sc.setGioBatDau(Time.valueOf(txtgiobatdau.getText()));
        sc.setGioKetThuc(Time.valueOf(txtgioketthuc.getText()));
        return sc;
    }
     
      
     void setForm(SuatChieu sc){
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        String giobatdau = format.format(sc.getGioBatDau());
        String gioketthuc = format.format(sc.getGioKetThuc());
        txtsuatchieu.setText(sc.getMaSuatChieu());
        cboPhim.setSelectedItem(sc.getTenPhim());
        cboPhong.setSelectedItem(sc.getMaphong()+"");
        cboDinhDang.setSelectedItem(sc.getMaDinhDang());
        lblNgay.setText(sc.getNgayChieu().toString());
        txtgiobatdau.setText(giobatdau);
        txtgioketthuc.setText(gioketthuc);
        jdcNgay.setDate(sc.getNgayChieu());
        System.out.print(giobatdau);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Line;
    private javax.swing.JButton btnLuu;
    private javax.swing.JComboBox<String> cboDinhDang;
    private javax.swing.JComboBox<String> cboPhim;
    private javax.swing.JComboBox<String> cboPhong;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollSuat;
    private com.toedter.calendar.JDateChooser jdcNgay;
    private javax.swing.JPanel jpnLeft;
    private javax.swing.JPanel jpnRight;
    private javax.swing.JPanel jpnText;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblNgay;
    private javax.swing.JTextField txtgiobatdau;
    private javax.swing.JTextField txtgioketthuc;
    private javax.swing.JTextField txtsuatchieu;
    // End of variables declaration//GEN-END:variables
}
