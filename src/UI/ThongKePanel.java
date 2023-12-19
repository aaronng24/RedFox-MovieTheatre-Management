package UI;

import DAO.BarChart;
import Controller.DBConnection;
import com.toedter.calendar.JTextFieldDateEditor;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import DAO.Piechart;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import DAO.overlaperchart;

/**
 *
 * @author Nguyen Dung
 */
public class ThongKePanel extends javax.swing.JPanel {

    List<Object[]> listVeBan = new ArrayList<>();
    Connection con = null;
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;
    Vector data = null;
    DecimalFormat decimalFormat = new DecimalFormat("##,###,###,###");

    /**
     * Creates new form ThongKePanel
     */
    public ThongKePanel() {
        initComponents();

        JTextFieldDateEditor editor = (JTextFieldDateEditor) jdcFromDate.getDateEditor();
        editor.setEditable(false);
        JTextFieldDateEditor editor1 = (JTextFieldDateEditor) jdcToDate.getDateEditor();
        editor1.setEditable(false);
    }

    void tongVe(String fromDate, String toDate) {
        try {
            DefaultTableModel model = (DefaultTableModel) tblThongKe.getModel();
            model.setRowCount(0);
            con = DBConnection.getConnection();
            st = con.createStatement();

            String query = "select ngaychieu,tenphim,\n"
                    + "	count(case when ID_dinhdangphim='2D' then 1 end) as'2d', \n"
                    + "	count(case when ID_dinhdangphim='3D' then 1 end) as'3d',\n"
                    + "	count(case when ID_dinhdangphim='4DX' then 1 end) as'4dx',\n"
                    + "	count(case when ID_dinhdangphim='IMAX' then 1 end) as 'imax',\n"
                    + "count(*) as 'tong ve',sum(ve.tongtien) as tongtien\n"
                    + "from SuatChieu sc inner join Ve on sc.ID_suatchieu=Ve.ID_suatchieu inner join Phim on sc.ID_phim=Phim.ID_phim\n"
                    + "where ngaychieu between" + fromDate + "and" + toDate
                    + "Group by ngaychieu,tenphim";
            rs = st.executeQuery(query);

            while (rs.next()) {
                data = new Vector();
                data.add(rs.getDate(1));
                data.add(rs.getNString(2));
                data.add(rs.getInt(3));
                data.add(rs.getInt(4));
                data.add(rs.getInt(5));
                data.add(rs.getInt(6));
                data.add(rs.getInt(7));
                int gia = rs.getInt(8);
                String fm = new DecimalFormat("#,###").format(gia);
                data.add(fm);
                model.addRow(data);
            }
            tblThongKe.setModel(model);
        } catch (Exception e) {
            Logger.getLogger(ThongKePanel.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    void InTKk() {
        FileOutputStream out = null;
        BufferedOutputStream bos = null;
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFRow row, r = null;
        Cell cell, c = null;
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setDialogTitle("Save as");
            DefaultTableModel model1 = (DefaultTableModel) tblThongKe.getModel();

            int opt = jFileChooser.showSaveDialog(null);

            if (opt == JFileChooser.APPROVE_OPTION) {
                XSSFSheet sheet = workbook.createSheet("vé bán");
                row = sheet.createRow(0);
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("Ngày Bán");
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("Phim");
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("2D");
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("3D");
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue("4D");
                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue("IMAX");
                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue("Tổng Số Vé");
                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(" Tổng Doanh Thu");

                for (int i = 0; i < model1.getRowCount(); i++) {
                    row = sheet.createRow(i + 1);
                    for (int j = 0; j < model1.getColumnCount(); j++) {
                        cell = row.createCell(j);
                        cell.setCellValue(model1.getValueAt(i, j).toString());
                    }
                }
                out = new FileOutputStream(jFileChooser.getSelectedFile() + ".xlsx");
                bos = new BufferedOutputStream(out);
                workbook.write(bos);
                JOptionPane.showMessageDialog(null, "Thành công!");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException io) {
            System.out.println(io);
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
                if (out != null) {
                    out.close();
                }
                if (workbook != null) {
                    workbook.close();
                }
            } catch (Exception e) {
            }
        }
    }

    public void bieuDoLoaiVe(String title, String tg) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int tongVe = 0;
        for (int i = 2; i <= 5; i++) {
            String key = tblThongKe.getColumnName(i);
            for (int j = 0; j < tblThongKe.getRowCount(); j++) {
                tongVe += Integer.parseInt(tblThongKe.getValueAt(j, i).toString());
            }
            map.put(key, tongVe);
            tongVe = 0;
        }
        new Piechart().displayChart(map, "Thống Kê Loại Vé " + title);
    }

    public void xemBieuDo(String title, String tg) {
        List<String> xData = new ArrayList<String>();
        List<Integer> yData = new ArrayList<>();

        for (int i = 0; i < tblThongKe.getRowCount(); i++) {
            String xValue = (String) tblThongKe.getValueAt(i, 1);
            Integer yValue = Integer.parseInt(tblThongKe.getValueAt(i, 7).toString().replace(".", ""));
            xData.add(xValue);
            yData.add(yValue);
        }
        new BarChart(xData, yData, "Thống Kê Tổng Doanh Thu Của Phim", this, "Phim", "Doanh Thu", "Doanh Thu").displayChart();
    }

    public void tongDoanhThu() {
        Long tong = Long.valueOf(0);
        for (int i = 0; i < tblThongKe.getRowCount(); i++) {
            tong += Integer.parseInt(tblThongKe.getValueAt(i, 7).toString().replace(",", ""));
        }
    }

    public void loadDataToTable() {
        Date today = new Date();
        DefaultTableModel modelTable = (DefaultTableModel) tblThongKe.getModel();
        modelTable.setRowCount(0);
        SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
        int i = 1;
        for (Object[] fill : listVeBan) {
            if (jdcFromDate.getDate().after(today)) {
                Object[] record = new Object[]{
                    i++, fill[0], fill[1], fill[2], fill[3], fill[4], fill[5], fill[6], decimalFormat.format(fill[7])
                };
                modelTable.addRow(record);
            } else {
                Object[] record = new Object[]{
                    i++, fm.format(fill[0]), fill[1], fill[2], fill[3], fill[4], fill[5], fill[6], decimalFormat.format(fill[7])
                };
                modelTable.addRow(record);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongKe = new javax.swing.JTable();
        bieudoloaive = new javax.swing.JButton();
        bieudodoangthu = new javax.swing.JButton();
        btnThongke = new javax.swing.JButton();
        xuatfile = new javax.swing.JButton();
        jdcFromDate = new com.toedter.calendar.JDateChooser();
        jdcToDate = new com.toedter.calendar.JDateChooser();

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Từ ngày:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Đến ngày:");

        tblThongKe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ngày", "Phim", "2D", "3D", "4DX", "IMAX", "Tổng số vé", "Doanh thu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblThongKe);

        bieudoloaive.setBackground(new java.awt.Color(255, 255, 255));
        bieudoloaive.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bieudoloaive.setText("Biểu đồ loại vé");
        bieudoloaive.setBorderPainted(false);
        bieudoloaive.setFocusPainted(false);
        bieudoloaive.setPreferredSize(new java.awt.Dimension(200, 35));
        bieudoloaive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bieudoloaiveActionPerformed(evt);
            }
        });

        bieudodoangthu.setBackground(new java.awt.Color(255, 255, 255));
        bieudodoangthu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bieudodoangthu.setText("Biểu đồ doanh thu");
        bieudodoangthu.setBorderPainted(false);
        bieudodoangthu.setFocusPainted(false);
        bieudodoangthu.setPreferredSize(new java.awt.Dimension(200, 35));
        bieudodoangthu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bieudodoangthuActionPerformed(evt);
            }
        });

        btnThongke.setBackground(new java.awt.Color(51, 51, 255));
        btnThongke.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnThongke.setForeground(new java.awt.Color(255, 255, 255));
        btnThongke.setText("Thống Kê");
        btnThongke.setBorderPainted(false);
        btnThongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongkeActionPerformed(evt);
            }
        });

        xuatfile.setBackground(new java.awt.Color(255, 255, 255));
        xuatfile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        xuatfile.setText("Xuất file");
        xuatfile.setBorderPainted(false);
        xuatfile.setFocusPainted(false);
        xuatfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xuatfileActionPerformed(evt);
            }
        });

        jdcFromDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jdcFromDate.setPreferredSize(new java.awt.Dimension(200, 30));

        jdcToDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jdcToDate.setPreferredSize(new java.awt.Dimension(200, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bieudoloaive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(bieudodoangthu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(xuatfile, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jdcFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcToDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnThongke, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 244, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jdcFromDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jdcToDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnThongke))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bieudoloaive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bieudodoangthu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xuatfile, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongkeActionPerformed

        Date today = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String hnay = s.format(today);

        if (jdcFromDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Chưa chọn ngày bắt đầu(Ngày kết thúc để trống = hôm nay)");
        } else {
            if (jdcFromDate.getDate().after(today)) {
                JOptionPane.showMessageDialog(this, "Chọn sai ngày bắt đầu");
            } else if (jdcToDate.getDate() == null) {
                String ngay1 = s.format(jdcFromDate.getDate());
                tongVe(ngay1, hnay);
            } else if (jdcFromDate.getDate().after(jdcToDate.getDate())) {
                JOptionPane.showMessageDialog(this, "Chọn ngày bắt đầu trước ngày kết thúc");
            } else {
                String ngay1 = s.format(jdcFromDate.getDate());
                String ngay2 = s.format(jdcToDate.getDate());
                tongVe(ngay1, ngay2);
            }
        }
    }//GEN-LAST:event_btnThongkeActionPerformed

    private void bieudoloaiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bieudoloaiveActionPerformed

        Date today = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String hnay = s.format(today);

        if (jdcFromDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Chưa chọn ngày bắt đầu(Ngày kết thúc để trống = hôm nay)");
        } else {
            if (jdcFromDate.getDate().after(today)) {
                JOptionPane.showMessageDialog(this, "Chọn sai ngày bắt đầu");
            } else if (jdcToDate.getDate() == null) {
                String ngay1 = s.format(jdcFromDate.getDate());
                // this.xemBieuDo("Ngày " + s.format(jdcFromDate.getDate()), "Ngày");
                this.bieuDoLoaiVe(ngay1, hnay);
            } else if (jdcFromDate.getDate().after(jdcToDate.getDate())) {
                JOptionPane.showMessageDialog(this, "Chọn ngày bắt đầu trước ngày kết thúc");
            } else {
                String ngay1 = s.format(jdcFromDate.getDate());
                String ngay2 = s.format(jdcToDate.getDate());
                this.bieuDoLoaiVe(ngay1 + " đến " + ngay2, ngay2);

            }
        }

    }//GEN-LAST:event_bieudoloaiveActionPerformed

    private void xuatfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xuatfileActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tblThongKe.getModel();

        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa có dữ liệu để in");
        } else {
            InTKk();
        }
    }//GEN-LAST:event_xuatfileActionPerformed

    private void bieudodoangthuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bieudodoangthuActionPerformed
        // TODO add your handling code here:
//        if (tblThongKe.getRowCount() > 0) {
//            if (jdcToDate.getDate() == null) {
//                SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
//                this.xemBieuDo("Ngày " + ft.format(jdcFromDate.getDate()), "Ngày");
//            } else {
//                this.xemBieuDo("ngay" + jdcFromDate.getDate().toString() + "-" + jdcToDate.getDate().toString(), "Ngày");
//            }
//        } else {
//            dialoghapper.message(this, "Không có dữ liệu thống kê !", dialoghapper.ERROR_MESSAGE);
//        }

        Date today = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String hnay = s.format(today);

        if (jdcFromDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Chưa chọn ngày bắt đầu(Ngày kết thúc để trống = hôm nay)");
        } else {
            if (jdcFromDate.getDate().after(today)) {
                JOptionPane.showMessageDialog(this, "Chọn sai ngày bắt đầu");
            } else if (jdcToDate.getDate() == null) {
                String ngay1 = s.format(jdcFromDate.getDate());
                // this.xemBieuDo("Ngày " + s.format(jdcFromDate.getDate()), "Ngày");
                this.xemBieuDo(ngay1, hnay);
            } else if (jdcFromDate.getDate().after(jdcToDate.getDate())) {
                JOptionPane.showMessageDialog(this, "Chọn ngày bắt đầu trước ngày kết thúc");
            } else {
                String ngay1 = s.format(jdcFromDate.getDate());
                String ngay2 = s.format(jdcToDate.getDate());
                this.xemBieuDo(ngay1, ngay2);

            }
        }
    }//GEN-LAST:event_bieudodoangthuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bieudodoangthu;
    private javax.swing.JButton bieudoloaive;
    private javax.swing.JButton btnThongke;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcFromDate;
    private com.toedter.calendar.JDateChooser jdcToDate;
    private javax.swing.JTable tblThongKe;
    private javax.swing.JButton xuatfile;
    // End of variables declaration//GEN-END:variables

}
