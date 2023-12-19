package UI.QLPanel;

import Controller.DBConnection;
import DAO.SuatChieuDAO;
import Model.NhanVien;
import Model.Phim;
import Model.PhongChieu;
import Model.SuatChieu;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class QLSuatChieuPanel extends javax.swing.JPanel {

    public QLSuatChieuPanel() throws ParseException {
        initComponents();
        fillTable();
        getTenPhim();
        getPhong();
    }
    SuatChieuDAO scd = new SuatChieuDAO();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSSuatChieu = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jdcCongChieu = new com.toedter.calendar.JDateChooser();
        cboPhongChieu = new javax.swing.JComboBox<>();
        cboTenPhim = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(0, 0, 0));

        tblDSSuatChieu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblDSSuatChieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã suất", "Tên phim", "Giờ chiếu", "Giờ kết thúc", "Ngày chiếu", "Định dạng", "Phòng chiếu", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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
        jScrollPane1.setViewportView(tblDSSuatChieu);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setPreferredSize(new java.awt.Dimension(100, 35));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setPreferredSize(new java.awt.Dimension(100, 35));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(250, 30, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(250, 30, 0));
        jLabel1.setText("Tra Cứu Suất Chiếu");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(232, 249, 253));
        jLabel2.setText("Phòng chiếu:");
        jLabel2.setPreferredSize(new java.awt.Dimension(70, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(232, 249, 253));
        jLabel3.setText("Ngày:");
        jLabel3.setPreferredSize(new java.awt.Dimension(70, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(232, 249, 253));
        jLabel4.setText("Tên phim:");
        jLabel4.setPreferredSize(new java.awt.Dimension(70, 30));

        btnTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setPreferredSize(new java.awt.Dimension(120, 30));
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRefresh.setText("Reset");
        btnRefresh.setPreferredSize(new java.awt.Dimension(120, 30));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jdcCongChieu.setPreferredSize(new java.awt.Dimension(200, 30));

        cboPhongChieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn Phòng" }));
        cboPhongChieu.setPreferredSize(new java.awt.Dimension(200, 30));

        cboTenPhim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn Tên Phim" }));
        cboTenPhim.setPreferredSize(new java.awt.Dimension(250, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcCongChieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboPhongChieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboTenPhim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addGap(9, 9, 9))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboPhongChieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboTenPhim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jdcCongChieu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        DialogSuatChieu dialogs = new DialogSuatChieu();
        dialogs.setVisible(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        deleteSuatChieu();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblDSSuatChieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSSuatChieuMouseClicked
        List<SuatChieu> list = new ArrayList();
        int i = tblDSSuatChieu.getSelectedRow();
        if (evt.getClickCount() == 2) {
            DialogSuatChieu dialogSuatChieu = new DialogSuatChieu();
            SuatChieu sc = new SuatChieu();
            sc.setMaSuatChieu(tblDSSuatChieu.getValueAt(i, 1).toString());
            sc.setTenPhim(tblDSSuatChieu.getValueAt(i, 2).toString());
            sc.setGioBatDau(Time.valueOf(tblDSSuatChieu.getValueAt(i, 3).toString()));
            sc.setGioKetThuc(Time.valueOf(tblDSSuatChieu.getValueAt(i, 4).toString()));
            sc.setNgayChieu((Date) tblDSSuatChieu.getValueAt(i, 5));
            sc.setMaDinhDang(tblDSSuatChieu.getValueAt(i, 6).toString());
            sc.setMaphong((int) tblDSSuatChieu.getValueAt(i, 7));
            dialogSuatChieu.setForm(sc);
            dialogSuatChieu.setVisible(true);
        }

    }//GEN-LAST:event_tblDSSuatChieuMouseClicked
    boolean timTheoNgay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = format.format(jdcCongChieu.getDate());
        DefaultTableModel model = (DefaultTableModel) tblDSSuatChieu.getModel();
        model.setRowCount(0);
        int i = 1;
        if (jdcCongChieu.getDate().toString().length() != 0 && cboPhongChieu.getSelectedIndex() != 0 && cboTenPhim.getSelectedIndex() != 0) {
            try {
                for (SuatChieu sc : scd.FindSuatChieu(date1, Integer.parseInt(cboPhongChieu.getSelectedItem().toString()), cboTenPhim.getSelectedItem().toString())) {
                    Object[] row = {
                        i++, sc.getMaSuatChieu(), sc.getTenPhim(), sc.getGioBatDau(), sc.getGioKetThuc(), sc.getNgayChieu(), sc.getMaDinhDang(), sc.getMaphong(), sc.getTinhTrang()
                    };
                    model.addRow(row);
                }
            } catch (Exception E) {
                return false;
            }
        }
        return true;
    }

    boolean timTheoPhong() {
        try {
            int i = 1;
            DefaultTableModel model = (DefaultTableModel) tblDSSuatChieu.getModel();
            model.setRowCount(0);
            for (SuatChieu sc : scd.FindPhongSuatChieu(cboPhongChieu.getSelectedItem().toString())) {
                Object[] row = {
                    i++, sc.getMaSuatChieu(), sc.getTenPhim(), sc.getGioBatDau(), sc.getGioKetThuc(), sc.getNgayChieu(), sc.getMaDinhDang(), sc.getMaphong(), sc.getTinhTrang()
                };
                model.addRow(row);
            }
        } catch (Exception E) {
            return false;
        }
        return true;
    }

    boolean timTheoTen() {
        try {
            int i = 1;
            DefaultTableModel model = (DefaultTableModel) tblDSSuatChieu.getModel();
            model.setRowCount(0);
            for (SuatChieu sc : scd.FindTenSuatChieu(cboTenPhim.getSelectedItem().toString())) {
                Object[] row = {
                    i++, sc.getMaSuatChieu(), sc.getTenPhim(), sc.getGioBatDau(), sc.getGioKetThuc(), sc.getNgayChieu(), sc.getMaDinhDang(), sc.getMaphong(), sc.getTinhTrang()
                };
                model.addRow(row);
            }
        } catch (Exception E) {
            return false;
        }
        return true;
    }

    boolean timTheoPhongvaTen() {
        try {
            int i = 1;
            DefaultTableModel model = (DefaultTableModel) tblDSSuatChieu.getModel();
            model.setRowCount(0);
            for (SuatChieu sc : scd.FindPhongandTen(Integer.parseInt(cboPhongChieu.getSelectedItem().toString()), cboTenPhim.getSelectedItem().toString())) {
                Object[] row = {
                    i++, sc.getMaSuatChieu(), sc.getTenPhim(), sc.getGioBatDau(), sc.getGioKetThuc(), sc.getNgayChieu(), sc.getMaDinhDang(), sc.getMaphong(), sc.getTinhTrang()
                };
                model.addRow(row);
            }
        } catch (Exception E) {

        }
        return true;
    }

    boolean timTheoNgayvaPhong() {
        try {
            int i = 1;
            DefaultTableModel model = (DefaultTableModel) tblDSSuatChieu.getModel();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String date1 = format.format(jdcCongChieu.getDate());
            model.setRowCount(0);
            for (SuatChieu sc : scd.FindNgayandPhong(date1, Integer.parseInt(cboPhongChieu.getSelectedItem().toString()))) {
                Object[] row = {
                    i++, sc.getMaSuatChieu(), sc.getTenPhim(), sc.getGioBatDau(), sc.getGioKetThuc(), sc.getNgayChieu(), sc.getMaDinhDang(), sc.getMaphong(), sc.getTinhTrang()
                };
                model.addRow(row);
            }
        } catch (Exception E) {
            return false;
        }
        return true;
    }

    boolean timTheoNgayvaTen() {
        try {
            int i = 1;
            DefaultTableModel model = (DefaultTableModel) tblDSSuatChieu.getModel();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String date1 = format.format(jdcCongChieu.getDate());
            model.setRowCount(0);
            for (SuatChieu sc : scd.FindNgayandTen(date1, cboTenPhim.getSelectedItem().toString())) {
                Object[] row = {
                    i++, sc.getMaSuatChieu(), sc.getTenPhim(), sc.getGioBatDau(), sc.getGioKetThuc(), sc.getNgayChieu(), sc.getMaDinhDang(), sc.getMaphong(), sc.getTinhTrang()
                };
                model.addRow(row);
            }
        } catch (Exception E) {
            return false;
        }
        return true;
    }

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        if (jdcCongChieu.getDate() == null) {
            if (cboPhongChieu.getSelectedIndex() == 0) {
                if (cboTenPhim.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(this, "Chưa chọn thông tin cần tìm");
                } else {
                    timTheoTen();
                }
            } else {
                if (cboTenPhim.getSelectedIndex() == 0) {
                    timTheoPhong();
                } else {
                    timTheoPhongvaTen();
                }
            }
        } else if (cboPhongChieu.getSelectedIndex() == 0) {
            timTheoNgayvaTen();
        } else {
            timTheoNgayvaPhong();
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        jdcCongChieu.setDate(null);
        cboPhongChieu.setSelectedIndex(0);
        cboTenPhim.setSelectedIndex(0);
        try {
            fillTable();
        } catch (ParseException ex) {
            Logger.getLogger(QLSuatChieuPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboPhongChieu;
    private javax.swing.JComboBox<String> cboTenPhim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcCongChieu;
    public static javax.swing.JTable tblDSSuatChieu;
    // End of variables declaration//GEN-END:variables

    SuatChieuDAO scDao = new SuatChieuDAO();
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    void fillTable() throws ParseException {

        List<SuatChieu> list = scDao.selectAll();
        DefaultTableModel model = (DefaultTableModel) tblDSSuatChieu.getModel();
        model.setRowCount(0);
        int i = 1;
        for (SuatChieu sc : list) {
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            String giobatdau = sdf.format(sc.getGioBatDau());
            String gioketthuc = sdf.format(sc.getGioKetThuc());
            Object[] o = new Object[]{
                i++, sc.getMaSuatChieu(), sc.getTenPhim(), giobatdau, gioketthuc, sc.getNgayChieu(), sc.getMaDinhDang(), sc.getMaphong(), sc.getTinhTrang()
            };
            model.addRow(o);
        }
    }

    void deleteSuatChieu() {
        int i = tblDSSuatChieu.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tblDSSuatChieu.getModel();
        String id = model.getValueAt(i, 1).toString();
        try {
            scDao.delete(id);
            this.fillTable();
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Xóa thất bại!");
        }
    }

    public void getTenPhim() {
        List<Phim> list = scDao.SelectTenPhim();
        for (Phim p : list) {
            cboTenPhim.addItem(p.getTenPhim().toString());
        }
    }

    public void getPhong() {
        List<PhongChieu> list = scDao.SelectIDPhong();
        for (PhongChieu pc : list) {
            cboPhongChieu.addItem(pc.getID_PhongChieu() + "");
        }
    }
}
