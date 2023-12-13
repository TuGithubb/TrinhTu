/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tu204
 */
public class DoanhThu {
    private String maHD;
    private String ngayTao;
    private int thanhTien;

    public DoanhThu() {
    }

    public DoanhThu(String maHD, String ngayTao, int thanhTien) {
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.thanhTien = thanhTien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "DoanhThu{" + "maHD=" + maHD + ", ngayTao=" + ngayTao + ", thanhTien=" + thanhTien + '}';
    }
    
    
}
