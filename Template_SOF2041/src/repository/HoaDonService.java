/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.HoaDon;

/**
 *
 * @author ADMIN
 */
public class HoaDonService {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<HoaDon> getAll() {
        String sql = "select * from Hoa_Don";
        List<HoaDon> lst = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getBoolean(6),
                        rs.getString(7)
                );
                lst.add(hd);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int add(HoaDon hd) {
        sql = "insert into Hoa_Don(ID, Ngay_Tao, Ma_HD, Trang_Thai, Thong_Tin_Giao_Hang) values(?,?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, hd.getID());
            ps.setObject(2, hd.getIDKhachHang());
            ps.setObject(3, hd.getIDUser());
            ps.setObject(4, hd.getMaHD());
            ps.setObject(5, hd.getNgayTao());
            ps.setObject(6, hd.isTrangThai());
            ps.setObject(7, hd.getThongTinGiaoHang());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean update(HoaDon hd, int ID) {
        int check = 0;
        sql = " update Hoa_Don set ID = ?, ID_User=?, ID_Khach_Hang =?, Ngay_Tao=?, Ma_HD=?, Trang_Thai=?, Thong_Tin_Giao_Hang=? where ID = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, hd.getID());
            ps.setObject(2, hd.getIDKhachHang());
            ps.setObject(3, hd.getIDUser());
            ps.setObject(4, hd.getMaHD());
            ps.setObject(5, hd.getNgayTao());
            ps.setObject(6, hd.isTrangThai());
            ps.setObject(7, hd.getThongTinGiaoHang());
            ps.setObject(8, ID);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
     public boolean delete(int ID) {
        int check = 0;
        String query = "delete Hoa_Don where ID =? ";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ID);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean checkTrung(int ID) {
        sql = """
            SELECT Ma_HD FROM Hoa_Don WHERE Ma_HD = ?
            """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
