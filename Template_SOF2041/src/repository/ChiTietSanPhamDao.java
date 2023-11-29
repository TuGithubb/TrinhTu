/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.CTSanPham;

/**
 *
 * @author user
 */
public class ChiTietSanPhamDao {
    public List<CTSanPham> getAll() {
        String query = "  SELECT ID,ID_SP,ID_Mau_Sac,ID_Thiet_Ke,ID_Noi_That,ID_Dong_Xe,ID_Phan_Khuc_Xe,"
                + "ID_Dong_Co,ID_Hop_So,Ten,Ma_SP,Gioi_Thieu FROM Chi_Tiet_San_Pham";

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<CTSanPham> List = new ArrayList<>();
            while (rs.next()) {
                CTSanPham ctsp = new CTSanPham(rs.getInt(1),
                        rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),
                rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12));
                List.add(ctsp);
            }
            return List;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public boolean add(CTSanPham ctsp) {
        int check = 0;
        String query = """
                   INSERT INTO Chi_Tiet_San_Pham
                                (ID,ID_SP,ID_Mau_Sac,ID_Thiet_Ke,ID_Noi_That,ID_Dong_Xe,ID_Phan_Khuc_Xe,ID_Dong_Co,ID_Hop_So,Ten,Ma_SP,Gioi_Thieu)
                                VALUES(?,?,?,?,?,?,?,?,?,?,?,?);
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {

            ps.setObject(1, ctsp.getId_CTSanPham());
            ps.setObject(2, ctsp.getId_SanPham());
            ps.setObject(3, ctsp.getId_MauSac());
            ps.setObject(4, ctsp.getId_ThietKe());
            ps.setObject(5, ctsp.getId_NoiThat());
            ps.setObject(6, ctsp.getId_Dong_Xe());
            ps.setObject(7, ctsp.getId_PhanKhucXe());
            ps.setObject(8, ctsp.getId_DongCo());
            ps.setObject(9, ctsp.getId_HopSo());
            ps.setObject(10, ctsp.getTen());
            ps.setObject(11, ctsp.getMa_SP());
            ps.setObject(12, ctsp.getGioi_Thieu());
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    public boolean delete(int id) {
        int check = 0;
        String query = """
                        DELETE FROM Chi_Tiet_San_Pham              
                        WHERE ID = ?
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    public boolean update(CTSanPham ctsp, int id) {
        int check = 0;
        String query = """
                   UPDATE Chi_Tiet_San_Pham SET ID_SP = ? ,ID_Mau_Sac = ? ,ID_Thiet_Ke = ? ,ID_Noi_That = ? ,
                       ID_Dong_Xe = ? ,ID_Phan_Khuc_Xe = ? ,ID_Dong_Co = ? ,ID_Hop_So = ? ,Ten = ? ,Ma_SP = ? ,Gioi_Thieu = ? WHERE ID = ?;
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {

            ps.setObject(1, ctsp.getId_SanPham());
            ps.setObject(2, ctsp.getId_MauSac());
            ps.setObject(3, ctsp.getId_ThietKe());
            ps.setObject(4, ctsp.getId_NoiThat());
            ps.setObject(5, ctsp.getId_Dong_Xe());
            ps.setObject(6, ctsp.getId_PhanKhucXe());
            ps.setObject(7, ctsp.getId_DongCo());
            ps.setObject(8, ctsp.getId_HopSo());
            ps.setObject(9, ctsp.getTen());
            ps.setObject(10, ctsp.getMa_SP());
            ps.setObject(11, ctsp.getGioi_Thieu());
            ps.setObject(12, id);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
}
