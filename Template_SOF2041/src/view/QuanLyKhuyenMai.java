/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import model.ChiTietKhuyenMai;
import model.KhuyenMai;
import repository.ChiTietKhuyenMaiService;
import repository.KhuyenMaiService;

/**
 *
 * @author tu204
 */
public class QuanLyKhuyenMai extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyKhuyenMai
     */
    private DefaultTableModel model = new DefaultTableModel();
    private DefaultTableModel modelCTKM = new DefaultTableModel();
    
    private ArrayList<KhuyenMai> lst = new ArrayList<>();
    private ArrayList<ChiTietKhuyenMai> lstCTKM = new ArrayList<>();
    
    private ChiTietKhuyenMaiService ctkmsv = new ChiTietKhuyenMaiService();
    private KhuyenMaiService kmsv = new KhuyenMaiService();

    public QuanLyKhuyenMai() {
        initComponents();
        setLocationRelativeTo(null);
        
        lst = kmsv.getAllKhuyenMai();
        model = (DefaultTableModel) tblHienThi.getModel();

        loatDataKM(lst);
        lstCTKM = ctkmsv.getAllChiTietKhuyenMai();
        modelCTKM = (DefaultTableModel) tblCTKM.getModel();
       loatCTKM(lstCTKM);
        
    }
    public void loatDataKM(ArrayList<KhuyenMai> lstKM) {
        model.setRowCount(0);
        for (KhuyenMai km : lstKM) {
            model.addRow(new Object[]{
                km.getID(),
                km.getMaKM(),
                km.getTen(),
                km.getTrangThai(),
                km.getNgayBatDau(),
                km.getNgayKetThuc()
            });
        }
    }

    public void loatCTKM(ArrayList<ChiTietKhuyenMai> lstCTKMM){
        modelCTKM.setRowCount(0);
        for (ChiTietKhuyenMai ctkm : lstCTKMM) {
            modelCTKM.addRow(new Object[]{
                ctkm.getID(),
                ctkm.getID_SP(),
                ctkm.getID_KM(),
                ctkm.getMaKM(),
                ctkm.getGiaTri(),
                ctkm.getHinhThuc(),
                ctkm.getSoLuong(),
                ctkm.getDK_Ap_Dung()
            });
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        lblMaNH = new javax.swing.JLabel();
        txtMaNH = new javax.swing.JTextField();
        lblMaNH1 = new javax.swing.JLabel();
        txtMaNH1 = new javax.swing.JTextField();
        lblMaNH2 = new javax.swing.JLabel();
        txtMaNH2 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        lblMaNH3 = new javax.swing.JLabel();
        txtMaNH3 = new javax.swing.JTextField();
        lblMaNH4 = new javax.swing.JLabel();
        txtMaNH4 = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHienThi = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        lblMaNH5 = new javax.swing.JLabel();
        txtMaNH5 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCTKM = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        lblMaNH.setText("ID");

        lblMaNH1.setText("Mã khuyến mại");

        lblMaNH2.setText("Tên");

        jLabel38.setText("Trạng thái");

        buttonGroup1.add(jRadioButton13);
        jRadioButton13.setText("Hoạt động");

        buttonGroup1.add(jRadioButton14);
        jRadioButton14.setText("Chưa hoạt động");

        lblMaNH3.setText("Ngày bắt đầu");

        lblMaNH4.setText("Ngày kết thúc");

        jButton19.setText("Thêm");

        jButton20.setText("Sửa");

        jButton21.setText("Xoá");

        tblHienThi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã khuyến mại", "Tên khuyến mại", "Trạng thái", "Ngày bắt đầu", "Ngày kết thúc"
            }
        ));
        jScrollPane2.setViewportView(tblHienThi);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jButton19)
                .addGap(26, 26, 26)
                .addComponent(jButton20)
                .addGap(37, 37, 37)
                .addComponent(jButton21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtMaNH1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                        .addComponent(lblMaNH, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblMaNH1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtMaNH))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtMaNH2, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                        .addComponent(lblMaNH2, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMaNH3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(13, 13, 13)
                        .addComponent(jRadioButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jRadioButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtMaNH3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtMaNH4, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                        .addComponent(lblMaNH4, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblMaNH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMaNH1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaNH1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMaNH2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaNH2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jRadioButton13)
                    .addComponent(jRadioButton14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMaNH3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaNH3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMaNH4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaNH4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton19)
                    .addComponent(jButton20)
                    .addComponent(jButton21))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Khuyến mại", jPanel2);

        lblMaNH5.setText("Tìm kiếm");

        tblCTKM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "ID_SP", "ID_KM", "Mã khuyến mại", "Hình thức", "Giá trị", "Số lượng", "DK_Ap_Dung"
            }
        ));
        jScrollPane3.setViewportView(tblCTKM);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtMaNH5, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                        .addComponent(lblMaNH5, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMaNH5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaNH5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Chi tiết khuyến mại", jPanel8);

        jLabel1.setText("QUẢN LÝ KHUYẾN MẠI");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyKhuyenMai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblMaNH;
    private javax.swing.JLabel lblMaNH1;
    private javax.swing.JLabel lblMaNH2;
    private javax.swing.JLabel lblMaNH3;
    private javax.swing.JLabel lblMaNH4;
    private javax.swing.JLabel lblMaNH5;
    private javax.swing.JTable tblCTKM;
    private javax.swing.JTable tblHienThi;
    private javax.swing.JTextField txtMaNH;
    private javax.swing.JTextField txtMaNH1;
    private javax.swing.JTextField txtMaNH2;
    private javax.swing.JTextField txtMaNH3;
    private javax.swing.JTextField txtMaNH4;
    private javax.swing.JTextField txtMaNH5;
    // End of variables declaration//GEN-END:variables
}
