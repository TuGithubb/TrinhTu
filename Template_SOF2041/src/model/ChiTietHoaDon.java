/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class ChiTietHoaDon {

    private int id, idHoaDon;
    private String mahd;
    private String masp;
    private int soluong;

    private double gia;
    private double tongtien;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int id, int idHoaDon, String mahd, String masp, int soluong, double gia, double tongtien) {
        this.id = id;
        this.idHoaDon = idHoaDon;
        this.mahd = mahd;
        this.masp = masp;
        this.soluong = soluong;
        this.gia = gia;
        this.tongtien = tongtien;
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

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    

    

    public Object[] todataRow() {
        return new Object[]{this.id, this.idHoaDon, this.mahd, this.masp, this.soluong, this.gia, this.tongtien,};
    }
}
