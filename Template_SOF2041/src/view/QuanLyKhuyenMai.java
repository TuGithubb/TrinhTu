/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.ArrayList;
import javax.swing.JOptionPane;

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
        model = (DefaultTableModel) tblHienThiKM.getModel();

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

    public void loatCTKM(ArrayList<ChiTietKhuyenMai> lstCTKMM) {
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

    private KhuyenMai getKhuyenMai() {
        int ID = Integer.parseInt(txtIDKM.getText().trim());
        String MaKM = txtMaKM.getText().trim();
        String Ten = txtTenKM.getText().trim();
        String trangThai;
        if (rdoHoatDong.isSelected() == true) {
            trangThai = "Hoat_Dong";
        } else {
            trangThai = "Chua_Hoat_Dong";
        }

        String ngayBatDau = txtNgayBatDau.getText().trim();
        String ngayKetThuc = txtNgayKetThuc.getText().trim();

        KhuyenMai km = new KhuyenMai(ID, MaKM, Ten, trangThai, ngayBatDau, ngayKetThuc);
        return km;
    }

    public void clickTable(int index) {
        KhuyenMai km = lst.get(index);
        txtIDKM.setText(km.getID() + "");
        txtMaKM.setText(km.getMaKM());
        txtTenKM.setText(km.getTen());
        String trangThai = km.getTrangThai();
        if (trangThai.equalsIgnoreCase("Hoat_Dong")) {
            rdoHoatDong.setSelected(true);
        } else {
            rdoChuaHoatDong.setSelected(true);
        }
        txtNgayBatDau.setText(km.getNgayBatDau());
        txtNgayKetThuc.setText(km.getNgayKetThuc());
    }

    public void clickTableCTKM(int indexCTKM) {
        ChiTietKhuyenMai ctkm = lstCTKM.get(indexCTKM);
        txtIDCTKM.setText(ctkm.getID() + "");
        txtIDSPCTKM.setText(ctkm.getID_SP() + "");
        txtIDKMCTKM.setText(ctkm.getID_KM() + "");
        txtMaKMCTKM.setText(ctkm.getMaKM() + "");
        String hinhThuc = ctkm.getHinhThuc();
        if (hinhThuc.equalsIgnoreCase("Giam_Gia")) {
            rdoGiamGia.setSelected(true);
        } else {
            rdoTangGia.setSelected(true);
        }
        txtGiaTri.setText(ctkm.getGiaTri() + "");
        txtSoLuong.setText(ctkm.getSoLuong() + "");
        txtDKApDung.setText(ctkm.getDK_Ap_Dung());
    }

    private ChiTietKhuyenMai getChiTietKhuyenMai() {
        int ID = Integer.parseInt(txtIDCTKM.getText().trim());
        int IDSP = Integer.parseInt(txtIDSPCTKM.getText().trim());
        int IDKM = Integer.parseInt(txtIDKMCTKM.getText().trim());
        String MaKM = txtMaKMCTKM.getText().trim();
        String hinhThuc;
        if (rdoGiamGia.isSelected() == true) {
            hinhThuc = "Giam_Gia";
        } else {
            hinhThuc = "Tang_Gia";
        }

        double giaTri = Double.parseDouble(txtGiaTri.getText().trim());
        int soLuong = Integer.parseInt(txtSoLuong.getText().trim());
        String DkApDung = txtDKApDung.getText().trim();

        ChiTietKhuyenMai ctkm = new ChiTietKhuyenMai(ID, IDSP, IDKM, MaKM, hinhThuc, giaTri, soLuong, DkApDung);
        return ctkm;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        lblMaNH = new javax.swing.JLabel();
        txtIDKM = new javax.swing.JTextField();
        lblMaNH1 = new javax.swing.JLabel();
        txtMaKM = new javax.swing.JTextField();
        lblMaNH2 = new javax.swing.JLabel();
        txtTenKM = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        rdoHoatDong = new javax.swing.JRadioButton();
        rdoChuaHoatDong = new javax.swing.JRadioButton();
        lblMaNH3 = new javax.swing.JLabel();
        txtNgayBatDau = new javax.swing.JTextField();
        lblMaNH4 = new javax.swing.JLabel();
        txtNgayKetThuc = new javax.swing.JTextField();
        btnThemKM = new javax.swing.JButton();
        btnSuaKM = new javax.swing.JButton();
        btnXoaKM = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHienThiKM = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCTKM = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblMaNH5 = new javax.swing.JLabel();
        txtIDCTKM = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIDSPCTKM = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtIDKMCTKM = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMaKMCTKM = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rdoGiamGia = new javax.swing.JRadioButton();
        rdoTangGia = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        txtGiaTri = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDKApDung = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnThemCTKM = new javax.swing.JButton();
        btnSuaCTKM = new javax.swing.JButton();
        btnXoaCTKM = new javax.swing.JButton();
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

        lblMaNH.setText("ID");

        lblMaNH1.setText("Mã khuyến mại");

        lblMaNH2.setText("Tên");

        jLabel38.setText("Trạng thái");

        buttonGroup1.add(rdoHoatDong);
        rdoHoatDong.setText("Hoạt động");

        buttonGroup1.add(rdoChuaHoatDong);
        rdoChuaHoatDong.setText("Chưa hoạt động");

        lblMaNH3.setText("Ngày bắt đầu");

        lblMaNH4.setText("Ngày kết thúc");

        btnThemKM.setText("Thêm");
        btnThemKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKMActionPerformed(evt);
            }
        });

        btnSuaKM.setText("Sửa");
        btnSuaKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaKMActionPerformed(evt);
            }
        });

        btnXoaKM.setText("Xoá");
        btnXoaKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKMActionPerformed(evt);
            }
        });

        tblHienThiKM.setModel(new javax.swing.table.DefaultTableModel(
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
        tblHienThiKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHienThiKMMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHienThiKM);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(btnThemKM)
                        .addGap(26, 26, 26)
                        .addComponent(btnSuaKM)
                        .addGap(37, 37, 37)
                        .addComponent(btnXoaKM))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtMaKM, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                                .addComponent(lblMaNH, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblMaNH1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtIDKM))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtTenKM, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                                .addComponent(lblMaNH2, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblMaNH3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(13, 13, 13)
                                .addComponent(rdoHoatDong, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(rdoChuaHoatDong, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtNgayBatDau, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                                .addComponent(lblMaNH4, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 855, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblMaNH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIDKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMaNH1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMaNH2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(rdoHoatDong)
                    .addComponent(rdoChuaHoatDong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMaNH3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMaNH4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemKM)
                    .addComponent(btnSuaKM)
                    .addComponent(btnXoaKM))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Khuyến mại", jPanel2);

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
        tblCTKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTKMMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblCTKM);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Quản lý"));

        lblMaNH5.setText("ID");

        jLabel2.setText("ID SP");

        jLabel3.setText("ID_KM");

        jLabel4.setText("Ma_KM");

        jLabel5.setText("Hình thức");

        buttonGroup3.add(rdoGiamGia);
        rdoGiamGia.setText("Giảm giá");

        buttonGroup3.add(rdoTangGia);
        rdoTangGia.setText("Tăng giá");

        jLabel6.setText("Giá trị: ");

        jLabel7.setText("Số lượng");

        jLabel8.setText("DK áp dụng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaKMCTKM, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtIDKMCTKM))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaNH5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIDCTKM)
                            .addComponent(txtIDSPCTKM, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))))
                .addGap(169, 169, 169)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rdoGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(rdoTangGia, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtGiaTri)
                    .addComponent(txtSoLuong)
                    .addComponent(txtDKApDung))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaNH5)
                    .addComponent(txtIDCTKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(rdoGiamGia)
                    .addComponent(rdoTangGia))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIDSPCTKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIDKMCTKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMaKMCTKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(txtDKApDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        btnThemCTKM.setText("Thêm");
        btnThemCTKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCTKMActionPerformed(evt);
            }
        });

        btnSuaCTKM.setText("Sửa");
        btnSuaCTKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaCTKMActionPerformed(evt);
            }
        });

        btnXoaCTKM.setText("Xoá");
        btnXoaCTKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaCTKMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 9, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158)
                        .addComponent(btnThemCTKM)
                        .addGap(42, 42, 42)
                        .addComponent(btnSuaCTKM)
                        .addGap(51, 51, 51)
                        .addComponent(btnXoaCTKM)
                        .addGap(412, 412, 412))))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSuaCTKM, btnThemCTKM, btnXoaCTKM});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemCTKM)
                            .addComponent(btnSuaCTKM)
                            .addComponent(btnXoaCTKM))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSuaCTKM, btnThemCTKM, btnXoaCTKM});

        jTabbedPane1.addTab("Chi tiết khuyến mại", jPanel8);

        jLabel1.setText("QUẢN LÝ KHUYẾN MẠI");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

    private void tblHienThiKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHienThiKMMouseClicked
        // TODO add your handling code here:
        int chon = tblHienThiKM.getSelectedRow();
        clickTable(chon);
    }//GEN-LAST:event_tblHienThiKMMouseClicked

    private void btnThemKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKMActionPerformed
        // TODO add your handling code here:
        try {
            //Check rỗng, là số, check miền.
            KhuyenMai km = getKhuyenMai();
            if (kmsv.addKhuyenMai(km) != null) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                loatDataKM(lst);
            } else {
                JOptionPane.showMessageDialog(this, "Không thêm được dòng nào");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm!");
        }
    }//GEN-LAST:event_btnThemKMActionPerformed

    private void btnSuaKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaKMActionPerformed
        // TODO add your handling code here:
        try {
            //Check rỗng, là số, check miền.
            KhuyenMai km = getKhuyenMai();
            if (kmsv.updateKhuyenMai(km) != null) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                loatDataKM(lst);
            } else {
                JOptionPane.showMessageDialog(this, "Không Sửa được dòng nào");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi sửa!");
        }
    }//GEN-LAST:event_btnSuaKMActionPerformed

    private void btnXoaKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKMActionPerformed
        // TODO add your handling code here:
        try {
            //Check rỗng, là số, check miền.
            KhuyenMai km = getKhuyenMai();
            if (kmsv.deleteKhuyenMai(txtIDKM.getText()) != null) {
                JOptionPane.showMessageDialog(this, "Xoá thành công");
                loatDataKM(lst);
            } else {
                JOptionPane.showMessageDialog(this, "Không xoá được dòng nào");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi xoá!");
        }
    }//GEN-LAST:event_btnXoaKMActionPerformed

    private void tblCTKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTKMMouseClicked
        // TODO add your handling code here:
        int chonCTKM = tblCTKM.getSelectedRow();
        clickTableCTKM(chonCTKM);
    }//GEN-LAST:event_tblCTKMMouseClicked

    private void btnThemCTKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCTKMActionPerformed
        // TODO add your handling code here:
        try {
            //Check rỗng, là số, check miền.
            ChiTietKhuyenMai ctkm = getChiTietKhuyenMai();
            if (ctkmsv.addChiTietKhuyenMai(ctkm) != null) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                loatCTKM(lstCTKM);
            } else {
                JOptionPane.showMessageDialog(this, "Không thêm được dòng nào");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm!");
        }
    }//GEN-LAST:event_btnThemCTKMActionPerformed

    private void btnSuaCTKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaCTKMActionPerformed
        // TODO add your handling code here:
        try {
            //Check rỗng, là số, check miền.
            ChiTietKhuyenMai ctkm = getChiTietKhuyenMai();
            if (ctkmsv.updateChiTietKhuyenMai(ctkm) != null) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                loatCTKM(lstCTKM);
            } else {
                JOptionPane.showMessageDialog(this, "Không Sửa được dòng nào");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi sửa!");
        }
    }//GEN-LAST:event_btnSuaCTKMActionPerformed

    private void btnXoaCTKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaCTKMActionPerformed
        // TODO add your handling code here:
        try {
            //Check rỗng, là số, check miền.
            ChiTietKhuyenMai ctkm = getChiTietKhuyenMai();
            if (ctkmsv.deleteChiTietKhuyenMai(txtIDCTKM.getText()) != null) {
                JOptionPane.showMessageDialog(this, "Xoá thành công");
                loatCTKM(lstCTKM);
            } else {
                JOptionPane.showMessageDialog(this, "Không xoá được dòng nào");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi xoá!");
        }
    }//GEN-LAST:event_btnXoaCTKMActionPerformed

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
    private javax.swing.JButton btnSuaCTKM;
    private javax.swing.JButton btnSuaKM;
    private javax.swing.JButton btnThemCTKM;
    private javax.swing.JButton btnThemKM;
    private javax.swing.JButton btnXoaCTKM;
    private javax.swing.JButton btnXoaKM;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
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
    private javax.swing.JRadioButton rdoChuaHoatDong;
    private javax.swing.JRadioButton rdoGiamGia;
    private javax.swing.JRadioButton rdoHoatDong;
    private javax.swing.JRadioButton rdoTangGia;
    private javax.swing.JTable tblCTKM;
    private javax.swing.JTable tblHienThiKM;
    private javax.swing.JTextField txtDKApDung;
    private javax.swing.JTextField txtGiaTri;
    private javax.swing.JTextField txtIDCTKM;
    private javax.swing.JTextField txtIDKM;
    private javax.swing.JTextField txtIDKMCTKM;
    private javax.swing.JTextField txtIDSPCTKM;
    private javax.swing.JTextField txtMaKM;
    private javax.swing.JTextField txtMaKMCTKM;
    private javax.swing.JTextField txtNgayBatDau;
    private javax.swing.JTextField txtNgayKetThuc;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenKM;
    // End of variables declaration//GEN-END:variables
}
