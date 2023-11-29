/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author user
 */
public class CTSanPham {
    private  int id_CTSanPham;
    private  int id_SanPham;
    private  int id_MauSac;
    private  int id_NoiThat;
    private  int id_ThietKe;
    private  int id_Dong_Xe;
    private  int id_PhanKhucXe;
    private  int id_DongCo;
    private  int id_HopSo;
    private  String ten;
    private  String ma_SP;
    private  String gioi_Thieu;

    public CTSanPham() {
    }

    public CTSanPham(int id_CTSanPham, int id_SanPham, int id_MauSac, int id_NoiThat, int id_ThietKe, int id_Dong_Xe, int id_PhanKhucXe, int id_DongCo, int id_HopSo, String ten, String ma_SP, String gioi_Thieu) {
        this.id_CTSanPham = id_CTSanPham;
        this.id_SanPham = id_SanPham;
        this.id_MauSac = id_MauSac;
        this.id_NoiThat = id_NoiThat;
        this.id_ThietKe = id_ThietKe;
        this.id_Dong_Xe = id_Dong_Xe;
        this.id_PhanKhucXe = id_PhanKhucXe;
        this.id_DongCo = id_DongCo;
        this.id_HopSo = id_HopSo;
        this.ten = ten;
        this.ma_SP = ma_SP;
        this.gioi_Thieu = gioi_Thieu;
    }

    public int getId_CTSanPham() {
        return id_CTSanPham;
    }

    public void setId_CTSanPham(int id_CTSanPham) {
        this.id_CTSanPham = id_CTSanPham;
    }

    public int getId_SanPham() {
        return id_SanPham;
    }

    public void setId_SanPham(int id_SanPham) {
        this.id_SanPham = id_SanPham;
    }

    public int getId_MauSac() {
        return id_MauSac;
    }

    public void setId_MauSac(int id_MauSac) {
        this.id_MauSac = id_MauSac;
    }

    public int getId_NoiThat() {
        return id_NoiThat;
    }

    public void setId_NoiThat(int id_NoiThat) {
        this.id_NoiThat = id_NoiThat;
    }

    public int getId_ThietKe() {
        return id_ThietKe;
    }

    public void setId_ThietKe(int id_ThietKe) {
        this.id_ThietKe = id_ThietKe;
    }

    public int getId_Dong_Xe() {
        return id_Dong_Xe;
    }

    public void setId_Dong_Xe(int id_Dong_Xe) {
        this.id_Dong_Xe = id_Dong_Xe;
    }

    public int getId_PhanKhucXe() {
        return id_PhanKhucXe;
    }

    public void setId_PhanKhucXe(int id_PhanKhucXe) {
        this.id_PhanKhucXe = id_PhanKhucXe;
    }

    public int getId_DongCo() {
        return id_DongCo;
    }

    public void setId_DongCo(int id_DongCo) {
        this.id_DongCo = id_DongCo;
    }

    public int getId_HopSo() {
        return id_HopSo;
    }

    public void setId_HopSo(int id_HopSo) {
        this.id_HopSo = id_HopSo;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMa_SP() {
        return ma_SP;
    }

    public void setMa_SP(String ma_SP) {
        this.ma_SP = ma_SP;
    }

    public String getGioi_Thieu() {
        return gioi_Thieu;
    }

    public void setGioi_Thieu(String gioi_Thieu) {
        this.gioi_Thieu = gioi_Thieu;
    }

    
    
    
}
