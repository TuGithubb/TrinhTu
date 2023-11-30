/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.CTHoaDon;
import model.SanPham;

/**
 *
 * @author user
 */
public class BanHangDao {

    public List<SanPham> getSanPham() {
        String sql = "select ID, ID_Hang, Ma_SP, Ten, Gia_Ban,Gia_Nhap,Mo_Ta,Trang_Thai from San_Pham";
        List<SanPham> list = new ArrayList<>();
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<SanPham> List = new ArrayList<>();
            while (rs.next()) {
                SanPham ot
                        = new SanPham(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
                                rs.getDouble(5), rs.getDouble(6), rs.getString(7), rs.getString(8));
                list.add(ot);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    public List<CTHoaDon> getCTHoaDon() {
//       String sql = "select ID, ID_Hoa_Don, ID_CTKM, ID_CTSP, Ma_HD,Ma_SP, Gia,So_Luong,Tong_Tien from Chi_Tiet_Hoa_Don";
//        List<CTHoaDon> list = new ArrayList<>();
//        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
//             ResultSet rs = ps.executeQuery();
//             List<CTHoaDon> List = new ArrayList<>();
//            while (rs.next()) {
//                CTHoaDon cthd
//                        = new CTHoaDon(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
//                                rs.getString(5),rs.getString(6), rs.getDouble(7), rs.getInt(8), rs.getDouble(9));
//                list.add(cthd);
//            }
//            return list;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
    public List<CTHoaDon> getCTHoaDon(String masp) {
        String sql = "select ID,Ma_SP, Gia,So_Luong,Tong_Tien from Chi_Tiet_Hoa_Don where Ma_SP =?";
        List<CTHoaDon> list = new ArrayList<>();
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, masp);
            ResultSet rs = ps.executeQuery();
            List<CTHoaDon> List = new ArrayList<>();
            while (rs.next()) {
                CTHoaDon cthd
                        = new CTHoaDon(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getDouble(5));
                list.add(cthd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



}
