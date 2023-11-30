/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class HoaDon {

    private int ID, IDUser, IDKhachHang;
    private String ngayTao, maHD;
    private boolean trangThai;
    private String thongTinGiaoHang;

    public HoaDon() {
    }

    public HoaDon(int ID, int IDUser, int IDKhachHang, String ngayTao, String maHD, boolean trangThai, String thongTinGiaoHang) {
        this.ID = ID;
        this.IDUser = IDUser;
        this.IDKhachHang = IDKhachHang;
        this.ngayTao = ngayTao;
        this.maHD = maHD;
        this.trangThai = trangThai;
        this.thongTinGiaoHang = thongTinGiaoHang;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDUser() {
        return IDUser;
    }

    public void setIDUser(int IDUser) {
        this.IDUser = IDUser;
    }

    public int getIDKhachHang() {
        return IDKhachHang;
    }

    public void setIDKhachHang(int IDKhachHang) {
        this.IDKhachHang = IDKhachHang;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getThongTinGiaoHang() {
        return thongTinGiaoHang;
    }

    public void setThongTinGiaoHang(String thongTinGiaoHang) {
        this.thongTinGiaoHang = thongTinGiaoHang;
    }

    public Object[] toDataRow() {
        return new Object[]{this.ID, this.IDKhachHang, this.IDUser, this.maHD, this.ngayTao, this.trangThai == true ? "Đã Thanh Toán" : "Chưa Thanh Toán", this.thongTinGiaoHang};
    }
}
