package UI.BanVe;

import Controller.DBConnection;
import DAO.BanVeDAO;
import DAO.GheNgoiDAO;
import Model.GheNgoi;
import Model.KhachHang;
import Model.PhongChieu;
import Model.SuatChieu;
import UI.BanVePanel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class DialogChonVe extends javax.swing.JFrame {

    public DialogChonVe() {
        initComponents();
        setLocationRelativeTo(this);
        setExtendedState(MAXIMIZED_BOTH);
        getLoaiVeCB();

        //lblTenNhanVien.setText(jlbTenN);
//        BanVePanel.frameList.add(this);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void getTennv(String name) {
        lblTenNhanVien.setText(name);
        System.out.println(name);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel115 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel107 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTenPhim = new javax.swing.JLabel();
        lblTimeBatDau = new javax.swing.JLabel();
        lblTimeKetThuc = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cboLoaiVe = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblTenKH = new javax.swing.JLabel();
        txtSDTKH = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        lblRankKH = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblGheDaChon = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblSoGheThuong = new javax.swing.JLabel();
        lblSoGheVIP = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        lblGiamGia = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblThanhTien = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        lblDinhDang = new javax.swing.JLabel();
        lblTenNhanVien = new javax.swing.JLabel();
        pnGheNgoi = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel115.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(117, 117, 117));
        jPanel5.setPreferredSize(new java.awt.Dimension(45, 35));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setText("Ghế thường");

        jPanel8.setBackground(new java.awt.Color(55, 72, 165));
        jPanel8.setPreferredSize(new java.awt.Dimension(45, 35));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel2.setText("Ghế VIP");

        jLabel3.setText("Ghế đã có người");

        jPanel9.setBackground(new java.awt.Color(255, 15, 0));
        jPanel9.setPreferredSize(new java.awt.Dimension(45, 35));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel4.setText("Ghế đang chọn");

        jPanel10.setBackground(new java.awt.Color(81, 178, 6));
        jPanel10.setPreferredSize(new java.awt.Dimension(45, 35));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("MÀN HÌNH");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel107.setBackground(new java.awt.Color(255, 255, 255));
        jPanel107.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Tên phim:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Thời gian:");

        lblTenPhim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTenPhim.setText("...");

        lblTimeBatDau.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTimeBatDau.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimeBatDau.setText("00:00:00");
        lblTimeBatDau.setPreferredSize(new java.awt.Dimension(80, 17));

        lblTimeKetThuc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTimeKetThuc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimeKetThuc.setText("00:00:00");
        lblTimeKetThuc.setPreferredSize(new java.awt.Dimension(80, 17));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("-");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Loại vé:");

        cboLoaiVe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboLoaiVe.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("SĐT Khách hàng:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Tên Khách hàng:");

        lblTenKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTenKH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenKH.setText("null");
        lblTenKH.setPreferredSize(new java.awt.Dimension(140, 17));

        txtSDTKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSDTKH.setPreferredSize(new java.awt.Dimension(65, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Hạng Khách hàng:");

        lblRankKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblRankKH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRankKH.setText("null");
        lblRankKH.setPreferredSize(new java.awt.Dimension(140, 17));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Số ghế đã chọn:");

        lblGheDaChon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblGheDaChon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGheDaChon.setText("0");
        lblGheDaChon.setPreferredSize(new java.awt.Dimension(140, 17));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Số ghế thường:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Số ghế VIP:");

        lblSoGheThuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSoGheThuong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSoGheThuong.setText("0");
        lblSoGheThuong.setPreferredSize(new java.awt.Dimension(140, 17));

        lblSoGheVIP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSoGheVIP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSoGheVIP.setText("0");
        lblSoGheVIP.setPreferredSize(new java.awt.Dimension(140, 17));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Tổng tiền:");

        lblTongTien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTongTien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongTien.setText("0");
        lblTongTien.setPreferredSize(new java.awt.Dimension(140, 17));

        lblGiamGia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblGiamGia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGiamGia.setText("0");
        lblGiamGia.setPreferredSize(new java.awt.Dimension(140, 17));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Giảm giá:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Thành tiền:");

        lblThanhTien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblThanhTien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThanhTien.setText("0");
        lblThanhTien.setPreferredSize(new java.awt.Dimension(140, 17));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("VNĐ");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("VNĐ");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("VNĐ");

        btnThanhToan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThanhToan.setText("Xác nhận");
        btnThanhToan.setPreferredSize(new java.awt.Dimension(140, 31));
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnHuy.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.setPreferredSize(new java.awt.Dimension(140, 50));
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Định dạng:");

        lblDinhDang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDinhDang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDinhDang.setText("...");

        javax.swing.GroupLayout jPanel107Layout = new javax.swing.GroupLayout(jPanel107);
        jPanel107.setLayout(jPanel107Layout);
        jPanel107Layout.setHorizontalGroup(
            jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel107Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel107Layout.createSequentialGroup()
                        .addComponent(lblTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel107Layout.createSequentialGroup()
                        .addGroup(jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel107Layout.createSequentialGroup()
                                .addGroup(jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel107Layout.createSequentialGroup()
                                        .addComponent(lblTimeBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblTimeKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtSDTKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboLoaiVe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblRankKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblGheDaChon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblSoGheThuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblSoGheVIP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel107Layout.createSequentialGroup()
                                .addGroup(jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTenPhim, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addGroup(jPanel107Layout.createSequentialGroup()
                                        .addComponent(lblDinhDang, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())))
                    .addGroup(jPanel107Layout.createSequentialGroup()
                        .addGroup(jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(lblGiamGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel107Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        jPanel107Layout.setVerticalGroup(
            jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel107Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblTenPhim))
                .addGap(18, 18, 18)
                .addGroup(jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(lblDinhDang))
                .addGap(18, 18, 18)
                .addGroup(jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblTimeBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTimeKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cboLoaiVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtSDTKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblRankKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblGheDaChon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lblSoGheThuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lblSoGheVIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(lblTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lblGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lblThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(49, 49, 49)
                .addGroup(jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout pnGheNgoiLayout = new javax.swing.GroupLayout(pnGheNgoi);
        pnGheNgoi.setLayout(pnGheNgoiLayout);
        pnGheNgoiLayout.setHorizontalGroup(
            pnGheNgoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnGheNgoiLayout.setVerticalGroup(
            pnGheNgoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel115Layout = new javax.swing.GroupLayout(jPanel115);
        jPanel115.setLayout(jPanel115Layout);
        jPanel115Layout.setHorizontalGroup(
            jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel115Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel115Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnGheNgoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(jPanel107, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel115Layout.setVerticalGroup(
            jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel115Layout.createSequentialGroup()
                .addGroup(jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel115Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                            .addGroup(jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnGheNgoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel107, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel115, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel115, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1327, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        this.dispose();
        selectedGheNgoiMap.clear();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        if (selectedGheNgoiMap.size() >= 1) {
            DialogThongTinVeBan dialogThongTinVeBan = new DialogThongTinVeBan();
        dialogThongTinVeBan.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null,"Chưa chọn ghế!");
        }
        
//        NewJDialog d = new NewJDialog(null, true, selectedGheNgoiMap);
//        d.setVisible(true);
//        NewJDialog.btnInve.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                d.addWindowListener(new WindowAdapter() {
//                    @Override
//                    public void windowClosed(WindowEvent e) {
//                        dispose();
//                    }
//                });
//            }
//        });

    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        loadGheNgoi();
        gheNgoi();
        eventKH();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnThanhToan;
    public static javax.swing.JComboBox<String> cboLoaiVe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel107;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel115;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblDinhDang;
    private javax.swing.JLabel lblGheDaChon;
    private javax.swing.JLabel lblGiamGia;
    private javax.swing.JLabel lblRankKH;
    private javax.swing.JLabel lblSoGheThuong;
    private javax.swing.JLabel lblSoGheVIP;
    public static javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel lblTenNhanVien;
    private javax.swing.JLabel lblTenPhim;
    public static javax.swing.JLabel lblThanhTien;
    private javax.swing.JLabel lblTimeBatDau;
    public static javax.swing.JLabel lblTimeKetThuc;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JPanel pnGheNgoi;
    public static javax.swing.JTextField txtSDTKH;
    // End of variables declaration//GEN-END:variables

    Connection con;
    Statement st;
    ResultSet rs;

    BanVeDAO bvDAO = new BanVeDAO();
    SuatChieu sc;
    Map<String, GheNgoi> gheNgoiMap = new TreeMap<>();
    public static Map<String, GheNgoi> selectedGheNgoiMap = new TreeMap<>();
    List<GheNgoi> gheNgoiList;

    public void getLoaiVeCB() {
        String sql = "select * from GiaVe";
        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                cboLoaiVe.addItem(rs.getString("tenloaive"));
            }
        } catch (Exception e) {

        }
    }

    void gheNgoi() {
        int gheNgoiWidth = 45;
        int gheNgoiHeight = 35;
        int phongchieu = (int) BanVePanel.tblDSSuatChieu.getValueAt(BanVePanel.tblDSSuatChieu.getSelectedRow(), 5);
        String suatchieu = (String) BanVePanel.tblDSSuatChieu.getValueAt(BanVePanel.tblDSSuatChieu.getSelectedRow(), 0);
        String dinhdang = (String) BanVePanel.tblDSSuatChieu.getValueAt(BanVePanel.tblDSSuatChieu.getSelectedRow(), 3);
        List<GheNgoi> gheNgoiDaDatList = new GheNgoiDAO().getGheNgoiBySuatChieu(suatchieu);
        PhongChieu pc = bvDAO.getPhongChieu(phongchieu);

        pnGheNgoi.setLayout(new GridLayout(pc.getSoluongDay(), pc.getSoluongCot(), 4, 4));

        //set Thông tin
        lblTenPhim.setText((String) BanVePanel.tblDSPhim.getValueAt(BanVePanel.tblDSPhim.getSelectedRow(), 1));
        lblDinhDang.setText(dinhdang);

        SimpleDateFormat sdf = new SimpleDateFormat("HH:"
                + "mm");
        List<SuatChieu> listsc = bvDAO.getSuatChieu(suatchieu);
        Time giobatdau = null;
        Time gioketthuc = null;
        String giobdf = "";
        String gioktf = "";
        for (SuatChieu sc : listsc) {
            giobatdau = sc.getGioBatDau();
            gioketthuc = sc.getGioKetThuc();
            giobdf = sdf.format(giobatdau);
            gioktf = sdf.format(gioketthuc);
        }
        lblTimeBatDau.setText(giobdf);
        lblTimeKetThuc.setText(gioktf);

        //get giave
        for (int row = 0; row < pc.getSoluongDay(); row++) {
            for (int col = 1; col <= pc.getSoluongCot(); col++) {
                JLabel btngheNgoi = new JLabel(((char) (65 + row)) + "" + col);
                btngheNgoi.setMinimumSize(new Dimension(gheNgoiWidth, gheNgoiHeight));
                btngheNgoi.setMaximumSize(new Dimension(gheNgoiWidth, gheNgoiHeight));
                btngheNgoi.setPreferredSize(new Dimension(gheNgoiWidth, gheNgoiHeight));
                btngheNgoi.setSize(new Dimension(gheNgoiWidth, gheNgoiHeight));
                btngheNgoi.setOpaque(true);
                btngheNgoi.setHorizontalAlignment(JLabel.CENTER);
                btngheNgoi.setFont(new Font("Open Sans", Font.PLAIN, 12));
                btngheNgoi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

//                btngheNgoi.setBackground(new Color(117, 117, 117));
//                btngheNgoi.setForeground(Color.black);
                if (gheNgoiMap.get(((char) (65 + row)) + "" + col).getLoaighe().equalsIgnoreCase("GT")) {
                    btngheNgoi.setBackground(new Color(117, 117, 117));
                    btngheNgoi.setForeground(Color.black);
                } else {
                    btngheNgoi.setBackground(new Color(55, 72, 165));
                    btngheNgoi.setForeground(Color.black);
                }

                boolean gheDaDat = false;
                for (GheNgoi gn : gheNgoiDaDatList) {
                    if ((gn.getVitriDay() + gn.getVitriCot()).equals(btngheNgoi.getText())) {
                        gheDaDat = true;
                        break;
                    }
                }

                if (gheDaDat) {
                    btngheNgoi.setBackground(new Color(255, 15, 0));
                    btngheNgoi.setForeground(Color.black);
                    btngheNgoi.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                } else {
                    //Sự kiện chọn ghế
                    btngheNgoi.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                            int gt = 0;
                            int gv = 0;
                            //xét điều kiện bỏ chọn ghế
                            if (btngheNgoi.getBackground().equals(new Color(81, 178, 6))) {
                                if (selectedGheNgoiMap.get(btngheNgoi.getText()).getLoaighe().equals("GT")) {
                                    btngheNgoi.setBackground(new Color(117, 117, 117));
                                    btngheNgoi.setForeground(Color.black);
                                } else {
                                    btngheNgoi.setBackground(new Color(55, 72, 165));
                                    btngheNgoi.setForeground(Color.black);
                                }
                                selectedGheNgoiMap.remove(btngheNgoi.getText());
                                //Duyệt map để đếm loại ghế đã chọn
                                for (Map.Entry<String, GheNgoi> map : selectedGheNgoiMap.entrySet()) {
                                    GheNgoi ghengoi = map.getValue();
                                    if (ghengoi.getLoaighe().equals("GT")) {
                                        gt++;
                                    } else if (ghengoi.getLoaighe().equals("GV")) {
                                        gv++;
                                    }

                                }
                                //set text ghế
                                lblGheDaChon.setText(String.valueOf(selectedGheNgoiMap.size()));
                                lblSoGheThuong.setText(String.valueOf(gt));
                                lblSoGheVIP.setText(String.valueOf(gv));
                                String tenloaive = (String) cboLoaiVe.getSelectedItem();
                                int giave = bvDAO.getGiaVe(tenloaive);
                                int tongtien = 0;
                                tongtien = (gt * giave) + ((gv * giave) + (gv * 25000));
                                lblTongTien.setText(String.valueOf(tongtien));
                                lblThanhTien.setText(String.valueOf(tongtien - Integer.parseInt(lblGiamGia.getText())));
                            } else {
                                if (selectedGheNgoiMap.size() >= 10) {
                                    JOptionPane.showMessageDialog(null, "Không được chọn quá 10 ghế 1 lần!");
                                } else {
                                    //Chọn ghế
                                    btngheNgoi.setBackground(new Color(81, 178, 6));
                                    btngheNgoi.setForeground(Color.black);
                                    selectedGheNgoiMap.put(btngheNgoi.getText(), gheNgoiMap.get(btngheNgoi.getText()));
                                    //Duyệt map ghế đã chọn
                                    for (Map.Entry<String, GheNgoi> map : selectedGheNgoiMap.entrySet()) {
                                        GheNgoi ghengoi = map.getValue();
                                        if (ghengoi.getLoaighe().equals("GT")) {
                                            gt++;
                                        } else if (ghengoi.getLoaighe().equals("GV")) {
                                            gv++;
                                        }
                                    }
                                }
                                //set Ghế

                                lblGheDaChon.setText(String.valueOf(selectedGheNgoiMap.size()));
                                lblSoGheThuong.setText(String.valueOf(gt));
                                lblSoGheVIP.setText(String.valueOf(gv));
                                String tenloaive = (String) cboLoaiVe.getSelectedItem();
                                int giave = bvDAO.getGiaVe(tenloaive);
                                int phuthuDDP = bvDAO.getGiaLoaiPhim(dinhdang);
                                int tongtien = 0;
                                tongtien = (gt * giave + (gt * phuthuDDP)) + ((gv * giave) + (gv * 25000) + (gv * phuthuDDP));
                                lblTongTien.setText(String.valueOf(tongtien));
                                lblThanhTien.setText(String.valueOf(tongtien - Integer.parseInt(lblGiamGia.getText())));
                            }

                        }
                    });
                }

                pnGheNgoi.add(btngheNgoi);
            }
        }
        pack();
        setLocationRelativeTo(null);
    }

    void loadGheNgoi() {
        int pc = (int) BanVePanel.tblDSSuatChieu.getValueAt(BanVePanel.tblDSSuatChieu.getSelectedRow(), 5);
        for (GheNgoi gheNgoi : new GheNgoiDAO().getGheNgoiByPhongChieu(pc)) {
            gheNgoiMap.put(gheNgoi.getVitriDay() + gheNgoi.getVitriCot(), gheNgoi);
            //gheNgoiMap.put(gheNgoi.getLoaighe(), gheNgoi);

        }
    }

    void getKH() {
        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select hoten_kh,rank_kh from khachhang,rank_kh where khachhang.id_kh=rank_kh.id_kh and khachhang.sdt_kh=N'" + txtSDTKH.getText() + "'");
            if (rs.next()) {
                lblTenKH.setText(rs.getString("hoten_kh"));
                lblRankKH.setText(rs.getString("rank_kh"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DialogChonVe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void eventKH() {
        txtSDTKH.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                lblTenKH.setText("Không tìm thấy");
                getKH();
                if (lblRankKH.getText().equals("Đồng")) {
                    lblGiamGia.setText("0");
                } else if (lblRankKH.getText().equals("Bạc")) {
                    lblGiamGia.setText("5000");
                } else if (lblRankKH.getText().equals("Vàng")) {
                    lblGiamGia.setText("7000");
                } else if (lblRankKH.getText().equals("Bạch kim")) {
                    lblGiamGia.setText("10000");
                } else if (lblRankKH.getText().equals("Kim cương")) {
                    lblGiamGia.setText("12000");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                lblTenKH.setText("Không tìm thấy");
                getKH();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                lblTenKH.setText("Không tìm thấy");
                getKH();
            }

        });

    }

}
