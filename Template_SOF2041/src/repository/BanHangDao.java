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
import model.SanPham;

/**
 *
 * @author user
 */
public class BanHangDao {
    
    public List<SanPham> getSanPham() {
       String sql = "select ID, ID_Hang, Ma_SP, Ten, Gia_Ban,Gia_Nhap,Mo_Ta,Trang_Thai from San_Pham";
        List<SanPham> lst = new ArrayList<>();
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
             ResultSet rs = ps.executeQuery();
             List<SanPham> List = new ArrayList<>();
            while (rs.next()) {
                SanPham ot
                        = new SanPham(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),
                        rs.getDouble(5),rs.getDouble(6),rs.getString(7),rs.getString(8));
                lst.add(ot);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
