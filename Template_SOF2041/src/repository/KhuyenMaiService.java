/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import model.KhuyenMai;
import java.sql.*;

/**
 *
 * @author tu204
 */
public class KhuyenMaiService {

    public ArrayList<KhuyenMai> getAllKhuyenMai() {
        ArrayList<KhuyenMai> lst = new ArrayList<>();
        String sql = "select * from Khuyen_Mai";

        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Thi hành Statement=> dùng Resultset nhận kq
            ResultSet rs = pstm.executeQuery();
            //xử lý kq: duyệt rs => đổ dữ liệu vào lst
            while (rs.next()) {

                KhuyenMai km = new KhuyenMai();
                km.setID(rs.getInt("ID"));
                km.setMaKM(rs.getString("Ma_KM"));
                km.setTen(rs.getString("Ten"));
                km.setTrangThai(rs.getString("Trang_Thai"));
                km.setNgayBatDau(rs.getString("Ngay_Bat_Dau"));
                km.setNgayKetThuc(rs.getString("Ngay_Ket_Thuc"));

                lst.add(km);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lst;
    }

    public Integer addKhuyenMai(KhuyenMai km) {
        Integer row = null;
        String sql = "INSERT INTO Khuyen_Mai (ID, Ma_KM, Ten, Trang_Thai, Ngay_Bat_Dau, Ngay_Ket_Thuc)\n"
                + "VALUES (?,?,?,?,?,?)";
        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho dấu ?
            pstm.setInt(1, km.getID());
            pstm.setString(2, km.getMaKM());
            pstm.setString(3, km.getTen());
            pstm.setString(4, km.getTrangThai());
            pstm.setString(5, km.getNgayBatDau());
            pstm.setString(6, km.getNgayKetThuc());

            //thi hành Statement
            row = pstm.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }

    public Integer updateKhuyenMai(KhuyenMai km) {
        Integer row = null;
        String sql = "update Khuyen_Mai\n"
                + "set Ma_KM=?, Ten=?, Trang_Thai=?, Ngay_Bat_Dau =?, Ngay_Ket_Thuc= ? "
                + "where ID like ?";
        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho dấu ?

            pstm.setString(2, km.getMaKM());
            pstm.setString(3, km.getTen());
            pstm.setString(4, km.getTrangThai());
            pstm.setString(5, km.getNgayBatDau());
            pstm.setString(6, km.getNgayKetThuc());
            pstm.setInt(1, km.getID());
            //thi hành Statement
            row = pstm.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }

    public Integer deleteKhuyenMai(String km) {
        Integer row = null;
        String sql = "delete from Khuyen_Mai\\n\"\n"
                + "                + \"where ID like ?";
        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho dấu ?
            pstm.setString(1, km);

            //thi hành Statement
            row = pstm.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }
}
