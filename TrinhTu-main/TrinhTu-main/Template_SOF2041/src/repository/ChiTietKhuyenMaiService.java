/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ChiTietKhuyenMai;
import model.KhuyenMai;

/**
 *
 * @author tu204
 */
public class ChiTietKhuyenMaiService {

    public ArrayList<ChiTietKhuyenMai> getAllChiTietKhuyenMai() {
        ArrayList<ChiTietKhuyenMai> lstCTKM = new ArrayList<>();
        String sql = "select * from Chi_Tiet_Khuyen_Mai";

        
        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Thi hành Statement=> dùng Resultset nhận kq
            ResultSet rs = pstm.executeQuery();
            //xử lý kq: duyệt rs => đổ dữ liệu vào lst
            while (rs.next()) {

                ChiTietKhuyenMai ctkm = new ChiTietKhuyenMai();
                ctkm.setID(rs.getInt("ID"));
                ctkm.setID_SP(rs.getInt("ID_SP"));
                ctkm.setID_KM(rs.getInt("ID_KM"));
                ctkm.setMaKM(rs.getString("Ma_KM"));
                ctkm.setHinhThuc(rs.getString("Hinh_Thuc"));
                ctkm.setGiaTri(rs.getDouble("Gia_tri"));
                ctkm.setSoLuong(rs.getInt("So_Luong"));
                ctkm.setDK_Ap_Dung(rs.getString("DK_Ap_Dung"));

                lstCTKM.add(ctkm);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lstCTKM;
    }
}
