/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class CTHoaDon {

    private int id;
    private int idHoaDon;
    private int idCTKM;
    private int idCTSP;
    private String maHD;
    private String maSP;
    private double gia;
    private int sl;
    private double tongTien;

    public CTHoaDon() {
    }

    public CTHoaDon(int id, int idHoaDon, int idCTKM, int idCTSP, String maHD, String maSP, double gia, int sl, double tongTien) {
        this.id = id;
        this.idHoaDon = idHoaDon;
        this.idCTKM = idCTKM;
        this.idCTSP = idCTSP;
        this.maHD = maHD;
        this.maSP = maSP;
        this.gia = gia;
        this.sl = sl;
        this.tongTien = tongTien;
    }

    public CTHoaDon(int id, String maSP, double gia, int sl, double tongTien) {
        this.id = id;
        this.maSP = maSP;
        this.gia = gia;
        this.sl = sl;
        this.tongTien = tongTien;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getIdCTKM() {
        return idCTKM;
    }

    public void setIdCTKM(int idCTKM) {
        this.idCTKM = idCTKM;
    }

    public int getIdCTSP() {
        return idCTSP;
    }

    public void setIdCTSP(int idCTSP) {
        this.idCTSP = idCTSP;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
    
    
}
