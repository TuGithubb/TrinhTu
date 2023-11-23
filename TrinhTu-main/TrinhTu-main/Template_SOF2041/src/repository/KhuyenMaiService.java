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
}
