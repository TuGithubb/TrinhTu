/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ThietKe;

/**
 *
 * @author tu204
 */
public class ThietKeService {

    public ArrayList<ThietKe> getAllThietKe() {
        ArrayList<ThietKe> lst = new ArrayList<>();
        String sql = "select * from Thiet_Ke";

        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Thi hành Statement=> dùng Resultset nhận kq
            ResultSet rs = pstm.executeQuery();
            //xử lý kq: duyệt rs => đổ dữ liệu vào lst
            while (rs.next()) {

                ThietKe nt = new ThietKe();
                nt.setID(rs.getInt("ID"));
                nt.setTen(rs.getString("Ten"));
                nt.setMoTa(rs.getString("Mo_Ta"));
                nt.setTrangThai(rs.getString("Trang_Thai"));
                lst.add(nt);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lst;
    }

    public Integer addThietKe(ThietKe nt) {
        Integer row = null;
        String sql = "INSERT INTO Thiet_Ke (ID, Ten, Mo_Ta, Trang_Thai)\n"
                + "VALUES (?,?,?,?)";
        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho dấu ?
            pstm.setInt(1, nt.getID());
            pstm.setString(2, nt.getTen());
            pstm.setString(4, nt.getMoTa());
            pstm.setString(3, nt.getTrangThai());

            //thi hành Statement
            row = pstm.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }

    public Integer updateThietKe(ThietKe nt) {
        Integer row = null;
        String sql = "update Thiet_Ke\n"
                + "set Ten=?, Mo_Ta =?, Trang_Thai=? "
                + "where ID like ?";
        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho dấu ?

            pstm.setString(2, nt.getTen());
            pstm.setString(4, nt.getMoTa());
            pstm.setString(3, nt.getTrangThai());
            pstm.setInt(1, nt.getID());
            //thi hành Statement
            row = pstm.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }

    public Integer deleteThietKe(String nt) {
        Integer row = null;
        String sql = "delete from Thiet_Ke\\n\"\n"
                + "                + \"where ID like ?";
        //Tạo kết nối
        Connection cn = DBConnect.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho dấu ?
            pstm.setString(1, nt);

            //thi hành Statement
            row = pstm.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }
}
