/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DongCo;
import model.DongXe;
import model.HopSo;
import model.MauSac;
import model.NoiThat;
import model.PhanKhucXe;
import model.ThietKe;
import repository.DongCoService;
import repository.DongXeService;
import repository.HopSoService;
import repository.MauSacService;
import repository.NoiThatService;
import repository.PhanKhucXeService;
import repository.ThietKeService;

/**
 *
 * @author tu204
 */
public class QuanLyThuocTinh extends javax.swing.JFrame {

    private DefaultTableModel modelMauSac = new DefaultTableModel();
    private ArrayList<MauSac> lstMauSac = new ArrayList<>();
    private MauSacService mssv = new MauSacService();

    private DefaultTableModel modelNoiThat = new DefaultTableModel();
    private ArrayList<NoiThat> lstNoiThat = new ArrayList<>();
    private NoiThatService ntsv = new NoiThatService();

    private DefaultTableModel modelThietKe = new DefaultTableModel();
    private ArrayList<ThietKe> lstThietKe = new ArrayList<>();
    private ThietKeService tksv = new ThietKeService();

    private DefaultTableModel modelDongXe = new DefaultTableModel();
    private ArrayList<DongXe> lstDongXe = new ArrayList<>();
    private DongXeService dxsv = new DongXeService();

    private DefaultTableModel modelPhanKhucXe = new DefaultTableModel();
    private ArrayList<PhanKhucXe> lstPhanKhucXe = new ArrayList<>();
    private PhanKhucXeService pkxsv = new PhanKhucXeService();

    private DefaultTableModel modelDongCo = new DefaultTableModel();
    private ArrayList<DongCo> lstDongCo = new ArrayList<>();
    private DongCoService dcsv = new DongCoService();
    
    private DefaultTableModel modelHopSo = new DefaultTableModel();
    private ArrayList<HopSo> lstHopSo = new ArrayList<>();
    private HopSoService hssv = new HopSoService();
    public QuanLyThuocTinh() {
        initComponents();
        setLocationRelativeTo(null);

        modelMauSac = (DefaultTableModel) tblMauSac.getModel();
        lstMauSac = mssv.getAllMauSac();
        loatDataMauSac(lstMauSac);

        modelNoiThat = (DefaultTableModel) tblNoiThat.getModel();
        lstNoiThat = ntsv.getAllNoiThat();
        loatDataNoiThat(lstNoiThat);

        modelThietKe = (DefaultTableModel) tblThietKe.getModel();
        lstThietKe = tksv.getAllThietKe();
        loatDataThietKe(lstThietKe);

        modelDongXe = (DefaultTableModel) tblDongXe.getModel();
        lstDongXe = dxsv.getAllDongXe();
        loatDataDongXe(lstDongXe);

        modelPhanKhucXe = (DefaultTableModel) tblPhanKhucXe.getModel();
        lstPhanKhucXe = pkxsv.getAllPhanKhucXe();
        loatDataPhanKhucXe(lstPhanKhucXe);
        
        modelDongCo = (DefaultTableModel) tblDongCo.getModel();
        lstDongCo = dcsv.getAllDongCo();
        loatDataDongCo(lstDongCo);
        
        modelHopSo = (DefaultTableModel) tblHopSo.getModel();
        lstHopSo = hssv.getAllHopSo();
        loatDataHopSo(lstHopSo);
    }

    //
    public void loatDataMauSac(ArrayList<MauSac> lstMS) {
        modelMauSac.setRowCount(0);
        for (MauSac ms : lstMS) {
            modelMauSac.addRow(new Object[]{
                ms.getID(),
                ms.getTen(),
                ms.getMoTa(),
                ms.getTrangThai(),});
        }
    }

    private MauSac getMauSac() {
        int ID = Integer.parseInt(txtIDMauSac.getText().trim());
        String Ten = txtTenMauSac.getText().trim();
        String moTa = txtMoTaMauSac.getText().trim();
        String trangThai;
        if (rdoConHangMauSac.isSelected() == true) {
            trangThai = "Con_Hang";
        } else {
            trangThai = "Het_Hang";
        }

        MauSac ms = new MauSac(ID, Ten, moTa, trangThai);
        return ms;
    }

    public void clickTableMauSac(int indexMauSac) {
        MauSac ms = lstMauSac.get(indexMauSac);
        txtIDMauSac.setText(ms.getID() + "");
        txtTenMauSac.setText(ms.getTen());
        txtMoTaMauSac.setText(ms.getMoTa());
        String trangThai = ms.getTrangThai();
        if (trangThai.equalsIgnoreCase("Hoat_Dong")) {
            rdoConHangMauSac.setSelected(true);
        } else {
            rdoHetHangMauSac.setSelected(true);
        }

    }

    //---------------------------------------------------------------
    public void loatDataNoiThat(ArrayList<NoiThat> lstNT) {
        modelNoiThat.setRowCount(0);
        for (NoiThat ms : lstNT) {
            modelNoiThat.addRow(new Object[]{
                ms.getID(),
                ms.getTen(),
                ms.getMoTa(),
                ms.getTrangThai(),});
        }
    }

    private NoiThat getNoiThat() {
        int ID = Integer.parseInt(txtIDNoiThat.getText().trim());
        String Ten = txtTenNoiThat.getText().trim();
        String moTa = txtMoTaNoiThat.getText().trim();
        String trangThai;
        if (rdoConHangNoiThat.isSelected() == true) {
            trangThai = "Con_Hang";
        } else {
            trangThai = "Het_Hang";
        }

        NoiThat ms = new NoiThat(ID, Ten, moTa, trangThai);
        return ms;
    }

    public void clickTableNoiThat(int indexNoiThat) {
        NoiThat ms = lstNoiThat.get(indexNoiThat);
        txtIDNoiThat.setText(ms.getID() + "");
        txtTenNoiThat.setText(ms.getTen());
        txtMoTaNoiThat.setText(ms.getMoTa());
        String trangThai = ms.getTrangThai();
        if (trangThai.equalsIgnoreCase("Hoat_Dong")) {
            rdoConHangNoiThat.setSelected(true);
        } else {
            rdoHetHangNoiThat.setSelected(true);
        }

    }

    //------------------------------------------------------------------
    public void loatDataThietKe(ArrayList<ThietKe> lstTK) {
        modelThietKe.setRowCount(0);
        for (ThietKe tk : lstTK) {
            modelThietKe.addRow(new Object[]{
                tk.getID(),
                tk.getTen(),
                tk.getMoTa(),
                tk.getTrangThai(),});
        }
    }

    private ThietKe getThietKe() {
        int ID = Integer.parseInt(txtIDThietKe.getText().trim());
        String Ten = txtTenThietKe.getText().trim();
        String moTa = txtMoTaThietKe.getText().trim();
        String trangThai;
        if (rdoConHangThietKe.isSelected() == true) {
            trangThai = "Con_Hang";
        } else {
            trangThai = "Het_Hang";
        }

        ThietKe tk = new ThietKe(ID, Ten, moTa, trangThai);
        return tk;
    }

    public void clickTableThietKe(int indexThietKe) {
        ThietKe tk = lstThietKe.get(indexThietKe);
        txtIDThietKe.setText(tk.getID() + "");
        txtTenThietKe.setText(tk.getTen());
        txtMoTaThietKe.setText(tk.getMoTa());
        String trangThai = tk.getTrangThai();
        if (trangThai.equalsIgnoreCase("Còn hàng")) {
            rdoConHangThietKe.setSelected(true);
        } else {
            rdoHetHangThietKe.setSelected(true);
        }

    }

    //------------------------------------------------------------------
    public void loatDataDongXe(ArrayList<DongXe> lstDX) {
        modelDongXe.setRowCount(0);
        for (DongXe dx : lstDX) {
            modelDongXe.addRow(new Object[]{
                dx.getID(),
                dx.getTen(),
                dx.getMoTa(),
                dx.getTrangThai(),});
        }
    }

    private DongXe getDongXe() {
        int ID = Integer.parseInt(txtIDDongXe.getText().trim());
        String Ten = txtTenDongXe.getText().trim();
        String moTa = txtMoTaDongXe.getText().trim();
        String trangThai;
        if (rdoConHangDongXe.isSelected() == true) {
            trangThai = "Còn hàng";
        } else {
            trangThai = "Hết hàng";
        }

        DongXe dx = new DongXe(ID, Ten, moTa, trangThai);
        return dx;
    }

    public void clickTableDongXe(int indexDongXe) {
        DongXe dx = lstDongXe.get(indexDongXe);
        txtIDDongXe.setText(dx.getID() + "");
        txtTenDongXe.setText(dx.getTen());
        txtMoTaDongXe.setText(dx.getMoTa());
        String trangThai = dx.getTrangThai();
        if (trangThai.equalsIgnoreCase("Còn hàng")) {
            rdoConHangDongXe.setSelected(true);
        } else {
            rdoHetHangDongXe.setSelected(true);
        }

    }

    //------------------------------------------------------------------
    public void loatDataPhanKhucXe(ArrayList<PhanKhucXe> lstPKX) {
        modelPhanKhucXe.setRowCount(0);
        for (PhanKhucXe pkx : lstPKX) {
            modelPhanKhucXe.addRow(new Object[]{
                pkx.getID(),
                pkx.getTen(),
                pkx.getMoTa(),
                pkx.getTrangThai(),});
        }
    }

    private PhanKhucXe getPhanKhucXe() {
        int ID = Integer.parseInt(txtIDPhanKhucXe.getText().trim());
        String Ten = txtTenPhanKhucXe.getText().trim();
        String moTa = txtMoTaPhanKhucXe.getText().trim();
        String trangThai;
        if (rdoConHangPhanKhucXe.isSelected() == true) {
            trangThai = "Con_Hang";
        } else {
            trangThai = "Het_Hang";
        }

        PhanKhucXe pkx = new PhanKhucXe(ID, Ten, moTa, trangThai);
        return pkx;
    }

    public void clickTablePhanKhucXe(int indexPhanKhucXe) {
        PhanKhucXe pkx = lstPhanKhucXe.get(indexPhanKhucXe);
        txtIDPhanKhucXe.setText(pkx.getID() + "");
        txtTenPhanKhucXe.setText(pkx.getTen());
        txtMoTaPhanKhucXe.setText(pkx.getMoTa());
        String trangThai = pkx.getTrangThai();
        if (trangThai.equalsIgnoreCase("Còn hàng")) {
            rdoConHangPhanKhucXe.setSelected(true);
        } else {
            rdoHetHangPhanKhucXe.setSelected(true);
        }

    }

    //------------------------------------------------------------------
    public void loatDataDongCo(ArrayList<DongCo> lstDC) {
        modelDongCo.setRowCount(0);
        for (DongCo dc : lstDC) {
            modelDongCo.addRow(new Object[]{
                dc.getID(),
                dc.getTen(),
                dc.getMoTa(),
                dc.getTrangThai(),});
        }
    }

    private DongCo getDongCo() {
        int ID = Integer.parseInt(txtIDDongCo.getText().trim());
        String Ten = txtTenDongCo.getText().trim();
        String moTa = txtMoTaDongCo.getText().trim();
        String trangThai;
        if (rdoConHangDongCo.isSelected() == true) {
            trangThai = "Còn hàng";
        } else {
            trangThai = "Hết hàng";
        }

        DongCo dc = new DongCo(ID, Ten, moTa, trangThai);
        return dc;
    }

    public void clickTableDongCo(int indexDongCo) {
        DongCo dc = lstDongCo.get(indexDongCo);
        txtIDDongCo.setText(dc.getID() + "");
        txtTenDongCo.setText(dc.getTen());
        txtMoTaDongCo.setText(dc.getMoTa());
        String trangThai = dc.getTrangThai();
        if (trangThai.equalsIgnoreCase("Còn hàng")) {
            rdoConHangDongCo.setSelected(true);
        } else {
            rdoHetHangDongCo.setSelected(true);
        }

    }

    //--------------------------------------------------------------------
    public void loatDataHopSo(ArrayList<HopSo> lstHS) {
        modelHopSo.setRowCount(0);
        for (HopSo hs : lstHS) {
            modelHopSo.addRow(new Object[]{
                hs.getID(),
                hs.getTen(),
                hs.getMoTa(),
                hs.getTrangThai(),});
        }
    }

    private HopSo getHopSo() {
        int ID = Integer.parseInt(txtIDHopSo.getText().trim());
        String Ten = txtTenHopSo.getText().trim();
        String moTa = txtMoTaHopSo.getText().trim();
        String trangThai;
        if (rdoConHangHopSo.isSelected() == true) {
            trangThai = "Còn hàng";
        } else {
            trangThai = "Hết hàng";
        }

        HopSo hs = new HopSo(ID, Ten, moTa, trangThai);
        return hs;
    }

    public void clickTableHopSo(int indexHopSo) {
        HopSo hs = lstHopSo.get(indexHopSo);
        txtIDHopSo.setText(hs.getID() + "");
        txtTenHopSo.setText(hs.getTen());
        txtMoTaHopSo.setText(hs.getMoTa());
        String trangThai = hs.getTrangThai();
        if (trangThai.equalsIgnoreCase("Còn hàng")) {
            rdoConHangHopSo.setSelected(true);
        } else {
            rdoHetHangHopSo.setSelected(true);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtIDMauSac = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMoTaMauSac = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTenMauSac = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        rdoConHangMauSac = new javax.swing.JRadioButton();
        rdoHetHangMauSac = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMauSac = new javax.swing.JTable();
        btnThemMauSac = new javax.swing.JButton();
        btnSuaMauSac = new javax.swing.JButton();
        btnXoaMauSac = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIDNoiThat = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenNoiThat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMoTaNoiThat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rdoConHangNoiThat = new javax.swing.JRadioButton();
        rdoHetHangNoiThat = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNoiThat = new javax.swing.JTable();
        tbnThemNoiThat = new javax.swing.JButton();
        tbnSuaNoiThat = new javax.swing.JButton();
        tbnXoaNoiThat = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtIDThietKe = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtMoTaThietKe = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTenThietKe = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        rdoConHangThietKe = new javax.swing.JRadioButton();
        rdoHetHangThietKe = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblThietKe = new javax.swing.JTable();
        btnThemThietKe = new javax.swing.JButton();
        btnSuaThietKe = new javax.swing.JButton();
        btnXoaThietKe = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtIDDongXe = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtMoTaDongXe = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTenDongXe = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        rdoConHangDongXe = new javax.swing.JRadioButton();
        rdoHetHangDongXe = new javax.swing.JRadioButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDongXe = new javax.swing.JTable();
        btnThemDongXe = new javax.swing.JButton();
        tbnSuaDongXe = new javax.swing.JButton();
        btnXoaDongXe = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtIDPhanKhucXe = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtMoTaPhanKhucXe = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtTenPhanKhucXe = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        rdoConHangPhanKhucXe = new javax.swing.JRadioButton();
        rdoHetHangPhanKhucXe = new javax.swing.JRadioButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblPhanKhucXe = new javax.swing.JTable();
        btnThemPhanKhucXe = new javax.swing.JButton();
        tbnSuaPhanKhucXe = new javax.swing.JButton();
        btnXoaPhanKhucXe = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtIDDongCo = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtMoTaDongCo = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtTenDongCo = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        rdoConHangDongCo = new javax.swing.JRadioButton();
        rdoHetHangDongCo = new javax.swing.JRadioButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblDongCo = new javax.swing.JTable();
        btnThemDongCo = new javax.swing.JButton();
        tbnSuaDongCo = new javax.swing.JButton();
        btnXoaDongCo = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtIDHopSo = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtMoTaHopSo = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtTenHopSo = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        rdoConHangHopSo = new javax.swing.JRadioButton();
        rdoHetHangHopSo = new javax.swing.JRadioButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblHopSo = new javax.swing.JTable();
        btnThemHopSo = new javax.swing.JButton();
        tbnSuaHopSo = new javax.swing.JButton();
        btnXoaHopSo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Quản lý"));

        jLabel5.setText("ID");

        jLabel6.setText("Mô tả:");

        jLabel7.setText("Tên");

        jLabel8.setText("Trạng thái");

        buttonGroup2.add(rdoConHangMauSac);
        rdoConHangMauSac.setText("Còn hàng");

        buttonGroup2.add(rdoHetHangMauSac);
        rdoHetHangMauSac.setText("Hết hàng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(txtMoTaMauSac))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(txtIDMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdoConHangMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdoHetHangMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtTenMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtIDMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtTenMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMoTaMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(rdoConHangMauSac)
                    .addComponent(rdoHetHangMauSac))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        tblMauSac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Tên", "Mô tả", "Trạng thái"
            }
        ));
        tblMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMauSacMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMauSac);

        btnThemMauSac.setText("Thêm");
        btnThemMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMauSacActionPerformed(evt);
            }
        });

        btnSuaMauSac.setText("Sửa");
        btnSuaMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaMauSacActionPerformed(evt);
            }
        });

        btnXoaMauSac.setText("Xoá");
        btnXoaMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMauSacActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(btnThemMauSac)
                        .addGap(75, 75, 75)
                        .addComponent(btnSuaMauSac)
                        .addGap(83, 83, 83)
                        .addComponent(btnXoaMauSac)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSuaMauSac, btnThemMauSac, btnXoaMauSac});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemMauSac)
                    .addComponent(btnSuaMauSac)
                    .addComponent(btnXoaMauSac))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSuaMauSac, btnThemMauSac, btnXoaMauSac});

        jTabbedPane1.addTab("Màu sắc", jPanel1);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Quản lý"));

        jLabel1.setText("ID");

        jLabel2.setText("Tên:");

        jLabel3.setText("Mô tả:");

        jLabel4.setText("Trạng thái:");

        buttonGroup1.add(rdoConHangNoiThat);
        rdoConHangNoiThat.setText("Còn hàng");

        buttonGroup1.add(rdoHetHangNoiThat);
        rdoHetHangNoiThat.setText("Hết hàng");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMoTaNoiThat, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addComponent(txtIDNoiThat))
                .addGap(87, 87, 87)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rdoConHangNoiThat, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(rdoHetHangNoiThat, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTenNoiThat, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIDNoiThat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenNoiThat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMoTaNoiThat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(rdoConHangNoiThat)
                    .addComponent(rdoHetHangNoiThat))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        tblNoiThat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Tên", "Mô tả", "Trạng thái"
            }
        ));
        tblNoiThat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNoiThatMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblNoiThat);

        tbnThemNoiThat.setText("Thêm");
        tbnThemNoiThat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnThemNoiThatActionPerformed(evt);
            }
        });

        tbnSuaNoiThat.setText("Sửa");
        tbnSuaNoiThat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnSuaNoiThatActionPerformed(evt);
            }
        });

        tbnXoaNoiThat.setText("Xoá");
        tbnXoaNoiThat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnXoaNoiThatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 49, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(tbnThemNoiThat)
                .addGap(69, 69, 69)
                .addComponent(tbnSuaNoiThat)
                .addGap(77, 77, 77)
                .addComponent(tbnXoaNoiThat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tbnSuaNoiThat, tbnThemNoiThat, tbnXoaNoiThat});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbnThemNoiThat)
                    .addComponent(tbnSuaNoiThat)
                    .addComponent(tbnXoaNoiThat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tbnSuaNoiThat, tbnThemNoiThat, tbnXoaNoiThat});

        jTabbedPane1.addTab("Nội thất", jPanel3);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Quản lý"));

        jLabel9.setText("ID");

        jLabel10.setText("Mô tả:");

        jLabel11.setText("Tên");

        jLabel12.setText("Trạng thái");

        buttonGroup3.add(rdoConHangThietKe);
        rdoConHangThietKe.setText("Còn hàng");

        buttonGroup3.add(rdoHetHangThietKe);
        rdoHetHangThietKe.setText("Hết hàng");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(txtMoTaThietKe))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(txtIDThietKe, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(rdoConHangThietKe, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdoHetHangThietKe, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtTenThietKe, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtIDThietKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtTenThietKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtMoTaThietKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(rdoConHangThietKe)
                    .addComponent(rdoHetHangThietKe))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        tblThietKe.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblThietKe);

        btnThemThietKe.setText("Thêm");

        btnSuaThietKe.setText("Sửa");

        btnXoaThietKe.setText("Xoá");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(btnThemThietKe)
                        .addGap(75, 75, 75)
                        .addComponent(btnSuaThietKe)
                        .addGap(83, 83, 83)
                        .addComponent(btnXoaThietKe))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemThietKe)
                    .addComponent(btnSuaThietKe)
                    .addComponent(btnXoaThietKe))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Thiết kế", jPanel5);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Quản lý"));

        jLabel13.setText("ID");

        jLabel14.setText("Mô tả:");

        jLabel15.setText("Tên");

        jLabel16.setText("Trạng thái");

        buttonGroup4.add(rdoConHangDongXe);
        rdoConHangDongXe.setText("Còn hàng");

        buttonGroup4.add(rdoHetHangDongXe);
        rdoHetHangDongXe.setText("Hết hàng");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(txtMoTaDongXe))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(txtIDDongXe, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(rdoConHangDongXe, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdoHetHangDongXe, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(txtTenDongXe, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtIDDongXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtTenDongXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtMoTaDongXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(rdoConHangDongXe)
                    .addComponent(rdoHetHangDongXe))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        tblDongXe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Tên", "Mô tả", "Trạng thái"
            }
        ));
        tblDongXe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDongXeMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblDongXe);

        btnThemDongXe.setText("Thêm");
        btnThemDongXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDongXeActionPerformed(evt);
            }
        });

        tbnSuaDongXe.setText("Sửa");
        tbnSuaDongXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnSuaDongXeActionPerformed(evt);
            }
        });

        btnXoaDongXe.setText("Xoá");
        btnXoaDongXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDongXeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(btnThemDongXe)
                        .addGap(75, 75, 75)
                        .addComponent(tbnSuaDongXe)
                        .addGap(83, 83, 83)
                        .addComponent(btnXoaDongXe))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemDongXe)
                    .addComponent(tbnSuaDongXe)
                    .addComponent(btnXoaDongXe))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Dòng xe", jPanel8);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Quản lý"));

        jLabel17.setText("ID");

        jLabel18.setText("Mô tả:");

        jLabel19.setText("Tên");

        jLabel20.setText("Trạng thái");

        buttonGroup5.add(rdoConHangPhanKhucXe);
        rdoConHangPhanKhucXe.setText("Còn hàng");

        buttonGroup5.add(rdoHetHangPhanKhucXe);
        rdoHetHangPhanKhucXe.setText("Hết hàng");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(txtMoTaPhanKhucXe))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(txtIDPhanKhucXe, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(rdoConHangPhanKhucXe, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdoHetHangPhanKhucXe, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(txtTenPhanKhucXe, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtIDPhanKhucXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txtTenPhanKhucXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtMoTaPhanKhucXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(rdoConHangPhanKhucXe)
                    .addComponent(rdoHetHangPhanKhucXe))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        tblPhanKhucXe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Title 2", "Mô tả", "Trạng thái"
            }
        ));
        tblPhanKhucXe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhanKhucXeMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblPhanKhucXe);

        btnThemPhanKhucXe.setText("Thêm");
        btnThemPhanKhucXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemPhanKhucXeActionPerformed(evt);
            }
        });

        tbnSuaPhanKhucXe.setText("Sửa");
        tbnSuaPhanKhucXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnSuaPhanKhucXeActionPerformed(evt);
            }
        });

        btnXoaPhanKhucXe.setText("Xoá");
        btnXoaPhanKhucXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaPhanKhucXeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(btnThemPhanKhucXe)
                        .addGap(75, 75, 75)
                        .addComponent(tbnSuaPhanKhucXe)
                        .addGap(83, 83, 83)
                        .addComponent(btnXoaPhanKhucXe))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemPhanKhucXe)
                    .addComponent(tbnSuaPhanKhucXe)
                    .addComponent(btnXoaPhanKhucXe))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Phân khúc xe", jPanel11);

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("Quản lý"));

        jLabel21.setText("ID");

        jLabel22.setText("Mô tả:");

        jLabel23.setText("Tên");

        jLabel24.setText("Trạng thái");

        buttonGroup6.add(rdoConHangDongCo);
        rdoConHangDongCo.setText("Còn hàng");

        buttonGroup6.add(rdoHetHangDongCo);
        rdoHetHangDongCo.setText("Hết hàng");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(txtMoTaDongCo))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(txtIDDongCo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(rdoConHangDongCo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdoHetHangDongCo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(txtTenDongCo, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtIDDongCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(txtTenDongCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtMoTaDongCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(rdoConHangDongCo)
                    .addComponent(rdoHetHangDongCo))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        tblDongCo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Tên", "Mô tả", "Trạng thái"
            }
        ));
        tblDongCo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDongCoMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblDongCo);

        btnThemDongCo.setText("Thêm");
        btnThemDongCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDongCoActionPerformed(evt);
            }
        });

        tbnSuaDongCo.setText("Sửa");
        tbnSuaDongCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnSuaDongCoActionPerformed(evt);
            }
        });

        btnXoaDongCo.setText("Xoá");
        btnXoaDongCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDongCoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(btnThemDongCo)
                        .addGap(75, 75, 75)
                        .addComponent(tbnSuaDongCo)
                        .addGap(83, 83, 83)
                        .addComponent(btnXoaDongCo))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemDongCo)
                    .addComponent(tbnSuaDongCo)
                    .addComponent(btnXoaDongCo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Động cơ", jPanel14);

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder("Quản lý"));

        jLabel25.setText("ID");

        jLabel26.setText("Mô tả:");

        jLabel27.setText("Tên");

        jLabel28.setText("Trạng thái");

        buttonGroup7.add(rdoConHangHopSo);
        rdoConHangHopSo.setText("Còn hàng");

        buttonGroup7.add(rdoHetHangHopSo);
        rdoHetHangHopSo.setText("Hết hàng");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(txtMoTaHopSo))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(txtIDHopSo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(rdoConHangHopSo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdoHetHangHopSo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(txtTenHopSo, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtIDHopSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(txtTenHopSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtMoTaHopSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(rdoConHangHopSo)
                    .addComponent(rdoHetHangHopSo))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        tblHopSo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Tên", "Mô tả", "Trạng thái"
            }
        ));
        tblHopSo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHopSoMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblHopSo);

        btnThemHopSo.setText("Thêm");
        btnThemHopSo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHopSoActionPerformed(evt);
            }
        });

        tbnSuaHopSo.setText("Sửa");
        tbnSuaHopSo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnSuaHopSoActionPerformed(evt);
            }
        });

        btnXoaHopSo.setText("Xoá");
        btnXoaHopSo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHopSoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(btnThemHopSo)
                        .addGap(75, 75, 75)
                        .addComponent(tbnSuaHopSo)
                        .addGap(83, 83, 83)
                        .addComponent(btnXoaHopSo))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemHopSo)
                    .addComponent(tbnSuaHopSo)
                    .addComponent(btnXoaHopSo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Hộp số", jPanel15);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMauSacMouseClicked
        // TODO add your handling code here:
        int chonMauSac = tblMauSac.getSelectedRow();
        clickTableMauSac(chonMauSac);
    }//GEN-LAST:event_tblMauSacMouseClicked

    private void btnThemMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMauSacActionPerformed
        // TODO add your handling code here:
        try {
            //Check rỗng, là số, check miền.
            MauSac ms = getMauSac();
            if (mssv.addMauSac(ms) != null) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                loatDataMauSac(lstMauSac);
            } else {
                JOptionPane.showMessageDialog(this, "Không thêm được dòng nào");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm!");
        }
    }//GEN-LAST:event_btnThemMauSacActionPerformed

    private void btnSuaMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaMauSacActionPerformed
        // TODO add your handling code here:
        try {
            //Check rỗng, là số, check miền.
            MauSac ms = getMauSac();
            if (mssv.updateMauSac(ms) != null) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                loatDataMauSac(lstMauSac);
            } else {
                JOptionPane.showMessageDialog(this, "Không Sửa được dòng nào");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi sửa!");
        }
    }//GEN-LAST:event_btnSuaMauSacActionPerformed

    private void btnXoaMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMauSacActionPerformed
        // TODO add your handling code here:
        try {
            //Check rỗng, là số, check miền.
            MauSac ms = getMauSac();
            if (mssv.deleteMauSac(txtIDMauSac.getText()) != null) {
                JOptionPane.showMessageDialog(this, "Xoá thành công");
                loatDataMauSac(lstMauSac);
            } else {
                JOptionPane.showMessageDialog(this, "Không xoá được dòng nào");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi xoá!");
        }

    }//GEN-LAST:event_btnXoaMauSacActionPerformed

    private void tbnThemNoiThatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnThemNoiThatActionPerformed
        // TODO add your handling code here:
        try {
            //Check rỗng, là số, check miền.
            NoiThat nt = getNoiThat();
            if (ntsv.addNoiThat(nt) != null) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                loatDataNoiThat(lstNoiThat);
            } else {
                JOptionPane.showMessageDialog(this, "Không thêm được dòng nào");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm!");
        }
    }//GEN-LAST:event_tbnThemNoiThatActionPerformed

    private void tbnSuaNoiThatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnSuaNoiThatActionPerformed
        // TODO add your handling code here:
        try {
            //Check rỗng, là số, check miền.
            NoiThat nt = getNoiThat();
            if (ntsv.updateNoiThat(nt) != null) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                loatDataNoiThat(lstNoiThat);
            } else {
                JOptionPane.showMessageDialog(this, "Không Sửa được dòng nào");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi sửa!");
        }
    }//GEN-LAST:event_tbnSuaNoiThatActionPerformed

    private void tbnXoaNoiThatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnXoaNoiThatActionPerformed
        // TODO add your handling code here:
        try {
            //Check rỗng, là số, check miền.
            NoiThat nt = getNoiThat();
            if (ntsv.deleteNoiThat(txtIDNoiThat.getText()) != null) {
                JOptionPane.showMessageDialog(this, "Xoá thành công");
                loatDataNoiThat(lstNoiThat);
            } else {
                JOptionPane.showMessageDialog(this, "Không xoá được dòng nào");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi xoá!");
        }

    }//GEN-LAST:event_tbnXoaNoiThatActionPerformed

    private void tblNoiThatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNoiThatMouseClicked
        // TODO add your handling code here:
        int chonNoiThat = tblNoiThat.getSelectedRow();
        clickTableNoiThat(chonNoiThat);
    }//GEN-LAST:event_tblNoiThatMouseClicked

    private void tblDongXeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDongXeMouseClicked
        // TODO add your handling code here:
        int chonDongXe = tblDongXe.getSelectedRow();
        clickTableDongXe(chonDongXe);
    }//GEN-LAST:event_tblDongXeMouseClicked

    private void btnThemDongXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDongXeActionPerformed
        // TODO add your handling code here:
        try {
            //Check rỗng, là số, check miền.
            DongXe dx = getDongXe();
            if (dxsv.addDongXe(dx) != null) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                loatDataDongXe(lstDongXe);
            } else {
                JOptionPane.showMessageDialog(this, "Không thêm được dòng nào");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm!");
        }
    }//GEN-LAST:event_btnThemDongXeActionPerformed

    private void tbnSuaDongXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnSuaDongXeActionPerformed
        // TODO add your handling code here:
        try {
            //Check rỗng, là số, check miền.
            DongXe dx = getDongXe();
            if (dxsv.updateDongXe(dx) != null) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                loatDataDongXe(lstDongXe);
            } else {
                JOptionPane.showMessageDialog(this, "Không Sửa được dòng nào");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi sửa!");
        }
    }//GEN-LAST:event_tbnSuaDongXeActionPerformed

    private void btnXoaDongXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDongXeActionPerformed
        // TODO add your handling code here:
        try {
            //Check rỗng, là số, check miền.
            DongXe dx = getDongXe();
            if (dxsv.deleteDongXe(txtIDDongXe.getText()) != null) {
                JOptionPane.showMessageDialog(this, "Xoá thành công");
                loatDataDongXe(lstDongXe);
            } else {
                JOptionPane.showMessageDialog(this, "Không xoá được dòng nào");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi xoá!");
        }
    }//GEN-LAST:event_btnXoaDongXeActionPerformed

    private void tblPhanKhucXeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhanKhucXeMouseClicked
        // TODO add your handling code here:
        int chonPhanKhucXe = tblPhanKhucXe.getSelectedRow();
        clickTablePhanKhucXe(chonPhanKhucXe);
    }//GEN-LAST:event_tblPhanKhucXeMouseClicked

    private void btnThemPhanKhucXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemPhanKhucXeActionPerformed
        // TODO add your handling code here:
        try {
            //Check rỗng, là số, check miền.
            PhanKhucXe pkx = getPhanKhucXe();
            if (pkxsv.addPhanKhucXe(pkx) != null) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                loatDataPhanKhucXe(lstPhanKhucXe);
            } else {
                JOptionPane.showMessageDialog(this, "Không thêm được dòng nào");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm!");
        }
    }//GEN-LAST:event_btnThemPhanKhucXeActionPerformed

    private void tbnSuaPhanKhucXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnSuaPhanKhucXeActionPerformed
        // TODO add your handling code here:
        try {
            //Check rỗng, là số, check miền.
            PhanKhucXe pkx = getPhanKhucXe();
            if (pkxsv.updatePhanKhucXe(pkx) != null) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                loatDataPhanKhucXe(lstPhanKhucXe);
            } else {
                JOptionPane.showMessageDialog(this, "Không Sửa được dòng nào");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi sửa!");
        }
    }//GEN-LAST:event_tbnSuaPhanKhucXeActionPerformed

    private void btnXoaPhanKhucXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaPhanKhucXeActionPerformed
        // TODO add your handling code here:
        try {
            //Check rỗng, là số, check miền.
            PhanKhucXe pkx = getPhanKhucXe();
            if (pkxsv.deletePhanKhucXe(txtIDPhanKhucXe.getText()) != null) {
                JOptionPane.showMessageDialog(this, "Xoá thành công");
                loatDataPhanKhucXe(lstPhanKhucXe);
            } else {
                JOptionPane.showMessageDialog(this, "Không xoá được dòng nào");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi xoá!");
        }
    }//GEN-LAST:event_btnXoaPhanKhucXeActionPerformed

    private void tblDongCoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDongCoMouseClicked
        // TODO add your handling code here:
        int chonDongCo = tblDongCo.getSelectedRow();
        clickTableDongCo(chonDongCo);
    }//GEN-LAST:event_tblDongCoMouseClicked

    private void btnThemDongCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDongCoActionPerformed
        // TODO add your handling code here:
        try {
            //Check rỗng, là số, check miền.
            DongCo dc = getDongCo();
            if (dcsv.addDongCo(dc) != null) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                loatDataDongCo(lstDongCo);
            } else {
                JOptionPane.showMessageDialog(this, "Không thêm được dòng nào");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm!");
        }
    }//GEN-LAST:event_btnThemDongCoActionPerformed

    private void tbnSuaDongCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnSuaDongCoActionPerformed
        // TODO add your handling code here:
        try {
            //Check rỗng, là số, check miền.
            DongCo dc = getDongCo();
            if (dcsv.updateDongCo(dc) != null) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                loatDataDongCo(lstDongCo);
            } else {
                JOptionPane.showMessageDialog(this, "Không Sửa được dòng nào");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi sửa!");
        }
    }//GEN-LAST:event_tbnSuaDongCoActionPerformed

    private void btnXoaDongCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDongCoActionPerformed
        // TODO add your handling code here:
        try {
            //Check rỗng, là số, check miền.
            DongCo dc = getDongCo();
            if (dcsv.deleteDongCo(txtIDDongCo.getText()) != null) {
                JOptionPane.showMessageDialog(this, "Xoá thành công");
                loatDataDongCo(lstDongCo);
            } else {
                JOptionPane.showMessageDialog(this, "Không xoá được dòng nào");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi xoá!");
        }
    }//GEN-LAST:event_btnXoaDongCoActionPerformed

    private void tblHopSoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHopSoMouseClicked
        // TODO add your handling code here:
        int chonHopSo = tblHopSo.getSelectedRow();
        clickTableHopSo(chonHopSo);
    }//GEN-LAST:event_tblHopSoMouseClicked

    private void btnThemHopSoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHopSoActionPerformed
        // TODO add your handling code here:
        try {
            //Check rỗng, là số, check miền.
            HopSo hs = getHopSo();
            if (hssv.addHopSo(hs) != null) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                loatDataHopSo(lstHopSo);
            } else {
                JOptionPane.showMessageDialog(this, "Không thêm được dòng nào");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm!");
        }
    }//GEN-LAST:event_btnThemHopSoActionPerformed

    private void tbnSuaHopSoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnSuaHopSoActionPerformed
        // TODO add your handling code here:
        try {
            //Check rỗng, là số, check miền.
            HopSo hs = getHopSo();
            if (hssv.updateHopSo(hs) != null) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                loatDataHopSo(lstHopSo);
            } else {
                JOptionPane.showMessageDialog(this, "Không Sửa được dòng nào");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi sửa!");
        }
    }//GEN-LAST:event_tbnSuaHopSoActionPerformed

    private void btnXoaHopSoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHopSoActionPerformed
        // TODO add your handling code here:
        try {
            //Check rỗng, là số, check miền.
            HopSo hs = getHopSo();
            if (hssv.deleteHopSo(txtIDHopSo.getText()) != null) {
                JOptionPane.showMessageDialog(this, "Xoá thành công");
                loatDataHopSo(lstHopSo);
            } else {
                JOptionPane.showMessageDialog(this, "Không xoá được dòng nào");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi xoá!");
        }
    }//GEN-LAST:event_btnXoaHopSoActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyThuocTinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyThuocTinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyThuocTinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyThuocTinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyThuocTinh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaMauSac;
    private javax.swing.JButton btnSuaThietKe;
    private javax.swing.JButton btnThemDongCo;
    private javax.swing.JButton btnThemDongXe;
    private javax.swing.JButton btnThemHopSo;
    private javax.swing.JButton btnThemMauSac;
    private javax.swing.JButton btnThemPhanKhucXe;
    private javax.swing.JButton btnThemThietKe;
    private javax.swing.JButton btnXoaDongCo;
    private javax.swing.JButton btnXoaDongXe;
    private javax.swing.JButton btnXoaHopSo;
    private javax.swing.JButton btnXoaMauSac;
    private javax.swing.JButton btnXoaPhanKhucXe;
    private javax.swing.JButton btnXoaThietKe;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdoConHangDongCo;
    private javax.swing.JRadioButton rdoConHangDongXe;
    private javax.swing.JRadioButton rdoConHangHopSo;
    private javax.swing.JRadioButton rdoConHangMauSac;
    private javax.swing.JRadioButton rdoConHangNoiThat;
    private javax.swing.JRadioButton rdoConHangPhanKhucXe;
    private javax.swing.JRadioButton rdoConHangThietKe;
    private javax.swing.JRadioButton rdoHetHangDongCo;
    private javax.swing.JRadioButton rdoHetHangDongXe;
    private javax.swing.JRadioButton rdoHetHangHopSo;
    private javax.swing.JRadioButton rdoHetHangMauSac;
    private javax.swing.JRadioButton rdoHetHangNoiThat;
    private javax.swing.JRadioButton rdoHetHangPhanKhucXe;
    private javax.swing.JRadioButton rdoHetHangThietKe;
    private javax.swing.JTable tblDongCo;
    private javax.swing.JTable tblDongXe;
    private javax.swing.JTable tblHopSo;
    private javax.swing.JTable tblMauSac;
    private javax.swing.JTable tblNoiThat;
    private javax.swing.JTable tblPhanKhucXe;
    private javax.swing.JTable tblThietKe;
    private javax.swing.JButton tbnSuaDongCo;
    private javax.swing.JButton tbnSuaDongXe;
    private javax.swing.JButton tbnSuaHopSo;
    private javax.swing.JButton tbnSuaNoiThat;
    private javax.swing.JButton tbnSuaPhanKhucXe;
    private javax.swing.JButton tbnThemNoiThat;
    private javax.swing.JButton tbnXoaNoiThat;
    private javax.swing.JTextField txtIDDongCo;
    private javax.swing.JTextField txtIDDongXe;
    private javax.swing.JTextField txtIDHopSo;
    private javax.swing.JTextField txtIDMauSac;
    private javax.swing.JTextField txtIDNoiThat;
    private javax.swing.JTextField txtIDPhanKhucXe;
    private javax.swing.JTextField txtIDThietKe;
    private javax.swing.JTextField txtMoTaDongCo;
    private javax.swing.JTextField txtMoTaDongXe;
    private javax.swing.JTextField txtMoTaHopSo;
    private javax.swing.JTextField txtMoTaMauSac;
    private javax.swing.JTextField txtMoTaNoiThat;
    private javax.swing.JTextField txtMoTaPhanKhucXe;
    private javax.swing.JTextField txtMoTaThietKe;
    private javax.swing.JTextField txtTenDongCo;
    private javax.swing.JTextField txtTenDongXe;
    private javax.swing.JTextField txtTenHopSo;
    private javax.swing.JTextField txtTenMauSac;
    private javax.swing.JTextField txtTenNoiThat;
    private javax.swing.JTextField txtTenPhanKhucXe;
    private javax.swing.JTextField txtTenThietKe;
    // End of variables declaration//GEN-END:variables
}
