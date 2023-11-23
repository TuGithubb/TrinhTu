/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Oto {

    private int ID;
    private int IDHang;
    private String MaSP;
    private String tenXe;
    private double giaBan;
    private double giaNhap;
    private String MoTa;
    private String TrangThai;

    public Oto() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDHang() {
        return IDHang;
    }

    public void setIDHang(int IDHang) {
        this.IDHang = IDHang;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    public Oto(int ID, int IDHang, String MaSP, String tenXe, double giaBan, double giaNhap, String MoTa, String TrangThai) {
        this.ID = ID;
        this.IDHang = IDHang;
        this.MaSP = MaSP;
        this.tenXe = tenXe;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.MoTa = MoTa;
        this.TrangThai = TrangThai;
    }

    public Object[] toDataRow() {
        return new Object[]{this.ID, this.IDHang, this.MaSP, this.tenXe, this.giaBan, this.giaNhap, this.MoTa, this.TrangThai};

    }
}
