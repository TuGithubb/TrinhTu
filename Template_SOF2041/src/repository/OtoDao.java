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
public class OtoDao {
    
    public List<SanPham> getAll() {
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
    
    public boolean add(SanPham ot) {
        int check = 0;
        String query = """
                   insert into San_Pham(ID, ID_Hang, Ma_SP, Ten, Gia_Ban,Gia_Nhap,Mo_Ta,Trang_Thai)values(?,?,?,?,?,?,?,?)
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {

            ps.setObject(1, ot.getID());
            ps.setObject(2, ot.getIDHang());
            ps.setObject(3, ot.getMaSP());
            ps.setObject(4, ot.getTenXe());
            ps.setObject(5, ot.getGiaBan());
            ps.setObject(6, ot.getGiaNhap());
            ps.setObject(7, ot.getMoTa());
            ps.setObject(8, ot.getTrangThai());
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    public boolean update(SanPham ot, int Id) {
        int check = 0;
        String query = """
                   update San_Pham set ID_Hang = ?, Ma_SP = ?,  Ten = ?, Gia_Ban =?, Gia_Nhap = ?,Mo_Ta =?, Trang_Thai = ? where ID = ?
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {

            
            ps.setObject(1, ot.getIDHang());
            ps.setObject(2, ot.getMaSP());
            ps.setObject(3, ot.getTenXe());
            ps.setObject(4, ot.getGiaBan());
            ps.setObject(5, ot.getGiaNhap());
            ps.setObject(6, ot.getMoTa());
            ps.setObject(7, ot.getTrangThai());
            ps.setObject(8, Id);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    public boolean delete(int id) {
        int check = 0;
        String query = """
                        delete San_Pham where ID =?
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
}
