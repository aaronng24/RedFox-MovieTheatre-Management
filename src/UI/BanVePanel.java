package UI;

import Controller.DBConnection;
import DAO.BanVeDAO;
import Model.Phim;
import Model.SuatChieu;
import UI.BanVe.DialogChonVe;
import UI.BanVe.DialogThongTinVeBan;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class BanVePanel extends javax.swing.JPanel {

    //public static ArrayList<JFrame> frameList = new ArrayList<>();
    public BanVePanel() {
        initComponents();
        fillTablePhim();
        btnChonGhe.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSPhim = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnChonGhe = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDSSuatChieu = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(0, 0, 0));

        tblDSPhim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblDSPhim.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phim", "Tên phim"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSPhim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSPhimMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSPhim);
        if (tblDSPhim.getColumnModel().getColumnCount() > 0) {
            tblDSPhim.getColumnModel().getColumn(0).setMinWidth(100);
            tblDSPhim.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblDSPhim.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Danh sách phim");

        btnChonGhe.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnChonGhe.setText("Chọn ghế");
        btnChonGhe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonGheActionPerformed(evt);
            }
        });

        tblDSSuatChieu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblDSSuatChieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Suất", "Ngày chiếu", "Giờ", "Loại", "Ngôn ngữ", "Phòng", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSSuatChieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSSuatChieuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDSSuatChieu);

        jPanel1.setBackground(new java.awt.Color(255, 30, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(15, 100));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnChonGhe, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnChonGhe, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnChonGheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonGheActionPerformed
        // TODO add your handling code here:
        DialogChonVe chonVe = new DialogChonVe();
        chonVe.setVisible(true);

    }//GEN-LAST:event_btnChonGheActionPerformed

    private void tblDSPhimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSPhimMouseClicked
        try {
            // TODO add your handling code here:
            fillTableSuatChieu();
            btnChonGhe.setEnabled(false);
        } catch (ParseException ex) {
            Logger.getLogger(BanVePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblDSPhimMouseClicked

    private void tblDSSuatChieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSSuatChieuMouseClicked
        // TODO add your handling code here:
        btnChonGhe.setEnabled(true);
        if (tblDSSuatChieu.getValueAt(tblDSSuatChieu.getSelectedRow(), 6).equals("Đã chiếu")) {
            JOptionPane.showMessageDialog(null, "Phim đã chiếu");
            return;
        }
    }//GEN-LAST:event_tblDSSuatChieuMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonGhe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    public static javax.swing.JTable tblDSPhim;
    public static javax.swing.JTable tblDSSuatChieu;
    // End of variables declaration//GEN-END:variables

    BanVeDAO bvDao = new BanVeDAO();

    void fillTablePhim() {
        List<Phim> list = bvDao.getPhimList();
        DefaultTableModel model = (DefaultTableModel) tblDSPhim.getModel();
        model.setRowCount(0);
        for (Phim p : list) {
            Object[] o = new Object[]{
                p.getID(), p.getTenPhim()
            };
            model.addRow(o);
        }
    }

    void fillTableSuatChieu() throws ParseException {
        String id = (String) tblDSPhim.getValueAt(tblDSPhim.getSelectedRow(), 0);
        List<SuatChieu> list = bvDao.getSuatChieuList(id);
        DefaultTableModel model = (DefaultTableModel) tblDSSuatChieu.getModel();
        model.setRowCount(0);

        String ngonngu = bvDao.getNgonNgu(id);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        Date date = new Date();

        for (SuatChieu sc : list) {
            String giobatdau = sdf.format(sc.getGioBatDau());
            String gioketthuc = sdf.format(sc.getGioKetThuc());
            String gio = giobatdau + " - " + gioketthuc;
            //String trangthai = "";
            if (sc.getTinhTrang().equals("Đã chiếu")) {
                //list.remove(sc);
                continue;
            }
            Object[] o = new Object[]{
                sc.getMaSuatChieu(), sc.getNgayChieu(), gio, sc.getMaDinhDang(), ngonngu, sc.getMaphong(), sc.getTinhTrang()
            };
            model.addRow(o);

        }
    }

}
