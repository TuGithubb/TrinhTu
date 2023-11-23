/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tu204
 */
public class ChiTietKhuyenMai {
    private int ID;
    private int ID_SP;
    private int ID_KM;
    private String maKM;
    private String hinhThuc;
    private double giaTri;
    private int soLuong;
    private String DK_Ap_Dung;

    public ChiTietKhuyenMai() {
    }

    public ChiTietKhuyenMai(int ID, int ID_SP, int ID_KM, String maKM, String hinhThuc, double giaTri, int soLuong, String DK_Ap_Dung) {
        this.ID = ID;
        this.ID_SP = ID_SP;
        this.ID_KM = ID_KM;
        this.maKM = maKM;
        this.hinhThuc = hinhThuc;
        this.giaTri = giaTri;
        this.soLuong = soLuong;
        this.DK_Ap_Dung = DK_Ap_Dung;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_SP() {
        return ID_SP;
    }

    public void setID_SP(int ID_SP) {
        this.ID_SP = ID_SP;
    }

    public int getID_KM() {
        return ID_KM;
    }

    public void setID_KM(int ID_KM) {
        this.ID_KM = ID_KM;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getHinhThuc() {
        return hinhThuc;
    }

    public void setHinhThuc(String hinhThuc) {
        this.hinhThuc = hinhThuc;
    }

    public double getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(double giaTri) {
        this.giaTri = giaTri;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getDK_Ap_Dung() {
        return DK_Ap_Dung;
    }

    public void setDK_Ap_Dung(String DK_Ap_Dung) {
        this.DK_Ap_Dung = DK_Ap_Dung;
    }

    @Override
    public String toString() {
        return "ChiTietKhuyenMai{" + "ID=" + ID + ", ID_SP=" + ID_SP + ", ID_KM=" + ID_KM + ", maKM=" + maKM + ", hinhThuc=" + hinhThuc + ", giaTri=" + giaTri + ", soLuong=" + soLuong + ", DK_Ap_Dung=" + DK_Ap_Dung + '}';
    }

    
}
