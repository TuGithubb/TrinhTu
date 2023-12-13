/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tu204
 */
public class PhanKhucXe {
    private int ID;
    private String ten;
    private String moTa;
    private String trangThai;

    public PhanKhucXe() {
    }

    public PhanKhucXe(int ID, String ten, String moTa, String trangThai) {
        this.ID = ID;
        this.ten = ten;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "NoiThat{" + "ID=" + ID + ", ten=" + ten + ", moTa=" + moTa + ", trangThai=" + trangThai + '}';
    }
    
}
