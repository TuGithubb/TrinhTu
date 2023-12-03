/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.MauSac;

/**
 *
 * @author tu204
 */
public class MauSacService {

    public ArrayList<MauSac> getAllMauSac() {
        ArrayList<MauSac> lst = new ArrayList<>();
        String sql = "select * from Mau_Sac";

        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Thi hành Statement=> dùng Resultset nhận kq
            ResultSet rs = pstm.executeQuery();
            //xử lý kq: duyệt rs => đổ dữ liệu vào lst
            while (rs.next()) {

                MauSac ms = new MauSac();
                ms.setID(rs.getInt("ID"));
                ms.setTen(rs.getString("Ten"));
                ms.setMoTa(rs.getString("Mo_Ta"));
                ms.setTrangThai(rs.getString("Trang_Thai"));
                lst.add(ms);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lst;
    }

    public Integer addMauSac(MauSac ms) {
        Integer row = null;
        String sql = "INSERT INTO Mau_Sac (ID, Ten, Mo_Ta, Trang_Thai)\n"
                + "VALUES (?,?,?,?)";
        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho dấu ?
            pstm.setInt(1, ms.getID());
            pstm.setString(2, ms.getTen());
            pstm.setString(4, ms.getMoTa());
            pstm.setString(3, ms.getTrangThai());

            //thi hành Statement
            row = pstm.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }

    public Integer updateMauSac(MauSac ms) {
        Integer row = null;
        String sql = "update Mau_Sac\n"
                + "set Ten=?, Mo_Ta =?, Trang_Thai=? "
                + "where ID like ?";
        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho dấu ?

            pstm.setString(2, ms.getTen());
            pstm.setString(4, ms.getMoTa());
            pstm.setString(3, ms.getTrangThai());
            pstm.setInt(1, ms.getID());
            //thi hành Statement
            row = pstm.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }

    public Integer deleteMauSac(String ms) {
        Integer row = null;
        String sql = "delete from Mau_Sac\\n\"\n"
                + "                + \"where ID like ?";
        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho dấu ?
            pstm.setString(1, ms);

            //thi hành Statement
            row = pstm.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }
}
